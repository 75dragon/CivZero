package Units;

import CivZero.World;
import Player.Player;

public class Settler extends Unit
{
	public Settler(int xCor, int yCor, World w, Player player)
	{
		super(xCor, yCor, w, 2, "Settler", player);
	}
	
	@Override
	public boolean special()
	{
		w.foundCity(player, x, y);
		return true;
	}
}
