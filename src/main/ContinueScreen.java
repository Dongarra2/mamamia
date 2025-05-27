package main;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import accesBDD.BDD;

public class ContinueScreen {
	
	GamePanel gp;
	MenuButton bNext,bEnd;
	Font arial_60;
	BufferedImage nextButton,nextButtonHover,endButton,endButtonHover,screen;
	
	public ContinueScreen(GamePanel gp) {
		this.gp=gp;
		arial_60=new Font("Arial", Font.PLAIN, 60/6*gp.scale);
		
		
		try {
			nextButton = ImageIO.read(getClass().getResourceAsStream("/continueScreen/nextButton.png"));
			nextButtonHover = ImageIO.read(getClass().getResourceAsStream("/continueScreen/nextButtonHover.png"));
			endButton = ImageIO.read(getClass().getResourceAsStream("/continueScreen/endButton.png"));
			endButtonHover = ImageIO.read(getClass().getResourceAsStream("/continueScreen/endButtonHover.png"));
			screen = ImageIO.read(getClass().getResourceAsStream("/continueScreen/screen.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bNext = new MenuButton(gp.tileSize*6, gp.tileSize*3, gp.tileSize*4, gp.tileSize);
		bEnd = new MenuButton(gp.tileSize*6, gp.tileSize*5, gp.tileSize*4, gp.tileSize);
		
		bNext.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {

				gp.gameState="play";
				gp.mapManager.loadMaps(gp.mapManager.chooseMap());

				bNext.hovered = false;
			}		
		});
		
		bEnd.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				//Send score to BDD	
				
				try {
					BDD.insertScore(gp.player.name, gp.player.score);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				gp.gameState="endScreen";
				bEnd.hovered = false;
			}		
		});
		
		
	}

	
	
	public void drawContinueScreen(Graphics2D g2) {
		
		g2.drawImage(screen, 0,0,gp.screenWidth,gp.screenHeight,null);
		g2.setFont(arial_60);
		g2.drawString("score : "+gp.player.score, 13*gp.tileSize/2, gp.tileSize*8);
		
		if(!bNext.hovered) {
			g2.drawImage(nextButton, bNext.posX, bNext.posY, bNext.width, bNext.height, null);
		}
		else {
			g2.drawImage(nextButtonHover, bNext.posX, bNext.posY, bNext.width, bNext.height, null);
		}
		if(!bEnd.hovered) {
			g2.drawImage(endButton, bEnd.posX, bEnd.posY, bEnd.width, bEnd.height, null);
		}
		else {
			g2.drawImage(endButtonHover, bEnd.posX, bEnd.posY, bEnd.width, bEnd.height, null);
		}
		
		gp.add(bNext);
		gp.add(bEnd);
		
	}
	
}
