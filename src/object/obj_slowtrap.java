package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class obj_slowtrap extends Superobject{
	GamePanel gp;
	public obj_slowtrap(GamePanel gp) 
     {
     	name = "Slowtrap";
     	try {
     		image=ImageIO.read(getClass().getResourceAsStream("/object/trap.png"));
    		uTool.scaleImage(image, gp.tileSize, gp.tileSize);

     	}catch(IOException e) 
     	{
     		e.printStackTrace();
     	}
     collision =true;
     }
}
