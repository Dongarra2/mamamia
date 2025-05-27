package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

	public class InfoScreen {
		
		GamePanel gp;
		Font arial_40;
		Font arial_20;
		BufferedImage backButton,backButtonHover,Screen;
		MenuButton bBack;
		
		
	
		public InfoScreen(GamePanel gp) {
			this.gp = gp;
			arial_40=new Font("Arial", Font.PLAIN, 40/6*gp.scale);
			arial_20=new Font("Arial", Font.PLAIN, 20/6*gp.scale);
			
			
			///BUTTONS SETUP////
			
			
			bBack = new MenuButton(23*gp.tileSize/2, gp.tileSize/2, gp.tileSize*4, gp.tileSize);
			
			bBack.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					gp.gameState="titleScreen";
					bBack.hovered = false;
				}
			
			});
			
			try {
				Screen = ImageIO.read(getClass().getResourceAsStream("/infoScreen/infoScreen.png"));
				backButton = ImageIO.read(getClass().getResourceAsStream("/infoScreen/backButton.png"));
				backButtonHover = ImageIO.read(getClass().getResourceAsStream("/infoScreen/backButtonHover.png"));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
		}
	
		
		
		
		public void drawInfoScreen(Graphics2D g2) {
			
			g2.drawImage(Screen, 0, 0, gp.screenWidth, gp.screenHeight,null);
			
			if(bBack.hovered==false) {
				
				g2.drawImage(backButton, bBack.posX, bBack.posY, bBack.width, bBack.height, null);
			}
			else {
				g2.drawImage(backButtonHover, bBack.posX, bBack.posY, bBack.width, bBack.height, null);
			}
			
			gp.add(bBack);
			
			g2.setFont(arial_40);
			g2.setColor(Color.WHITE);
			g2.drawString("But du jeu : Eliminez le plus de monstres sans mourir afin d'obtenir le meilleur score.", gp.tileSize, 2*gp.tileSize);
			g2.drawString("Tuez au moins 10 monstres sur la carte pour pouvoir passer à la carte suivante ou", gp.tileSize, 6*gp.tileSize/2);
			g2.drawString("sauvegarder votre score en empruntant le portail : ", gp.tileSize, 4*gp.tileSize);
			g2.drawImage(gp.tileM.tile[9].image, gp.tileSize*10,7*gp.tileSize/2,gp.tileSize,gp.tileSize,null);
			g2.drawString("Potions :", gp.tileSize, 5*gp.tileSize);
			g2.drawImage(gp.redPot.redPotion, gp.tileSize*1,5*gp.tileSize,gp.tileSize,3*gp.tileSize/2,null);
			g2.drawImage(gp.greenPot.greenPotion, gp.tileSize*1,13*gp.tileSize/2,gp.tileSize,3*gp.tileSize/2,null);
			g2.drawImage(gp.purplePot.purplePotion, gp.tileSize*5,5*gp.tileSize,gp.tileSize,3*gp.tileSize/2,null);
			g2.drawString("rend 10 PV", 2*gp.tileSize, 6*gp.tileSize);
			g2.drawString("+1 dégats min", 2*gp.tileSize, 15*gp.tileSize/2);
			g2.drawString("+1 dégats max", 6*gp.tileSize, 6*gp.tileSize);
			g2.drawString("Equipement :", 9*gp.tileSize, 5*gp.tileSize);
			g2.drawImage(gp.ui.shield, gp.tileSize*9,5*gp.tileSize,gp.tileSize,3*gp.tileSize/2,null);
			g2.drawString("réduit les dégats subis de 2", 10*gp.tileSize, 6*gp.tileSize);
			
			g2.setFont(arial_20);
			g2.drawString("Oui je sais on voit rien je vais changer la couleur", 10*gp.tileSize, 8*gp.tileSize);
			


			
		}
	

}
