package Units;

import CivZero.World;
import Player.Player;

public class Scout extends Unit
{
	public Scout()
	{
		super(2, "Scout", 50);
	}
	
	@Override
	public Unit newCopy()
	{
		System.out.println("hi");
		Scout Bob = new Scout();
		return Bob;
	}
}
