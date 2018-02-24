package Gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import CivZero.World;

public class GamePanel extends JPanel
{
	int[][] locations;
	World w;
	public GamePanel(World wo)
	{
		w = wo;
	}
	
	@Override
	public void paint(Graphics g)
	{
		for (int i = 0; i < w.getxDim(); i++)
		{
			for (int j = 0; j < w.getyDim(); j++)
			{
				System.out.println(i + " " + j);
				w.getTheWorlds()[i][j].drawMe(g);
			}
		}
	}
}
