package ie.dit.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject { //is a game object 

	
	private Handler handler;
	public BasicEnemy(int x, int y, ID id,Handler handler) { //game object constructor and it vars 
		super(x, y, id);
		
		this.handler = handler;
		velX = 5;//enemy x velocity is 5 
		velY = 5; //enemy y velocity is 5 
		
	}

	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16); 
		
	}

	public void tick() {
		x += velX; //update position of enemy based on x velocity
		y += velY; //update position of enemy based on y velocity
		
		
		
		if (y <=0 || y >= Game.HEIGHT -32) velY *= -1; //if enemy hit top or bottom change direction 
		if (x <=0 || x >= Game.WIDTH -16) velX *= -1; //if enemy hit right or left change direction 
		
		handler.addObject(new BasicEnemyTrail(x,y,ID.BasicEnemyTrail,Color.red,16,16,0.1f,handler)); //add a trail to the enemy 
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red); //make the enemy red
		g.fillRect((int)x,(int)y,16,16); //draw the rectangle 
		
	}

}
