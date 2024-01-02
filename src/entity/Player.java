package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

public class Player extends Entity 
{
  GamePanel gp;
  KeyHandler keyH;
   
  public final int screenX;
  public final int screenY;
  public int hasKey=0;
	public boolean gameFinished = false;
  
  public Player(GamePanel gp , KeyHandler keyH )
  {
	  this.gp=gp;
	  this.keyH=keyH;
	  
	  screenX=gp.screenWidth /2 -(gp.tileSize/2) ;
	  screenY=gp.screenHeight / 2 -(gp.tileSize/2);
	  
	  soildArea = new Rectangle();
	  soildArea.x=23;
	  soildArea.y=23;
	  solidAreaDefaultX = soildArea.x;
	  solidAreaDefaultY = soildArea.y;
	  soildArea.width = 5;
	  soildArea.height =5 ;
	  
	  setDefaultValues();
	  getPlayerImage();
  }
  
  public void setDefaultValues()
  {
	  worldX=gp.tileSize * 23;
	  worldY=gp.tileSize * 21;
	  speed = 2;
	  direction ="down";
  }
  
  public void getPlayerImage()
  {
	    
	  up1=setup("boy_up_1");
	  up2=setup("boy_up_2");
	  down1=setup("boy_down_1");
	  down2=setup("boy_down_2");
	  left1=setup("boy_left_1");
	  left2=setup("boy_left_2");
	  right1=setup("boy_right_1");
	  right2=setup("boy_right_2");
	  
  }
  
  public BufferedImage setup(String imagePath )
	{
		UtilityTool uTool =  new UtilityTool();
		BufferedImage scaledImage = null;
		
		try {
			scaledImage = ImageIO.read(getClass().getResourceAsStream("/player/"+imagePath+".png"));
			scaledImage = uTool.scaleImage(scaledImage , gp.tileSize , gp.tileSize);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return scaledImage;
		
	}
  
  public void update() 
	{
	  
	    if(keyH.upPressed == true || 
	    		keyH.downPressed == true || 
	    		keyH.leftPressed == true || 
	    		keyH.rightPressed ==true )
	    {
	    	if(keyH.upPressed == true )
			{
				direction="up";
			}
			else if(keyH.downPressed == true)
			{
				direction="down";
			}
			else if(keyH.leftPressed == true)
			{
				direction="left";

			}
			else if(keyH.rightPressed == true)
			{			
				direction="right";
			}
			
	    	
	    	//Check the Collision
	    	collisionOn = false;
	    	gp.cChecker.checkTile(this);
	    	
	    	//object collision
	    	int objIndex = gp.cChecker.checkObject(this,true);
	    	pickUpobject(objIndex);
	    	
	    	//if collision is false , player can move
	    	if(collisionOn == false)
	    	{
	    		switch(direction)
	    		{
	    		case "up":
	    			worldY -= speed;
	    			break;
	    			
	    		case "down":
					worldY += speed;

	    			break;
	    		case "left":
					worldX -= speed;

	    			break;
	    		case "right":
					worldX += speed;

	    			break;
	    		}
	    	}
	    	
	    	
			spriteCounter++;
			if(spriteCounter>10)
			{
				if(spriteNum == 1)
				{
					spriteNum=2;
				}else if(spriteNum == 2)
				{
					spriteNum=1;
				}
				spriteCounter=0;
			}	
	    }
	    
		
	}
  
  public void pickUpobject(int i)
  {
	  if(i != 999)
	  {
		  String objectName =  gp.obj[i].name;
  
		  switch(objectName)
		  {
		 
		  case "Key":
			  
		  gp.playSE(1);
		  hasKey++;
		  gp.obj[i]= null;
		  gp.ui.showMessage("Key Picked Up !");
		  break;
		  
		  case "Door":
			  
		  if(hasKey > 0)
		  {
			  gp.playSE(3);
			  gp.obj[i]=null;
			  hasKey--;
			  gp.ui.showMessage("Door Opened !");
		  }else {
			  gp.ui.showMessage("You Need a Key !");
		  }

		  break;
		  
		  case "Boots":
			  
			speed += 1;
			gp.playSE(2);
			  gp.obj[i]=null;
			  gp.ui.showMessage("Speed Up !");
	      break;
			  
		  case "Slowtrap":
			  gp.playSE(5);
			  speed -= 2;
			  gp.obj[i]=null;
			  gp.ui.showMessage("Slow Down !");			
			  break;
			  
		  case "Chest":
			  gp.ui.gameFinished = true;
			  gp.stopMusic();	  
		      break;
			  
		  }
	  }
  }
  
  
  public void draw(Graphics2D g2)
  {
//	    g2.setColor(Color.white);
//		
//		g2.fillRect(x,y,gp.tileSize ,gp.tileSize );
//		
		BufferedImage image = null;
		
		switch(direction) 
		{
		
		case "up":
			if(spriteNum == 1) 
			{
				image = up1;
			}
			if(spriteNum == 2) 
			{
				image = up2;
			}
			break;
			
		case "down":
			if(spriteNum == 1) 
			{
				image = down1;
			}
			if(spriteNum==2) 
			{
				image = down2;
			}
			break;
		
		case "left":
			if(spriteNum==1) 
			{
				image = left1;
			}
			if(spriteNum==2) 
			{
				image = left2;
			}
			break;
		
		case "right":
			if(spriteNum==1) 
			{
				image = right1;
			}
			if(spriteNum==2) 
			{
				image = right2;
			}
			break;
		}
		
		g2.drawImage(image , screenX , screenY , null );
    }
}
