import java.util.ArrayList;

public class Location {
	
	private String locationName;
	
	private ArrayList<Item> items;
	
	private int[] accessibleLocations;
	
	private ArrayList<InteractionEvent> interactions;
	
	private ArrayList<Creature> creatures;
	
	public Location(String locationName,int[] accessibleLocations) {
		setLocationName(locationName);
		this.items = new ArrayList<Item>();
		this.interactions = new ArrayList<InteractionEvent>();
		this.creatures = new ArrayList<Creature>();
		this.accessibleLocations = accessibleLocations;
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
	 * @param items the items to set
	 */
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	/**
	 * @param items the items to set
	 */
	public void removeItem(int index) {
		this.items.remove(index);
	}

	/**
	 * @return the accessibleLocations
	 */
	public int[] getAccessibleLocations() {
		return this.accessibleLocations;
	}

	/**
	 * @return the events
	 */
	public ArrayList<InteractionEvent> getLocationInteractions() {
		return this.interactions;
	}

	/**
	 * @param event the event to add
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
