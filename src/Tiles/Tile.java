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
	public Tile( int xLoc, int yLoc, int w, Terrain te, Biome bo )
	{
		width = w;
		t = te;
		b = bo;
		x = xLoc;
		y = yLoc;
		yield = new Yields(2,2);
		ym = new ArrayList<YieldModifier>();
		ym.add(te);
	}
	
	public Tile( int xLoc, int yLoc, int w, Terrain te, Biome bo, LuxuryResources lu )
	{
		width = w;
		t = te;
		b = bo;
		lr = lu;
		x = xLoc;
		y = yLoc;
		yield = new Yields(2,2);
		ym = new ArrayList<YieldModifier>();
		ym.add(te);
		ym.add(lu);
	}
	
	public Tile( int xLoc, int yLoc, int w, Terrain te, Biome bo, Resources re )
	{
		width = w;
		t = te;
		b = bo;
		r = re;
		x = xLoc;
		y = yLoc;
		yield = new Yields(2,2);
		ym = new ArrayList<YieldModifier>();
		ym.add(te);
		ym.add(re);
	}
	
	public void drawMe(Graphics g)
	{
		g.setColor(t.getCol());
		if (y % 2 == 0)
		{
			g.fillRect(x * width, y * width, width, width);
		}
		else
		{
			g.fillRect(x * width + (int)(width * .5), y * width, width, width);
		}
	}
	
}
