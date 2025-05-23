package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tools {
	
	public BufferedImage scaleImage (BufferedImage image, int width, int height) {
		
		BufferedImage scaleImage=new BufferedImage (width, height, image.getType());
		Graphics2D g2 = scaleImage.createGraphics();
		g2.drawImage(image, 0, 0, width, height, null);
		g2.dispose();
		
		return scaleImage;
	}

}
