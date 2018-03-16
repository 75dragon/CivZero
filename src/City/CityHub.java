package City;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import CivZero.World;
import Tiles.Tile;
import Tiles.Yields;

public class CityHub
{
	int HP;
	int xLoc;
	int yLoc;
	int population;
	int nextPopulation = 2;
	Timer collector;
	BufferedImage img;
	World w;
	Tile cityCenter;
	Yields cityTotals;
	ArrayList<Tile> territory = new ArrayList<Tile>();
	ArrayList<Tile> worked = new ArrayList<Tile>();

	public CityHub(int xLoc, int yLoc, World w)
	{
		this.w = w;
		startingTiles();
		loadImg("City");
		population = 1;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		cityTotals = new Yields();
		collector = new Timer(1000, collectAction );
		collector.start();
		img = scale(img, 70,70);
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
	
	public void startingTiles()
	{
		int xLocMinus = (xLoc - 1 + w.getxDim()) % w.getxDim();
		int xLocPlus = (xLoc + 1) % w.getxDim();
		int yLocMinus = (yLoc - 1 + w.getyDim()) % w.getyDim();
		int yLocPlus = (yLoc + 1) % w.getxDim();
		territory.add(w.getWorld()[xLocPlus][yLoc]);
		territory.add(w.getWorld()[xLocMinus][yLoc]);
		territory.add(w.getWorld()[xLoc][yLocPlus]);
		territory.add(w.getWorld()[xLoc][yLocMinus]);
		if (yLoc % 2 == 0)
		{
			territory.add(w.getWorld()[xLocMinus][yLocPlus]);
			territory.add(w.getWorld()[xLocMinus][yLocMinus]);
		}
		else
		{
			territory.add(w.getWorld()[xLocPlus][yLocPlus]);
			territory.add(w.getWorld()[xLocPlus][yLocMinus]);
		}
	}

	ActionListener collectAction = new ActionListener()
	{
		public void actionPerformed(ActionEvent actionEvent)
		{
			collectYeilds();		
		}
	};

	public void collectYeilds()
	{
		for (int i = 0; i < territory.size(); i++)
		{
			cityTotals.addTo(territory.get(i).getYield());
		}
	}

	public void drawMe(int x, int y, int w, Graphics g)
	{
		g.drawImage(img, x, y, null);
		g.setColor(Color.BLACK);
		g.drawString("Food: " + cityTotals.getFood(), x + 10, y + 10);
	}
}
