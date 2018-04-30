package ie.dit.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BasicEnemyTrail extends GameObject { //is a game object 

	private float alpha = 1;
	private float life;
	private Handler handler;
	private Color color ;
	
	private int width;
	private int height;
	
	
	public BasicEnemyTrail(float x, float y, ID id,Color color ,int width ,int height,float life,Handler handler) { //constructor and its vars 
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
		
		
		
	}


	public void tick() {
		
		if (alpha > life)
		{
			alpha -= life - 0.01f; //Continually update position of trail 
		}
		else
		{
			
			handler.removeObject(this); //remove the previous position of the trail 
		}
	}

	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha)); //make end of tail appear faded
		g.setColor(color);
		g.fillRect((int)x,(int) y, width, height);//draw trail as a rect
		
		g2d.setComposite(makeTransparent(1)); //fixes bug which was making random things transparent
	}

	
	public Rectangle getBounds() {
		
		return null;
	}
	
	public  AlphaComposite makeTransparent(float alpha)
	{
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type,alpha));
	}
	

}
