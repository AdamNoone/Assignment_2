package ie.dit.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import ie.dit.main.Game.STATE;

public class Menu extends MouseAdapter{

	Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	 public Menu (Game game,Handler handler,HUD hud)
	 {
		 this.game = game;
		 this.hud = hud;
		 this.handler = handler;
	 }
	
	public void mousePressed(MouseEvent e)
	{
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == STATE.Menu)
		{
			
		
		//play button
		if (mouseOver(mx,my,210,150,280,64))
		{
			//Game.gameState = STATE.Game;
			//handler.addObject(new Player (Game.WIDTH/2 - 32, Game.HEIGHT/2 - 32, ID.Player,handler)); //add a new player
			//handler.clearEnemies();
			
			//handler.addObject(new BasicEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,handler)); //add a new enemy
			game.gameState = STATE.Select;
			return;
		}
		//help
		if (mouseOver(mx,my,210,250,280,64))
		{
			Game.gameState = STATE.Help;
		}
		
		
		//quit
		if (mouseOver(mx,my,210,350,280,64))
		{
			System.exit(0);
		}
		}
		
		if(Game.gameState == STATE.Select)
		{
			
		
		//normal button
		if (mouseOver(mx,my,210,150,280,64))
		{
			Game.gameState = STATE.Game;
			handler.addObject(new Player (Game.WIDTH/2 - 32, Game.HEIGHT/2 - 32, ID.Player,handler)); //add a new player
			handler.clearEnemies();
			
			handler.addObject(new BasicEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,handler)); //add a new enemy
			
			game.difficulty = 0;
		}
		//hard
		if (mouseOver(mx,my,210,250,280,64))
		{
			Game.gameState = STATE.Game;
			handler.addObject(new Player (Game.WIDTH/2 - 32, Game.HEIGHT/2 - 32, ID.Player,handler)); //add a new player
			handler.clearEnemies();
			
			handler.addObject(new HardEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,handler)); //add a new enemy
			
			game.difficulty = 1;
		}
		
		
		//back
		if (mouseOver(mx,my,210,350,280,64))
		{
			
				Game.gameState = STATE.Menu;
				return;
			
		}
		}
		
		//back button
				if(Game.gameState == STATE.Help)
				{
					if (mouseOver(mx,my,210,350,280,64))
					{
						Game.gameState = STATE.Menu;
						return;
					}
				}
				
				//try again button
				if(Game.gameState == STATE.End)
				{
					if (mouseOver(mx,my,210,350,200,64))
					{
						Game.gameState = STATE.Game;
						hud.setLevel(1);
					    hud.setScore(0);
						
						
						handler.addObject(new Player (Game.WIDTH/2 - 32, Game.HEIGHT/2 - 32, ID.Player,handler)); //add a new player
						handler.clearEnemies();
						
						handler.addObject(new BasicEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,handler)); //add a new enemy
					
					
					}
				}
	}
	
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	
	//use this function to check if mouse is in a selected box
	private boolean mouseOver(int mx,int my,int x,int y,int width,int height) 
	{
		if (mx > x && mx < x + width)
		{
			if (my > y && my < y + height)
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		else 
		{
			return false;
		}
	}
	
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		if(Game.gameState == STATE.Menu)
		{
			
		
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Menu", 240, 70);
		
		
		g.setFont(fnt2);
		
		g.drawRect(210, 150, 200, 64);
		g.drawString("Play", 270, 190);
		
		
		g.drawRect(210, 250, 200, 64);
		g.drawString("Help", 270, 290);
		
		
		g.drawRect(210, 350, 200, 64);
		g.drawString("Quit", 270, 390);
		}
		
		else if(Game.gameState == STATE.Help)
		{
			
		
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		Font fnt3 = new Font("arial",1,20);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Help", 240, 70);
		
		g.setFont(fnt3);
		g.drawString("You WASD to move player and dodge enemies", 50, 200);
		
		g.setFont(fnt2);
		g.drawRect(210, 350, 200, 64);
		g.drawString("Back", 270, 390);
		}
		
		else if(Game.gameState == STATE.End)
		{
			
		
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		Font fnt3 = new Font("arial",1,20);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Game Over", 180, 70);
		
		g.setFont(fnt3);
		g.drawString("Your Score was " + hud.getScore(), 225, 200);
		
		g.setFont(fnt2);
		g.drawRect(210, 350, 200, 64);
		g.drawString("Try Again", 245, 390);
		}
		else if(Game.gameState == STATE.Select)
		{
			
		
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("SLECT DIFFICULTY", 140, 70);
		
		
		g.setFont(fnt2);
		
		g.drawRect(210, 150, 200, 64);
		g.drawString("Normal", 270, 190);
		
		
		g.drawRect(210, 250, 200, 64);
		g.drawString("Hard", 270, 290);
		
		
		g.drawRect(210, 350, 200, 64);
		g.drawString("Back", 270, 390);
		}
		
	}
}
