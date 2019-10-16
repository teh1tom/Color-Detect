package Color;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;

public class Detect extends JFrame
{
	start startlistener;
	mouse mouselistener;
	stop stoplistener;
	JButton startbutton;
	JButton mousebutton;
	JButton stopbutton;
	Thread started = new Thread(new Start());
	Thread mouseget = new Thread(new MouseGet());
	
	public static Color c;

	public Detect() throws AWTException
	{
		setLayout(new FlowLayout());

		startbutton = new JButton("Start");
		mousebutton = new JButton("Mouse");
		stopbutton = new JButton("Stop");

		startlistener = new start();
		startbutton.addActionListener(startlistener);
		
		mouselistener = new mouse();
		mousebutton.addActionListener(mouselistener);

		stoplistener = new stop();
		stopbutton.addActionListener(stoplistener);

		add(startbutton);
		add(mousebutton);
		add(stopbutton);

		setTitle("Color Detection");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
	}

	private class start implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			started.start();
		}
	}
	
	private class mouse implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			mouseget.start();
		}
	}

	private class stop implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Start.running = false;
			MouseGet.running = false;
			System.exit(0);
		}
	}
	
	public void paint(Graphics g)
	{
		g.setColor(c);
		g.fill3DRect(10, 80, 200, 200, true);
		//repaint();
	}
	
	public static void main(String[] args) throws AWTException
	{
		Detect agiwindow = new Detect();
	}
}
