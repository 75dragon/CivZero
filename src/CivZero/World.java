package CivZero;

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

	public int getxDim()
	{
		return xDim;
	}

	public void setxDim(int xDim)
	{
		this.xDim = xDim;
	}

	public int getyDim()
	{
		return yDim;
	}

	public void setyDim(int yDim)
	{
		this.yDim = yDim;
	}

	public Tile[][] getWorld()
	{
		return theWorlds;
	}

	public void setTheWorlds(Tile[][] theWorlds)
	{
		this.theWorlds = theWorlds;
	}
	
}
