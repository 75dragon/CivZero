package Tiles;

import java.awt.Color;

public enum Terrain implements YeildModifier
{
	WATER(-1, -2, Color.BLUE), FLAT(0, -2, Color.GREEN), HILL(-2, 0, new Color(255, 255, 102)), MOUNTAIN(-2, -2, Color.GRAY), PLAIN(-1,-1, new Color(204, 255, 51));
	Yields y;
	private Color color;
	
	private Terrain(int foodMod, int productionMod, Color color)
	{
		this.color = color;
		y = new Yields(foodMod, productionMod);
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
