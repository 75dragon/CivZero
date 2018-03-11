package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import CivZero.World;

public class GamePanel extends JPanel
{
	int[][] locations;
	World w;
	int xTranslate;
	int yTranslate;
	int xDim;
	int yDim;

	public GamePanel(World wo, int x, int y)
	{
		xDim = x;
		yDim = y;
		w = wo;
		xTranslate = 0;
		yTranslate = 0;
		this.setPreferredSize(new Dimension(x, y));
	}

	public void setXTranslate(int x)
	{
		if (x < 0)
		{
			x = 0;
		}
		if (x > xDim - this.getWidth())
		{
			x = xDim - this.getWidth();
		}
		xTranslate = x;
	}

	public void setYTranslate(int y)
	{
		if (y < 0)
		{
			y = 0;
		}
		if (y > yDim - this.getHeight())
		{
			y = yDim - this.getHeight();
		}
		yTranslate = y;
	}

	public int getXTranslate()
	{
		return xTranslate;
	}

	public int getYTranslate()
	{
		return yTranslate;
	}

	@Override
	public void paint(Graphics g)
	{
		super.paintComponent(g);
		g.clearRect(-xDim, -yDim, 3 * xDim, 3 * yDim);
		g.translate(-xTranslate, -yTranslate);
		for (int i = 0; i < w.getxDim(); i++)
		{
			for (int j = 0; j < w.getyDim(); j++)
			{
				w.getWorld()[i][j].drawMe(g);
			}
		}
	}
}
