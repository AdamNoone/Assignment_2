package ie.dit.main;

import java.util.Random;

public class Spawn {

	
	private Handler handler ;
	private HUD hud;
	private Random r = new Random();
	private int scoreKeep = 0;
	
	public Spawn (Handler handler,HUD hud)
	{
		this.handler = handler;
		this.hud = hud;
	}

	
	public void tick() {
	
		scoreKeep++;
		
		if (scoreKeep >= 100)
		{
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			if (hud.getLevel() == 2)
			{
				handler.addObject(new BossOne ((Game.WIDTH/2 )-48,-100, ID.BossOne,handler)); //add a new enemy
			}
			
			/*else if (hud.getLevel() == 3)
			{
				handler.addObject(new BasicEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,handler)); //add a new enemy
			}
			
			else if (hud.getLevel() == 4)
			{
				handler.addObject(new FastEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.FastEnemy,handler)); //add a new enemy
			}
			else if (hud.getLevel() == 5)
			{
				handler.addObject(new SmartEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}
			else if (hud.getLevel() == 6)
			{
				handler.addObject(new SmartEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}
			else if (hud.getLevel() == 7)
			{
				handler.addObject(new SmartEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}	*/
		}
		}
	}
	
	
	

