package monsters;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class Monster_ArmorSkeleton extends Entity{

		
	public Monster_ArmorSkeleton(GamePanel gp) {
		
		super(gp);

		name = "Armored Skeleton";
		maxHP=15 * (10+gp.difficulty)/10;
		HP=maxHP;
		minDamage=3 * (10+gp.difficulty)/10;
		maxDamage=8 * (10+gp.difficulty)/10;
		score = 15 * (10+gp.difficulty)/10;
		shield = 1 * (10+gp.difficulty)/10;
		
		getImage();
		
	}
	
	public void getImage() {
		
		down1 = setupImage("/monsters/ArmorSkel1");
	}
	
	@Override
	public String loot() {
		String loot="none";
		
		Random random = new Random();
		int randInt = random.nextInt(100);
				
		if(randInt<=5) {
			loot = "redPot";
		}
		else if(randInt<=7) {
			loot = "greenPot";
		}
		else if(randInt<=9) {
			loot = "purplePot";
		}
		else if(randInt<=11) {
			loot = "shield";
		}
		else {
			loot="none";
			
		}	
		
		return loot;
	}
}
