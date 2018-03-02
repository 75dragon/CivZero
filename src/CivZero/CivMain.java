package CivZero;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Map.Generate;

public class CivMain
{
	CivMain()
	{
		World world = new World(20, 20, 100);
	}
	
	
	public static void main( String args[] )
	{
		new CivMain();
	}
}
