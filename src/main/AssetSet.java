package main;

import object.Obj_Boote;
import object.Obj_chest;
import object.Obj_door;
import object.Obj_key;
import object.obj_slowtrap;

public class AssetSet 
{
		 GamePanel gp;
		
		public AssetSet(GamePanel gp)
		{
			this.gp=gp;
		}
		
		public void setObj()
		{
			
			//Key
			
			gp.obj[0]=new Obj_key(gp);
			gp.obj[0].worldX = 23 * gp.tileSize;    //D
			gp.obj[0].worldY = 07 *  gp.tileSize;
			
			gp.obj[1]=new Obj_key(gp);
			gp.obj[1].worldX = 36 * gp.tileSize;     //D
			gp.obj[1].worldY = 37 *  gp.tileSize;
			
			gp.obj[2]=new Obj_key(gp);
			gp.obj[2].worldX = 38 * gp.tileSize;
			gp.obj[2].worldY = 9 * gp.tileSize;       //D
			
			gp.obj[3]=new Obj_key(gp);
			gp.obj[3].worldX = 23 * gp.tileSize;
			gp.obj[3].worldY = 39 *  gp.tileSize;    //D
			
			gp.obj[4]=new Obj_key(gp);
			gp.obj[4].worldX = 36 * gp.tileSize;
			gp.obj[4].worldY = 21 *  gp.tileSize;
			
			gp.obj[5]=new Obj_key(gp);
			gp.obj[5].worldX = 9 * gp.tileSize;
			gp.obj[5].worldY = 22 *  gp.tileSize;
			
		    //Chest
			gp.obj[6]=new Obj_chest(gp);
			gp.obj[6].worldX = 10 * gp.tileSize;
			gp.obj[6].worldY = 10 *  gp.tileSize;    //D
			
			//Door
			gp.obj[7]=new Obj_door(gp);
			gp.obj[7].worldX = 10 * gp.tileSize;      //D
			gp.obj[7].worldY = 12 *  gp.tileSize;
			
			gp.obj[8]=new Obj_door(gp);
			gp.obj[8].worldX = 23 * gp.tileSize;        //D
			gp.obj[8].worldY = 18 *  gp.tileSize;
			
			gp.obj[9]=new Obj_door(gp);
			gp.obj[9].worldX = 23 * gp.tileSize;
			gp.obj[9].worldY = 24 *  gp.tileSize;       //D
			
			gp.obj[10]=new Obj_door(gp);
			gp.obj[10].worldX = 38 * gp.tileSize;
			gp.obj[10].worldY = 16 *  gp.tileSize;    //D
			
			gp.obj[11]=new Obj_door(gp);
			gp.obj[11].worldX = 36 * gp.tileSize;
			gp.obj[11].worldY = 30 *  gp.tileSize;    //D
			
			gp.obj[12]=new Obj_door(gp);
			gp.obj[12].worldX = 9 * gp.tileSize;
			gp.obj[12].worldY = 24 *  gp.tileSize;      //D
			
			//Speed Boost			
			gp.obj[13]=new Obj_Boote(gp);
			gp.obj[13].worldX = 20 * gp.tileSize;
			gp.obj[13].worldY = 21 *  gp.tileSize;     //D
			
			//Slow Trap
			gp.obj[14]=new obj_slowtrap(gp);
			gp.obj[14].worldX = 24 * gp.tileSize;
			gp.obj[14].worldY = 23 *  gp.tileSize;   //D
			
			
			
			}

}
