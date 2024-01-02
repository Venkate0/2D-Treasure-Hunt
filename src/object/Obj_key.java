package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Obj_key extends Superobject 
{
	GamePanel gp;	
        public Obj_key(GamePanel gp) 
        {
        	name = "Key";
        	try {
        		image=ImageIO.read(getClass().getResourceAsStream("/object/key.png"));
        		uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        	}catch(IOException e) 
        	{
        		e.printStackTrace();
        	}
        	
        }
}
