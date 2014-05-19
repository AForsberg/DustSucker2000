import java.util.*;


/**
 * DustSucker 2000 Simulator Software
 * @author Anton
 */
public class Simulator {

	Scanner in = new Scanner(System.in);
	Room room;
	Dustsucker sucker;
	char[] move;
	

	/**
	 * Constructor creates objects and variables needed for simulation.
	 */
	public Simulator(){
		createRoom();
		createDustsucker();
		getMovement();
	}
	
	/**
	 * Performs the movement instructed by user
	 * @param c Movement instruction
	 */
	private void executeMovement(char c) {
		switch (c) {
		case 'R':
			sucker.turnRight();
			break;
		case 'L':
			sucker.turnLeft();
			break;
		case 'A':
			sucker.move();
			break;
		default:
			break;
		}
		
	}
	
	/**
	 * Validates that the DustSucker does not go through walls. 
	 * If its X or Y position is outside the room it will be reset to inside it, sort of like it had run into the wall and stopped.
	 * 
	 */
	private void wallCheck() {
		if(sucker.getPosX() > room.dimensions.width -1){
			sucker.setPosX(room.dimensions.width -1);
		}else if(sucker.getPosX() < 0){
			sucker.setPosX(0);
		}else if(sucker.getPosY() > room.dimensions.height -1){
			sucker.setPosY(room.dimensions.height -1);
		}else if(sucker.getPosY() < 0){
			sucker.setPosY(0);
		}
		
	}

	/**
	 * Gets movement commands from user.
	 */
	private void getMovement() {
				
		System.out.println("Please enter your movement commands without spaces. (A = move forward, R = turn right, L = turn left)");
		String input = in.nextLine();
		move = input.toCharArray();
	}

	
	/**
	 * Creates an instance of Room with user specified size.
	 */
	private void createRoom(){
		
		int x;
		int y;
		
		System.out.println("Please enter room length and width, separated by space:");
		String input = in.nextLine();
		String[] coords = input.split("\\s+");
		if(validateRoom(coords)){
			x = Integer.parseInt(coords[0]);
			y = Integer.parseInt(coords[1]);
			room = new Room(x,y);
		}else{
			System.out.println("Invalid entry, try again.");
			createRoom();
		}
	}
	
	/**
	 * Validates that the room coordinates entered by the user are valid.
	 * @param coords array containing coordinates to be checked
	 * @return true if there are two coordinates that are positive integers, otherwise false.
	 */
	private boolean validateRoom(String[] coords) {
		if(coords.length != 2){
			return false;
		}
		try{
			int x = Integer.parseInt(coords[0]);
			int y = Integer.parseInt(coords[1]);
			if(x <= 0 || y <= 0){
				return false;
			}
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}

	/**
	 * Gets input from user and creates a new instance of Dustsucker at the position specified.
	 */
	private void createDustsucker() {
		int x;
		int y;
		char d;
		Direction dir = null;
		
		System.out.println("Please enter initial direction and position of the sucker, separated by space:");
		String input = in.nextLine();
		String[] startpos = input.split("\\s+");
		boolean isOK = validatePosition(startpos);
		d = startpos[0].charAt(0);
		
		//Validates direction
		switch (d) {
		case 'N':
			dir = Direction.NORTH;
			break;
		case 'S':
			dir = Direction.SOUTH;
			break;
		case 'E':
			dir = Direction.EAST;
			break;
		case 'W':
			dir = Direction.WEST;
			break;
		default:
			isOK = false;
			break;
		}
		if(isOK){
			x = Integer.parseInt(startpos[1]);
			y = Integer.parseInt(startpos[2]);
			
			sucker = new Dustsucker(x, y, dir);
		}else{
			System.out.println("Invalid entry, try again");
			createDustsucker();
		}
		
	}
	
	/**
	 * Validates the DustSuckers position as entered by user
	 * @param startpos contains entered starting position
	 * @return <code>true</code> if there are three position variables and the X and Y positions are integers within the room dimensions. Otherwise <code>false</code>
	 */
	private boolean validatePosition(String[] startpos) {
		if (startpos.length != 3) {
			return false;
		}
		try{
			int x = Integer.parseInt(startpos[1]);
			int y = Integer.parseInt(startpos[2]);
			
			if(x < 0 || y < 0 || x >= (room.dimensions.width) || y >= room.dimensions.height){
				return false;
			}
		}catch(NumberFormatException e){
			return false;
		}
		
		return true;
	}

	/**
	 * Prints out the direction and position of the DustSucker.
	 */
	private void printResult() {
		System.out.println("Result: "+sucker.getDirection() +" " +sucker.getPosX() + " " +sucker.getPosY());
		
	}
	
	/**
	 * Runs the simulation by moving DustSucker according to instruction, checking walls 
	 * and when there are no more instructions, printing results.
	 */
	public void runSim(){
		for (int i = 0; i < move.length; i++) {
			executeMovement(move[i]);
			wallCheck();
		}
		printResult();
	}	

	/**
	 * Creates a new instance of Simulator and runs the simulation.
	 * @param args
	 */
	public static void main(String[] args) {
		// Create a new Simulator object and run it.
		System.out.println("DustSucker 2000 Simulator by Anton Forsberg\n");
		System.out.println("This software simulates the movement of a vacuum cleaner. It will perform the movements you entered in the room you specified and print out the endposition and direction.\n");
		Simulator sim = new Simulator();
		sim.runSim();
	}

}
