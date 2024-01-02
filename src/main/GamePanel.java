package main;

import javax.swing.JPanel;

import entity.Player;
import object.Superobject;
import tile.tileManager;

import java.awt.*;

public class GamePanel extends JPanel implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2571440252348086961L;
	//Screen Setting
	public final int originalTileSize=16;   //16 x 16 size
	public final int scale = 3;
	
	public final int tileSize = originalTileSize * scale;
	public final int maxScreenCol=16;
	public final int maxScreenRow=12;
	
	public final int screenWidth =  tileSize * maxScreenCol;  //768 p
	public final int screenHeight = tileSize * maxScreenRow;  //576 p
	
	
	//world map
	public final int maxWorldcol = 50;
	public final int maxWorldrow = 50;

	int FPS=60;
	
	tileManager tileM =  new tileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	
	public UI ui = new UI(this);
	
	//Starting Thread
	Thread gameThread;
	//calling Collision Checker Class
	public CollisionChecker cChecker = new CollisionChecker(this);
	//calling AssetSetter 
	public AssetSet set = new AssetSet(this);
	//calling Player class
	public Player player = new Player(this,keyH);
	//calling class as a array
	public Superobject obj[] = new Superobject [15];
	//Entity and audio
	public Sound sound = new Sound();
	
	public int gameState ;
	public final int playState=1 ;
	public final int pauseState=2 ;
	
    public GamePanel()
	{
		
		this.setPreferredSize(new Dimension(screenWidth , screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);  //rendering 
        this.addKeyListener(keyH);
        this.setFocusable(true);    
        
	}
 
	public void setUpGame()
	{
		set.setObj();
		playMusic(0); 
		
		gameState = playState;
	}
	
	public void startGameThread()
	{
		gameThread =new Thread(this);
		gameThread.start();
	}

	public void run () 
	{
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		
		long lastTime = System.nanoTime();
		long currentTime;
		long timer=0;
		while (gameThread != null) 
		{
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if (delta >= 1) 
			{
				update ();
				repaint (); 
				delta--;
			}
			
			if(timer >= 1000000000)
			{
              timer = 0;
			}
		}
	}
	
	public void update() 
	{
		player.update();
		
		if(gameState == playState)
		{
			player.update();
		}
		
		if(gameState == pauseState)
		{
			//N
		}
	}
	
	
	public boolean gameStart=false;
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	
		Graphics2D g2 = (Graphics2D)g;
		//Tile
		tileM.draw(g2);
		//Object
		for(int i =0 ; i<obj.length;i++)
		{
			if(obj[i] != null)
			{
				obj[i].draw(g2,this);

			}
		}
		
	    ui.gameStart(true,g2);  
	    
		//Player
		player.draw(g2);
	
		ui.draw(g2);
		g2.dispose();
	
	}
	
	public void playMusic(int i)
	{
		sound.setFile(i);
		sound.play();
		sound.loop();
	}
	
	public void stopMusic()
    {
		sound.stop();	
	}
	
    public void playSE(int i)
    {
    	sound.setFile(i);
    	sound.play();
    }
}
