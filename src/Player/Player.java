package Player;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Buildings.Buildable;
import Buildings.Grainery;
import Buildings.Monument;
import City.CityHub;
import CivZero.World;
import Tiles.Tile;
import Tiles.Yields;
import Units.Scout;
import Units.Settler;
import Units.Unit;

public class Player
{
	World w;
	String playerName;
	Color playerColor;
	ArrayList<Buildable> canBuild = new ArrayList<Buildable>();
	ArrayList<CityHub> citys = new ArrayList<CityHub>();
	ArrayList<Unit> units = new ArrayList<Unit>();
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	Yields total = new Yields();
	CityHub activeCity;

	public Player(Color startingColor, String startingName, World w)
	{
		playerName = startingName;
		playerColor = startingColor;
		this.w = w;
	}
	
	public void populateBuildables()
	{
		canBuild.add(new Scout());
		canBuild.add(new Settler());
		canBuild.add(new Monument());
		canBuild.add(new Grainery());
	}

	public void addCity(CityHub myCity)
	{
		citys.add(myCity);
	}

	public void addUnit(Unit myUnit)
	{
		units.add(myUnit);
	}

	public void removeUnit(Unit getOut)
	{
		units.remove(getOut);
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public Color getPlayerColor()
	{
		return playerColor;
	}

	public ArrayList<CityHub> getCitys()
	{
		return citys;
	}

	public ArrayList<Unit> getUnits()
	{
		return units;
	}

	public ArrayList<Tile> getTiles()
	{
		return tiles;
	}

	public Yields getTotal()
	{
		return total;
	}
	
	public void setActiveCity(CityHub newCity)
	{
		activeCity = newCity;
	}

	public void drawMe(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, w.getxDim() * w.getTilePixelSideLength(), 40);
		g.setColor(playerColor);
		g.drawString(playerName, 5, 10);
		g.drawString("Gold: " + total.getGold(), 5, 25);
		g.drawString("Science: " + total.getScience(), 85, 25);
		g.drawString("Culture: " + total.getCulture(), 165, 25);
	}
	
	public void drawCity(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 40, w.getxDim() * w.getTilePixelSideLength(), 60);
		g.setColor(playerColor);
		for (int i = 0; i < canBuild.size(); i++)
		{
			g.drawString(canBuild.get(i).getName(), 45, 10 + 100 * i);
		}
	}
}
