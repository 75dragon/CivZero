package Tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Gui.Drawable;
import Resources.Resources;

import Resources.LuxuryResources;

public class Tile
{

	public Yields yield;
	public int x;
	public int y;
	Terrain t;
	Biome b;
	LuxuryResources lr;
	Resources r;
	ArrayList<YieldModifier> ym;
	Color color;
	int width;
	Color gold = new Color(255, 200, 0);

	/**
	 * Plain tile constructor
	 * 
	 * @param xLoc
	 * @param yLoc
	 * @param pixelWidth
	 * @param terrain
	 * @param biome
	 */
	public Tile(int xLoc, int yLoc, int pixelWidth, Terrain terrain, Biome biome)
	{
		width = pixelWidth;
		t = terrain;
		b = biome;
		x = xLoc;
		y = yLoc;
		yield = new Yields();
		ym = new ArrayList<YieldModifier>();
		ym.add(terrain);
		updateYeilds();
	}

	/**
	 * Tile constructor, with Lux resource
	 * 
	 * @param xLoc
	 * @param yLoc
	 * @param pixelWidth
	 * @param terrain
	 * @param biome
	 * @param luxResource
	 */
	public Tile(int xLoc, int yLoc, int pixelWidth, Terrain terrain, Biome biome, LuxuryResources luxResource)
	{
		width = pixelWidth;
		t = terrain;
		b = biome;
		lr = luxResource;
		x = xLoc;
		y = yLoc;
		yield = new Yields();
		ym = new ArrayList<YieldModifier>();
		ym.add(terrain);
		ym.add(luxResource);
		updateYeilds();
	}

	/**
	 * Tile constructor, with resource
	 * 
	 * @param xLoc
	 * @param yLoc
	 * @param pixelWidth
	 * @param terrain
	 * @param biome
	 * @param resource
	 */
	public Tile(int xLoc, int yLoc, int pixelWidth, Terrain terrain, Biome biome, Resources resource)
	{
		width = pixelWidth;
		t = terrain;
		b = biome;
		r = resource;
		x = xLoc;
		y = yLoc;
		yield = new Yields();
		ym = new ArrayList<YieldModifier>();
		ym.add(terrain);
		ym.add(resource);
		updateYeilds();
	}

	/**
	 * update the yields on the tile. Call after changing the YeildModifier
	 * array list.
	 */
	public void updateYeilds()
	{
		for (int i = 0; i < ym.size(); i++)
		{
			yield.addTo(ym.get(i).getModifiers());
		}
	}

	/**
	 * draws the tile in the graphics object
	 * 
	 * @param g
	 *            Graphics
	 */
	public void drawMe(Graphics g)
	{
		g.setColor(t.getCol());
		if (y % 2 == 0)
		{
			g.fillRect(x * width, y * width, width, width);
			for (int i = 0; i < yield.getFood(); i++)
			{
				g.setColor(Color.RED);
				g.fillOval(x * width + i * 7, y * width, 5, 5);
			}
			for (int i = 0; i < yield.getProduction(); i++)
			{
				g.setColor(Color.PINK);
				g.fillOval(x * width + i * 7, y * width + 7, 5, 5);
			}
			for (int i = 0; i < yield.getGold(); i++)
			{
				g.setColor(gold);
				g.fillOval(x * width + i * 7, y * width + 14, 5, 5);
			}
			g.setColor(Color.black);
			g.drawRect(x * width, y * width, width, width);
			for (int i = 0; i < ym.size(); i++)
			{
				if (ym.get(i) instanceof Drawable)
				{
					((Drawable) ym.get(i)).drawMe(x * width, y * width, width, g);
				}
			}
		}
		else
		{
			g.fillRect(x * width + (int) (width * .5), y * width, width, width);
			for (int i = 0; i < yield.getFood(); i++)
			{
				g.setColor(Color.RED);
				g.fillOval(x * width + (int) (width * .5) + i * 7, y * width, 5, 5);
			}
			for (int i = 0; i < yield.getProduction(); i++)
			{
				g.setColor(Color.PINK);
				g.fillOval(x * width + (int) (width * .5) + i * 7, y * width + 7, 5, 5);
			}
			for (int i = 0; i < yield.getGold(); i++)
			{
				g.setColor(gold);
				g.fillOval(x * width + (int) (width * .5) + i * 7, y * width + 14, 5, 5);
			}
			g.setColor(Color.black);
			g.drawRect(x * width + (int) (.5 * width), y * width, width, width);
			for (int i = 0; i < ym.size(); i++)
			{
				if (ym.get(i) instanceof Drawable)
				{
					((Drawable) ym.get(i)).drawMe(x * width + (int) (.5 * width), y * width, width, g);
				}
			}
		}
	}

}
