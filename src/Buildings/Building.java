package Buildings;

import Tiles.Yields;

public class Building
{
	Yields yield;
	int production;
	String name;
	public Building(String name, Yields benefits)
	{
		this.name = name;
		yield = benefits;
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
