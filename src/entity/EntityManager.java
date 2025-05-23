package entity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import main.GamePanel;

public class EntityManager {

	
	GamePanel gp;

	public EntityManager(GamePanel gp) {
		this.gp=gp;


				
	}
	
	public void setCrate(int index, int X, int Y) {
		
		gp.lootCrates[index] = new LootCrate(gp);
		gp.lootCrates[index].worldX = gp.tileSize*X;
		gp.lootCrates[index].worldY = gp.tileSize*Y;

				
	}
	
public void loadMapEntity(String filePath) {
		
		
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			int i =0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					
					switch(num) {
					case 0 : break;
					case 1 :
						setCrate(i, col, row);
						i++;
						break;
					case 2 :
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

	public void resetEntity() {
	
		for (int i = 0; i < gp.lootCrates.length; i++) {
			gp.lootCrates[i]=null;
		}
	}


	
}
