package monsters;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class Monster_Skeleton extends Entity{

	
	public Monster_Skeleton(GamePanel gp) {
		
		super(gp);

		name = "Skeleton";
		maxHP=10 * (10+gp.difficulty)/10;
		HP=maxHP;
		minDamage=1 * (10+gp.difficulty)/10;
		maxDamage=4 * (10+gp.difficulty)/10;
		score = 10 * (10+gp.difficulty)/10;
		shield = 0 * (10+gp.difficulty)/10;
		
		getImage();
		
	}
	
	public void getImage() {
		
		down1 = setupImage("/monsters/Skel1");
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
