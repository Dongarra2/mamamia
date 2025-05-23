package entity;

import java.awt.image.BufferedImage;
import main.GamePanel;

public class PurplePotion extends Entity{
	
	public static BufferedImage purplePotion,purplePotion2;
	Player player;
	
	
	public PurplePotion(GamePanel gp, Player player) {
		
		super(gp);
		this.player=player;
		
		purplePotion = setupImage("/UI/purple_potion", gp.tileSize, 3*gp.tileSize/2);
		purplePotion2 = setupImage("/UI/purple_potion_grayed", gp.tileSize, 3*gp.tileSize/2);
		
		
	}
	
	
	public static void getPurplePotion(Player player) {
		player.purplePotCount+=1;
	}
	
	
	public static void usePotion(Player player) {
		
		if(player.purplePotCount>0) {
		player.maxDamage++;
		player.purplePotCount--;
		}
		
	}


}
