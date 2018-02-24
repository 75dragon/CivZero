package Tiles;

import java.awt.Color;

public enum Terrain
{
	WATER(-1, -2, Color.BLUE), FLAT(0, -2, Color.GREEN), HILL(-2, 0, new Color(255, 255, 102)), MOUNTAIN(-2, -2, Color.GRAY), PLAIN(-1,-1, new Color(204, 255, 51));
	private int foodMod;
	private int productionMod;
	private Color color;
	
	private Terrain(int foodMod, int productionMod, Color color)
	{
		this.color = color;
		this.foodMod = foodMod;
		this.productionMod = productionMod;
	}
	
	public int getFoodMod()
	{
		return foodMod;
	}

	public void setFoodMod(int foodMod)
	{
		this.foodMod = foodMod;
	}

	public int getProductionMod()
	{
		return productionMod;
	}

	public void setProductionMod(int productionMod)
	{
		this.productionMod = productionMod;
	}
	
	public Color getCol()
	{
		return color;
	}
	
}
