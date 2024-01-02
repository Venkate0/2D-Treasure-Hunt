package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Obj_Boote extends Superobject{
	 
	GamePanel gp;
	public Obj_Boote(GamePanel gp) 
     {
     	name = "Boots";
     	try {
     		image=ImageIO.read(getClass().getResourceAsStream("/object/boots.png"));
    		uTool.scaleImage(image, gp.tileSize, gp.tileSize);

     	}catch(IOException e) 
     	{
     		e.printStackTrace();
     	}
     collision =true;
     }
}
