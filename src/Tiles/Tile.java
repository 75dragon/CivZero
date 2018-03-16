package Tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import CivZero.World;
import Gui.Drawable;
import Resources.Resources;
import Units.Unit;
import Resources.LuxuryResources;

public class Tile
{
	int shift = 0;
	World world;
	public Yields yield;
	public int x;
	public int y;
	Unit millitaryUnit;
	Terrain t;
	Biome b;
	LuxuryResources lr;
	Resources r;
	ArrayList<YieldModifier> ym;
	Color color;
	int width;
	boolean isReachable = false;
	Color gold = new Color(255, 200, 0);

	/**
	 * Plain tile constructor
	 * 
	 * @param xLoc
	 * @param yLoc
	 * @param pixelWidth
	 * @param terrain
	 * @param biome
	 * @param world
	 */
	public Tile(int xLoc, int yLoc, int pixelWidth, Terrain terrain, Biome biome, World world)
	{
		this.world = world;
		width = pixelWidth;
		t = terrain;
		b = biome;
		x = xLoc;
		y = yLoc;
		if (yLoc % 2 == 1)
		{
			shift = pixelWidth / 2;
		}
		yield = new Yields();
		ym = new ArrayList<YieldModifier>();
		ym.add(terrain);
		updateYeilds();
	}

	/**
	 * Tile constructor, with additional resources. Accepts null for the
	 * resources
	 * 
	 * @param xLoc
	 * @param yLoc
	 * @param pixelWidth
	 * @param terrain
	 * @param biome
	 * @param world
	 * @param resource
	 * @param luxResource
	 */
	public Tile(int xLoc, int yLoc, int pixelWidth, Terrain terrain, Biome biome, World world, Resources resource,
			LuxuryResources luxResource)
	{
		this(xLoc, yLoc, pixelWidth, terrain, biome, world);
		if (resource != null)
		{
			r = resource;
			ym.add(resource);
		}
		if (luxResource != null)
		{
			lr = luxResource;
			ym.add(luxResource);
		}
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
			yield.clear();
		}
		for (int i = 0; i < ym.size(); i++)
		{
			yield.addTo(ym.get(i).getModifiers());
		}
	}

	/**
	 * draws the tile in the graphics object
	 * 
	 * @param g
	 */
	public void drawMe(Graphics g)
	{
		g.setColor(t.getCol());
		if (isReachable)
		{
			g.setColor(Color.BLACK);
		}
		g.fillRect(x * width + shift, y * width, width, width);
		if (millitaryUnit != null)
		{
			millitaryUnit.drawMe(x * width + shift + 25, y * width + 25, width, g);
		}
		for (int i = 0; i < yield.getFood(); i++)
		{
			g.setColor(Color.RED);
			g.fillOval((int) ((x + .5) * width) + i * 7 + shift, y * width + (int) (width * .5), 5, 5);
		}
		for (int i = 0; i < yield.getProduction(); i++)
		{
			g.setColor(Color.PINK);
			g.fillOval((int) ((x + .5) * width) + i * 7 + shift, y * width + (int) (width * .5) + 7, 5, 5);
		}
		for (int i = 0; i < yield.getGold(); i++)
		{
			g.setColor(gold);
			g.fillOval((int) ((x + .5) * width) + i * 7 + shift, y * width + 14 + (int) (width * .5), 5, 5);
		}
		g.setColor(Color.black);
		g.drawRect(x * width + shift, y * width, width, width);
		for (int i = 0; i < ym.size(); i++)
		{
			if (ym.get(i) instanceof Drawable)
			{
				((Drawable) ym.get(i)).drawMe(x * width + shift, y * width, width, g);
			}
		}
	}

	/**
	 * What happens if this tile is clicked on
	 * 
	 * @return true of false, based off if something actually happened
	 */
	public boolean clickOn()
	{
		// if there is a current active unit
		if (world.isActive())
		{
			if (millitaryUnit == null && isReachable)
			{
				millitaryUnit = world.getWorld()[world.getActiveX()][world.getActiveY()].getMillitaryUnit();
				world.getWorld()[world.getActiveX()][world.getActiveY()].setMillitaryUnit(null);
				world.setActive(false);
				world.resetReachableTiles();
				return true;
			}
			else
			{
				world.setActive(false);
				world.resetReachableTiles();
				return false;
			}
		}
		if (millitaryUnit == null)
		{
			return false;
		}
		world.setReachableTiles(millitaryUnit.getMovement(), x, y);
		world.setActive(true);
		world.setActiveX(x);
		world.setActiveY(y);
		return true;
	}

	// getters and setters
	public void setReachable(Boolean reach)
	{
		isReachable = reach;
	}

	public boolean getReachable()
	{
		return isReachable;
	}

	public Unit getMillitaryUnit()
	{
		return millitaryUnit;
	}

	public void setMillitaryUnit(Unit millitaryUnit)
	{
		this.millitaryUnit = millitaryUnit;
	}

	public Yields getYield()
	{
		return yield;
	}

}
