package ie.dit.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList <GameObject> object = new LinkedList<GameObject>();
	
	public int speed = 5;
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
	
	public void clearEnemies()
	{
		for (int i = 0 ;i < object.size();i++) 
		{
			GameObject tempObject = object.get(i);//temp becomes the current object
			
			if(tempObject.getId() == ID.Player)
			{
				object.clear();
				if(Game.gameState != Game.STATE.End)
				{
				addObject(new Player ((int)tempObject.getX(),(int)tempObject.getY(),ID.Player,this));
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
