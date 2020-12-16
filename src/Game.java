import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	private ArrayList<Location> locations;
	private Location currentLocation;
	public boolean preGameRunning;
	public data_creatures creatures;
	public Controls controls;
	public ArrayList<InteractionEvent> validInteractions;
	public ArrayList<Location> validLocations;
	public ArrayList<Creature> validCreatures;
	
	public void init() {
		Scanner in = new Scanner(System.in);
		PRINTER.prompt("Enter your name: ");
		String name = in.nextLine();
		PRINTER.prompt("\nEnter your catch phrase: ");
		String catchPhrase = in.nextLine();
		CONTROLLER.player = new Player(name, 5, 1, catchPhrase,0);
		ArrayList<Control> controls = new ArrayList<Control>();
		controls.add(new Control("GO", "move from one location to another.", 'g',new Runner() {
			public void run(String arg) {
				if (arg == null || Integer.parseInt(arg) == 0) {
					PRINTER.errorln("\nPlease enter a location to move to.");
					return;
				}
				ArrayList<Location> accessibleLocations = CONTROLLER.GAME.getCurrentLocation().getAccessibleLocations();
				if (accessibleLocations.contains(Integer.parseInt(arg))) {
					CONTROLLER.GAME.setCurrentLocation(accessibleLocations.get(Integer.parseInt(arg)));
				} else {
					PRINTER.errorln("\nYou are not allowed to go to that location.");
				}
			}
		}));
		controls.add(new Control("HELP", "display this menu.", 'h', new Runner() {
			public void run(String arg) {
				PRINTER.narrate(CONTROLLER.GAME.controls.toString());
			}
		}));
		controls.add(new Control("SPEAK", "speak to a creature.", 's', new Runner() {
			public void run(String arg) {
				if (arg == null || Integer.parseInt(arg) == 0) {
					PRINTER.errorln("\nPlease enter a creature to speak to.");
					return;
				}
				
				if (CONTROLLER.GAME.getCurrentLocation().getLocationCreatures().size() > Integer.parseInt(arg)) {
					CONTROLLER.GAME.getCurrentLocation().getLocationCreatures().get(Integer.parseInt(arg)).converse();;
				} else {
					PRINTER.errorln("\nThat creature does not exist.");
				}
			}
		}));
		this.controls = new Controls(controls);
		
		this.creatures = new data_creatures();
		data_events.init();
		this.preGameRunning = true;
		this.locations = data_locations.getLocationsPreGame();
		for (Location l : locations) {
			l.connectLocations();
		}
	}
	
	public ArrayList<Location> getLocations() {
		return locations;
	}
	
	public void setCurrentLocation(Location location) {
		currentLocation = location;
	}
	
	public Location getCurrentLocation() {
		return currentLocation;
	}
	
	public void playPreGame() {
		currentLocation = locations.get(0);
		PRINTER.narrateln("\nYou started the game.");
			
		PRINTER.narrateln("\n" + controls.toString());
		while(true) {
			if (!preGameRunning) {
				break;
			}
			try {Runtime.getRuntime().exec("cls");} catch (IOException e) {}
			
			PRINTER.narrateln("\nYou are currently at " + currentLocation.getLocationName());
			
			validCreatures = null;
			validInteractions = null;
			validLocations = null;
			
			if (currentLocation.getAccessibleLocations().size() > 0) {
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("\nYou can go to these locations:");
			}
			validLocations = currentLocation.getAccessibleLocations();
			int count = 0;
			for (Location index : validLocations) {
				PRINTER.narrateln("[" + count + "]: " + index.getLocationName());
			}
			
			if (currentLocation.getLocationInteractions().size() > 0) {
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("\nYou can do these actions:");
			}
			validInteractions = currentLocation.getLocationInteractions();
			count = 0;
			for (InteractionEvent interaction : validInteractions) {
				PRINTER.narrateln("[" + count++ + "]: " + interaction.getTitle());
			}
			
			if (currentLocation.getLocationCreatures().size() > 0) {
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("\nThese people are around you:");
			}
			validCreatures = currentLocation.getLocationCreatures();
			count = 0;
			for (Creature creature : validCreatures) {
				PRINTER.narrateln("[" + count++ + "]: " + creature.getName());
			}
			
			CONTROLLER.sleep(1000);
			
			PRINTER.prompt("\nWhat would you like to do?: ");
			
			Scanner in = new Scanner(System.in);
			String[] arguments = in.nextLine().split(" ");
			Control control;
			if (arguments[1].length() > 1) {
				control = controls.getControl(arguments[0]);
			} else if (arguments[1].length() == 1) {
				control = controls.getControl(arguments[0].charAt(0));
			} else {
				PRINTER.errorln("Please enter a control.");
				continue;
			}
			
			if (control != null) {
				control.run(arguments[1]);
					
			} else {
				PRINTER.errorln("Please enter a valid control.");
			}
			
			/*if (choice.compareTo("") == 0) {
				continue;
			} else if (choice.charAt(0) == 'g') {
				int index = Integer.parseInt(choice.replaceAll("[\\D]", ""));
				currentLocation = locations.get(index);
				continue;
			} else if (choice.charAt(0) == 'd') {
				int index = Integer.parseInt(choice.replaceAll("[\\D]", ""));
				currentLocation.getLocationInteractions().get(index).doEvent();
			} else if (choice.charAt(0) == 's') {
				int index = Integer.parseInt(choice.replaceAll("[\\D]", ""));
				currentLocation.getLocationCreatures().get(index).converse();
			} else if (choice.charAt(0) == 'p') {
				int index = Integer.parseInt(choice.replaceAll("[\\D]", ""));
				//fight()
			} else {
				PRINTER.errorln("\nPLEASE ENTER A VALID COMMAND");
			}*/
		}
	}
	
	public void playGame() {
		
	}
}
