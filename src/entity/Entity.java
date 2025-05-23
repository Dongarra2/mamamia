package entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.Tools;

public class Entity {
	
	GamePanel gp;
	
	public int worldX, worldY;
	public int speed = 1;
	
	public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
	public String direction = "down";
	
	public int spriteCounter = 0;
	public boolean spriteNumber = true;
	
	public boolean collisionOn = false;
	
	public int score;
	
	public int HP,maxHP,minDamage,maxDamage,shield;
	public boolean hasTakenDamage=false;
	public int damageTaken,damageCounter;
	public String name;
	Font arial_40;
	
	public Entity(GamePanel gp) {
		this.gp = gp;
		
		arial_40=new Font("Arial", Font.PLAIN, 40/6*gp.scale);
	}
	
	public BufferedImage setupImage(String imagePath) {
		
		Tools upTool = new Tools();
		BufferedImage image = null;
		
		try {
			image=ImageIO.read(getClass().getResourceAsStream(imagePath+".png"));
			image = upTool.scaleImage(image, gp.tileSize, gp.tileSize);			
			
		}catch(IOException e) {
			e.printStackTrace();
		}		
		return image;
	}
	
	public BufferedImage setupImage(String imagePath, int x, int y) {
		
		Tools upTool = new Tools();
		BufferedImage image = null;
		
		try {
			image=ImageIO.read(getClass().getResourceAsStream(imagePath+".png"));
			image = upTool.scaleImage(image, x, y);			
			
		}catch(IOException e) {
			e.printStackTrace();
		}		
		return image;
	}
	
	public int calcDmg() {
		
		int dmg = minDamage + (int)(Math.random() * ((maxDamage - minDamage) + 1));
		
		return dmg;
	}


	public void draw(Graphics2D g2) {
	
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			worldX -gp.tileSize < gp.player.worldX + gp.player.screenX &&
			worldY +gp.tileSize > gp.player.worldY - gp.player.screenY &&
			worldY -gp.tileSize < gp.player.worldY + gp.player.screenY) {
			
			if (spriteNumber==true) {
				
				switch(direction) {
				case "up":
					image = up1;
					break;
				case "down":
					image = down1;
					break;
				case "left":
					image = left1;
					break;
				case "right":
					image = right1;
					break;
				}
				
			}
			else {
				switch(direction) {
				case "up":
					image = up2;
					break;
				case "down":
					image = down2;
					break;
				case "left":
					image = left2;
					break;
				case "right":
					image = right2;
					break;
				}
			}
			
			g2.drawImage(image, screenX, screenY, null);
			}
		
		if(hasTakenDamage==true&&damageCounter<(60/speed)) {
			damageCounter +=1;
			drawDmg(g2);
		}
		else {
			damageCounter=0;
			hasTakenDamage=false;
			}

		
		}
	
	public String loot() {
		String loot="none";
		return loot;
	}

	public void drawDmg(Graphics2D g2) {
		
		if (hasTakenDamage==true) {
			g2.setColor(Color.red);
			g2.setFont(arial_40);
			g2.drawString(Integer.toString(damageTaken), worldX - gp.player.worldX + gp.player.screenX, worldY - gp.player.worldY + gp.player.screenY);
		}
		
	}


}
