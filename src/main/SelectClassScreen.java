package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SelectClassScreen {

	BufferedImage fire1,fire2,fire3,fire4,screen,soldier1,soldier2,soldier3,mask,class1,class1Hover;
	int fireCycle=0;
	GamePanel gp;
	MenuButton bClass1;
	Font arial_60;
	
	
	public SelectClassScreen(GamePanel gp){
		this.gp=gp;
		
		arial_60=new Font("Arial", Font.PLAIN, 60/6*gp.scale);
		bClass1 = new MenuButton(gp.tileSize*3,gp.tileSize*4, gp.tileSize*2,gp.tileSize*3);
		
		try {
			screen = ImageIO.read(getClass().getResourceAsStream("/selectClassScreen/classScreen.png"));
			fire1 = ImageIO.read(getClass().getResourceAsStream("/selectClassScreen/fire1.png"));
			fire2 = ImageIO.read(getClass().getResourceAsStream("/selectClassScreen/fire2.png"));
			fire3 = ImageIO.read(getClass().getResourceAsStream("/selectClassScreen/fire3.png"));
			fire4 = ImageIO.read(getClass().getResourceAsStream("/selectClassScreen/fire4.png"));
			soldier1 = ImageIO.read(getClass().getResourceAsStream("/selectClassScreen/soldier1.png"));
			soldier2 = ImageIO.read(getClass().getResourceAsStream("/selectClassScreen/soldier2.png"));
			soldier3 = ImageIO.read(getClass().getResourceAsStream("/selectClassScreen/soldier3.png"));
			mask = ImageIO.read(getClass().getResourceAsStream("/selectClassScreen/mask.png"));
			class1 = ImageIO.read(getClass().getResourceAsStream("/selectClassScreen/class1.png"));
			class1Hover = ImageIO.read(getClass().getResourceAsStream("/selectClassScreen/class1Hover.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bClass1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gp.player.setPlayerClass("Warrior");
				gp.gameState="play";
				bClass1.hovered=false;
			}
		
		});
		
	}
	
	public void drawClassScreen(Graphics2D g2) {
		
		g2.drawImage(screen, 0, 0, gp.screenWidth, gp.screenHeight,null);
		
		g2.drawImage(soldier1, gp.tileSize*14, gp.tileSize*0, gp.tileSize,gp.tileSize,null);
		g2.drawImage(soldier3, gp.tileSize*13, gp.tileSize*1, gp.tileSize,gp.tileSize,null);
		g2.drawImage(soldier2, gp.tileSize*15, gp.tileSize*1, gp.tileSize,gp.tileSize,null);

		////CAMPFIRE
		if(fireCycle<10) {
			g2.drawImage(fire1, gp.tileSize*14, gp.tileSize*1,gp.tileSize,gp.tileSize, null);
		}
		else if(fireCycle<20) {
			g2.drawImage(fire2, gp.tileSize*14, gp.tileSize*1,gp.tileSize,gp.tileSize, null);
		}
		else if(fireCycle<30) {
			g2.drawImage(fire3, gp.tileSize*14, gp.tileSize*1,gp.tileSize,gp.tileSize, null);
		}
		else if(fireCycle<=40) {
			g2.drawImage(fire4, gp.tileSize*14, gp.tileSize*1,gp.tileSize,gp.tileSize, null);
		}
		if(fireCycle == 40) {
			fireCycle=0;
		}
		fireCycle++;
		
		
		g2.drawImage(mask, 0, 0, gp.screenWidth, gp.screenHeight,null);
		
		if(!bClass1.hovered) {
			g2.drawImage(class1, bClass1.posX, bClass1.posY, bClass1.width, bClass1.height, null);
		}
		else {
			g2.drawImage(class1Hover, bClass1.posX, bClass1.posY, bClass1.width, bClass1.height, null);
		}
		g2.setFont(arial_60);
		g2.setColor(Color.black);
		g2.drawString("Soldier", gp.tileSize*3, 15*gp.tileSize/2);
		
		
		gp.add(bClass1);
		
	}
}
