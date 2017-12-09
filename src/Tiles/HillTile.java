package Tiles;

public class HillTile extends Tile
{
	public HillTile( int xLoc, int yLoc )
	{
		super( xLoc, yLoc );
		yield.changeProduction(2);
	}
}
