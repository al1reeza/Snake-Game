package Entity;

public class Entity {
	// The length of our entity, which will come in handy with the snake
	public int length;
	// The x location of our entity
	public int screenX;
	// The y location of our entity
	public int screenY;
	
	public Entity(int xLoc, int yLoc, int length) {
		this.screenX = xLoc;
		this.screenY = yLoc;
		this.length = length;
	}
	
	public void setCoordinates(int x, int y) {
		this.screenX = x;
		this.screenY = y;
	}
}
