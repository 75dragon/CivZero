package Resources;

import Tiles.Tile;

public class Bananas extends Resource
{
	Bananas()
	{
		super();
		sName = "Bananas";
	}

	@Override
	public void passive(Tile ref)
	{
		ref.yield.changeFood(1);
	}

	@Override
	public void improved(Tile ref)
	{
		ref.yield.changeFood(1);
	}
}
