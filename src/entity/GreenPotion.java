package entity;

import java.awt.image.BufferedImage;
import main.GamePanel;

public class GreenPotion extends Entity{
	
	public static BufferedImage greenPotion,greenPotion2;
	Player player;
	
	
	public GreenPotion(GamePanel gp, Player player) {
		
		super(gp);
		this.player=player;
		
		greenPotion = setupImage("/UI/green_potion", gp.tileSize, 3*gp.tileSize/2);
		greenPotion2 = setupImage("/UI/green_potion_grayed", gp.tileSize, 3*gp.tileSize/2);
			
	}
	
	public static void getGreenPotion(Player player) {
		player.greenPotCount+=1;
	}
	
	public static void usePotion(Player player) {
		
		if(player.greenPotCount>0 && player.minDamage<player.maxDamage) {
		player.minDamage++;
		player.greenPotCount--;
		}
		
		
	}
	


}
