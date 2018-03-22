package City;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import CivZero.World;
import Player.Player;
import Tiles.Tile;
import Tiles.Yields;

public class CityHub
{
	int HP;
	int xLoc;
	int yLoc;
	int population;
	int nextPopulation = 2;
	BufferedImage img;
	World w;
	Tile cityCenter;
	Yields cityTotals;
	Yields temp;
	ArrayList<Tile> territory = new ArrayList<Tile>();
	ArrayList<Tile> worked = new ArrayList<Tile>();
	Player owner;

	public CityHub(int xLoc, int yLoc, World w, Player creator)
	{
		owner = creator;
		this.w = w;
		startingTiles();
		loadImg("City");
		population = 1;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		cityTotals = new Yields();
		img = scale(img, 70, 70);
		temp = new Yields();
	}

	/**
	 * Loads the image for the resource
	 * 
	 * @param pic
	 *            string location
	 */
	public void loadImg(String pic)
	{
		try
		{
			img = ImageIO.read(getClass().getResourceAsStream(pic + ".png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Scales the image to the given size
	 * 
	 * @param src
	 *            the image
	 * @param w
	 *            width
	 * @param h
	 *            height
	 * @return the scaled image
	 */
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

	public void startingTiles()
	{
		int xLocMinus = (xLoc - 1 + w.getxDim()) % w.getxDim();
		int xLocPlus = (xLoc + 1) % w.getxDim();
		int yLocMinus = (yLoc - 1 + w.getyDim()) % w.getyDim();
		int yLocPlus = (yLoc + 1) % w.getxDim();
		territory.add(w.getWorld()[xLoc][yLoc]);
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

	public void collectYeilds()
	{
		temp.clear();
		for (int i = 0; i < territory.size(); i++)
		{
			temp.addTo(territory.get(i).getYield());
		}
		if (population < territory.size())
		{
			temp.setFood((temp.getFood() * population + territory.size() - 1) / territory.size());
			temp.setProduction((temp.getProduction() * population + territory.size() - 1) / territory.size());
			temp.setGold((temp.getGold() * population + territory.size() - 1) / territory.size());
			temp.setScience((temp.getScience() * population + territory.size() - 1) / territory.size());
			temp.setCulture((temp.getCulture() * population + territory.size() - 1) / territory.size());
		}
		cityTotals.addTo(temp);
		cityTotals.addTo(w.getWorld()[xLoc][yLoc].getYield());
		cityTotals.changeFood(-2 * population);
		cityTotals.changeGold(3);
		cityTotals.changeScience(3 + population);
		cityTotals.changeCulture(3 + (int) (.5 + .5 * population));
		manageFood();
	}

	public void manageFood()
	{
		if (cityTotals.getFood() > nextPopulation)
		{
			population++;
			nextPopulation *= 2;
			cityTotals.setFood(0);
		}
	}

	public void manageCulture()
	{

	}

	public void manageScience()
	{

	}

	public void drawMe(int x, int y, int w, Graphics g)
	{
		g.drawImage(img, x + w / 10, y + w / 10, null);
		g.setColor(Color.BLACK);
		g.drawString("F: " + cityTotals.getFood(), x + w / 10 + 10, y + w / 10 + 10);
		g.drawString("P: " + cityTotals.getProduction(), x + w / 10 + 10, y + w / 10 + 20);
		g.drawString("G: " + cityTotals.getGold(), x + w / 10 + 10, y + w / 10 + 30);
		g.drawString("S: " + cityTotals.getScience(), x + w / 10 + 10, y + w / 10 + 40);
		g.drawString("C: " + cityTotals.getCulture(), x + w / 10 + 10, y + w / 10 + 50);
		g.setColor(owner.getPlayerColor());
		g.drawRect(x + 1, y + 1, w - 2, w - 2);
	}
}
