package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class tileManager {
	
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum [] [] ;
	
	public tileManager(GamePanel gp) 
	{
		this.gp=gp;
		
		tile = new Tile[100];
		mapTileNum = new int[gp.maxWorldcol][gp.maxWorldrow];
		
		getTileImage();
		loadMap("/maps/worldV2.txt");
	}
    
	public void  getTileImage()
	{
	        //placeholder
            setup(0,"grass00",false);
		    setup(1,"grass00",false);
		    setup(2,"grass00",false);
		    setup(3,"grass00",false);
		    setup(4,"grass00",false);
		    setup(5,"grass00",false);
		    setup(6,"grass00",false);
		    setup(7,"grass00",false);
		    setup(8,"grass00",false);
		    setup(9,"grass00",false);
		    
		    //placeholder
		    setup(10,"grass00",false);
		    setup(11,"grass01",false);
		    setup(12,"water00",true);
		    setup(13,"water01",true);
		    setup(14,"water02",true);
		    setup(15,"water03",true);
		    setup(16,"water04",true);
		    setup(17,"water05",true);
		    setup(18,"water06",true);
		    setup(19,"water07",true);
		    setup(20,"water08",true);
		    setup(21,"water09",true);
		    setup(22,"water10",true);
		    setup(23,"water11",true);
		    setup(24,"water12",true);
		    setup(25,"water13",true);
		    setup(26,"road00",false);
		    setup(27,"road01",false);
		    setup(28,"road02",false);
		    setup(29,"road03",false);
		    setup(30,"road04",false);
		    setup(31,"road05",false);
		    setup(32,"road06",false);
		    setup(33,"road07",false);
		    setup(34,"road08",false);
		    setup(35,"road09",false);
		    setup(36,"road10",false);
		    setup(37,"road11",false);
		    setup(38,"road12",false);
		    setup(39,"earth",false);
		    setup(40,"wall",true);
		    setup(41,"tree",true);
		    setup(42,"tree_road",true);
		    setup(43,"road_tree",true);
		    //Platform mark
		    setup(44,"00",false);
		    setup(45,"01",false);
		    setup(46,"02",false);
		    setup(47,"10",false);
		    setup(48,"11",false);
		    setup(49,"12",false);
		    setup(50,"20",false);
		    setup(51,"21",false);
		    setup(52,"22",false);
		    
			
	}
	
	public void setup(int index , String imagePath , boolean collision)
	{
		UtilityTool uTool =  new UtilityTool();
		
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+imagePath+".png"));
		    tile[index].image = uTool.scaleImage(tile[index].image , gp.tileSize , gp.tileSize);
		    tile[index].collision = collision;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void loadMap(String filepath)
	{
		try {
		
		InputStream is = getClass().getResourceAsStream(filepath);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
		for (int row = 0; row < gp.maxWorldrow; row++) {
		    String line = br.readLine();
		    String[] numbers = line.split(" ");
		    
		    for (int col = 0; col < gp.maxWorldcol; col++) {
		        int num = Integer.parseInt(numbers[col]);
		        mapTileNum[col][row] = num;
		    }
		}
		br.close();
		
		}catch(Exception e)
		{	

		}
	}
	
	public void draw(Graphics2D g2) {
	    for (int worldRow = 0; worldRow < gp.maxWorldrow; worldRow++) {
	        for (int worldCol = 0; worldCol < gp.maxWorldcol; worldCol++) {
	         
	        	int tileNum = mapTileNum[worldCol][worldRow];
	            int worldX = worldCol * gp.tileSize;
	            int worldY = worldRow * gp.tileSize;
	            
	            int screenX = worldX - gp.player.worldX + gp.player.screenX;
	            int screenY = worldY - gp.player.worldY + gp.player.screenY;
	            
	            
	            if(worldX + gp.tileSize > gp.player.worldX - gp.player.worldX && 
	               worldX - gp.tileSize < gp.player.worldX + gp.player.worldX && 
	               worldY + gp.tileSize > gp.player.worldY - gp.player.worldY && 
	               worldY - gp.tileSize < gp.player.worldY + gp.player.worldY)
	            {
	            	g2.drawImage(tile[tileNum].image, screenX, screenY,null);
	            }
	        }
	    }
	}

	
}
