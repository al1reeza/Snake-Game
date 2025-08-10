package KeyHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	// We will use these to determine the direction that we are going to be moving in
	public boolean up, down, left, right;
	
	// We don't need this method for our game
	public void keyTyped(KeyEvent e) {
		// no-op
	}

	// Handles the case when a keyboard key is pressed
	public void keyPressed(KeyEvent e) {
		// Stores the integer form of the key we just pressed in the code variable
		int code = e.getKeyCode();
		
		/*
		 * The series of if statement determines the direction of our entity, in this
		 * specific game and case the snake based on the key pressed
		 */
		if(code == KeyEvent.VK_W) {
			up = true;
		}
		if(code == KeyEvent.VK_S) {
			down = true;
		}
		if(code == KeyEvent.VK_A) {
			left = true;
		}
		if(code == KeyEvent.VK_D) {
			right = true;
		}
	}

	// Handles the case when a keyboard key is released
	public void keyReleased(KeyEvent e) {
		// Stores the integer form of the key we just pressed in the code variable
		int code = e.getKeyCode();
		/*
		 * The series of if statement determines the direction of our entity, in this
		 * specific game and case the snake based on the key released
		 */
		if(code == KeyEvent.VK_W) {
			up = false;
		}
		if(code == KeyEvent.VK_S) {
			down = false;
		}
		if(code == KeyEvent.VK_A) {
			left = false;
		}
		if(code == KeyEvent.VK_D) {
			right = false;
		}
	}
}

