package Units;

import CivZero.World;
import Player.Player;

public class Settler extends Unit
{
	public Settler()
	{
		super(2, "Settler", 50, 100);
	}

	@Override
	public boolean special()
	{
		if (w.foundCity(player, x, y))
		{
			w.removeUnit(this);
			System.out.println(player.getPlayerName() + " founded city at " + x + ", " + y);
			return true;
		}
		return false;
	}

	@Override
	public Unit newCopy()
	{
		Settler Bob = new Settler();
		return Bob;
	}
}
