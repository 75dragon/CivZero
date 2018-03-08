package Tiles;

/**
 * Yeilds for anything. Currently there are 5 resources to use 
 * 0 = food 
 * 1 = production 
 * 2 = gold 
 * 3 = science 
 * 4 = culture
 * 
 * @author Austin Cheng
 *
 */
public class Yields
{
	int[] theYields = new int[5];

	public Yields()
	{
		for (int i = 0; i < 5; i++)
		{
			theYields[i] = 0;
		}
	}

	public Yields(int f, int p)
	{
		theYields[0] = f;
		theYields[1] = p;
		for (int i = 2; i < 5; i++)
		{
			theYields[i] = 0;
		}
	}

	public Yields(int f, int p, int g)
	{
		theYields[0] = f;
		theYields[1] = p;
		theYields[2] = g;
		for (int i = 3; i < 5; i++)
		{
			theYields[i] = 0;
		}
	}

	public void changeFood(int amount)
	{
		theYields[0] = theYields[0] + amount;
	}

	public void changeProduction(int amount)
	{
		theYields[1] = theYields[1] + amount;
	}

	public void changeGold(int amount)
	{
		theYields[2] = theYields[2] + amount;
	}

	public void changeScience(int amount)
	{
		theYields[3] = theYields[3] + amount;
	}

	public void changeCulture(int amount)
	{
		theYields[4] = theYields[4] + amount;
	}

	public int getFood()
	{
		return theYields[0];
	}

	public int getProduction()
	{
		return theYields[1];
	}

	public int getGold()
	{
		return theYields[2];
	}

	public int getScience()
	{
		return theYields[3];
	}

	public int getCulture()
	{
		return theYields[4];
	}

	public void addTo(Yields y)
	{
		for (int i = 0; i < 5; i++)
		{
			theYields[i] += y.getYields()[i];
		}
	}

	public int[] getYields()
	{
		return theYields;
	}
}
