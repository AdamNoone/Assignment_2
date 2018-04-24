package ie.dit.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import ie.dit.main.Game.STATE;

public class KeyInput extends KeyAdapter {

	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];//this boolean array is used to solve my sticky keys problem when player freezes during a direction change 
	
	//Game game;
	
	public KeyInput(Handler handler)
	{
		this.handler = handler;
		
		
		//game = new Game();
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		for (int i = 0 ;i < handler.object.size();i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.Player) 
			{
				//keys for player 1
				
				                if (key == KeyEvent.VK_W) tempObject.setVelY(-5);
								if (key == KeyEvent.VK_A) tempObject.setVelX(-5);
								if (key == KeyEvent.VK_S) tempObject.setVelY(5);
								if (key == KeyEvent.VK_D) tempObject.setVelX(5);
			}
			
		
		}
		/*if (key == KeyEvent.VK_P)
		{
			if(game.gameState == STATE.Game )
			{
			if(Game.paused)
			{
				Game.paused = false;
			}
			else 
			{
				Game.paused = true;
			}
		}
		}*/
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	public void keyReleased(KeyEvent e)
	{
	int key = e.getKeyCode();
		
		for (int i = 0;i < handler.object.size();i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.Player) 
			{
				//keys for player 1
				
								if (key == KeyEvent.VK_W) tempObject.setVelY(0);
								if (key == KeyEvent.VK_A) tempObject.setVelX(0);
								if (key == KeyEvent.VK_S) tempObject.setVelY(0);
								if (key == KeyEvent.VK_D) tempObject.setVelX(0);
			
		
			
			
		
		}
		}
	}
}

