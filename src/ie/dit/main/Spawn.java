package ie.dit.main;

import java.util.Random;

public class Spawn {

	
	private Handler handler ;
	private HUD hud;
	private Random r = new Random();
	private Game game ;
	private int scoreKeep = 0;
	
	public Spawn (Handler handler,HUD hud,Game game)
	{
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}

	
	public void tick() {
	
		scoreKeep++;
		
		if (scoreKeep >= 500)
		{
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			if(game.difficulty == 0)
			{
			
				if (hud.getLevel() == 1)
				{
					handler.addObject(new BasicEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,handler)); //add a new enemy
				}
				else if (hud.getLevel() == 2)
			{
				handler.addObject(new BasicEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,handler)); //add a new enemy
			}
			
			else if (hud.getLevel() == 3)
			{
				handler.addObject(new BasicEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,handler)); //add a new enemy
			}
			
			else if (hud.getLevel() == 4)
			{
				handler.addObject(new FastEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.FastEnemy,handler)); //add a new enemy
			}
			else if (hud.getLevel() == 5)
			{
				handler.addObject(new FastEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.FastEnemy,handler)); //add a new enemy
			}
			else if (hud.getLevel() == 6)
			{
				handler.addObject(new SmartEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}
			else if (hud.getLevel() == 7)
			{
				handler.addObject(new SmartEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}	
			else if (hud.getLevel() == 8)
			{
				handler.addObject(new SmartEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}	
			else if (hud.getLevel() == 9)
			{
				handler.addObject(new SmartEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}	
			else if (hud.getLevel() == 10)
			{
				handler.addObject(new BasicEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}
			else if (hud.getLevel() == 11)
			{
				handler.addObject(new FastEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}	
			else if (hud.getLevel() == 12)
			{
				handler.addObject(new SmartEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}	
			else if (hud.getLevel() == 13)
			{
				handler.addObject(new FastEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}
			else if (hud.getLevel() == 14)
			{
				handler.addObject(new SmartEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}
			
			else if (hud.getLevel() == 15)
			{
				handler.clearEnemies();
				handler.addObject(new BossOne ((Game.WIDTH/2 )-48,-100, ID.BossOne,handler)); //add a new enemy
			}	
			
			
		  }
			
			else 	if(game.difficulty == 1)
			{
				if (hud.getLevel() == 1)
				{
					handler.addObject(new HardEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,handler)); //add a new enemy
				}
			
				else if (hud.getLevel() == 2)
			{
				handler.addObject(new HardEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,handler)); //add a new enemy
			}
			
			else if (hud.getLevel() == 3)
			{
				handler.addObject(new HardEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,handler)); //add a new enemy
			}
			
			else if (hud.getLevel() == 4)
			{
				handler.addObject(new FastEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.FastEnemy,handler)); //add a new enemy
			}
			else if (hud.getLevel() == 5)
			{
				handler.addObject(new FastEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.FastEnemy,handler)); //add a new enemy
			}
			else if (hud.getLevel() == 6)
			{
				handler.addObject(new SmartEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}
			else if (hud.getLevel() == 7)
			{
				handler.addObject(new SmartEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}	
			
			else if (hud.getLevel() == 8)
			{
				handler.addObject(new HardEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}	
			else if (hud.getLevel() == 9)
			{
				handler.addObject(new SmartEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}	
			
			
			else if (hud.getLevel() == 10)
			{
				handler.addObject(new HardEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}
			else if (hud.getLevel() == 11)
			{
				handler.addObject(new FastEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}	
			else if (hud.getLevel() == 12)
			{
				handler.addObject(new SmartEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}	
			else if (hud.getLevel() == 13)
			{
				handler.addObject(new HardEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}
			else if (hud.getLevel() == 14)
			{
				handler.addObject(new SmartEnemy (r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.SmartEnemy,handler)); //add a new enemy
			}
			
			else if (hud.getLevel() == 15)
			{
				handler.clearEnemies();
				handler.addObject(new BossOne ((Game.WIDTH/2 )-48,-100, ID.BossOne,handler)); //add a new enemy
			}	
			
			
		  }
		}
		}
	}
	
	
	

