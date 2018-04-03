package Buildings;

import Tiles.Yields;

public class Building implements Buildable
{
	Yields yield;
	int productionCost;
	String name;
	public Building(String name, Yields benefits, int productionCost)
	{
		this.name = name;
		yield = benefits;
		this.productionCost = productionCost;
	}
	
	public Yields getYeild()
	{
		return yield;
	}
	
	public void specialEffect()
	{
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getProductionCost()
	{
		return productionCost;
	}
}
