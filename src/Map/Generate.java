package Map;

import java.util.Random;

import Tiles.Biome;
import Tiles.Terrain;
import Tiles.Tile;

public class Generate
{
	String[][] world;

	String[][] holdPattern;

	String[][] resource;

	private Tile[][] gameWorld;

	int[][] numbers;

	int col, row;

	Random rand;

	int iE = 0;

	int jE = 0;

	int d = 0;
	public Generate(int x, int y, int dim)
	{
		d = dim;
		rand = new Random();
		row = y;
		col = x;
		world = new String[x][y];
		makeWorld(50, ".");
		iterateWorld(".", 3, true);
		addTerrain(20, "H", true);
		iterateWorld("H", 3, false);
		addTerrain(30, "P", true);
		iterateWorld("P", 3, false);
		fillTerrain("G");
		firstConvert();
		System.out.println("Done generating");
	}

	public void firstConvert()
	{
		gameWorld = new Tile[row][col];
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (world[i][j] == ".")
				{
					gameWorld[i][j] = new Tile(i, j, d, Terrain.WATER, Biome.GRASSLAND);
				}
				else if (world[i][j] == "H")
				{
					gameWorld[i][j] = new Tile(i, j, d, Terrain.HILL, Biome.GRASSLAND);
				}
				else if (world[i][j] == "P")
				{
					gameWorld[i][j] = new Tile(i, j, d, Terrain.PLAIN, Biome.GRASSLAND);
				}
				else if (world[i][j] == "G")
				{
					gameWorld[i][j] = new Tile(i, j, d, Terrain.FLAT, Biome.GRASSLAND);
				}
			}
		}
	}

	public String[][] makeBlankWorld()
	{
		String[][] temp = new String[row][col];
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				temp[i][j] = " ";
			}
		}
		return temp;
	}

	public String[][] makeWorld(int percent, String type)
	{
		String[][] temp = new String[row][col];
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (rand.nextInt(99) + 1 <= percent)
				{
					world[i][j] = type;
				} else
				{
					world[i][j] = " ";
				}
			}
		}
		return temp;
	}

	public void addTerrain(int percent, String type, boolean land)
	{
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (land)
				{
					if (rand.nextInt(99) + 1 <= percent && world[i][j] == " ")
					{
						world[i][j] = type;
					}
				} else
				{
					if (rand.nextInt(99) + 1 <= percent && world[i][j] == "#")
					{
						world[i][j] = type;
					}
				}
			}
		}
	}

	public void fillTerrain(String type)
	{
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (world[i][j] == " ")
				{
					world[i][j] = type;
				}
			}
		}
	}

	void printWorld()
	{
		System.out.println();
		System.out.println();
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				System.out.print(world[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	/**
	 * Iterates the world - takes adjacent tiles and molds
	 * 
	 * @param type
	 *            the thing to meld
	 * @param threshold
	 *            the tiles need to convert
	 * @param revert
	 *            revert to the original or land tile
	 */
	void iterateWorld(String type, int threshold, boolean revert)
	{
		numbers = new int[row][col];
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				// numbers[i][j] = getWall( i + 1, j + 1, type ) + getWall( i +
				// 1, j, type ) + getWall( i + 1, j - 1, type )
				// + getWall( i, j + 1, type ) + getWall( i, j, type ) +
				// getWall( i, j - 1, type ) + getWall( i - 1, j + 1, type )
				// + getWall( i - 1, j, type ) + getWall( i - 1, j - 1, type );
				if (j % 2 == 0)
				{
					numbers[i][j] = getWall(i - 1, j + 1, type) + getWall(i + 1, j, type) + getWall(i, j + 1, type)
							+ getWall(i, j, type) + getWall(i, j - 1, type) + getWall(i - 1, j, type)
							+ getWall(i - 1, j - 1, type);
				} 
				else
				{
					numbers[i][j] = getWall(i + 1, j + 1, type) + getWall(i + 1, j, type) + getWall(i, j + 1, type)
							+ getWall(i, j, type) + getWall(i, j - 1, type) + getWall(i - 1, j, type)
							+ getWall(i + 1, j - 1, type);
				}
			}
		}

		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (numbers[i][j] > threshold)
				{
					world[i][j] = type;
				} else
				{
					if (revert)
					{
						world[i][j] = " ";
					}
				}
			}
		}
	}

	void finalTouch()
	{
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (world[i][j].equals("M"))
				{
					if (rand.nextInt(20) == 0)
					{
						world[i][j] = "";
					} else if (rand.nextInt(10) == 0)
					{
						world[i][j] = "S";
					}
				} else if (world[i][j].equals(" "))
				{
					if (rand.nextInt(20) == 0)
					{
						world[i][j] = "g";
					} else if (rand.nextInt(50) == 0)
					{
						world[i][j] = "T";
					} else if (rand.nextInt(40) == 0)
					{
						world[i][j] = "t";
					} else if (rand.nextInt(100) == 0)
					{
						world[i][j] = "B";
					} else if (rand.nextInt(200) == 0)
					{
						world[i][j] = "H";
					} else if (rand.nextInt(500) == 0)
					{
						world[i][j] = "W";
					}
				}
			}
		}
	}

	int getWall(int y, int x, String type)
	{
		if (x >= col)
		{
			x = x - col;
		}
		if (x < 0)
		{
			x = x + col;
		}
		if (y >= row)
		{
			y = y - row;
		}
		if (y < 0)
		{
			y = y + row;
		}
		if (world[y][x].equals(type))
		{
			return 1;
		}
		return 0;
	}

	public int distance(int x, int y)
	{
		return Math.abs(x - y);
	}

	public Tile[][] getGameWorld()
	{
		return gameWorld;
	}

	public void setGameWorld(Tile[][] gameWorld)
	{
		this.gameWorld = gameWorld;
	}
}