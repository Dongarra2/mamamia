package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EndScreen {
	
	GamePanel gp;
	MenuButton bMenu;
	Font arial_60;
	BufferedImage menuButton,menuButtonHover,screen;
	
	
	public EndScreen(GamePanel gp) {
		this.gp = gp;
		
		arial_60=new Font("Arial", Font.PLAIN, 60/6*gp.scale);
		
		try {
			menuButton = ImageIO.read(getClass().getResourceAsStream("/endScreen/menuButton.png"));
			menuButtonHover = ImageIO.read(getClass().getResourceAsStream("/endScreen/menuButtonHover.png"));
			screen = ImageIO.read(getClass().getResourceAsStream("/endScreen/endScreen.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		bMenu = new MenuButton(gp.tileSize*6, gp.tileSize*7, gp.tileSize*4, gp.tileSize);		
		bMenu.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				gp.gameState="titleScreen";
				bMenu.hovered = false;
			}		
		});
		
	}
	
	public void drawEndScreen(Graphics2D g2) {
		
		g2.drawImage(screen, 0,0,gp.screenWidth,gp.screenHeight,null);
		g2.setFont(arial_60);
		g2.setColor(Color.white);
		g2.drawString(gp.player.name,6*gp.tileSize, gp.tileSize*5);
		g2.drawString(gp.player.score+" points",6*gp.tileSize, gp.tileSize*6);
		
		if(bMenu.hovered==false) {
			g2.drawImage(menuButton, bMenu.posX, bMenu.posY, bMenu.width, bMenu.height, null);
		}
		else {
			g2.drawImage(menuButtonHover, bMenu.posX, bMenu.posY, bMenu.width, bMenu.height, null);
		}
		
		gp.add(bMenu);
		
	}

}
