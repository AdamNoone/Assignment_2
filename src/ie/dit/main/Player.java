package ie.dit.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject {
	
	Random r = new Random();

	public Player(int x, int y, ID id) {
		super(x, y, id);
		
		
		
	}

	
	public void tick() {
	x+= velX;
	y+= velY;
	
    x = Game.clamp(x,0, Game.WIDTH -32);
	}

	
	public void render(Graphics g) {
		g.setColor(Color.white); 
		//else if (id == ID.Player2)g.setColor(Color.blue); 
		//g.setColor(Color.white);
		g.fillRect(x, y, 40, 40);
	}

	
	
	
	
}
