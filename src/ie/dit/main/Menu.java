package ie.dit.main;

//import java files 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import ie.dit.main.Game.STATE;

public class Menu extends MouseAdapter{ //need to extend mouseAdapter so we can get input from mouse and keyboard 

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
		int mx = e.getX(); //get x co_ord pressed on screen 
		int my = e.getY(); //get y co_ord pressed on screen 
		
		if(Game.gameState == STATE.Menu) //when game is in menu state 
		{
			
		
		//play button
		if (mouseOver(mx,my,210,150,280,64))
		{
			
			game.gameState = STATE.Select; //change game state to select 
			return;
		}
		//help
		if (mouseOver(mx,my,210,250,280,64))
		{
			Game.gameState = STATE.Help;  //change game state to help
		}
		
		
		//quit
		if (mouseOver(mx,my,210,350,280,64))
		{
			System.exit(0); //close the game 
		}
		}
		
		if(Game.gameState == STATE.Select)
		{
			
		
		//normal button
		if (mouseOver(mx,my,210,150,280,64))
		{
			Game.gameState = STATE.Game;  //change game state to game 
			handler.addObject(new Player (Game.WIDTH/2 - 32, Game.HEIGHT/2 - 32, ID.Player,handler)); //add a new player
			handler.clearEnemies();//clear enemies from screen 
			
			handler.addObject(new BasicEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,handler)); //add a new enemy
			
			game.difficulty = 0; 
		}
		//hard
		if (mouseOver(mx,my,210,250,280,64))
		{
			Game.gameState = STATE.Game;  //change game state to game
			handler.addObject(new Player (Game.WIDTH/2 - 32, Game.HEIGHT/2 - 32, ID.Player,handler)); //add a new player
			handler.clearEnemies();
			
			handler.addObject(new HardEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,handler)); //add a new enemy
			
			game.difficulty = 1;
		}
		
		
		//back
		if (mouseOver(mx,my,210,350,280,64))
		{
			
				Game.gameState = STATE.Menu;  //change game state to menu
				return;
			
		}
		}
		
		//back button in help
				if(Game.gameState == STATE.Help)
				{
					if (mouseOver(mx,my,210,350,280,64))
					{
						Game.gameState = STATE.Menu;  //change game state to menu
						return;
					}
				}
				
				//try again button
				if(Game.gameState == STATE.End)
				{
					if (mouseOver(mx,my,210,350,200,64))
					{
						Game.gameState = STATE.Menu; //change game state to menu
						hud.setLevel(1); //set level back to 1 
					    hud.setScore(0); //set level back to 0
					    handler.clearEnemies(); //clear all enemies
					    
					    
					  
						
					    	return;
					
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
			//draw menu and all its options 
		
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("SquareHead", 165, 70);
		
		
		g.setFont(fnt2);
		g.setColor(Color.green);
		g.drawRect(210, 150, 200, 64);
		g.setColor(Color.white);
		g.drawString("Play", 270, 190);
		
		g.setColor(Color.green);
		g.drawRect(210, 250, 200, 64);
		g.setColor(Color.white);
		g.drawString("Help", 270, 290);
		
		g.setColor(Color.green);
		g.drawRect(210, 350, 200, 64);
		g.setColor(Color.white);
		g.drawString("Quit", 270, 390);
		}
		
		else if(Game.gameState == STATE.Help)
		{
			
			//draw help menu and all its information
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		Font fnt3 = new Font("arial",1,20);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Help", 240, 70);
		
		g.setFont(fnt3);
		g.drawString("Use WASD to move player and dodge enemies", 80, 200);
		g.drawString("Use Space to get upgrades for your player", 80, 230);
		
		g.setFont(fnt2);
		g.setColor(Color.green);
		g.drawRect(210, 350, 200, 64);
		g.setColor(Color.white);
		g.drawString("Back", 270, 390);
		}
		
		else if(Game.gameState == STATE.End)
		{
			
			//draw end screen
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		Font fnt3 = new Font("arial",1,20);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Game Over", 180, 70);
		
		g.setFont(fnt3);
		g.drawString("Your Score was " + hud.getScore(), 225, 200);
		
		g.setFont(fnt2);
		g.setColor(Color.green);
		g.drawRect(210, 350, 200, 64);
		g.setColor(Color.white);
		g.drawString("Try Again", 245, 390);
		}
		else if(Game.gameState == STATE.Select)
		{
			//draw menu that allows user to select there game difficulty 
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("SELECT DIFFICULTY", 70, 70);
		
		
		g.setFont(fnt2);
		
		g.setColor(Color.green);
		g.drawRect(210, 150, 200, 64);
		g.setColor(Color.white);
		g.drawString("Normal", 260, 190);
		
		g.setColor(Color.green);
		g.drawRect(210, 250, 200, 64);
		g.setColor(Color.white);
		g.drawString("Hard", 270, 290);
		
		g.setColor(Color.green);
		g.drawRect(210, 350, 200, 64);
		g.setColor(Color.white);
		g.drawString("Back", 270, 390);
		}
		
	}
}
