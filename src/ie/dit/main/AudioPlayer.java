package ie.dit.main;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {

	
	public static Map<String,Sound> soundMap = new HashMap<String,Sound>();
	public static Map<String,Music> musicMap = new HashMap<String,Music>();

	public static void load() 
	{
		try {
			soundMap.put("menu_sound", new Sound("resources/Select8-Bit.oog"));
			musicMap.put("music", new Music("resources/01.Forever-Bound-Stereo-Madness.oog"));
		} catch (SlickException e)
		{
			e.printStackTrace();
		}

	}



}
