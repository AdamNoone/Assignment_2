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

	public Player(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,32,32);
		
	}

	
	public void tick() {
	x+= velX;
	y+= velY;
	
    x = Game.clamp(x,0, Game.WIDTH -47);
    y = Game.clamp(y,0, Game.HEIGHT -70);
    
   //handler.addObject(new BasicEnemyTrail(x,y,ID.BasicEnemyTrail,Color.white,32,32,0.2f,handler));
    
    collision();
	}

	
	public void collision()
	{
		for(int i = 0 ; i < handler.object.size();i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			
		if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy|| tempObject.getId() == ID.SmartEnemy) //tempObject is basic enemy
			{
				if (getBounds().intersects(tempObject.getBounds()))//if basicEnemy hits player do the following
				{
					HUD.HEALTH -=2;
				}
			}
		}
	}

	public void render(Graphics g) {
		
		//graphics 2d has extra methods 
		//Graphics2D g2d = (Graphics2D) g; //creates a graphics g method and casts it into a graphics 2d variable
		g.setColor(Color.white); 
		
		
		//else if (id == ID.Player2)g.setColor(Color.blue); 
		//g.setColor(Color.white);
		g.fillRect((int)x,(int) y, 40, 40);
	}

	
	
	
	
}
