package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Obj_chest extends Superobject {
	GamePanel gp;
	 public Obj_chest(	GamePanel gp) 
     {
     	name = "Chest";
     	try {
     		image=ImageIO.read(getClass().getResourceAsStream("/object/chest.png"));
    		uTool.scaleImage(image, gp.tileSize, gp.tileSize);

     	}catch(IOException e) 
     	{
     		e.printStackTrace();
     	}
     }
}
