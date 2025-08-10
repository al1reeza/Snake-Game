package Entity;

import java.awt.Color;

import java.awt.Graphics2D;
import java.util.Random;


import Main.GamePanel;

public class Food {
	Random random = new Random();
	GamePanel gp;
	
	public int screenX;
	public int screenY;
	
	public boolean ateFood;
	// Creates a food or we can just call this the default constructor for food
	public Food(GamePanel gp) {
		this.gp = gp;
		// Picks random dimensions for our food variable that is going to be added
		this.screenX = random.nextInt(30) * gp.tileSize;
		this.screenY = random.nextInt(30) * gp.tileSize;
	}

	// This method draws the food objects that the snakes can eat to make sure they get bigger
	public void drawFood(Graphics2D g2) {
		g2.setColor(Color.red);
		g2.fillRect(this.screenX, this.screenY, gp.tileSize, gp.tileSize);
	}
	
	//	The snake eats the food
	public void eatFood() {
		if((int)(gp.snake.xLocation / gp.tileSize) == (int)(gp.food.screenX /gp.tileSize) &&
		   		(int)(gp.snake.yLocation / gp.tileSize) == (int)(gp.food.screenY / gp.tileSize)){
			gp.snake.length++;
			ateFood = true;
		}
	}
}

