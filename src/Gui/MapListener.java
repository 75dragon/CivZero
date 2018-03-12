package Gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import CivZero.World;

public class MapListener implements MouseListener
{
	World w;
	int xOnPress;
	int yOnPress;

	public MapListener(World wo)
	{
		w = wo;
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		if (((arg0.getY() + w.getDisplayer().getGamepanel().getYTranslate()) / w.getTilePixelSideLength()) % 2 == 0)
		{
			w.setReachableTiles(2,
					(arg0.getX() + w.getDisplayer().getGamepanel().getXTranslate()) / w.getTilePixelSideLength(),
					(arg0.getY() + w.getDisplayer().getGamepanel().getYTranslate()) / w.getTilePixelSideLength());
		}
		else
		{
			w.setReachableTiles(2,
					(arg0.getX() + w.getDisplayer().getGamepanel().getXTranslate() - w.getTilePixelSideLength() / 2)
							/ w.getTilePixelSideLength(),
					(arg0.getY() + w.getDisplayer().getGamepanel().getYTranslate()) / w.getTilePixelSideLength());
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{

	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{

	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		xOnPress = arg0.getX();
		yOnPress = arg0.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		w.getDisplayer().getGamepanel()
				.setXTranslate(xOnPress - arg0.getX() + w.getDisplayer().getGamepanel().getXTranslate());
		w.getDisplayer().getGamepanel()
				.setYTranslate(yOnPress - arg0.getY() + w.getDisplayer().getGamepanel().getYTranslate());
		xOnPress = 0;
		yOnPress = 0;
		w.getDisplayer().getGamepanel().repaint();
	}

}
