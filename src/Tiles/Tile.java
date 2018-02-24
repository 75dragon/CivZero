package Tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Tile
{

	public Yields yield;
	public int x;
	public int y;
	Terrain t; 
	Biome b;
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
