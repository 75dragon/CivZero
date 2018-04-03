package Units;

import CivZero.World;
import Player.Player;

public class Scout extends Unit
{
	public Scout()
	{
		super(2, "Scout", 50, 40);
	}
	
	@Override
	public Unit newCopy()
	{
		Scout Bob = new Scout();
		return Bob;
	}
}
