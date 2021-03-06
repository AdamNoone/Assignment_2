package ie.dit.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HardEnemy extends GameObject { //LOOK AT BASIC ENEMY COMMENTS EVERYTHING IS THE SAME EXCEPT ENEMY VELOCITY 

	
	private Handler handler;
	
	
	public HardEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		velX = 10;
		velY = 10;
		
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
		
		handler.addObject(new BasicEnemyTrail(x,y,ID.BasicEnemyTrail,Color.cyan,16,16,0.1f,handler));
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect((int)x,(int)y,16,16);
		
	}

}

