package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	public boolean upPressed,downPressed,leftPressed,rightPressed,onePressed,twoPressed,threePressed,PPressed,JPressed;
	GamePanel gp;
	
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_Z) {
			upPressed=true;			
		}
		if(code == KeyEvent.VK_S) {
			downPressed=true;
		}
		if(code == KeyEvent.VK_Q) {
			leftPressed=true;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed=true;
		}
		if(code == KeyEvent.VK_3) {
			threePressed=true;
			}
		if(code == KeyEvent.VK_2) {
			twoPressed=true;
			}
		if(code == KeyEvent.VK_1) {
			onePressed=true;
			}
		if(code == KeyEvent.VK_P) {
			PPressed=true;
			}		
		
		if(gp.gameState=="titleScreen") {
			if(code == KeyEvent.VK_J) {
				gp.gameState="play";
				}
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_Z) {
			upPressed=false;
		}
		if(code == KeyEvent.VK_S) {
			downPressed=false;
		}
		if(code == KeyEvent.VK_Q) {
			leftPressed=false;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed=false;
		}
		if(code == KeyEvent.VK_3) {
			threePressed=false;
			}
		if(code == KeyEvent.VK_2) {
			twoPressed=false;
			}
		if(code == KeyEvent.VK_1) {
			onePressed=false;
			}
		if(code == KeyEvent.VK_P) {
			PPressed=false;
			}		
		if(code == KeyEvent.VK_J) {
			JPressed=false;
			}
		
	}

}
