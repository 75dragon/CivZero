package Resources;

import Tiles.Tile;

public class Cattle extends Resource
{
	public Cattle()
	{
		super();
		sName = "Cattle";
	}

	@Override
	public void passive(Tile ref)
	{
		ref.yield.changeFood(1);
	}

	@Override
	public void improved(Tile ref)
	{
		ref.yield.changeProduction(1);
	}
}
