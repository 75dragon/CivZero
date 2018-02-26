package Tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

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

	public Tile(int xLoc, int yLoc, int w, Terrain te, Biome bo)
	{
		width = w;
		t = te;
		b = bo;
		x = xLoc;
		y = yLoc;
		yield = new Yields();
		ym = new ArrayList<YieldModifier>();
		ym.add(te);
		updateYeilds();
	}

	public Tile(int xLoc, int yLoc, int w, Terrain te, Biome bo, LuxuryResources lu)
	{
		width = w;
		t = te;
		b = bo;
		lr = lu;
		x = xLoc;
		y = yLoc;
		yield = new Yields();
		ym = new ArrayList<YieldModifier>();
		ym.add(te);
		ym.add(lu);
		updateYeilds();
	}

	public Tile(int xLoc, int yLoc, int w, Terrain te, Biome bo, Resources re)
	{
		width = w;
		t = te;
		b = bo;
		r = re;
		x = xLoc;
		y = yLoc;
		yield = new Yields();
		ym = new ArrayList<YieldModifier>();
		ym.add(te);
		ym.add(re);
		updateYeilds();
	}

	public void updateYeilds()
	{
		for (int i = 0; i < ym.size(); i++)
		{
			yield.addTo(ym.get(i).getModifiers());
		}
	}

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
		}
	}

}
