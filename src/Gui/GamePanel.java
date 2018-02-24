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
	public GamePanel(World wo, int x, int y)
	{
		w = wo;
		this.setPreferredSize(new Dimension(x,y));
	}
	
	@Override
	public void paint(Graphics g)
	{
		for (int i = 0; i < w.getxDim(); i++)
		{
			for (int j = 0; j < w.getyDim(); j++)
			{
				w.getWorld()[i][j].drawMe(g);
			}
		}
	}
}
