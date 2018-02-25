package Map;

import java.util.Random;

import Tiles.Biome;
import Tiles.Terrain;
import Tiles.Tile;
import Resources.LuxuryResources;
import Resources.Resources;

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
		addTerrain(20, "Hills", true);
		iterateWorld("Hills", 3, false);
		addTerrain(30, "Plains", true);
		iterateWorld("Plains", 3, false);
		fillTerrain("Grassland");
		finalTouch();
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
				else if (world[i][j].contains("Hills"))
				{
					if (world[i][j].contains("Wheat"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.HILL, Biome.GRASSLAND, Resources.WHEAT);
					}
					else if (world[i][j].contains("Cattle"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.HILL, Biome.GRASSLAND, Resources.CATTLE);
					}
					else if (world[i][j].contains("Horse"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.HILL, Biome.GRASSLAND, Resources.HORSE);
					}
					else if (world[i][j].contains("Sheep"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.HILL, Biome.GRASSLAND, Resources.SHEEP);
					}
					else if (world[i][j].contains("Citrus"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.HILL, Biome.GRASSLAND, LuxuryResources.CITRUS);
					}
					else if (world[i][j].contains("Silver"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.HILL, Biome.GRASSLAND, LuxuryResources.SILVER);
					}
					else if (world[i][j].contains("Gold"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.HILL, Biome.GRASSLAND, LuxuryResources.GOLD);
					}
					else if (world[i][j].contains("Salt"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.HILL, Biome.GRASSLAND, LuxuryResources.SALT);
					}
					else
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.HILL, Biome.GRASSLAND);
					}
				}
				else if (world[i][j].contains("Plains"))
				{
					if (world[i][j].contains("Wheat"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.PLAIN, Biome.GRASSLAND, Resources.WHEAT);
					}
					else if (world[i][j].contains("Cattle"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.PLAIN, Biome.GRASSLAND, Resources.CATTLE);
					}
					else if (world[i][j].contains("Horse"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.PLAIN, Biome.GRASSLAND, Resources.HORSE);
					}
					else if (world[i][j].contains("Sheep"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.PLAIN, Biome.GRASSLAND, Resources.SHEEP);
					}
					else if (world[i][j].contains("Citrus"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.PLAIN, Biome.GRASSLAND, LuxuryResources.CITRUS);
					}
					else if (world[i][j].contains("Silver"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.PLAIN, Biome.GRASSLAND, LuxuryResources.SILVER);
					}
					else if (world[i][j].contains("Gold"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.PLAIN, Biome.GRASSLAND, LuxuryResources.GOLD);
					}
					else if (world[i][j].contains("Salt"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.PLAIN, Biome.GRASSLAND, LuxuryResources.SALT);
					}
					else
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.PLAIN, Biome.GRASSLAND);
					}
				}
				else if (world[i][j].contains("Grassland"))
				{
					if (world[i][j].contains("Wheat"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.FLAT, Biome.GRASSLAND, Resources.WHEAT);
					}
					else if (world[i][j].contains("Cattle"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.FLAT, Biome.GRASSLAND, Resources.CATTLE);
					}
					else if (world[i][j].contains("Horse"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.FLAT, Biome.GRASSLAND, Resources.HORSE);
					}
					else if (world[i][j].contains("Sheep"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.FLAT, Biome.GRASSLAND, Resources.SHEEP);
					}
					else if (world[i][j].contains("Citrus"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.FLAT, Biome.GRASSLAND, LuxuryResources.CITRUS);
					}
					else if (world[i][j].contains("Silver"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.FLAT, Biome.GRASSLAND, LuxuryResources.SILVER);
					}
					else if (world[i][j].contains("Gold"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.FLAT, Biome.GRASSLAND, LuxuryResources.GOLD);
					}
					else if (world[i][j].contains("Salt"))
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.FLAT, Biome.GRASSLAND, LuxuryResources.SALT);
					}
					else
					{
						gameWorld[i][j] = new Tile(i, j, d, Terrain.FLAT, Biome.GRASSLAND);
					}
				}
				else if (world[i][j].contains("Mountains"))
				{
					gameWorld[i][j] = new Tile(i, j, d, Terrain.MOUNTAIN, Biome.GRASSLAND);
				}
				else
				{
					System.out.println("FAIL: " + world[i][j]);
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
				}
				else
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
				}
				else
				{
					if (rand.nextInt(99) + 1 <= percent && world[i][j] == ".")
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
				}
				else
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
				if (!world[i][j].equals("."))
				{
					if (rand.nextInt(50) == 0)
					{
						world[i][j] = "Mountains";
					}
					else if (rand.nextInt(40) == 0)
					{
						world[i][j] = world[i][j] + "Wheat";
					}
					else if (rand.nextInt(40) == 0)
					{
						world[i][j] = world[i][j] + "Cattle";
					}
					else if (rand.nextInt(40) == 0)
					{
						world[i][j] = world[i][j] + "Horse";
					}
					else if (rand.nextInt(40) == 0)
					{
						world[i][j] = world[i][j] + "Sheep";
					} // lux
					else if (rand.nextInt(40) == 0)
					{
						world[i][j] = world[i][j] + "Silver";
					}
					else if (rand.nextInt(40) == 0)
					{
						world[i][j] = world[i][j] + "Gold";
					}
					else if (rand.nextInt(40) == 0)
					{
						world[i][j] = world[i][j] + "Salt";
					}
					else if (rand.nextInt(40) == 0)
					{
						world[i][j] = world[i][j] + "Citrus";
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