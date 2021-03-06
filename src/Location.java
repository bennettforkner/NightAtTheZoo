import java.util.ArrayList;

public class Location {
	
	private String locationName;
	
	private ArrayList<Item> items;
	
	private int[] accessibleLocationInts;
	
	private ArrayList<Location> accessibleLocations;
	
	private ArrayList<InteractionEvent> interactions;
	
	private ArrayList<Creature> creatures;
	
	public Location(String locationName,int[] accessibleLocationInts) {
		setLocationName(locationName);
		this.items = new ArrayList<Item>();
		this.interactions = new ArrayList<InteractionEvent>();
		this.creatures = new ArrayList<Creature>();
		this.accessibleLocationInts = accessibleLocationInts;
		this.accessibleLocations = new ArrayList<Location>();
	}
	
	public void connectLocations() {
		for (int i : accessibleLocationInts) {
			this.addLocation(CONTROLLER.GAME.getLocations().get(i));
		}
	}

	private void addLocation(Location location) {
		accessibleLocations.add(location);
		
	}

	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * @return the items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * @param item the item to add
	 */
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	/**
	 * @param index the index of the item to remove
	 */
	public void removeItem(int index) {
		this.items.remove(index);
	}

	/**
	 * @return the accessibleLocations
	 */
	public ArrayList<Location> getAccessibleLocations() {
		return this.accessibleLocations;
	}

	/**
	 * @return the events
	 */
	public ArrayList<InteractionEvent> getLocationInteractions() {
		return this.interactions;
	}

	/**
	 * @param interaction the InteractionEvent to add
	 */
	public void addLocationEvent(InteractionEvent interaction) {
		this.interactions.add(interaction);
	}
	
	public void addLocationCreature(Creature c) {
		creatures.add(c);
		
	}
	
	public ArrayList<Creature> getLocationCreatures() {
		return creatures;
	}
	
}
