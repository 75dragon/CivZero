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
		y = new Yields(foodMod, prodMod, goldMod,0,0);
		this.name= name;
		loadImg(pic);
		img = scale(img,30,30);
	}
	
	/**
	 * Loads the image for the resource
	 * @param pic string location
	 */
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
	
	/**
	 * Scales the image to the given size
	 * @param src the image
	 * @param w width
	 * @param h height
	 * @return the scaled image
	 */
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
