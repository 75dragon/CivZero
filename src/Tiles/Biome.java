package Tiles;

public enum Biome
{
	DESERT(-2, 0), FOREST(-1, 1), BEACH(-1, -1), GRASSLAND(0, 0), PLAINS(-1, 1);
	private int foodMod;
	private int productionMod;

	private Biome(int foodMod, int productionMod)
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
