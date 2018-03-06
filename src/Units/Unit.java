package Units;

import java.awt.image.BufferedImage;

public class Unit
{
	int x;
	int y;
	int movement;
	int sight;
	BufferedImage img;
	String name;

	/**
	 * @param x
	 *            xCoor
	 * @param y
	 *            yCoor
	 * @param movement
	 * @param s
	 *            name of unit
	 */
	public Unit(int x, int y, int movement, String s, BufferedImage img)
	{
		this.x = x;
		this.y = y;
		this.movement = movement;
		this.img = img;
		name = s;
	}

	public void moveUnit()
	{

	}
}
