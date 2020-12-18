
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
		controls.add(new Control("GO", "move from one location to another.", 'g', false, new Runner() {
			public void run() {
				Location l = CONTROLLER.SELECTEDLOCATION;
				if (l != null)
					CONTROLLER.GAME.setCurrentLocation(l);
				else
					PRINTER.errorln("Please select a location.");
			}
		}));
		controls.add(new HelpControl("HELP", "display this menu.", 'h', new Runner() {
			public void run() {
				PRINTER.narrateln(CONTROLLER.GAME.controls.toString());
			}
		}));
		controls.add(new Control("SPEAK", "speak to a creature.", 's', true, new Runner() {
			public void run() {
				
				Creature creature = CONTROLLER.SELECTEDCREATURE;
				
				if (creature != null) {
					creature.converse();
				} else {
					PRINTER.errorln("Please select a creature.");
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
		PRINTER.setCurrentLocation(location);
	}
	
	public Location getCurrentLocation() {
		return currentLocation;
	}
	
	public void playPreGame() {
		setCurrentLocation(locations.get(1));
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
			
			PRINTER.displayLocations();
			
			for (Location index : validLocations) {
				PRINTER.narrateln("[" + count++ + "]: " + index.getLocationName());
			}
			
			
			if (currentLocation.getLocationInteractions().size() > 0) {
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("\nYou can do these actions:");
			}
			validInteractions = currentLocation.getLocationInteractions();
			count = 0;
			
			PRINTER.displayActions();
			
			for (InteractionEvent interaction : validInteractions) {
				PRINTER.narrateln("[" + count++ + "]: " + interaction.getTitle());
			}
			
			
			if (currentLocation.getLocationCreatures().size() > 0) {
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("\nThese people are around you:");
			}
			validCreatures = currentLocation.getLocationCreatures();
			count = 0;
			
			PRINTER.displayCreatures();
			
			for (Creature creature : validCreatures) {
				PRINTER.narrateln("[" + count++ + "]: " + creature.getName());
			}
			
			CONTROLLER.sleep(1000);
			
			PRINTER.promptln("\nWhat would you like to do?: ");
			
			String[] arguments = PRINTER.readLine().split(" ");;
			/*
			Control control;
			if (arguments[0].length() > 1) {
				control = controls.getControl(arguments[0]);
			} else if (arguments[0].length() == 1) {
				control = controls.getControl(arguments[0].charAt(0));
			} else {
				PRINTER.errorln("Please enter a control.");
				continue;
			}
			
			if (control != null) {
				if (arguments.length > 1) control.run(arguments[1]);
				else control.run();
					
			} else {
				PRINTER.errorln("Please enter a valid control.");
			}
			*/
			
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
