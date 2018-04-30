package ie.dit.main;

//import java files 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {//need to extend mouseAdapter so we can get input from mouse and keyboard 

	
	private Handler handler;
	private HUD hud ;
	
	private int B1 = 500; //used to control upgrade health 
	private int B2 = 500; //used to control upgrade speed 
	private int B3 = 500; //used to control refill health 

	public Shop(Handler handler,HUD hud)
	{
		this.handler = handler;
		this.hud = hud;
	}
	
	public void render (Graphics g)
	{
		///just draw the shop 
		g.setColor(Color.white);
		g.setFont(new Font ("arial",0,48));
		g.drawString("SHOP", Game.WIDTH/2-80, 50);
		
		//upgrade health 
		g.setFont(new Font ("arial",0,12));
		g.setColor(Color.white);
		g.drawString("Upgrade Health", 110, 120);
		g.drawString("Cost : " + B1, 110, 140);
		g.setColor(Color.yellow);
		g.drawRect(100, 100, 100, 80);
		
		//upgrade speed 
				g.setColor(Color.white);
				g.drawString("Upgrade Speed", 260, 120);
				g.drawString("Cost : " + B2, 260, 140);
				g.setColor(Color.blue);
				g.drawRect(250, 100, 100, 80);
				
		//refill health  
				g.setColor(Color.white);
				g.drawString("Refill Health", 410, 120);
				g.drawString("Cost : " + B3, 410, 140);
				g.setColor(Color.green);
				g.drawRect(400, 100, 100, 80);
		
		
		//show the score 
				g.setColor(Color.white);
				g.drawString("Score " + hud.getScore(), Game.WIDTH/2-50, 310);
				g.drawString("Press Space to return to the Game", Game.WIDTH/2-110, 340);
				
	
	}
	
	public void mousePressed (MouseEvent e)
	{
		int mx = e.getX(); // x co-ords of mouse press
		int my = e.getY(); // y co-ords of mouse press
		//box 1
		if (mx >=100 && mx <=200)
		{
			if (my >=100 && my <=180)
			{
				if (hud.getScore() >= B1)
				{
					hud.setScore(hud.getScore() - B1);
					//user can buy upgrade 3 times 
					if (B1 < 2501)
					{
					B1 += 1000; //cost goes up by 100 each time they buy upgrade
					hud.bounds += 20;
					HUD.HEALTH = (100 + (hud.bounds /2)); //increase the amount of health 
					}
					else
					{
						B1 += 100000;//increment by large number so user cant upgrade again 
						
						hud.bounds += 0;
					}
					
				}
			}
		}
		
		//box2
		if (mx >=250 && mx <=350)
		{
			if (my >=100 && my <=180)
			{
				if (hud.getScore() >= B2)
				{
					hud.setScore(hud.getScore() - B2); 
					B2 += 1000;//cost goes up by 100 each time they buy upgrade
					handler.speed += 2; //Increase player speed 
					
				}
			}
		}
		
//box 3
		if (mx >=400 && mx <=500)
		{
			if (my >=100 && my <=180)
			{
				if (hud.getScore() >= B3)
				{
					hud.setScore(hud.getScore() - B3);
				
					HUD.HEALTH = (100 + (hud.bounds /2));//refill players health 
				}
				}
			}
		}
		
		
		
	}

