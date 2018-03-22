package Units;

import CivZero.World;
import Player.Player;

public class Scout extends Unit
{
	public Scout(int xCor, int yCor, World w, Player player)
	{
		super(xCor, yCor, w, 2, "Scout", player);
	}
}
