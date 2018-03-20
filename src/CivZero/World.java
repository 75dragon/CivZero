package CivZero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import City.CityHub;
import Gui.Displayer;
import Map.Generate;
import Tiles.Tile;
import Units.Scout;

public class World
{
	boolean isActive = false;
	int activeX;
	int activeY;
	private int xDim;
	private int yDim;
	int tilePixelSideLength;
	private Tile[][] theWorld;
	ArrayList<CityHub> citys = new ArrayList<CityHub>();
	Timer gameTimer;
	Generate gen;
	Displayer Dis;

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
		this.tilePixelSideLength = tilePixelSideLength;
		this.xDim = xDim;
		this.yDim = yDim;
		gen = new Generate(xDim, yDim, tilePixelSideLength, this);
		setTheWorlds(gen.getGameWorld());
		theWorld[0][0].setMilitaryUnit(new Scout(0, 0, 2));
		theWorld[2][2].setMilitaryUnit(new Scout(2, 2, 2));
		CityHub test = new CityHub(0, 0, this);
		theWorld[0][0].setCity(test);
		citys.add(test);
		Dis = new Displayer(xDim, yDim, tilePixelSideLength, this);
		gameTimer();
		gameTimer.start();
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
				theWorld[i][j].setReachable(false);
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
		theWorld[xLoc][yLoc].setReachable(true);
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

	public void setTilePixelSideLength(int tilePixelSideLength)
	{
		this.tilePixelSideLength = tilePixelSideLength;
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

}
