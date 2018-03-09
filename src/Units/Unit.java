package Units;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	 *            yeah
	 * @param s
	 *            name of unit
	 */
	public Unit(int x, int y, int w, int movement, String s)
	{
		this.x = x;
		this.y = y;
		this.movement = movement;
		this.img = scale(loadImg(s), 50, 50);
		name = s;
	}

	public static BufferedImage scale(BufferedImage src, int w, int h)
	{
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		int x, y;
		int ww = src.getWidth();
		int hh = src.getHeight();
		int[] ys = new int[h];
		for (y = 0; y < h; y++)
			ys[y] = y * hh / h;
		for (x = 0; x < w; x++)
		{
			int newX = x * ww / w;
			for (y = 0; y < h; y++)
			{
				int col = src.getRGB(newX, ys[y]);
				img.setRGB(x, y, col);
			}
		}
		return img;
	}

	public BufferedImage loadImg(String pic)
	{
		try
		{
			return ImageIO.read(getClass().getResourceAsStream(pic + ".png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
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

	public void drawMe(int x, int y, int wid, Graphics g)
	{

		g.drawImage(img, x, y, null);

	}
}
