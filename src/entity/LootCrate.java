package entity;

import java.util.Random;
import main.GamePanel;

public class LootCrate extends Entity{


	
	public LootCrate(GamePanel gp) {
		
		super(gp);
		getImage();
		
	}
	
	public void getImage() {
		
		down1 = setupImage("/tiles/loot_Crate");
	}
	
	@Override
	public String loot() {
		String loot="none";
		
		Random random = new Random();
		int randInt = random.nextInt(10);
				
		if(randInt<=5) {
			loot = "redPot";
		}
		else if(randInt<=7) {
			loot = "greenPot";
		}
		else if(randInt<=9) {
			loot = "purplePot";
		}
		else {
			loot="none";
			
		}	
		
		return loot;
	}
	
	
}
