package CivZero;

public class Yields
{
	// 0 = food
	// 1 = production
	// 2 = gold
	// 3 = science
	// 4 = culture
	int[] theYields = new int[5];
	// if the tile is "pillaged"
	boolean damaged = false;
	// unhappy - content - golden
	int happy = 0;
	
	Yields()
	{
		for ( int i = 0; i < 5; i++ )
		{
			theYields[i] = 0;
		}
	}	
	
	public void changeFood( int amount )
	{
		theYields[0] = theYields[0] + amount;
	}
	
	public void changeProduction( int amount )
	{
		theYields[1] = theYields[1] + amount;
	}
	
	public void changeGold( int amount )
	{
		theYields[2] = theYields[2] + amount;
	}
	
	public void changeScience( int amount )
	{
		theYields[3] = theYields[3] + amount;
	}
	
	public void changeCulture( int amount )
	{
		theYields[4] = theYields[4] + amount;
	}
	
	public void changeState( int state )
	{
		happy = state;
	}
	
	public int[] getYields()
	{
		int[] retArray = new int[5];
		for ( int i = 0; i < 5; i++ )
		{
			retArray[i] = (int) (theYields[i] + (1 * happy));
		}
		return retArray;
	}
}
