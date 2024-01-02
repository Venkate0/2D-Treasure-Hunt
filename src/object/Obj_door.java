package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Obj_door extends Superobject{
	 
	GamePanel gp;
	public Obj_door(GamePanel gp) 
     {
     	name = "Door";
     	try {
     		image=ImageIO.read(getClass().getResourceAsStream("/object/door.png"));
    		uTool.scaleImage(image, gp.tileSize, gp.tileSize);

     	}catch(IOException e) 
     	{
     		e.printStackTrace();
     	}
     collision =true;
     }
}
