package monsters;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import main.GamePanel;

public class MonsterManager {
	
	GamePanel gp;
	
	
	public MonsterManager(GamePanel gp) {
		this.gp=gp;


				
	}
	
	private void setSkel(int index, int X, int Y) {
		
		gp.monster[index] = new Monster_Skeleton(gp);
		gp.monster[index].worldX = gp.tileSize*X;
		gp.monster[index].worldY = gp.tileSize*Y;
				
	}
	
	public void setArmorSkel(int index, int X, int Y) {
		
		gp.monster[index] = new Monster_ArmorSkeleton(gp);
		gp.monster[index].worldX = gp.tileSize*X;
		gp.monster[index].worldY = gp.tileSize*Y;

				
	}
	
	public void loadMapMonsters(String filePath) {
		
		
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			int i =1;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow && gp.monster[gp.arrayLength-1]==null) {
				
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol && gp.monster[gp.arrayLength-1]==null) {
					String numbers[] = line.split(" ");
					
					switch(numbers[col]) {
					case "0" : break;
					case "1" :
						if (spawnMonster()==true) {
						setSkel(i, col, row);
						i++;
						}
						break;
					case "2" :
						if (spawnMonster()==true) {
						setArmorSkel(i, col, row);
						i++;
						}
						break;
					}
									
					col++;			
				}
				if (col == gp.maxWorldCol) {
					col=0;
					row++;
				}
			}
			br.close();
			
			}catch(Exception e) {
		}
		
		
	}
	
	private boolean spawnMonster() {
		
		Random random = new Random();
		int randInt = random.nextInt(2);
		
		if (randInt==0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void resetMonsters() {
		
		for (int i = 0; i < gp.monster.length; i++) {
			gp.monster[i]=null;
		}
	}
	
	
	

}

