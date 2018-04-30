package ie.dit.main; //package

//import java files 
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.lang.Thread.State;
import java.util.Random;

public class Game extends Canvas implements Runnable { //must implement runnable because we want objects to execute code while they are already active 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//give the thread an I.D
	
	public static final int WIDTH = 640 ,HEIGHT = WIDTH /12 * 9 ; //set the size of the game window 
	
	private Thread thread ; //declare a thread 
	private boolean running = false; //init runnable to false before game is lunched 
	
	
	public int difficulty = 0; // 0 = normal and 1 = hard 
	
	//init of variables and classes 
	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private Shop shop;
	
	//init of States which are used to control what part of out game is being displayed based on a users actions 
	public enum STATE {
		Menu ,
		Help ,
		Game,
		Shop,
		Select,
		End
	};
	
	public static STATE gameState = STATE.Menu;//when game is launched show the start menu 
	
	public Game() 
	{
		handler = new Handler();
		hud = new HUD();
		shop = new Shop(handler,hud);
		menu = new Menu(this,handler,hud);
		
		//following 3 lines allow us to get key and mouse input 
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		this.addMouseListener(shop);
		
		//handle game audio 
		AudioPlayer.load();
		AudioPlayer.getMusic("music").loop();
		
		new Window(WIDTH,HEIGHT,"SquareHead []" ,this) ;
		
		
		      
		       spawner = new Spawn (handler ,hud,this);//create instance of spawn class 
		       
				r = new Random();
				
				if(gameState == STATE.Game)//if game state changes to play 
				{
					handler.addObject(new Player (WIDTH/2 - 32, HEIGHT/2 - 32, ID.Player,handler)); //add a new player
					handler.addObject(new BasicEnemy (r.nextInt(WIDTH),r.nextInt(HEIGHT), ID.BasicEnemy,handler)); //add a new enemy
				
				}
				
				else 
				{
					//this for loop is used to spawn the moving particles on the menus 
					for (int i = 0 ; i < 15 ;i ++)
					{
						handler.addObject(new MenuParticle(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.MenuParticle,handler));
					}
				}
				
	
			
			
	}
	
	
	public synchronized void start ()
	{
		thread = new Thread(this);
		thread.start();
		running = true;//makes the game start 
	}
	
	public synchronized void stop ()
	{
		try
		{
		
		thread.join();
		running = false; //makes the game stop
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void run ()
	{//the game loop
			this.requestFocus(); //Don't need to click on window to have control
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
	                    while(delta >=1) //if delta is greter than 1 
	                            {
	                                tick(); //call the tick method 
	                                delta--;
	                            }
	                            if(running) //if the the game is running 
	                                render();//draw the graphics on screen 
	                            frames++;
	                            
	                            if(System.currentTimeMillis() - timer > 1000)
	                            {
	                                timer += 1000;
	                                System.out.println("FPS: "+ frames);//i just print this to see how fast and efficient the game is running 
	                                frames = 0;
	                            }
	        }
	                stop();
	}
	
	private void tick ()
	{
		
		handler.tick();
		if(gameState == STATE.Game)
		{
			
			hud.tick();//call hud tick method 
			spawner.tick();//call spawner tick method 
			
			if (HUD.HEALTH <=0) //when player has no health 
			{
				HUD.HEALTH = 100;//set health back to 100
				gameState = STATE.End;//end the game 
				handler.clearEnemies();//hget rid of all the enemies on screen 
				
				//this for loop is used to spawn the moving particles on the menus 
				for (int i = 0 ; i < 15 ;i ++)
				{
					handler.addObject(new MenuParticle(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.MenuParticle,handler));
				}
				
			}
		}
		
		
		else if(gameState == STATE.Menu || gameState == STATE.End  || gameState == STATE.Select)
		{
			menu.tick();//call tick methos in menu class 
			
		}
		
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
		
		 g.setColor(Color.black);// make the window black 
		 g.fillRect(0, 0, WIDTH, HEIGHT);
		 
		 
		 
		 
		 if(gameState == STATE.Game)
			{
			 hud.render(g);//display the hud 
			 handler.render(g);//draw each object weather it be a player or enemy 
			}
		 
		 if(gameState == STATE.Shop)
			{
			 shop.render(g);//dispaly the shop 
			}
		 else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select)
			{
				menu.render(g);//display the menu 
				handler.render(g);
			}
		 
		 else if(gameState == STATE.Help)
			{
				menu.render(g);//display the help menu 
			}
		 
		 g.dispose();
		 bs.show();
	}
	
	//the clamp method used to keep player on screen
	public static float clamp (float var,float min,float max)
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
		new Game();//instanciate a new game object 
	}
}
