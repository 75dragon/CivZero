package City;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import Buildings.Buildable;
import Buildings.Building;
import CivZero.World;
import Player.Player;
import Tiles.Tile;
import Tiles.Yields;

/**
 * @author Austin Cheng
 *
 */
public class CityHub
{
	int HP;
	int xLoc;
	int yLoc;
	int population;
	int nextPopulation = 2;
	int nextCulture = 20;
	BufferedImage img;
	World w;
	Tile cityCenter;
	Yields cityTotals;
	Yields temp;
	ArrayList<Buildable> canBuild = new ArrayList<Buildable>();
	ArrayList<Building> buildings = new ArrayList<Building>();
	ArrayList<Tile> territory = new ArrayList<Tile>();
	ArrayList<Point> assignment = new ArrayList<Point>();
	Player owner;
	Random rand = new Random();
	PopulationManager PM;

	public CityHub(int xLoc, int yLoc, World w, Player creator)
	{
		owner = creator;
		this.w = w;
		loadImg("City");
		population = 1;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		startingTiles();
		cityTotals = new Yields();
		img = scale(img, 70, 70);
		temp = new Yields();
		cityCenter = w.getWorld()[xLoc][yLoc];
		PM = new PopulationManager(this);
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

	public void addBuilding(Building built)
	{
		buildings.add(built);
	}

	public void startingTiles()
	{
		int xLocMinus = (xLoc - 1 + w.getxDim()) % w.getxDim();
		int xLocPlus = (xLoc + 1) % w.getxDim();
		int yLocMinus = (yLoc - 1 + w.getyDim()) % w.getyDim();
		int yLocPlus = (yLoc + 1) % w.getxDim();
		getTile(xLoc, yLoc);
		getTile(xLocPlus, yLoc);
		getTile(xLocMinus, yLoc);
		getTile(xLoc, yLocPlus);
		getTile(xLoc, yLocMinus);
		if (yLoc % 2 == 0)
		{
			getTile(xLocMinus, yLocPlus);
			getTile(xLocMinus, yLocMinus);
		}
		else
		{
			getTile(xLocPlus, yLocPlus);
			getTile(xLocPlus, yLocMinus);
		}
	}

	/**
	 * Grabs a tile peacefully to the city if its avalible. Places it into the
	 * territory of this city, and sets its owner to this player.
	 * 
	 * @param xl
	 *            xLoc
	 * @param yl
	 *            yLoc
	 * @return if you have successfully obtained the tile
	 */
	public boolean getTile(int xl, int yl)
	{
		if (w.getWorld()[xl][yl].getOwner() != null)
		{
			return false;
		}
		territory.add(w.getWorld()[xl][yl]);
		w.getWorld()[xl][yl].setOwner(owner);
		return true;
	}

	public void collectYeilds()
	{
		temp.clear();
		for (int i = 0; i < PM.getCitizenLocation().size(); i++)
		{
			temp.addTo(w.getWorld()[(int) PM.getCitizenLocation().get(i).getX()][(int) PM.getCitizenLocation().get(i)
					.getY()].getYield());
		}
		for (int i = 0; i < buildings.size(); i++)
		{
			temp.addTo(buildings.get(i).getYeild());
		}
		temp.changeFood(-2 * (population - 1));
		temp.changeGold(3);
		temp.changeScience(3 + population);
		temp.changeCulture(3 + (int) (.5 + .5 * population));
		cityTotals.addTo(temp);
		manageFood();
		manageProduction();
		manageGold();
		manageCulture();
		manageScience();
	}

	public void manageProduction()
	{

	}

	public void manageFood()
	{
		if (cityTotals.getFood() > nextPopulation)
		{
			population++;
			nextPopulation *= 2;
			cityTotals.setFood(0);
			PM.addPopulation();
		}
	}

	public void manageCulture()
	{
		owner.getTotal().changeCulture(temp.getCulture());
		if (cityTotals.getCulture() > nextCulture)
		{
			expandBorders();
			nextCulture *= 2;
			cityTotals.setCulture(0);
			PM.resetPopulation();
		}
	}

	public void expandBorders()
	{
		int citySize = 2;
		if (territory.size() >= 37)
		{
			return;
		}
		if (territory.size() >= 19)
		{
			citySize = 3;
		}
		ArrayList<Integer> holdx = new ArrayList<Integer>();
		ArrayList<Integer> holdy = new ArrayList<Integer>();
		w.setReachableTiles(citySize, xLoc, yLoc);
		for (int i = 0; i < w.getxDim(); i++)
		{
			for (int j = 0; j < w.getyDim(); j++)
			{
				if (w.getWorld()[i][j].getReachable() == 0 && w.getWorld()[i][j].getOwner() == null)
				{
					holdx.add(i);
					holdy.add(j);
				}
			}
		}
		int holdR = rand.nextInt(holdx.size());
		getTile(holdx.get(holdR), holdy.get(holdR));
		w.resetReachableTiles();
	}

	public void manageScience()
	{
		owner.getTotal().changeScience(temp.getScience());
	}

	public void manageGold()
	{
		owner.getTotal().changeGold(temp.getGold());
	}

	public int getPopulation()
	{
		return population;
	}

	public ArrayList<Tile> getTerritory()
	{
		return territory;
	}

	public int getxLoc()
	{
		return xLoc;
	}

	public int getyLoc()
	{
		return yLoc;
	}

	public Tile getCityCenter()
	{
		return cityCenter;
	}

	public World getWorld()
	{
		return w;
	}

	public Player getPlayer()
	{
		return owner;
	}

	public void clickOn()
	{
		
	}

	public void drawBuildables(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(w.getxDim() * w.getTilePixelSideLength() - 100, 0, w.getxDim() * w.getTilePixelSideLength(), w.getActiveY() * w.getTilePixelSideLength());
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
		g.drawRect(x + 2, y + 2, w - 4, w - 4);
		g.drawRect(x + 3, y + 3, w - 6, w - 6);
		g.drawRect(x + 4, y + 4, w - 8, w - 8);
	}
}
