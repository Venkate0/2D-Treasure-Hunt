package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.Obj_key;

public class UI 
{
	GamePanel gp;
	Font arial_40 , arial_80B;
	BufferedImage KeyImage ;
	public boolean messageOn =false;
	public String message = "";
	int messageCounter = 0 ;
	public boolean gameFinished;
	
	double playTime ;
	
	DecimalFormat dformat = new DecimalFormat("#0.00");

	
	public UI(GamePanel gp) 
	{
		this.gp=gp;
		arial_40 = new Font("Arial" , Font.HANGING_BASELINE , 30);
		Obj_key key = new Obj_key(gp);
		KeyImage = key.image;
	}
	
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2)
	{
		
		if(gameFinished == true)
		{
			//completed game
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			String text;
			int textLength;
			int x;
			int y;
			
			text = "You found the treasure!";
			textLength = (int) g2.getFontMetrics ().getStringBounds (text, g2).getWidth ();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 - (gp.tileSize* 3);
			g2.drawString (text, x, y);
			
			g2.setFont (arial_80B);
			g2.setColor (Color.yellow);
		    text = "Congratulations!";
			textLength = (int) g2.getFontMetrics ().getStringBounds (text, g2).getWidth ();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 + (gp.tileSize*2);
			g2.drawString (text, x, y);
			
			g2.setColor(Color.white);
			text = "You Time is :"+ dformat.format(playTime) + " !";
		    textLength = (int) g2.getFontMetrics ().getStringBounds (text, g2).getWidth ();
			x = gp.screenWidth/2 - textLength/2;
			y = gp.screenHeight/2 + (gp.tileSize*3);
			g2.drawString (text, x, y);
			
			gp.gameThread = null;
		}
		else
		{
			
			
			//Running Game
		g2.setFont(arial_40);
		g2.setColor(Color.ORANGE);
		g2.drawImage(KeyImage , gp.tileSize/2 , gp.tileSize/2 , gp.tileSize , gp.tileSize , null);
		g2.drawString("x "+ gp.player.hasKey , 74 ,50 );
	
		//Time
		playTime += (double)1/60;
		g2.drawString("Time : "+ dformat.format(playTime), gp.tileSize * 11  , 65);
		
		if(messageOn == true)
		  {
     		g2.setFont(g2.getFont().deriveFont(30F));
			g2.drawString(message, gp.tileSize /2 ,gp.tileSize * 5);

			messageCounter++;
		if(messageCounter > 120)
			{
				messageCounter = 0;	
				messageOn = false;
			 }
		   }
	     }
	}
	int gameStartCount=0;
	public  void gameStart(boolean gameStart , Graphics2D g2)
	{
		if(gameStartCount < 150) {
		g2.setFont(arial_40);
		g2.setColor(Color.ORANGE);
		
		if(gameStart == true)
		  {
   		    
   		    String text;
			int textLength;
			int x;
			int y;
			
			g2.setFont(g2.getFont().deriveFont(30F));
   		    text = "WELCOME TO TREASURE HUNT";
   			textLength = (int) g2.getFontMetrics ().getStringBounds (text, g2).getWidth ();
   			x = gp.screenWidth/2 - textLength/2;
   			y = gp.screenHeight/2 + (gp.tileSize*1);
			g2.drawString(text, x ,y);

			messageCounter++;
		if(messageCounter > 120)
			{
				messageCounter = 0;	
				gameStart = false;
			 }
		   }
    	gameStartCount++;
		}
	}	
}
