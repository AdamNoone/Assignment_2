package ie.dit.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 640 ,HEIGHT = WIDTH /12 * 9 ;
	
	private Thread thread ;
	private boolean running = false;
	
	private Random r;
	private Handler handler;
	
	public Game() 
	{
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH,HEIGHT,"Assigment xx" ,this);
		
		
		
				r = new Random();
		
		
			
		handler.addObject(new Player (WIDTH/2 - 32, HEIGHT/2 - 32, ID.Player)); //add a new player
		for (int i = 0;i < 20; i ++)
		{
		handler.addObject(new BasicEnemy (r.nextInt(WIDTH),r.nextInt(HEIGHT), ID.BasicEnemy)); //add a new enemy
		}
		//handler.addObject(new Player (WIDTH/2 + 64, HEIGHT/2 - 32, ID.Player2)); //add a new player
	}
	
	
	public synchronized void start ()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop ()
	{
		try
		{
		
		thread.join();
		running = false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void run ()
	{//the game loop
		  long lastTime = System.nanoTime();
	        double amountOfTicks = 60.0;
	        double ns = 1000000000 / amountOfTicks;
	        double delta = 0;
	        long timer = System.currentTimeMillis();
	        int frames = 0;
	        while(running)
	        {
	                    long now = System.nanoTime();
	                    delta += (now - lastTime) / ns;
	                    lastTime = now;
	                    while(delta >=1)
	                            {
	                                tick();
	                                delta--;
	                            }
	                            if(running)
	                                render();
	                            frames++;
	                            
	                            if(System.currentTimeMillis() - timer > 1000)
	                            {
	                                timer += 1000;
	                                System.out.println("FPS: "+ frames);
	                                frames = 0;
	                            }
	        }
	                stop();
	}
	
	private void tick ()
	{
		handler.tick();
	}
	
	private void render ()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		
		Graphics g = bs.getDrawGraphics();
		
		 g.setColor(Color.black);
		 g.fillRect(0, 0, WIDTH, HEIGHT);
		 
		 handler.render(g);
		 g.dispose();
		 bs.show();
	}
	
	//the clamp method used to keep player on screen
	public static int clamp (int var,int min,int max)
	{
		if(var >= max)
		{
			return var = max ;
		}

			else if (var <= min)
			{
				
				return var = min ;
				
			}
		
			else
			{
				return var;
			}
	}
	
	public static void main (String args[])
	{
		new Game();
	}
}
