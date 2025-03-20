package Main;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Entity.Snake;
import KeyHandler.KeyHandler;
import Entity.Food;

public class GamePanel extends JPanel implements Runnable {
	
	public int numColumns = 35;
	public int numRows = 35;
	
	public int tileSize = 20;
	
	public int maxScreenWidth = numColumns * tileSize;
	public int maxScreenHeight = numRows * tileSize;
	
	public boolean reachFood = true;
	
	// This is how many times our screen will re-draw per second
	int FPS = 7;
	
	// This will allow our game to run
	Thread gameThread;
	
	// This will import the method of handling our keyboard responses
	KeyHandler keyH = new KeyHandler();
	
	// This will be an example of our snake entity
	public Snake snake = new Snake(this, keyH);
	
	// This will be our food class that we will use
	public Food food = new Food(this);
	
	// Default constructor for GamePanel class
	public GamePanel() {
		// Sets the width and height of our screen
		this.setPreferredSize(new Dimension(maxScreenWidth, maxScreenHeight));
		// Sets the background color of our screen
		this.setBackground(Color.green);
		this.setDoubleBuffered(true); // This will make the game more smooth
		// This adds a key listener so that our gamePanel actually takes input
		this.addKeyListener(keyH);
		this.setFocusable(true); // Allows our GamePanel to receive keyBoard inputs
	}
	
	// This method starts our gameThread
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
		this.requestFocusInWindow(); // Ensure the GamePanel has focus
	}
	
	// The start method calls this method so that our game is run
	public void run() {
		double drawInterval = 1000 / FPS ; // This variable will be our frames per second in milli seconds
		double nextDrawTime = System.currentTimeMillis() + drawInterval; // The next time we want to draw
		double timeRemaining; // We will use this in the loop to determine how long our loop took
		while(gameThread != null) { // Makes sure that the loop runs while the Thread, gameThread is running
			repaint();
			update();
			timeRemaining = nextDrawTime - System.currentTimeMillis();
			try {
				// This if statement makes sure our program runs in 60 FPS
				if(timeRemaining < 0) {
					timeRemaining = 0;
				}
				Thread.sleep((long)timeRemaining);
				nextDrawTime += drawInterval; 
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		snake.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // This method fills the background
		Graphics2D g2 = (Graphics2D) g;
 		snake.draw(g2);
 		food.drawFood(g2);
 		if(food.ateFood == true) {
			this.food = new Food(this);
			food.ateFood= false;
		}
	}
}
