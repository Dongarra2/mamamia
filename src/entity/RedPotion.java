package entity;

import java.awt.image.BufferedImage;
import main.GamePanel;

public class RedPotion extends Entity{
	
	public static BufferedImage redPotion,redPotion2;
	Player player;
	
	
	public RedPotion(GamePanel gp, Player player) {
		
		super(gp);
		this.player=player;
		
		redPotion = setupImage("/UI/red_potion", gp.tileSize, 3*gp.tileSize/2);
		redPotion2 = setupImage("/UI/red_potion_grayed", gp.tileSize, 3*gp.tileSize/2);
		
	
	}
	
	public static void getRedPotion(Player player) {
		player.redPotCount+=1;
	}
	
	public static void usePotion(Player player) {
		
		if(player.redPotCount>0 && player.HP<player.maxHP) {
		player.HP+=10;
		player.redPotCount--;
		}
		
	}
	

}
