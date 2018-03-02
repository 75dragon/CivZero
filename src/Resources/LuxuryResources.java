package Resources;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Gui.Drawable;
import Tiles.YieldModifier;
import Tiles.Yields;

public enum LuxuryResources implements YieldModifier, Drawable
{
	SILVER(0, 0, 2, "Silver", "Silver"), GOLD(0, 0, 2, "Gold", "Gold"), SALT(1, 0, 1, "Salt", "Salt"), CITRUS(1, 0, 1, "Citrus", "Citrus");
	Yields y;
	String name;
	BufferedImage img;
	/**
	 * Creates a luxury resource
	 * @param foodMod
	 * @param prodMod
	 * @param goldMod
	 * @param name
	 */
	private LuxuryResources(int foodMod, int prodMod, int goldMod, String name, String pic)
	{
		y = new Yields(foodMod, prodMod, goldMod);
		this.name= name;
		loadImg(pic);
	}

	public void loadImg(String pic)
	{
		try
		{
			img = ImageIO.read( getClass().getResourceAsStream( pic + ".png" ) );
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public Yields getModifiers()
	{
		return y;
	}
	
	/**
	 * returns the name
	 * @return String
	 */
	public String getName()
	{
		return name;
	}

	@Override
	public void drawMe(int x, int y, int wid, Graphics g)
	{
		g.drawImage(img, x , y , null);
	}
}
