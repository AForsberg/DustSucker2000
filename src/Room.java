import java.awt.Dimension;

/**
 * @author Anton
 */
public class Room {

	//int[] dimensions = new int[2];
	private Dimension dimensions = new Dimension();
	
	/**
	 * Constructor sets room dimensions
	 * @param x X-dimension
	 * @param y Y-dimension
	 */
	public Room(int x, int y) {
		//dimensions[0] = x;
		//dimensions[1] = y;
		dimensions.width = x;
		dimensions.height = y;
	}	
	
	//Getters
	public int getWidth(){
		return dimensions.width;
	}
	
	public int getHeight(){
		return dimensions.height;
	}
}
