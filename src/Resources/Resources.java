package Resources;

import Tiles.YeildModifier;
import Tiles.Yields;

public enum Resources implements YeildModifier
{
	WHEAT(1, 0), CATTLE(1, 0), HORSE(0, 1), SHEEP(0, 1);
	Yields y;

	private Resources(int f, int p)
	{
		y = new Yields(f, p);
	}

	@Override
	public Yields getModifiers()
	{
		// TODO Auto-generated method stub
		return y;
	}
}
