package Buildings;

import Tiles.Yields;

public class Monument extends Building
{
	public Monument()
	{
		super("Monument", new Yields(0,0,-1,5,0), 50);
	}
}
