package Tiles;

public class GrassTile extends Tile
{
	public GrassTile( int xLoc, int yLoc )
	{
		super(xLoc, yLoc);
		yield.changeFood(2);
	}
}
