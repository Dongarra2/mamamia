package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

@SuppressWarnings({ "serial" })
public class MenuButton extends JButton{
	

	public boolean clicked,hovered;
	public int posX,posY,width,height;
	
	public MenuButton(int posX, int posY, int width, int height) {
		this.posX=posX;
		this.posY=posY;
		this.width=width;
		this.height=height;
		

		
		this.setOpaque(false);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setVisible(true);
		this.setBounds(posX, posY, width, height);
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				hovered = true;
			    }
			public void mouseExited(MouseEvent e) {
				hovered = false;
			    }
		});
		
		this.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				clicked = true;
			}
			
		});
		
	}

}