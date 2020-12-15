import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private ArrayList<Location> locations;
	private Location currentLocation;
	public boolean preGameRunning;
	public data_creatures creatures;
	public Controls controls;
	
	public void init() {
		Scanner in = new Scanner(System.in);
		PRINTER.prompt("Enter your name: ");
		String name = in.nextLine();
		PRINTER.prompt("\nEnter your catch phrase: ");
		String catchPhrase = in.nextLine();
		CONTROLLER.player = new Player(name, 5, 1, catchPhrase,0);
		ArrayList<Control> controls = new ArrayList<Control>();
		controls.add(new Control("GO", "move from one location to another.", 'g',() -> {}));
		controls.add(new Control("HELP", "display this menu.", 'h', () -> {
			PRINTER.narrate(this.controls.toString());
		}));
		this.controls = new Controls(controls);
		
		this.creatures = new data_creatures();
		data_events.init();
		this.preGameRunning = true;
		this.locations = data_locations.getLocationsPreGame();
	}
	
	public ArrayList<Location> getLocations() {
		return locations;
	}
	
	public void setCurrentLocation(int location) {
		currentLocation = locations.get(location);
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
			
			if (currentLocation.getAccessibleLocations().length > 0) {
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("\nYou can go to these locations:");
			}
			
			int count = 0;
			for (int index : currentLocation.getAccessibleLocations()) {
				PRINTER.narrateln("[" + index + "]: " + locations.get(index).getLocationName());
			}
			if (currentLocation.getLocationInteractions().size() > 0) {
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("\nYou can do these actions:");
			}
			
			count = 0;
			for (InteractionEvent interaction : currentLocation.getLocationInteractions()) {
				PRINTER.narrateln("[" + count++ + "]: " + interaction.getTitle());
			}
			if (currentLocation.getLocationCreatures().size() > 0) {
				CONTROLLER.sleep(1000);
				PRINTER.narrateln("\nThese people are around you:");
			}
			
			count = 0;
			for (Creature creature : currentLocation.getLocationCreatures()) {
				PRINTER.narrateln("[" + count++ + "]: " + creature.getName());
			}
			
			CONTROLLER.sleep(1000);
			
			PRINTER.prompt("\nWhat would you like to do?: ");
			
			Scanner in = new Scanner(System.in);
			String[] arguments = in.nextLine().split(" ");
			
			for (Control c : controls.getControls()) {
				if (arguments[0].compareToIgnoreCase(c.controlName) == 0 || arguments[0].compareToIgnoreCase(Character.toString(c.oneChar)) == 0) {
					c.run();
				}
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
