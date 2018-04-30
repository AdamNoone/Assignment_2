package ie.dit.main;

//import java files 
import java.awt.Color;
import java.awt.Graphics;

public class HUD  {

	


public int bounds  = 0;
public static float HEALTH = 100; //players health starts at 100 
 
 private int greenValue = 253; //color of the player health will change as health decreases
 private int score =0; //players score starts at 0
 private int level =1;//player starts on level 1
	
	public void tick() {
		greenValue = (int) Game.clamp(greenValue, 0, 255); //rbg value of green cant be more that 255
		HEALTH = (int) Game.clamp(HEALTH, 0,600); //ensure players health doesn't overflow the bounds of the actual health bar rectangle 
		
		
		score ++;//increase the score as player is still alive 
	}

	
	public void render(Graphics g) {
		
		g.setColor(Color.gray);
		g.fillRect (15,15,200 + bounds,32);
		 
		g.setColor(new Color(75,greenValue,0));
		g.fillRect (15,15,(int)HEALTH * 2,32);
		
		
		g.setColor(Color.white);
		g.drawRect (15,15,200 + bounds,32);
		
		g.drawString(HEALTH+"%", 15, 13);
		g.drawString("Score : " + score,15,64 );
		g.drawString("Level : " + level,15,80 );
		g.drawString("Press Space to Shop",15,94 );
		
	}

	 public int getScore() {
			return score;
		}


		public void setScore(int score) {
			this.score = score;
		}
		
		public int getLevel()
		{
			return level;
		}
		
		public void setLevel(int level)
		{
			this.level = level;
		}
	
}


