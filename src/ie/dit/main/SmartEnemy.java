package ie.dit.main;



//import java files 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject { 

	
	private Handler handler;
	private GameObject player;
	
	public SmartEnemy(int x, int y, ID id,Handler handler) { //declare method and vars to be passed in 
		super(x, y, id);
		
		this.handler = handler;
		
		
		
	}

	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16);
		
	}

	public void tick() {
		
		for (int i = 0 ; i <  handler.object.size();i++)
		{
			if (handler.object.get(i).getId() == ID.Player) 
			{
				player = handler.object.get(i);
			}
		}
		x += velX;
		y += velY;
		
		float diffX = x - player.getX() ; //trying to locte difference between smartEnemy and player on x axis 
		float diffY = y - player.getY() ; //trying to locte difference between smartEnemy and player on y axis 
		
		float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY())); //we are getting the distance between player and enemy in both the x and y axis            
		
		 velX = (float) ((-1.0/distance) * diffX) ; //sets x velocity so enemy goes toward player 
		 velY = (float) ((-1.0/distance) * diffY ) ; //sets y velocity so enemy goes toward player 
		 
		
		
		
		
	if (y <=0 || y >= Game.HEIGHT -32) velY *= -1;
	if (x <=0 || x >= Game.WIDTH -16) velX *= -1;
		
		handler.addObject(new BasicEnemyTrail(x,y,ID.BasicEnemyTrail,Color.pink,16,16,0.1f,handler)); //adds trail 
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y,16,16); //draws enemy 
		
	}

}

