package Tiles;

public class Tile
{

	public Yields yield;
	public int x;
	public int y;
	Terrain t; 
	Biome b;
	public Tile( int xLoc, int yLoc )
	{
		x = xLoc;
		y = yLoc;
		yield = new Yields(2,2);
	}

	
}
