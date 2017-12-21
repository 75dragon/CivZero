package Tiles;

public enum Terrain
{
	WATER(-1, 0), FLAT(0, 0), HILL(-1, 1), MOUNTAIN(-2, +2);
	private int foodMod;
	private int productionMod;
	
	private Terrain(int foodMod, int productionMod)
	{
		this.foodMod = foodMod;
		this.productionMod = productionMod;
	}
	
}
