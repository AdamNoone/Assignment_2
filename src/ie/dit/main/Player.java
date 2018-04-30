package ie.dit.main;

//import java files 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	
	Random r = new Random(); 
	Handler handler;

	public Player(int x, int y, ID id,Handler handler) {//int vars to be passed into player class {
		super(x, y, id);
		this.handler = handler; 
		
		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,32,32); //used to detect collision with enemies 
		
	}

	
	public void tick() {
	x+= velX; // velocity in x axis will be changing based on what key the p[layer presses so we must constantly update it 
	y+= velY; // velocity in y axis  will be changing based on what key the p[layer presses so we must constantly update it 
	
    x = Game.clamp(x,0, Game.WIDTH -47); //cant go outside game window 
    y = Game.clamp(y,0, Game.HEIGHT -70);//cant go outside game window 
    
   
    
    collision();//call collision for the player 
	}

	
	public void collision()
	{
		for(int i = 0 ; i < handler.object.size();i++)
		{
			GameObject tempObject = handler.object.get(i); //get the object that hit the player 
			
			
		if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy|| tempObject.getId() == ID.SmartEnemy) //tempObject is an enemy
			{
				if (getBounds().intersects(tempObject.getBounds()))//if any of the Enemies hits player do the following
				{
					HUD.HEALTH -=2; //the players health will decrease by 2 
				}
			}
		}
	}

	public void render(Graphics g) {
		
		
		//draw a white player 
		g.setColor(Color.white); 
		g.fillRect((int)x,(int) y, 40, 40);
	}

	
	
	
	
}
