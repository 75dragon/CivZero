package City;

import java.awt.Point;
import java.util.ArrayList;

import Tiles.Tile;

public class PopulationManager
{
	CityHub home;
	ArrayList<Point> citizenLocation = new ArrayList<Point>();
	
	public PopulationManager(CityHub city)
	{
		home = city;
		citizenLocation.add(new Point(home.getyLoc(), home.getyLoc()));
		home.getCityCenter().setPersonWorking(true);
	}
	
	public void addPopulation()
	{
		int index = 0;
		int toBeat = 0;
		ArrayList<Tile> findBig = new ArrayList<Tile>();
		for (int i = 0; i < home.getTerritory().size(); i++)
		{
			findBig.add(home.getTerritory().get(i));
		}
		for (int i = 0; i < findBig.size(); i++)
		{
			if (!findBig.get(i).isPersonWorking() && findBig.get(i).getYield().getFood() * 100 + findBig.get(i).getYield().getProduction() * 10
					+ findBig.get(i).getYield().getGold() * 1 > toBeat)
			{
				index = i;
				toBeat = findBig.get(i).getYield().getFood() * 100 + findBig.get(i).getYield().getProduction() * 10
						+ findBig.get(i).getYield().getGold() * 1;
			}
		}
		findBig.get(index).setPersonWorking(true);
		citizenLocation.add(new Point(findBig.get(index).getX(), findBig.get(index).getY()));
	}
	
	public void foodFocus()
	{
		
	}
	
	public void resetPopulation()
	{
		//clear the population
		citizenLocation.clear();
		for(int i = 0; i < home.getTerritory().size(); i++)
		{
			home.getTerritory().get(i).setPersonWorking(false);
		}
		//re-add the population
		citizenLocation.add(new Point(home.getyLoc(), home.getyLoc()));
		home.getCityCenter().setPersonWorking(true);
		for(int i = 0; i < home.getPopulation(); i++)
		{
			addPopulation();
		}
	}

	public ArrayList<Point> getCitizenLocation()
	{
		return citizenLocation;
	}
	
}
