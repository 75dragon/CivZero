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

	public static BufferedImage scale(BufferedImage src, int w, int h)
	{
	    BufferedImage img = 
	            new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    int x, y;
	    int ww = src.getWidth();
	    int hh = src.getHeight();
	    int[] ys = new int[h];
	    for (y = 0; y < h; y++)
	        ys[y] = y * hh / h;
	    for (x = 0; x < w; x++) {
	        int newX = x * ww / w;
	        for (y = 0; y < h; y++) {
	            int col = src.getRGB(newX, ys[y]);
	            img.setRGB(x, y, col);
	        }
	    }
	    return img;
	}
	
	public void moveUnit(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getSight()
	{
		return sight;
	}

	public void setSight(int sight)
	{
		this.sight = sight;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
}
