package ie.dit.main;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {

	
	private Handler handler;
	public FastEnemy(int x, int y, ID id,Handler handler) { //LOOK AT BASIC ENEMY COMMENTS EVERYTHING IS THE SAME EXCEPT ENEMY VELOCITY 
		super(x, y, id);
		
		this.handler = handler;
		velX = 2;
		velY = 10; // Makes this enemy faster than basic enemy 
		
	}

	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16);
		
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if (y <=0 || y >= Game.HEIGHT -32) velY *= -1;
		if (x <=0 || x >= Game.WIDTH -16) velX *= -1;
		
		//adds Fast enemy
		handler.addObject(new BasicEnemyTrail(x,y,ID.BasicEnemyTrail,Color.yellow,16,16,0.1f,handler));
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x,(int)y,16,16);
		
	}

}

