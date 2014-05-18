/**
 * Enum for directions
 * @author Anton
 */
public enum Direction {
	NORTH,
	EAST,
	SOUTH,
	WEST;
	
	/**
	 *@return The next Direction in clockwise order.
	 */
	public Direction getNext(){
		return values()[(this.ordinal()+1) % values().length];
	}

	
	/**
	 * @return The previous Direction
	 */
	public Direction getPrevious() {
		return values()[(this.ordinal() + values().length -1) % values().length];

	}
}
