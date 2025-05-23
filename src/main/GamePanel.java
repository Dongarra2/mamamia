package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.Entity;
import entity.EntityManager;
import entity.GreenPotion;
import entity.LootCrate;
import entity.Player;
import entity.PurplePotion;
import entity.RedPotion;
import monsters.MonsterManager;
import tile.TileManager;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable{
	
	//Screen settings
	final int originalTileSize = 16; //16x16 tiles
	public final int scale = 6; 
	public final int tileSize = originalTileSize * scale;
	
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 9;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	//world settings
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize*maxWorldCol;
	public final int worldHeight = tileSize*maxWorldRow;
	
	//FullScreen
//	int fullScreenWidth = screenWidth;
//	int fullScreenHeight = screenHeight;
//	BufferedImage tempScreen;
//	Graphics2D g2;
	
	
	
	public int difficulty = 0;
	
	public String gameState = "play";
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	public CollisionChecker cChecker = new CollisionChecker(this);
	Thread gameThread;
		
	public Player player = new Player(this,keyH);
	MonsterManager mManager = new MonsterManager(this);
	EntityManager eManager = new EntityManager(this);
	MapManager mapManager = new MapManager(this);
	
	public int arrayLength = 20;
	public Entity monster[] = new Entity[arrayLength];
	public Entity lootCrates[] = new Entity[arrayLength];

	ArrayList<Entity> entityList = new ArrayList<>();
	
	UI ui = new UI(this,player);
	
	RedPotion redPot = new RedPotion(this,player);
	GreenPotion greenPot = new GreenPotion(this,player);
	PurplePotion purplePot = new PurplePotion(this,player);
	LootCrate lootCrate = new LootCrate(this);
	
	
	int FPS=60;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
	}
	
	
	public void setupGame() {
		
//		mManager.loadMapMonsters("/maps/01monsterMap.txt");
//		eManager.loadMapEntity("/maps/01entityMap.txt");
//		tileM.loadMap("/maps/01map.txt");
		
		mapManager.loadMaps(mapManager.chooseMap());
		
//		tempScreen = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
//		g2 = (Graphics2D)tempScreen.getGraphics();
		
		
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {

		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime)/drawInterval;
			lastTime = currentTime;
			
			if(delta >= 1) {
				
				if(gameState=="play") {
				update();
				}
				repaint();
//				drawTempScreen();
//				drawScreen();
				delta--;
				
			}
		
		}
		
		
	}
	public void update() {
		
		player.update();
//		try {
//			TestRequest.insertScore(player.name, player.score);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		if(keyH.PPressed==true) {
//			keyH.PPressed=false;
//			mapManager.loadMaps(mapManager.chooseMap());
//		}
		
	}
//	public void drawTempScreen() {
//		
//		
//
//		tileM.draw(g2);		
//		entityList.add(player);
//		
//		for (int i = 0; i < arrayLength; i++) {
//			if (monster[i]!=null) {	entityList.add(monster[i]);	}
//			if (lootCrates[i]!=null) {	entityList.add(lootCrates[i]);	}
//		}
//		
//
//		for (int i = 0; i < entityList.size(); i++) {
//			entityList.get(i).draw(g2);
//		}
//		
//		for (int i = 0; i < entityList.size(); i++) {
//			entityList.remove(i);
//		}
//		
//		ui.draw(g2);
//
//	}
//	public void drawScreen() {
//		
//		g2.setColor(new Color(0, 0, 0)); 
//		g2.fillRect(0, 0, fullScreenWidth, fullScreenHeight);
//		Graphics g = getGraphics();
//		g.drawImage(tempScreen, 0, 0, fullScreenWidth, fullScreenHeight,null);
//		g.dispose();
//		
//	}
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);

		
		entityList.add(player);
		
		for (int i = 0; i < arrayLength; i++) {
			if (monster[i]!=null) {	entityList.add(monster[i]);	}
			if (lootCrates[i]!=null) {	entityList.add(lootCrates[i]);	}
		}
		

		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).draw(g2);
		}
		
		for (int i = 0; i < entityList.size(); i++) {
			entityList.remove(i);
		}		
		
		ui.draw(g2);
		g2.dispose();
	}
	

}
