package ie.dit.main;

//import java files 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject {

	
	private Handler handler;
	
	Random r = new Random();
	
	
	
	private Color col;
	public MenuParticle(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		
		velX = (r.nextInt(5 - -5) + -5); //make particle go random x direction
		velY = (r.nextInt(5 - -5) + -5);  //make particle go random y direction
		
		//if  to ensure particles on menu are always moving 
		if (velX == 0 )
		{
			velX = 1;
		}
		
		if (velY== 0 )
		{
			velY = 1;
		}
		
		
		col = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)); //gives particle random color
		
	}

	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16); //draws the rectangle 
		
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if (y <=0 || y >= Game.HEIGHT -32) velY *= -1;//changes particle direction if it hits left or right of screen 
		if (x <=0 || x >= Game.WIDTH -16) velX *= -1;//changes particle direction if it hits top or bottom of screen 
		
		
		handler.addObject(new BasicEnemyTrail(x,y,ID.BasicEnemyTrail,col,16,16,0.05f,handler)); //give the particle a trail 
		 
	}

	
	public void render(Graphics g) {
		g.setColor(col);
		g.fillRect((int)x,(int)y,16,16);//draw the particle 
		
	}

}


