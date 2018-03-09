package CivZero;

import Gui.Displayer;
import Map.Generate;
import Tiles.Tile;

public class World
{
	private int xDim;
	private int yDim;
	int tilePixelSideLength;
	private Tile[][] theWorlds;
	Generate gen;
	Displayer Dis;

	/**
	 * The hub of everything. Creates the generator to make the map then creates the
	 * displayer to manage the game
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
		gen = new Generate(xDim, yDim, tilePixelSideLength);
		setTheWorlds(gen.getGameWorld());
		Dis = new Displayer(xDim, yDim, tilePixelSideLength, this);
	}

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
		return theWorlds;
	}

	/**
	 * set the world
	 * 
	 * @param theWorlds
	 *            tile[][]
	 */
	public void setTheWorlds(Tile[][] theWorlds)
	{
		this.theWorlds = theWorlds;
	}

	/**
	 * @return Displayer
	 */
	public Displayer getDisplayer()
	{
		return Dis;
	}

}
