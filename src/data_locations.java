import java.util.ArrayList;
import java.util.Scanner;

public class data_locations {
	
	public static ArrayList<Location> getLocationsPreGame() {
		Scanner in = new Scanner(System.in);
		LocationList locations = new LocationList();
		locations.add(new Location("your living room",new int[] {}));
		locations.get("your living room").addLocationCreature(CONTROLLER.GAME.creatures.mom);
		locations.get("your living room").addLocationCreature(CONTROLLER.GAME.creatures.timmy);
		
		locations.add(new Location("the zoo entrance",new int[] {7,4}));
		locations.get("the zoo entrance").addLocationEvent((InteractionEvent)data_events.getEvent("Take a Selfie"));
		
		locations.add(new Location("the hippo exhibit",new int[] {4,9}));
		locations.get("the hippo exhibit").addLocationEvent((InteractionEvent)data_events.getEvent("Watch the Hippos"));
		locations.get("the hippo exhibit").addLocationEvent((InteractionEvent)data_events.getEvent("Take a Selfie2"));
		
		locations.add(new Location("the penguin exhibit",new int[] {9}));
		
		locations.add(new Location("the turtle pond",new int[] {1,2}));
		locations.get("the turtle pond").addLocationEvent((InteractionEvent)data_events.getEvent("Feed the Turtles"));
		
		locations.add(new Location("the reptile room",new int[] {1}));
		
		locations.add(new Location("the bugs & slugs exhibit",new int[] {10,9}));
		
		locations.add(new Location("the food court",new int[] {1,10}));
		locations.get("the food court").addLocationEvent((InteractionEvent)data_events.getEvent("Order Something"));
		
		locations.add(new Location("the bird sanctuary",new int[] {9,3}));
		
		locations.add(new Location("the flamingo hellhole",new int[] {2,4,8,6}));
		locations.get("the flamingo hellhole").addLocationEvent((InteractionEvent)data_events.getEvent("Mock the Flamingos"));
		
		locations.add(new Location("the gift shop",new int[] {7,6}));
		locations.get("the gift shop").addLocationEvent((InteractionEvent)data_events.getEvent("Buy a Toy Hippo for Timmy"));
		return locations;
	}
}
