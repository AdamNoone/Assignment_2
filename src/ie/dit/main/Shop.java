package ie.dit.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {

	
	private Handler handler;
	private HUD hud ;
	
	private int B1 = 500;
	private int B2 = 500;
	private int B3 = 500;

	public Shop(Handler handler,HUD hud)
	{
		this.handler = handler;
		this.hud = hud;
	}
	
	public void render (Graphics g)
	{
		g.setColor(Color.white);
		g.setFont(new Font ("arial",0,48));
		g.drawString("SHOP", Game.WIDTH/2-100, 50);
		
		//1st item 
		g.setFont(new Font ("arial",0,12));
		g.drawString("Upgrade Health", 110, 120);
		g.drawString("Cost : " + B1, 110, 140);
		g.drawRect(100, 100, 100, 80);
		
		//2nd item 
				
				g.drawString("Upgrade Speed", 260, 120);
				g.drawString("Cost : " + B2, 260, 140);
				g.drawRect(250, 100, 100, 80);
				
		//3rd item 
				
				g.drawString("Refill Health", 410, 120);
				g.drawString("Cost : " + B3, 410, 140);
				g.drawRect(400, 100, 100, 80);
		
		
		//show the score 
				g.drawString("Score " + hud.getScore(), Game.WIDTH/2-50, 310);
				g.drawString("Press Space to return to the Game", Game.WIDTH/2-50, 340);
				
	
	}
	
	public void mousePressed (MouseEvent e)
	{
		int mx = e.getX();
		int my = e.getY();
		
		if (mx >=100 && mx <=200)
		{
			if (my >=100 && my <=180)
			{
				System.out.println("Box 1");
			}
		}
		
		if (mx >=250 && mx <=350)
		{
			if (my >=100 && my <=180)
			{
				System.out.println("Box 2");
			}
		}
		
		if (mx >=400 && mx <=500)
		{
			if (my >=100 && my <=180)
			{
				System.out.println("Box 3");
			}
		}
		
		
		
	}
}
