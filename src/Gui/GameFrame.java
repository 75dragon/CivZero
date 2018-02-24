package Gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GameFrame extends JFrame
{
	public GameFrame(int x, int y)
	{
		this.setVisible(true);
		this.setSize(x, y);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}
