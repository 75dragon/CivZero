package Units;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import CivZero.World;
import Player.Player;

public class Unit
{
	int x;
	int y;
	int movement;
	int sight;
	BufferedImage img;
	String name;
	Player player;
	World w;

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
	public Unit(int movement, String name, int imageScale)
	{
		this.movement = movement;
		this.img = scale(loadImg(name), imageScale, imageScale);
		this.name = name;
	}

	public void initiateUnit(int x, int y, Player owner, World w)
	{
		this.x = x;
		this.y = y;
		player = owner;
		this.w = w;
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
		g.drawImage(img, x + wid / 4, y + wid / 4, null);
		g.setColor(player.getPlayerColor());
		g.drawOval(x + wid / 4, y + wid / 4, wid / 2, wid / 2);
	}

	public int getMovement()
	{
		return movement;
	}

	public void setMovement(int movement)
	{
		this.movement = movement;
	}

	public boolean special()
	{
		return false;
	}

	public void setLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
		System.out.println(x + " " + y);
	}

	public void setPlayer(Player owner)
	{
		player = owner;
	}

	public void setWorld(World w)
	{
		this.w = w;
	}
	
	public Unit newCopy()
	{
		System.out.println("shouldbeoverriden");
		return null;
	}
}
