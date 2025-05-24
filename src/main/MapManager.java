package main;

import java.util.Random;

public class MapManager {

	GamePanel gp;
	int maxNumMap;
	int remainingMaps;
	int[] maps;
	
	
	
	
	
	public MapManager(GamePanel gp) {
		this.gp = gp;
		
		
		maxNumMap = 3;
		remainingMaps=maxNumMap;
		maps = new int[maxNumMap];

	}

	
	public int chooseMap() {
		
		if(remainingMaps!=0) {
			
						
			while(true) {
				
				Random random = new Random();
				int randInt = random.nextInt(maxNumMap+1);
				
				boolean newMap = true;
				
				for(int i=0; i<maxNumMap; i++) {
					if(maps[i] == randInt) {
						newMap = false;			
					}					
				}
				if(newMap==true) {
					for(int i=0; i<maxNumMap; i++) {
						if(maps[i] == 0) {
							maps[i] = randInt;
							remainingMaps--;
							return randInt;
						}
					}
				}		
			}
		}
		return 0;
	}
	
	public void loadMaps(int mapNum) {
		
		if (mapNum!=0) {
			
			
			gp.player.monstersKilledThisMap=0;
			gp.tileM.resetMap();
			gp.mManager.resetMonsters();
			gp.eManager.resetEntity();
			gp.tileM.loadMap("/maps/0"+mapNum+"map.txt");
			gp.mManager.setArmorSkel(0, 44, 4);
			gp.mManager.loadMapMonsters("/maps/0"+mapNum+"monsterMap.txt");
			gp.eManager.loadMapEntity("/maps/0"+mapNum+"entityMap.txt");
			gp.player.worldX=1*gp.tileSize;
			gp.player.worldY=1*gp.tileSize;
			gp.mManager.monstersRemaining();
			gp.difficulty++;
		}
	}
	
	
	
	
	
}
