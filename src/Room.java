/**
 * @author Anton
 */
public class Room {

	private int height;
	private int width;
	
	/**
	 * Constructor sets room dimensions
	 * @param x X-dimension
	 * @param y Y-dimension
	 */
	public Room(int x, int y) {
		width = x;
		height = y;		
	}	
	
	//Getters
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
