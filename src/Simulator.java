import java.util.*;

/**
 * @author Anton
 *
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
		x = Integer.parseInt(coords[0]);
		y = Integer.parseInt(coords[1]);
		room = new Room(x,y);
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
		d = startpos[0].charAt(0);
		x = Integer.parseInt(startpos[1]);
		y = Integer.parseInt(startpos[2]);
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
			System.out.println("Not a valid direction, terminating simulation.");
			System.exit(1);
			break;
		}
		sucker = new Dustsucker(x, y, dir);
	}
	
	/**
	 * Runs the simulation.
	 */
	public void runSim(){
		System.out.println("Simulating...");
		for (int i = 0; i < move.length; i++) {
			char command = move[i];
			switch (command) {
			case 'A':
				System.out.println("Moving forward");
				break;
			case 'R':
				System.out.println("Turning right");
				break;
			case 'L':
				System.out.println("Turning left");
				break;
			default:
				break;
			}
		}
		System.out.println("Simulation stopped.");
	}	
	
	public static void main(String[] args) {
		// Create a new Simulator object and run it.
		Simulator sim = new Simulator();
		sim.runSim();
	}

}
