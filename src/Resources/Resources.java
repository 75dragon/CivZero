package Resources;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Gui.Drawable;
import Tiles.YieldModifier;
import Tiles.Yields;

public enum Resources implements YieldModifier, Drawable
{
	WHEAT(1, 0, "Wheat", "Wheat"), CATTLE(1, 0, "Cattle", "Cattle"), HORSE(0, 1, "Horse", "Horses"), SHEEP(0, 1, "Sheep", "Sheep");
	Yields y;
	String name;
	BufferedImage img;
	private Resources(int foodMod, int prodMod, String name, String pic)
	{
		this.name = name;
		y = new Yields(foodMod, prodMod);
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

	@Override
	public void drawMe(int x, int y, int wid, Graphics g)
	{
		g.drawImage(img, x , y , null);
	}
	
}
