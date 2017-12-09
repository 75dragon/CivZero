package Resources;

import Tiles.Tile;

public class Gold extends Resource
{
	Gold()
	{
		super();
		sName = "Gold";
	}

	@Override
	public void passive(Tile ref)
	{
		ref.yield.changeGold(2);
	}

	@Override
	public void improved(Tile ref)
	{
		ref.yield.changeGold(1);
	}
}
