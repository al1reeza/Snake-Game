package Main;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		// This creates our window
		JFrame window = new JFrame();
		// Makes sure we exit when we press "x" top right corner
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Makes the window NOT able to be resizable
		window.setResizable(false);
		// Sets the title
		window.setTitle("Snake Game");
	
		GamePanel gp = new GamePanel();
		// Adds our GamePanel
		window.add(gp); 
		// Sets the window size to fit our GamePanel
		window.pack(); 
		
		// Makes sure the screen is centered
		window.setLocationRelativeTo(null);
		// Makes sure we can see the screen
		window.setVisible(true);
		
		// Starts our gameThread
		gp.startGameThread();
	}
}
