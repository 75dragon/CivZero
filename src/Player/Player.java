package Player;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import City.CityHub;
import CivZero.World;
import Tiles.Tile;
import Tiles.Yields;
import Units.Unit;

public class Player
{
	World w;
	String playerName;
	Color playerColor;
	ArrayList<CityHub> citys = new ArrayList<CityHub>();
	ArrayList<Unit> units = new ArrayList<Unit>();
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	Yields total = new Yields();

	public Player(Color startingColor, String startingName, World w)
	{
		playerName = startingName;
		playerColor = startingColor;
		this.w = w;
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

	public void drawMe(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, w.getxDim() * w.getTilePixelSideLength(), 40);
		g.setColor(playerColor);
		g.drawString(playerName, 5, 10);
		g.drawString("Gold: " + total.getGold(), 5, 25);
		g.drawString("Science: " + total.getScience(), 65, 25);
		g.drawString("Culture: " + total.getCulture(), 145, 25);
	}
}
