package Entity;

import java.awt.Graphics2D;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import KeyHandler.KeyHandler;
import Main.GamePanel;

public class Snake{
	public GamePanel gp;
	public KeyHandler keyH;
	// This will be the direction that our snake is moving in
	public String direction;
	
	// The x and y location of the Snake
	public int xLocation, yLocation;
	
	// The speed in which we will change xSpeed and ySpeed
	public int xSpeed, ySpeed;
	
	// This will be the length of our snake's tail
	public int length;
		
	// This will show the difference squares, or in this case entities that make up our snake
	public ArrayList<Entity> tail = new ArrayList<>();
	

	// This will be an example of our food class, which will be used to draw foods and other uses
	Food food;
	
	public final int speed = 20;
	
	// Tells us whether to turn or not
	boolean turn = false;
	
	public Snake(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		setDefaultValues();
	}
	
	/*
	 * Sets the default values of the entity to make sure that we start
	 * at the center of the screen
	 */
	public void setDefaultValues() {
		this.length = 0;
		this.direction = "right";
		this.xSpeed = gp.tileSize;
		this.ySpeed = 0;
		this.xLocation = gp.maxScreenWidth /2 + gp.tileSize/2;
		this.yLocation = gp.maxScreenHeight /2 + gp.tileSize/2;
		this.food = new Food(gp);
		}
	
	// Determines what the direction is based on the keyboard input
	public void whatIsDirection() {
		// We want to figure out if key is pressed or not to know how our snake should move
		if(keyH.up == true) {
			direction = "up";
			this.xSpeed = 0;
			this.ySpeed = gp.tileSize * (-1);
		}
		else if(keyH.down == true){
			direction = "down";
			this.xSpeed = 0;
			this.ySpeed = gp.tileSize;
		}
		else if(keyH.left == true) {
			direction = "left";
			this.xSpeed = gp.tileSize * (-1);
			this.ySpeed = 0;
		}
		else if(keyH.right == true) {
			direction = "right";
			this.xSpeed = gp.tileSize;
			this.ySpeed = 0;
		}
	}
	
	public void update() {
		whatIsDirection();
		gp.food.eatFood();
		if(this.tail.size() == this.length) {
			for(int i = 0; i < this.tail.size() - 1; i++) {
				this.tail.set(i, this.tail.get(i + 1));
			}
			if(this.tail.size() > 0) {
				this.tail.set(this.tail.size() - 1, new Entity(this.xLocation, this.yLocation, 1));
			}
		}else {
			this.tail.add(new Entity(this.xLocation, this.yLocation, 1));
		}
		this.xLocation += this.xSpeed;
		this.yLocation += this.ySpeed;
		collission();
	}
		
	public void draw(Graphics2D g2) {
		for(int i = 0; i < length; i++) {
			g2.fillRect(tail.get(i).screenX, tail.get(i).screenY, gp.tileSize, gp.tileSize);
		}
		g2.fillRect(xLocation, yLocation, gp.tileSize, gp.tileSize);
	}
	
	public void collission() {
		
		for(int i = 0; i < length; i++) {
			for(int j = i + 1; j < length; j++) {
				if((int)(gp.snake.tail.get(i).screenX / gp.tileSize) == (int)(gp.snake.tail.get(j).screenX /gp.tileSize) &&
					(int)(gp.snake.tail.get(i).screenY / gp.tileSize) == (int)(gp.snake.tail.get(j).screenY / gp.tileSize)){
					JOptionPane.showMessageDialog(null, "GAME OVER", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
			}
		}
		
		if(this.xLocation > gp.maxScreenWidth || this.xLocation < 0 || this.yLocation < 0 || this.yLocation > gp.maxScreenHeight) {
			JOptionPane.showMessageDialog(null, "GAME OVER", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
	
}
