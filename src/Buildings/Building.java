package Buildings;

import Tiles.Yields;

public class Building
{
	Yields yield;
	int production;
	String name;
	public Building(String name, Yields benefits, int productionCost)
	{
		this.name = name;
		yield = benefits;
		production = productionCost;
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
	
	public int getProduction()
	{
		return production;
	}
}
