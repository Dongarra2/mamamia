package main;

import entity.Player;

public class CollisionChecker {
	
	GamePanel gp;

	
	public CollisionChecker (GamePanel gp) {
		this.gp = gp;
	}
	
	
	
	
	public void checkCollision(Player player) {
				
		int playerX = player.worldX/gp.tileSize;
		int playerY = player.worldY/gp.tileSize;
		
		int playerLeftCol = playerX -1;
		int playerRightCol = playerX +1;
		int playerTopRow = playerY -1;
		int playerBottomRow = playerY +1;
		
		int tileX = 0,tileY = 0;
		

		
		int tileNum = 0;
		
		
		///TILE COLLISION
		
		
		
		switch(player.direction) {
		case"up":
			tileX=playerX;tileY=playerTopRow;
			break;
		case"down":
			tileX=playerX;tileY=playerBottomRow;
			break;
		case"left":
			tileX=playerLeftCol;tileY=playerY;
			break;
		case"right":
			tileX=playerRightCol;tileY=playerY;
			break;
		}
		
		
		tileNum=gp.tileM.mapTileNum[tileX][tileY];
		
		if(tileNum==9) {
			if(gp.mManager.monstersRemaining==0 || player.monstersKilledThisMap>=3) {
				gp.gameState="continue";
				player.collisionOn=true;
			}
		}
		
		
		
		else if(gp.tileM.tile[tileNum].collision==true) {
			player.collisionOn=true;
		}
		
		
		
		
				///OBJECT COLLISION///
		
		for (int i = 0; i < gp.lootCrates.length; i++) {
			if(gp.lootCrates[i]!=null) {
							
				if (gp.lootCrates[i].worldX/gp.tileSize == tileX && gp.lootCrates[i].worldY/gp.tileSize == tileY) {
				
					player.getLoot(gp.lootCrates[i].loot());
					gp.lootCrates[i]=null;
					
				}
			}
		}
				
		
		
				///MONSTER COLLISION
		
		
		
		for (int i = 0; i < gp.monster.length; i++) {
			if(gp.monster[i]!=null) {
							
				if (gp.monster[i].worldX/gp.tileSize == tileX && gp.monster[i].worldY/gp.tileSize == tileY) {
				
					//combat
					
					player.attack=true;
					int playerDmg=player.calcDmg();
					int monsterDmg=gp.monster[i].calcDmg();
					
					int realPlayerDmg = playerDmg-gp.monster[i].shield;
					int realMonsterDmg = monsterDmg-player.shield;
					
					if (realPlayerDmg<0) {realPlayerDmg=0;}
					if (realMonsterDmg<0) {realMonsterDmg=0;}
					
//					System.out.println("playerDmg = "+playerDmg+" monsterDmg = "+monsterDmg);
					
					gp.monster[i].HP-=realPlayerDmg;
					
					
					if(gp.monster[i].HP <= 0) {
						player.score+=gp.monster[i].score;						
						player.getLoot(gp.monster[i].loot());
						player.monstersKilledThisMap++;
						gp.monster[i].hasTakenDamage=true;	
						gp.monster[i].damageTaken=realPlayerDmg;
						gp.mManager.monstersRemaining--;						
						gp.monster[i]=null;
						

					}
					else {
						player.collisionOn=true;
						player.HP-=realMonsterDmg;
						player.damageTaken=realMonsterDmg;
						player.hasTakenDamage=true;
						gp.monster[i].damageTaken=realPlayerDmg;
						gp.monster[i].hasTakenDamage=true;
					}
					break;
				}
			}
		}
	}
	


}
