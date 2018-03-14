package City;

import java.awt.Graphics;
import java.util.ArrayList;

import CivZero.World;
import Tiles.Tile;
import Tiles.Yields;

public class CityHub
{
	int HP;
	int xLoc;
	int yLoc;
	int population;
	int nextPopulation = 2;
	World w;
	Tile cityCenter;
	Yields CityTotals;
	ArrayList<Tile> territory = new ArrayList<Tile>();
	ArrayList<Tile> worked = new ArrayList<Tile>();

	public CityHub(int xLoc, int yLoc)
	{
		population = 1;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}

	public void startingTiles()
	{
		territory.add(w.getWorld()[xLoc + 1][yLoc]);
		territory.add(w.getWorld()[xLoc - 1][yLoc]);
		territory.add(w.getWorld()[xLoc][yLoc + 1]);
		territory.add(w.getWorld()[xLoc][yLoc - 1]);
		if (yLoc % 2 == 0)
		{
			territory.add(w.getWorld()[xLoc - 1][yLoc + 1]);
			territory.add(w.getWorld()[xLoc - 1][yLoc - 1]);
		}
		else
		{
			territory.add(w.getWorld()[xLoc + 1][yLoc + 1]);
			territory.add(w.getWorld()[xLoc + 1][yLoc - 1]);
		}
	}

	public void drawMe(Graphics g)
	{

	}
}
