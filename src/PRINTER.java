import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * PRINTER is the fully static Class that is used to interface between GUIs and the code.
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public class PRINTER {
	
	/**
	 * The GameInterface to be referenced by the PRINTER
	 */
	private static GameInterface gi;
	
	/**
	 * The method to set the GameInterface to be referenced by the PRINTER
	 * 
	 * @param gameint The GameInterface passed
	 */
	public static void setUI(GameInterface gameint) {
		gi = gameint;
	}
	
	/**
	 * The method to append narration to the screen
	 * 
	 * @param in The text to be appended
	 * 
	 */
	public static void narrate(String in) {
		
		// Add text to the screen and replace newlines with HTML-coded newlines
		gi.setScreenText(in.replace("\n","<br>"));
	}
	
	/**
	 * The method to set narration to the screen
	 * 
	 * @param in The text to be displayed
	 * 
	 */
	public static void narrateln(String in) {
		
		// Clear the screen's text
		gi.clearScreenText();
		
		// Add text to the screen and replace newlines with HTML-coded newlines
		gi.setScreenText(in.replace("\n","<br>"));
	}
	
	/**
	 * The method to append dialog text to the screen
	 * 
	 * @param in The text to be appended
	 * @param c The Creature that the statement is said by
	 * 
	 */
	public static void say(String in,Creature c) {
		System.out.print(in);
		gi.setScreenColor(new Color(255, 0, 0));
		gi.setScreenText(in.replace("\n", "<br>"));
	}
	
	/**
	 * The method to set dialog text to the screen
	 * 
	 * @param in The text to be displayed
	 * @param c The Creature that the statement is said by
	 * 
	 */
	public static void sayln(String in,Creature c) {
		System.out.println(in);
		gi.setScreenColor(new Color(255, 0, 0));
		gi.clearScreenText();
		gi.setScreenText(in.replace("\n", "<br>"));
	}
	
	/**
	 * The method to append errors to the screen
	 * 
	 * @param in The error text to be appended
	 * 
	 */
	public static void error(String in) {
		System.err.print(in);
	}
	
	/**
	 * The method to display errors to the screen
	 * 
	 * @param in The error text to be displayed
	 * 
	 */
	public static void errorln(String in) {
		System.err.println(in);
	}
	
	/**
	 * The method to wait for user input
	 * 
	 * @return empty string
	 * 
	 */
	public static String readLine() {
		
		CONTROLLER.WAIT = true;
		
		while (CONTROLLER.WAIT) {
			CONTROLLER.sleep(500);
		}
		return "";
	}
	
	/**
	 * The method to refresh the screen's controls
	 * 
	 */
	public static void displayControls() {
		gi.displayButtons(CONTROLLER.GAME.controls.getControls());
	}
	
	/**
	 * The method to refresh the screen's creature buttons
	 * 
	 */
	public static void displayCreatures() {
		gi.displayCreatureChoice(CONTROLLER.GAME.getCurrentLocation().getLocationCreatures());
	}

	/**
	 * The method to refresh the screen's location buttons
	 * 
	 */
	public static void displayLocations() {
		gi.displayLocationChoice(CONTROLLER.GAME.getCurrentLocation().getAccessibleLocations());
	}

	/**
	 * The method to refresh the screen's action buttons
	 * 
	 */
	public static void displayActions() {
		gi.displayActionChoice(CONTROLLER.GAME.getCurrentLocation().getLocationInteractions());
	}

	/**
	 * The method to refresh the screen's current location
	 * @param l The location to be set
	 * 
	 */
	public static void setCurrentLocation(Location l) {
		gi.setCurrentLocation(l);
	}
	
	/**
	 * The method to get the interface for direct use
	 * 
	 * @return the GameInterface that this PRINTER uses
	 * 
	 */
	public static GameInterface getUI() {
		return gi;
	}

	/**
	 * The method to clear the location buttons from the screen
	 * 
	 */
	public static void clearLocations() {
		gi.clearLocations();
	}
	
	/**
	 * The method to clear the creature buttons from the screen
	 * 
	 */
	public static void clearCreatures() {
		gi.clearCreatures();
	}
	
	/**
	 * The method to clear the action buttons from the screen
	 * 
	 */
	public static void clearActions() {
		gi.clearActions();
	}
	
}
