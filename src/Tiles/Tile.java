package Tiles;

import Resources.Resource;

public class Tile
{
	public Resource res;
	public Yields yield;
	public boolean worked;
	public boolean improved;
	public String improvement;
	public int x;
	public int y;
	Terrain t; 
	Biome b;
	public Tile( int xLoc, int yLoc )
	{
		x = xLoc;
		y = yLoc;
	}

	
}
