package Gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GameFrame extends JFrame
{
	public GameFrame()
	{
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	}
}
