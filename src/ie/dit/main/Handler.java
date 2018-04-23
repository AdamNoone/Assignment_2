package ie.dit.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList <GameObject> object = new LinkedList<GameObject>();
	
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
	
	public void addObject(GameObject object)
	{
		this.object.add(object);
	}
	
	
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}
	
	
	
	
	
	
	
	
	
	}