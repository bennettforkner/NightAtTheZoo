
/**
 * Controller is the fully-static class to aggregate all of the global values
 * which need to be passed back and forth between other classes
 * 
 * @author b4knah
 * @since 12/21/2020
 *
 */
public class CONTROLLER {
	
	/**
	 * The current Game that is being run
	 */
	public static Game GAME;
	
	/**
	 * The Player that is being used
	 */
	public static Player player;
	
	/**
	 * The title of this Game
	 */
	public static String gameTitle = "Night at the Zoo";
	
	/**
	 * The boolean value to be set to true when the program should wait for user input
	 */
	public static boolean WAIT;
	
	/**
	 * The Creature that the user has selected on the interface
	 */
	public static Creature SELECTEDCREATURE;
	
	/**
	 * The Location that the user has selected on the interface
	 */
	public static Location SELECTEDLOCATION;
	
	/**
	 * The global function to wait a certain amount of milliseconds
	 * before continuing on in the program
	 * 
	 * @param millis The amount of milliseconds to wait before continuing
	 */
	public static void sleep(int millis) {
		
		// Try to execute and print the error details on failure
		try {
			
			// Ask the thread to wait for the specified amount of milliseconds
			Thread.sleep(millis);
			
		} catch (InterruptedException e) {
			
			// Print the error details & location
			e.printStackTrace();
			
		}
	}
	
	
}
