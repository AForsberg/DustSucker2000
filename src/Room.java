/**
 * 
 */

/**
 * @author Anton
 *
 */
public class Room {

	int[][] room;
	
	
	/**
	 * @param x
	 * @param y
	 */
	public Room(int x, int y) {
		room = new int[x][y];
	}

	public int[][] getRoom() {
		return room;
	}

	public void setRoom(int[][] room) {
		this.room = room;
	}

	
	
}
