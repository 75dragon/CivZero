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
	WHEAT(1, 0, "Wheat", "Wheat"), CATTLE(1, 0, "Cattle", "Cattle"), HORSE(0, 1, "Horse", "Horse"), SHEEP(0, 1, "Sheep", "Sheep");
	Yields y;
	String name;
	BufferedImage img;
	private Resources(int foodMod, int prodMod, String name, String pic)
	{
		this.name = name;
		y = new Yields(foodMod, prodMod);
		loadImg(pic);
		img = scale(img,100,100);
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
