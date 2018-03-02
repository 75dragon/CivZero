package Resources;

import Tiles.YieldModifier;
import Tiles.Yields;

public enum LuxuryResources implements YieldModifier
{
	SILVER(0, 0, 2, "Silver"), GOLD(0, 0, 2, "Gold"), SALT(1, 0, 1, "Salt"), CITRUS(1, 0, 1, "Citrus");
	Yields y;
	String name;
	
	/**
	 * Creates a luxury resource
	 * @param foodMod
	 * @param prodMod
	 * @param goldMod
	 * @param name
	 */
	private LuxuryResources(int foodMod, int prodMod, int goldMod, String name)
	{
		y = new Yields(foodMod, prodMod, goldMod);
		this.name= name;
	}

	@Override
	public Yields getModifiers()
	{
		return y;
	}
	
	/**
	 * returns the name
	 * @return String
	 */
	public String getName()
	{
		return name;
	}
}
