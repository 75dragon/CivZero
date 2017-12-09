package Resources;

import Tiles.Tile;

public abstract class Resource
{
	String sName = "";
	
	public Resource()
	{
		
	}
	
	public abstract void passive( Tile ref );
	
	public abstract void improved( Tile ref );
}
