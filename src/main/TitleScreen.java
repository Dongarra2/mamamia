package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TitleScreen {

	GamePanel gp;
	Font arial_20;
	Font arial_25;
	Font arial_60;
	BufferedImage infoButton,infoButtonHover,exitButton,exitButtonHover,playButton,playButtonHover,Screen;
	MenuButton bExit,bPlay,bInfo;
	
	public TitleScreen(GamePanel gp) {
		
		this.gp=gp;
		arial_20=new Font("Arial", Font.PLAIN, 20/6*gp.scale);
		arial_25=new Font("Arial", Font.PLAIN, 25/6*gp.scale);
		arial_60=new Font("Arial", Font.PLAIN, 60/6*gp.scale);
		
		
		///BUTTONS SETUP////
		
		
		bExit = new MenuButton(gp.tileSize*6, gp.tileSize*7, gp.tileSize*4, gp.tileSize);
		
		bExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		
		});


		bPlay = new MenuButton(gp.tileSize*6, gp.tileSize*3, gp.tileSize*4, gp.tileSize);
		
		bPlay.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gp.gameState="nameScreen";
				gp.repaint();
				bPlay.hovered = false;
			}
		
		});
		
		bInfo = new MenuButton(gp.tileSize*6, gp.tileSize*5, gp.tileSize*4, gp.tileSize);
		
		bInfo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gp.gameState="info";
				bInfo.hovered = false;
			}
		
		});
		
		
					
		try {
			Screen = ImageIO.read(getClass().getResourceAsStream("/titleScreen/titleScreen.png"));
			playButton = ImageIO.read(getClass().getResourceAsStream("/titleScreen/playButton.png"));
			playButtonHover = ImageIO.read(getClass().getResourceAsStream("/titleScreen/playButtonHover.png"));
			exitButton = ImageIO.read(getClass().getResourceAsStream("/titleScreen/exitButton.png"));
			exitButtonHover = ImageIO.read(getClass().getResourceAsStream("/titleScreen/exitButtonHover.png"));
			infoButton = ImageIO.read(getClass().getResourceAsStream("/titleScreen/infoButton.png"));
			infoButtonHover = ImageIO.read(getClass().getResourceAsStream("/titleScreen/infoButtonHover.png"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void drawTitleScreen(Graphics2D g2) {
		
			g2.drawImage(Screen, 0, 0, gp.screenWidth, gp.screenHeight,null);
			g2.setFont(arial_60);
			g2.setColor(Color.white);
			g2.drawString("TITRE", 3*gp.tileSize*gp.maxScreenRow/4, gp.tileSize/2);
			
			
			if(!bExit.hovered) {
				g2.drawImage(exitButton, bExit.posX, bExit.posY, bExit.width, bExit.height, null);
			}
			else {
				g2.drawImage(exitButtonHover, bExit.posX, bExit.posY, bExit.width, bExit.height, null);
			}
						
			if(!bPlay.hovered) {
				g2.drawImage(playButton, bPlay.posX, bPlay.posY, bPlay.width, bPlay.height, null);
			}
			else {
				g2.drawImage(playButtonHover, bPlay.posX, bPlay.posY, bPlay.width, bPlay.height, null);
			}
			
			
			if(!bInfo.hovered) {
				g2.drawImage(infoButton, bInfo.posX, bInfo.posY, bInfo.width, bInfo.height, null);
			}
			else {
				g2.drawImage(infoButtonHover, bInfo.posX, bInfo.posY, bInfo.width, bInfo.height, null);
			}
						
			gp.add(bPlay);
			gp.add(bExit);
			gp.add(bInfo);
		
		
	}
	
}
