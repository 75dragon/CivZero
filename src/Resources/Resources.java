package Resources;

import Tiles.YieldModifier;
import Tiles.Yields;

public enum Resources implements YieldModifier
{
	WHEAT(1, 0), CATTLE(1, 0), HORSE(0, 1), SHEEP(0, 1);
	Yields y;
	String name;
	private Resources(int foodMod, int prodMod)
	{
		y = new Yields(foodMod, prodMod);
	}

	@Override
	public Yields getModifiers()
	{
		return y;
	}
}
