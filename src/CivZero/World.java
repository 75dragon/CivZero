package CivZero;

import Gui.Displayer;
import Map.Generate;
import Tiles.Tile;

public class World
{
	private int xDim;
	private int yDim;
	int dim;
	private Tile[][] theWorlds;
	Generate gen;
	Displayer Dis;

	World(int x, int y, int dimention)
	{
		dim = dimention;
		setxDim(x);
		setyDim(y);
		gen = new Generate(getxDim(), getyDim(), dimention);
		setTheWorlds(gen.getGameWorld());
		Dis = new Displayer(getxDim(), getyDim(), dimention, this);
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
