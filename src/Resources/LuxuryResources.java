package Resources;

import Tiles.YeildModifier;
import Tiles.Yields;

public enum LuxuryResources implements YeildModifier
{
	SILVER(0,0,2), GOLD(0,0,2), SALT(1,1,0), CITRUS(1,1,0);
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
