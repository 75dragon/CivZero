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
	
	private static final int MOUNTAINSPAWNCHANCE = 50;
	private static final int RESOURCESPAWNCHANCE = 30;
	private static final int LUXURYRESOURCESPAWNCHANCE = 35;
	private static final int WATERPERCENTAGE = 52;
	private static final int HILLPERCENTAGE = 23;
	private static final int PLAINPERCENTAGE = 23;
	
	Random rand;

	int iE = 0;

	int jE = 0;

	int d = 0;

	String water = ".";

	public Generate(int x, int y, int dim)
	{
		d = dim;
		rand = new Random();
		row = y;
		col = x;
		world = new String[x][y];
		makeBlankWorld();
		makeWorld(WATERPERCENTAGE, water);
		for (int i = 0; i < 3; i++)
		{
			iterateWorld(" ", 3, true);
		}
		addTerrain(HILLPERCENTAGE, "Hills", true);
		iterateWorld("Hills", 3, false);
		addTerrain(PLAINPERCENTAGE, "Plains", true);
		iterateWorld("Plains", 3, false);
		fillTerrain("Grassland");
		finalTouch();
		ConvertStringtoTile();
		System.out.println("Done generating");
	}

	/**
	 * converts the string array to a tile array call this last, gameWorld
	 * should be ready to use afterwards
	 */
	public void ConvertStringtoTile()
	{
		gameWorld = new Tile[row][col];
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (world[i][j] == water)
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

	/**
	 * Fills the world with " "
	 */
	public void makeBlankWorld()
	{
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				world[i][j] = " ";
			}
		}
	}

	/**
	 * has a % chance for each tile to become type
	 * 
	 * @param percent
	 * @param type
	 */
	public void makeWorld(int percent, String type)
	{
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (rand.nextInt(99) + 1 <= percent)
				{
					world[i][j] = type;
				}
			}
		}
	}

	/**
	 * Adds terrain based off a percentage
	 * 
	 * @param percent
	 *            int % threshold to have (0-100)
	 * @param type
	 *            String
	 * @param land
	 *            if it should be a land or water type
	 */
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
					if (rand.nextInt(99) + 1 <= percent && world[i][j] == water)
					{
						world[i][j] = type;
					}
				}
			}
		}
	}

	/**
	 * fills the empty " " tiles with type
	 * 
	 * @param type
	 *            String
	 */
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

	/**
	 * Prints the world. Debugging reasons
	 */
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
						world[i][j] = water;
					}
				}
			}
		}
	}

	/**
	 * Currently randomly adds the Resources and LuxeryResources
	 */
	void finalTouch()
	{
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (!world[i][j].equals(water))
				{
					if (rand.nextInt(MOUNTAINSPAWNCHANCE) == 0)
					{
						world[i][j] = "Mountains";
					}
					else if (rand.nextInt(RESOURCESPAWNCHANCE) == 0)
					{
						world[i][j] = world[i][j] + "Wheat";
					}
					else if (rand.nextInt(RESOURCESPAWNCHANCE) == 0)
					{
						world[i][j] = world[i][j] + "Cattle";
					}
					else if (rand.nextInt(RESOURCESPAWNCHANCE) == 0)
					{
						world[i][j] = world[i][j] + "Horse";
					}
					else if (rand.nextInt(RESOURCESPAWNCHANCE) == 0)
					{
						world[i][j] = world[i][j] + "Sheep";
					} // lux
					else if (rand.nextInt(LUXURYRESOURCESPAWNCHANCE) == 0)
					{
						world[i][j] = world[i][j] + "Silver";
					}
					else if (rand.nextInt(LUXURYRESOURCESPAWNCHANCE) == 0)
					{
						world[i][j] = world[i][j] + "Gold";
					}
					else if (rand.nextInt(LUXURYRESOURCESPAWNCHANCE) == 0)
					{
						world[i][j] = world[i][j] + "Salt";
					}
					else if (rand.nextInt(LUXURYRESOURCESPAWNCHANCE) == 0)
					{
						world[i][j] = world[i][j] + "Citrus";
					}
				}
			}
		}
	}

	/**
	 * returns if x,y is type
	 * @param y int
	 * @param x int
	 * @param type String
	 * @return 1 if yes, 0 if no
	 */
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

	/**
	 * Get the game world
	 * @return Tile[][]
	 */
	public Tile[][] getGameWorld()
	{
		return gameWorld;
	}
}