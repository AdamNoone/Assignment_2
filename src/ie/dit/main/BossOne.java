package ie.dit.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossOne extends GameObject {

	
	private Handler handler;
	private int timer = 80;
	private int timer2 = 50;
	Random r = new Random();
	public BossOne(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		velX = 0;
		velY = 2;
		
	}

	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,96,96);
		
	}

	public void tick() {
		x += velX;
		y += velY;
		
		//so i want to make the boos stop in the middle of the screen 
		
		if (timer <=0 ) 
		{
			velY = 0;
			
			
		}
		
		else
		{
			timer --;
		}
		
		
		if (timer <=0 ) 
		{
			timer2--;
			
			
		}
		
		if (timer2 <=0 ) 
		{
			if(velX == 0 )
			{
				velX = 2;
			}
			
			if(velX > 0)
			{
				velX += 0.05f;
			}
			else if (velX < 0)
			{
				velX -= 0.05f;
			}
			
			velX = Game.clamp(velX ,-10,10);
				int spawn = r.nextInt(10);
				if (spawn ==0)
				{
					handler.addObject(new EnemyBossBullet((int)x + 48,(int)y + 48,ID.BasicEnemy,handler));
				}
			
			
			
		}
		
		
		
		//if (y <=0 || y >= Game.HEIGHT -32) velY *= -1;
		if (x <=0 || x >= Game.WIDTH -96) velX *= -1;
		
		handler.addObject(new BasicEnemyTrail(x,y,ID.BasicEnemyTrail,Color.red,96,96,0.1f,handler));
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y,96,96);
		
	}

}