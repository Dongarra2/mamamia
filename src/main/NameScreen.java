package main;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTextField;

public class NameScreen {

	
	GamePanel gp;
	Font arial_60;
	BufferedImage playButton,playButtonHover,backButton,backButtonHover,Screen;
	MenuButton bPlay,bBack;
	JTextField textField= new JTextField("NOM");;
	
	

	public NameScreen(GamePanel gp) {
		
		this.gp = gp;
		arial_60=new Font("Arial", Font.PLAIN, 60/6*gp.scale);
		textField.setFont(arial_60);
		textField.setBounds(gp.tileSize*6,gp.tileSize*3,gp.tileSize*4,gp.tileSize);
		textField.setHorizontalAlignment(JTextField.CENTER);
		
		
		///BUTTONS SETUP////
		
		
		bPlay = new MenuButton(gp.tileSize*6, gp.tileSize*5, gp.tileSize*4, gp.tileSize);
		
		bPlay.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gp.player.name=textField.getText();
				gp.gameState="classScreen";
				bPlay.hovered = false;
			}
		
		});
		
		bBack = new MenuButton(gp.tileSize*6, gp.tileSize*7, gp.tileSize*4, gp.tileSize);
		
		bBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gp.gameState="titleScreen";
				bBack.hovered = false;
			}
		
		});
		
		try {
			Screen = ImageIO.read(getClass().getResourceAsStream("/nameScreen/screen.png"));
			playButton = ImageIO.read(getClass().getResourceAsStream("/nameScreen/playButton.png"));
			playButtonHover = ImageIO.read(getClass().getResourceAsStream("/nameScreen/playButtonHover.png"));
			backButton = ImageIO.read(getClass().getResourceAsStream("/nameScreen/backButton.png"));
			backButtonHover = ImageIO.read(getClass().getResourceAsStream("/nameScreen/backButtonHover.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	
	
	
	public void drawNameScreen(Graphics2D g2) {
		
		g2.drawImage(Screen, 0, 0, gp.screenWidth, gp.screenHeight,null);
		
		if(bPlay.hovered==false) {
			
			g2.drawImage(playButton, bPlay.posX, bPlay.posY, bPlay.width, bPlay.height, null);
		}
		else {
			g2.drawImage(playButtonHover, bPlay.posX, bPlay.posY, bPlay.width, bPlay.height, null);
			gp.repaint();
		}
		
		if(bBack.hovered==false) {
			
			g2.drawImage(backButton, bBack.posX, bBack.posY, bBack.width, bBack.height, null);
		}
		else {
			g2.drawImage(backButtonHover, bBack.posX, bBack.posY, bBack.width, bBack.height, null);
			gp.repaint();
		}
		
		gp.add(bPlay);
		gp.add(bBack);
		gp.add(textField);
		
		
		


		
	}
}
