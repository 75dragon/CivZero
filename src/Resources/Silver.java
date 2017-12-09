package Resources;

import Tiles.Tile;

public class Silver extends Resource
{
	public Silver()
	{
		super();
		sName = "Silver";
	}
	@Override
	public void passive(Tile ref)
	{
		ref.yield.changeGold(1);
	}

	@Override
	public void improved(Tile ref)
	{
		ref.yield.changeGold(1);
	}

}
