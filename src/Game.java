
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Game is the class to store information about a NightAtTheZoo Game
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public class Game {
	
	/**
	 * The locations that are a part of this Game
	 */
	private ArrayList<Location> locations;
	
	/**
	 * The current location of the Player
	 */
	private Location currentLocation;
	
	/**
	 * A boolean variable to tell whether or not the pre-game sequence is running
	 */
	public boolean preGameRunning;
	
	/**
	 * The creatures that are a part of this game
	 */
	public data_creatures creatures;
	
	/**
	 * The controls that are available in this Game
	 */
	public Controls controls;
	
	/**
	 * The initializer method of this game
	 * 
	 */
	public void init() {
		
		// Get the user's preferred name and catch phrase
		Scanner in = new Scanner(System.in);
		//PRINTER.prompt("Enter your name: ");
		String name = "Bennett";//in.nextLine();
		//PRINTER.prompt("Enter your catch phrase: ");
		String catchPhrase = "yes";//in.nextLine();
		
		// Create the Player Object to represent the user
		CONTROLLER.player = new Player(name, 5, 1, catchPhrase,0);
		
		// Initialize the controls that can be used
		ArrayList<Control> controls = new ArrayList<Control>();
		
		// Add GO to the available controls
		controls.add(new Control("GO", "move from one location to another.", 'g', false, new Runner() {
			
			@Override
			public void run() {
				
				// Get the Location that is selected by the user
				Location l = CONTROLLER.SELECTEDLOCATION;
				
				// Conditional if the user has not selected a Location
				if (l != null)
					
					// Set the current location to that location
					CONTROLLER.GAME.setCurrentLocation(l);
				
				else
					
					// Let the user know of an error
					PRINTER.errorln("Please select a location.");
				
			}
			
		}));

		// Add HELP to the available controls
		controls.add(new HelpControl("HELP", "display this menu.", 'h', new Runner() {
			
			@Override
			public void run() {
				
				// Display the help screen
				PRINTER.narrateln(CONTROLLER.GAME.controls.toString());
				
			}
			
		}));

		// Add SPEAK to the available controls
		controls.add(new Control("SPEAK", "speak to a creature.", 's', true, new Runner() {
			
			@Override
			public void run() {
				
				// Get the Creature that is selected by the user
				Creature creature = CONTROLLER.SELECTEDCREATURE;
				
				// Conditional if the user has not selected a Creature
				if (creature != null) {
					
					// Start a conversation with the Creature
					creature.converse();
					
				} else {
					
					// Notify the user of an error
					PRINTER.errorln("Please select a creature.");
					
				}
			}
			
		}));
		
		// Create a Controls Object and set its available Control Objects to controls
		this.controls = new Controls(controls);
		
		// Initialize the creatures instance variable
		this.creatures = new data_creatures();
		
		// Initialize the data_events static class
		data_events.init();
		
		// Initialize the locations to the pre-game Locations
		this.locations = data_locations.getLocationsPreGame();
		
		// Loop over all the available locations
		for (Location l : locations) {
			
			// Connect each of them with the locations that they are next to
			l.connectLocations();
			
		}
		
		// Start the pre-game
		this.preGameRunning = true;
	}
	
	/**
	 * The method to get the locations that are available in this scenario of the game
	 * 
	 * @return the locations variable
	 * 
	 */
	public ArrayList<Location> getLocations() {
		return locations;
	}
	
	/**
	 * The method to set the current location of the Player
	 * 
	 * @param location The new location
	 * 
	 */
	public void setCurrentLocation(Location location) {
		
		// Change the current location on the GUI
		PRINTER.setCurrentLocation(location);
		
		// Set the instance variable to the new location
		this.currentLocation = location;
		
		// Update all of the buttons on the GUI
		PRINTER.displayLocations();
		PRINTER.displayCreatures();
		PRINTER.displayActions();
				
	}
	
	/**
	 * The method to get the current location of the Player
	 * 
	 * @return the currentLocation
	 */
	public Location getCurrentLocation() {
		return currentLocation;
	}
	
	/**
	 * The method to commence the pre-game scenario
	 */
	public void playPreGame() {
		
		// Set the current location to the starting Location
		setCurrentLocation(locations.get(1));
		
		// Display the available controls to the user
		PRINTER.displayControls();
		
		//PRINTER.narrateln("\n" + controls.toString());
		
		// Loop as long as the pre-game is running
		while(preGameRunning) {
			
			// Clear the screen
			try {Runtime.getRuntime().exec("cls");} catch (IOException e) {}
			
			// Delay for 1s
			CONTROLLER.sleep(1000);
			
			// Wait for the user to choose an action
			PRINTER.readLine();
			
		}
	}
	
	/**
	 * The method to run the actual game logic
	 * 
	 */
	public void playGame() {
		
	}
}
