package Units;

import CivZero.World;
import Player.Player;

public class Settler extends Unit
{
	public Settler()
	{
		super(2, "Settler", 50);
	}

	@Override
	public boolean special()
	{
		w.foundCity(player, x, y);
		w.removeUnit(this);
		return true;
	}

	@Override
	public Unit newCopy()
	{
		System.out.println("hi");
		Settler Bob = new Settler();
		return Bob;
	}
}
