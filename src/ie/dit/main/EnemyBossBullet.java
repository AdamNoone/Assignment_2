package ie.dit.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject { //is a game object 
 
	
	private Handler handler;
	Random r = new Random();
	public EnemyBossBullet(int x, int y, ID id,Handler handler) { ///Constructor and all its vars 
		super(x, y, id);
		
		this.handler = handler;
		velX = (r.nextInt(5 - -5) + -5);// bullets go in a random speed  in x axis
		velY = 5;
		
	}

	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16);
		
	}

	public void tick() {
		x += velX; //update x
		y += velY; //update y
		
		
		
		
		
		if ( y >= Game.HEIGHT )
		{
			handler.removeObject(this); //if the bullets reaches the edge of the screen remove it from the game 
		}
		
		handler.addObject(new BasicEnemyTrail(x,y,ID.BasicEnemyTrail,Color.red,16,16,0.1f,handler)); //add a trail to the bullets 
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red);//make the bullet red 
		g.fillRect((int)x,(int)y,16,16); //draw the bullet 
		
	}

}

