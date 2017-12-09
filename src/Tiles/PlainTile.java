package Tiles;

public class PlainTile extends Tile
{
	public PlainTile( int xLoc, int yLoc )
	{
		super( xLoc, yLoc );
		yield.changeFood(1);
		yield.changeProduction(1);
	}
}
