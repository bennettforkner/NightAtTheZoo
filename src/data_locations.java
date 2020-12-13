import java.util.ArrayList;
import java.util.Scanner;

public class data_locations {
	
	public static ArrayList<Location> getLocationsPreGame() {
		Scanner in = new Scanner(System.in);
		ArrayList<Location> locations = new ArrayList<Location>();
		locations.add(0,new Location("home",new int[] {}));
		locations.get(0).addLocationCreature(CONTROLLER.GAME.creatures.mom);
		locations.get(0).addLocationCreature(CONTROLLER.GAME.creatures.timmy);
		
		locations.add(1,new Location("the zoo entrance",new int[] {7,4}));
		locations.get(1).addLocationEvent((InteractionEvent)data_events.getEvent("Take a Selfie"));
		
		locations.add(2,new Location("the hippo exhibit",new int[] {4,9}));
		locations.get(2).addLocationEvent((InteractionEvent)data_events.getEvent("Watch the Hippos"));
		
		locations.add(3,new Location("the penguin exhibit",new int[] {9}));
		
		locations.add(4,new Location("the turtle pond",new int[] {1,2}));
		locations.get(4).addLocationEvent((InteractionEvent)data_events.getEvent("Feed the Turtles"));
		
		locations.add(5,new Location("the reptile room",new int[] {1}));
		
		locations.add(6,new Location("the bugs & slugs exhibit",new int[] {10,9}));
		
		locations.add(7,new Location("the food court",new int[] {1,10}));
		locations.get(7).addLocationEvent((InteractionEvent)data_events.getEvent("Order Something"));
		
		locations.add(8,new Location("the bird sanctuary",new int[] {9,3}));
		
		locations.add(9,new Location("the flamingo hellhole",new int[] {2,4,8,6}));
		locations.get(9).addLocationEvent((InteractionEvent)data_events.getEvent("Mock the Flamingos"));
		
		locations.add(10,new Location("the gift shop",new int[] {7,6}));
		locations.get(10).addLocationEvent((InteractionEvent)data_events.getEvent("Buy a Toy Hippo for Timmy"));
		return locations;
	}
}
