package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import entity.GreenPotion;
import entity.Player;
import entity.PurplePotion;
import entity.RedPotion;

public class UI {
	
	BufferedImage UIBack,shield,shield_gray,sword,perdu;
	GamePanel gp;
	Player player;
	Font arial_20;
	Font arial_25;
	Font arial_60;
	int potionTextPosY,potionPosY,equipmentPosY,equipmentTextPosY,itemHeight,itemWidth,item1PosX,item2PosX,item3PosX;
	
	
	public UI(GamePanel gp,Player player) {
		
		this.gp=gp;
		this.player=player;
		arial_20=new Font("Arial", Font.PLAIN, 20/6*gp.scale);
		arial_25=new Font("Arial", Font.PLAIN, 25/6*gp.scale);
		arial_60=new Font("Arial", Font.PLAIN, 60/6*gp.scale);
		
		potionPosY=6*gp.tileSize;
		potionTextPosY = potionPosY + 3*gp.tileSize/2 + gp.tileSize/6;
		
		itemHeight = 3*gp.tileSize/2;
		itemWidth = gp.tileSize;
		
		item1PosX=gp.tileSize/2;
		item2PosX=2*gp.tileSize;
		item3PosX=7*gp.tileSize/2;
		
		equipmentPosY = 7*gp.tileSize/2;
		equipmentTextPosY = equipmentPosY + 3*gp.tileSize/2 + gp.tileSize/6;		


		
		try {
			UIBack = ImageIO.read(getClass().getResourceAsStream("/UI/UI_3.png"));
			shield = ImageIO.read(getClass().getResourceAsStream("/UI/shield.png"));
			shield_gray = ImageIO.read(getClass().getResourceAsStream("/UI/shield_gray.png"));
			sword = ImageIO.read(getClass().getResourceAsStream("/UI/sword.png"));
			perdu = ImageIO.read(getClass().getResourceAsStream("/UI/perdu.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
//		//potion buttons
//		JButton bRedPot = new JButton();
//		bRedPot.setBounds(11*gp.tileSize/4, potionPosY, itemWidth, itemHeight);
//		bRedPot.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				RedPotion.usePotion(player);
//			}
//		});
//		JButton bGreenPot = new JButton();
//		bGreenPot.setBounds(6*gp.tileSize/4, potionPosY, itemWidth, itemHeight);
//		bGreenPot.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				GreenPotion.usePotion(player);
//			}
//		});
//		JButton bPurplePot = new JButton();
//		bPurplePot.setBounds(1*gp.tileSize/4, potionPosY, itemWidth, itemHeight);
//		bPurplePot.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				PurplePotion.usePotion(player);
//			}
//		});
//		
//		
//		gp.add(bRedPot);
//		gp.add(bGreenPot);
//		gp.add(bPurplePot);
//		
		
		
		
	}
	
	
	
	public void draw(Graphics2D g2) {
		
		g2.drawImage(UIBack,0,0,5*gp.tileSize,gp.maxScreenRow*gp.tileSize,null);
		
		g2.setFont(arial_25);
		g2.setColor(Color.white);
		
		
		//////////CHARACTER//////////
		
		g2.drawString("HP : "+player.HP+"/"+player.maxHP, gp.tileSize/4, 9*gp.tileSize/8);
		g2.drawString("Damage : "+player.minDamage+" - "+player.maxDamage, gp.tileSize/4, 12*gp.tileSize/8);
		g2.drawString("Score : "+player.score, gp.tileSize/4, 15*gp.tileSize/8);
		
		

		
		//////////POTIONS////////
		
		g2.setFont(arial_20);
	
		
		//potion sprites and amounts
		if(player.redPotCount>0) {
			g2.drawImage(RedPotion.redPotion,item3PosX,potionPosY,itemWidth,itemHeight,null);
			g2.drawString("Potion3 : x"+player.redPotCount, item3PosX, potionTextPosY);
		}
		else {
			g2.drawImage(RedPotion.redPotion2,item3PosX,potionPosY,itemWidth,itemHeight,null);
			g2.drawString("Potion3", item3PosX, potionTextPosY);
		}
		
		if(player.greenPotCount>0) {
			g2.drawImage(GreenPotion.greenPotion,item2PosX,potionPosY,itemWidth,itemHeight,null);
			g2.drawString("Potion2 : x"+player.greenPotCount, item2PosX, potionTextPosY);
			}
		else {
			g2.drawImage(GreenPotion.greenPotion2,item2PosX,potionPosY,itemWidth,itemHeight,null);
			g2.drawString("Potion2", item2PosX, potionTextPosY);
			}
		
		if(player.purplePotCount>0) {
			g2.drawImage(PurplePotion.purplePotion,item1PosX,potionPosY,itemWidth,itemHeight,null);
			g2.drawString("Potion1 : x"+player.purplePotCount, item1PosX, potionTextPosY);
		}
		else {
			g2.drawImage(PurplePotion.purplePotion2,item1PosX,potionPosY,itemWidth,itemHeight,null);
			g2.drawString("Potion1", item1PosX, potionTextPosY);
		}


		
		//////////EQUIPMENT////////
		
		g2.drawString("Weapon", item1PosX, equipmentTextPosY);
		g2.drawString("Armor", item2PosX, equipmentTextPosY);
		g2.drawString("Shield", item3PosX, equipmentTextPosY);

		
		g2.drawImage(sword,item1PosX,equipmentPosY,itemWidth,itemHeight,null);
		
		if(player.hasShield==true) {
			g2.drawImage(shield,item3PosX,equipmentPosY,itemWidth,itemHeight,null);
		}
		else {
			g2.drawImage(shield_gray,item3PosX,equipmentPosY,itemWidth,itemHeight,null);			
		}
		
		if(gp.gameState=="dead") {
			g2.drawImage(perdu, 0,0,gp.screenWidth,gp.screenHeight,null);
			g2.setFont(arial_60);
			g2.drawString("score : "+gp.player.score, gp.tileSize*5, gp.tileSize*8);
		}
		
		g2.dispose();
	}
}
