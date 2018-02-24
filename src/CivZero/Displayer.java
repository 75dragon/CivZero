package CivZero;

import java.awt.BorderLayout;

import Gui.GameFrame;
import Gui.GamePanel;

public class Displayer
{
	World w;
	GameFrame gf;
	GamePanel gp;
	public Displayer(int x, int y, int dim, World w)
	{
		gf = new GameFrame();
		gp = new GamePanel(w, x * dim, y * dim);
		gf.add(gp, BorderLayout.CENTER);
		gf.pack();
	}
}
