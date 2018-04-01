package CivZero;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Timer;

import City.CityHub;
import Gui.Displayer;
import Map.Generate;
import Player.Player;
import Tiles.Terrain;
import Tiles.Tile;
import Units.Scout;
import Units.Settler;
import Units.Unit;

public class World
{
	boolean isActive = false;
	int activeX;
	int activeY;
	private int xDim;
	private int yDim;
	int tilePixelSideLength;
	private Tile[][] theWorld;
	Timer gameTimer;
	Generate gen;
	Displayer Dis;
	ArrayList<CityHub> citys = new ArrayList<CityHub>();
	HashMap<String, Unit> holdPrefabs = new HashMap<String, Unit>();
	ArrayList<Player> players = new ArrayList<Player>();

	/**
	 * The hub of everything. Creates the generator to make the map then creates
	 * the displayer to manage the game
	 * 
	 * @param x
	 *            tiles in the x direction
	 * @param y
	 *            tiles in the y direction
	 * @param dimention
	 *            how wide the tiles are (100) pref
	 */
	World(int xDim, int yDim, int tilePixelSideLength)
	{
		makePrefabs();
		Player austin = new Player(new Color(120,60,240), "Austin", this);
		this.tilePixelSideLength = tilePixelSideLength;
		this.xDim = xDim;
		this.yDim = yDim;
		gen = new Generate(xDim, yDim, tilePixelSideLength, this);
		setTheWorlds(gen.getGameWorld());
		foundUnit(austin, 2, 2, "Settler");
		Dis = new Displayer(xDim, yDim, tilePixelSideLength, this);
		players.add(austin);
		gameTimer();
		gameTimer.start();
	}

	public void makePrefabs()
	{
		holdPrefabs.put("Scout", new Scout());
		holdPrefabs.put("Settler", new Settler());
	}

	ActionListener cityCollector = new ActionListener()
	{
		public void actionPerformed(ActionEvent actionEvent)
		{
			for (int i = 0; i < citys.size(); i++)
			{
				citys.get(i).collectYeilds();
			}
			Dis.getGamepanel().repaint();
		}
	};

	public boolean foundUnit(Player founder, int xLoc, int yLoc, String type)
	{
		if (theWorld[xLoc][yLoc].getMilitaryUnit() != null)
		{
			return false;
		}
		Unit made = holdPrefabs.get(type).newCopy();
		made.initiateUnit(xLoc, yLoc, founder, this);
		founder.addUnit(made);
		theWorld[xLoc][yLoc].setMilitaryUnit(made);
		return true;
	}

	public void removeUnit(Unit toRemove)
	{
		theWorld[toRemove.getX()][toRemove.getY()].setMilitaryUnit(null);
		toRemove.getPlayer().removeUnit(toRemove);
	}

	public boolean foundCity(Player founder, int xLoc, int yLoc)
	{
		if (theWorld[xLoc][yLoc].getCity() != null || theWorld[xLoc][yLoc].getT() == Terrain.WATER)
		{
			return false;
		}
		CityHub founded = new CityHub(xLoc, yLoc, this, founder);
		founder.addCity(founded);
		theWorld[xLoc][yLoc].setCity(founded);
		citys.add(founded);
		return true;
	}

	public void gameTimer()
	{
		gameTimer = new Timer(1000, cityCollector);
	}

	public void resetReachableTiles()
	{
		for (int i = 0; i < xDim; i++)
		{
			for (int j = 0; j < yDim; j++)
			{
				theWorld[i][j].setReachable(-1);
			}
		}
	}

	public void setReachableTiles(int range, int xLoc, int yLoc)
	{
		if (xLoc < 0)
		{
			xLoc = xLoc + xDim;
		}
		if (xLoc >= xDim)
		{
			xLoc = xLoc - xDim;
		}
		if (yLoc < 0)
		{
			yLoc = yLoc + yDim;
		}
		if (yLoc >= yDim)
		{
			yLoc = yLoc - yDim;
		}
		theWorld[xLoc][yLoc].setReachable(range);
		if (range == 0)
		{
			return;
		}
		range--;
		setReachableTiles(range, xLoc + 1, yLoc);
		setReachableTiles(range, xLoc, yLoc + 1);
		setReachableTiles(range, xLoc, yLoc - 1);
		setReachableTiles(range, xLoc - 1, yLoc);
		if (yLoc % 2 == 0)
		{
			setReachableTiles(range, xLoc - 1, yLoc + 1);
			setReachableTiles(range, xLoc - 1, yLoc - 1);
		}
		else
		{
			setReachableTiles(range, xLoc + 1, yLoc + 1);
			setReachableTiles(range, xLoc + 1, yLoc - 1);
		}
	}

	// getters and setters
	/**
	 * gets the numbers of tiles in the X demension
	 * 
	 * @return int
	 */
	public int getxDim()
	{
		return xDim;
	}

	/**
	 * set the number of tiles in the Y direction
	 * 
	 * @param xDim
	 *            int
	 */
	public void setxDim(int xDim)
	{
		this.xDim = xDim;
	}

	/**
	 * get the number of tiles in the y direction
	 * 
	 * @return int
	 */
	public int getyDim()
	{
		return yDim;
	}

	/**
	 * set the number of tiles in the y direction
	 * 
	 * @param yDim
	 *            int
	 */
	public void setyDim(int yDim)
	{
		this.yDim = yDim;
	}

	/**
	 * return the giant array of tiles
	 * 
	 * @return a tile[][]
	 */
	public Tile[][] getWorld()
	{
		return theWorld;
	}

	/**
	 * set the world
	 * 
	 * @param theWorlds
	 *            tile[][]
	 */
	public void setTheWorlds(Tile[][] theWorlds)
	{
		this.theWorld = theWorlds;
	}

	/**
	 * @return Displayer
	 */
	public Displayer getDisplayer()
	{
		return Dis;
	}

	public int getTilePixelSideLength()
	{
		return tilePixelSideLength;
	}

	public boolean isActive()
	{
		return isActive;
	}

	public void setActive(boolean isActive)
	{
		this.isActive = isActive;
	}

	public int getActiveX()
	{
		return activeX;
	}

	public void setActiveX(int activeX)
	{
		this.activeX = activeX;
	}

	public int getActiveY()
	{
		return activeY;
	}

	public void setActiveY(int activeY)
	{
		this.activeY = activeY;
	}

	public ArrayList<Player> getPlayers()
	{
		return players;
	}
	
	

}
