package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class TitleScreen {

	GamePanel gp;
	Font arial_20;
	Font arial_25;
	Font arial_60;
	boolean infoHover,exitHover,playHover = false;
	BufferedImage infoButton,infoButtonHover,exitButton,exitButtonHover,playButton,playButtonHover,Screen;
	JButton bExit,bPlay,bInfo;
	
	public TitleScreen(GamePanel gp) {
		this.gp=gp;
		arial_20=new Font("Arial", Font.PLAIN, 20/6*gp.scale);
		arial_25=new Font("Arial", Font.PLAIN, 25/6*gp.scale);
		arial_60=new Font("Arial", Font.PLAIN, 60/6*gp.scale);
		
		
		///BUTTONS SETUP////
		
		bExit = new JButton();		
		bExit.setOpaque(false);
		bExit.setContentAreaFilled(false);
		bExit.setBorderPainted(false);
		bExit.setVisible(true);
		bExit.setBounds(gp.tileSize*6, gp.tileSize*7, gp.tileSize*4, gp.tileSize);	
		
					
		bExit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				exitHover = true;
			    }
			public void mouseExited(MouseEvent e) {
				exitHover = false;
			    }
		});
		bExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		bPlay = new JButton();		
		bPlay.setOpaque(false);
		bPlay.setContentAreaFilled(false);
		bPlay.setBorderPainted(false);
		bPlay.setVisible(true);
		bPlay.setBounds(gp.tileSize*6, gp.tileSize*3, gp.tileSize*4, gp.tileSize);	
		
		bPlay.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				playHover = true;
			    }
			public void mouseExited(MouseEvent e) {
				playHover = false;
			    }
		});
		
		bPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gp.gameState="play";
				bPlay.setVisible(false);
				playHover = false;
			}
		});
		
		bInfo = new JButton();		
		bInfo.setOpaque(false);
		bInfo.setContentAreaFilled(false);
		bInfo.setBorderPainted(false);
		bInfo.setVisible(true);
		bInfo.setBounds(gp.tileSize*6, gp.tileSize*5, gp.tileSize*4, gp.tileSize);	
		
					
		bInfo.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				infoHover = true;
			    }
			public void mouseExited(MouseEvent e) {
				infoHover = false;
			    }
		});
		
		bInfo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gp.gameState="info";
				infoHover = false;
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
			
			
			if(exitHover==false) {
				g2.drawImage(exitButton, gp.tileSize*6, gp.tileSize*7, gp.tileSize*4, gp.tileSize, null);
			}
			else {
				g2.drawImage(exitButtonHover, gp.tileSize*6, gp.tileSize*7, gp.tileSize*4, gp.tileSize, null);
			}
						
			if(playHover==false) {
				g2.drawImage(playButton, gp.tileSize*6, gp.tileSize*3, gp.tileSize*4, gp.tileSize, null);
			}
			else {
				g2.drawImage(playButtonHover, gp.tileSize*6, gp.tileSize*3, gp.tileSize*4, gp.tileSize, null);
			}
			
			
			if(infoHover==false) {
				g2.drawImage(infoButton, gp.tileSize*6, gp.tileSize*5, gp.tileSize*4, gp.tileSize, null);
			}
			else {
				g2.drawImage(infoButtonHover, gp.tileSize*6, gp.tileSize*5, gp.tileSize*4, gp.tileSize, null);
			}
						
			gp.add(bPlay);
			gp.add(bExit);
			gp.add(bInfo);
		
		
	}
	
}
