/**
 * @author Anton
 *
 */
public class Dustsucker {
	
	int posX;
	int posY;
	Direction direction;
	
	/**
	 * Constructor setting position and direction variables
	 * @param x x-position
	 * @param y y-position
	 * @param dir Direction
	 */
	public Dustsucker(int x, int y, Direction dir){
		posX = x;
		posY = y;
		direction = dir;
	}
	
	//Functions
	
	/**
	 * Turns the DustSucker to the right
	 */
	public void turnRight() {
		direction = direction.getNext();
		
	}

	/**
	 * Turns the DustSucker to the left
	 */
	public void turnLeft() {
		direction = direction.getPrevious();
		
	}

	/**
	 * Moves the DustSucker forward one step in the currently facing direction.
	 */
	public void move() {
		switch (direction) {
		case NORTH:
			posY++;
			break;
		case EAST:
			posX++;
			break;
		case SOUTH:
			posY--;
			break;
		case WEST:
			posX--;
			break;
		default:
			break;
		}
		
	}
	
	//Getters & Setters
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
