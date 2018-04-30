package ie.dit.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossOne extends GameObject { //is a game object 

	
	private Handler handler;
	//timers used to decide when boss descends 
	private int timer = 80; //timer 1 used to decend boss
	private int timer2 = 50; //timer 2 used to decide when boss starts moving left and right 
	Random r = new Random();
	public BossOne(int x, int y, ID id,Handler handler) {//constructor
		super(x, y, id);
		
		this.handler = handler;
		velX = 0;
		velY = 2; //only moves left and right 
		
	}

	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,96,96);
		
	}

	public void tick() {
		x += velX;
		y += velY;
		
		//so i want to make the boss stop in the middle of the screen  and then start moving 
		
		if (timer <=0 )  //if the timer expires 
		{
			velY = 0;
			
			
		}
		
		else
		{
			timer --;
		}
		
		
		if (timer <=0 )  //if the timer expires 
		{
			timer2--;
			
			
		}
		
		if (timer2 <=0 ) //if the timer expires 
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
			
			velX = Game.clamp(velX ,-10,10); //boss cant go outside window 
				int spawn = r.nextInt(10);
				if (spawn ==0)
				{
					handler.addObject(new EnemyBossBullet((int)x + 48,(int)y + 48,ID.BasicEnemy,handler)); //spawn the bosses bullets 
				}
			
			
			
		}
		
		
		
		
		if (x <=0 || x >= Game.WIDTH -96) velX *= -1;
		
		handler.addObject(new BasicEnemyTrail(x,y,ID.BasicEnemyTrail,Color.red,96,96,0.1f,handler));
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y,96,96);
		
	}

}
