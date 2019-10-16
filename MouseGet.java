package Color;

import java.awt.MouseInfo;

public class MouseGet implements Runnable{
	
	public static boolean running = true;
	
	public void run()
	{
		while(running)
		{
			System.out.println(MouseInfo.getPointerInfo().getLocation().x + ", " + MouseInfo.getPointerInfo().getLocation().y);
		}
	}
}