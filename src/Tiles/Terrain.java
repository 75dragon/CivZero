package Tiles;

import java.awt.Color;

public enum Terrain implements YieldModifier
{
	WATER(1, 0, Color.BLUE), FLAT(2, 0, Color.GREEN), HILL(0, 2, new Color(255, 255, 102)), MOUNTAIN(0, 0,
			Color.GRAY), PLAIN(1, 1, new Color(204, 255, 51));
	Yields y;
	private Color color;

	private Terrain(int foodMod, int productionMod, Color color)
	{
		this.color = color;
		y = new Yields(foodMod, productionMod,0,0,0);
	}

	public Color getCol()
	{
		return color;
	}

	@Override
	public Yields getModifiers()
	{
		return y;
	}

}
