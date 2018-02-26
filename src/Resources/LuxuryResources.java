package Resources;

import Tiles.YieldModifier;
import Tiles.Yields;

public enum LuxuryResources implements YieldModifier
{
	SILVER(0,0,2), GOLD(0,0,2), SALT(1,0,1), CITRUS(1,0,1);
	Yields y;
	private LuxuryResources(int f, int p, int g )
	{
		y = new Yields(f,p,g);
	}
	@Override
	public Yields getModifiers()
	{
		return y;
	}
}
