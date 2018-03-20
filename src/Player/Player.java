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
		
	}
}
