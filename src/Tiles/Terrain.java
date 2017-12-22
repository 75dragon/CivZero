package Tiles;

public enum Terrain
{
	WATER(-1, -2), FLAT(-2, -2), HILL(-2, 0), MOUNTAIN(-2, -2);
	private int foodMod;
	private int productionMod;
	
	private Terrain(int foodMod, int productionMod)
	{
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
}
