package Color;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.Color;
import java.util.Random;

public class Start implements Runnable{
	
	Robot colordetect;
	public static boolean running = true;
	
	public Start() throws AWTException
	{
		colordetect = new Robot();
	}
	
	public void run()
	{
		Color color;
		Color target = new Color(255, 255, 255);

		while(running)
		{
			
			color = colordetect.getPixelColor(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
			Detect.c = color;
			System.out.println(color);
			if(color.equals(target))
			{
				System.out.println("I found the block.");
			}
		}
	}
}