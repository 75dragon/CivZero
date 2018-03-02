package Gui;

import java.awt.BorderLayout;

import CivZero.World;

public class Displayer
{
	World w;
	GameFrame gf;
	GamePanel gp;
	public Displayer(int x, int y, int dim, World w)
	{
		gf = new GameFrame();
		gp = new GamePanel(w, (x + 1 )* dim, y * dim);
		gf.add(gp, BorderLayout.CENTER);
		gf.pack();
		MapListener lis = new MapListener(w);
		gp.addMouseListener(lis);
	}
	
	public GamePanel getGamepanel()
	{
		return gp;
	}
}
