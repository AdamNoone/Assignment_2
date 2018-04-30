package ie.dit.main;

//import java files 
import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList <GameObject> object = new LinkedList<GameObject>(); //Make an array list of all the gameobjects 
	
	public int speed = 5; //speed of all game objects is 5
	public void tick()
	{
		for (int i = 0 ;i < object.size();i++) 
		{
			GameObject tempObject = object.get(i);//temp becomes the current object 
			
			tempObject.tick();
		}
	}
	
	
	public void render(Graphics g)
	{
		for (int i = 0 ;i < object.size();i++) 
		{
			GameObject tempObject = object.get(i);//temp becomes the current object
			
			tempObject.render(g);
		}
	}
	
	public void clearEnemies() //get rid of all the enemies on screen 
	{
		for (int i = 0 ;i < object.size();i++) 
		{
			GameObject tempObject = object.get(i);//temp becomes the current object
			
			if(tempObject.getId() == ID.Player)
			{
				object.clear();//clear each object 
				if(Game.gameState != Game.STATE.End)
				{
				addObject(new Player ((int)tempObject.getX(),(int)tempObject.getY(),ID.Player,this)); //adds a player if game  state not at end (used this to fix bug )
				}
			}
			
		}
		
	}
	
	
	public void addObject(GameObject object)
	{
		this.object.add(object);
	}
	
	
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}
	
	
	
	
	
	
	
	
	
	}
