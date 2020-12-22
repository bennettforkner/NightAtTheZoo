import java.util.ArrayList;

/**
 * Creature is the class to collect logic and variables that will
 * be shared by all Creature subclasses
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public abstract class Creature {
	
	/**
	 * The friendly name of the Creature
	 */
	private String name;
	
	/**
	 * The Integer representing the amount of health that this Creature has left
	 */
	protected int healthPoints;
	
	/**
	 * The Integer representing the maximum amount of health
	 * that this Creature is allowed
	 */
	protected int maxHealthPoints;
	
	/**
	 * The Integer representing the strength of this Creature's attacks
	 */
	protected int strength;
	
	/**
	 * The String that is displayed whenever this Creature beats another
	 * Creature in a fight
	 */
	protected String catchPhrase;
	
	/**
	 * The ArrayList that sores Items in the Creature's inventory
	 */
	protected ArrayList<Item> inventory;
	
	/**
	 * The ArrayList that stores conversations that can be had with this Creature
	 */
	private ArrayList<ConversationEvent> conversations;
	
	/**
	 * The Constructor for a Creature without Items in their inventory
	 * 
	 * @param name The friendly name of the Creature
	 * @param hp The Health Points of the Creature
	 * @param strength The Strength of the Creature's attacks
	 * @param catchPhrase The catch phrase of the Creature
	 * 
	 */
	public Creature(String name,int hp,int strength,String catchPhrase) {
		
		// Call below constructor with empty inventory
		this(name,hp,strength,catchPhrase,new ArrayList<Item>());
	}
	
	/**
	 * The Constructor for a Creature without Items in their inventory
	 * 
	 * @param name The friendly name of the Creature
	 * @param hp The Health Points of the Creature
	 * @param strength The Strength of the Creature's attacks
	 * @param catchPhrase The catch phrase of the Creature
	 * @param inventory The starting inventory of this Creature
	 */
	public Creature(String name,int hp,int strength,String catchPhrase,ArrayList<Item> inventory) {
		
		// Set instance variables to passed parameters
		setName(name);
		this.healthPoints = hp;
		this.maxHealthPoints = hp;
		setStrength(strength);
		setCachePhrase(catchPhrase);
		this.inventory = inventory;
		conversations = new ArrayList<ConversationEvent>();
	}

	/**
	 * The method to return the name of this Creature
	 * 
	 * @return the name
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * The method to set the name of this Creature
	 * 
	 * @param name the name to set
	 * 
	 */
	public void setName(String name) {
		this.name = name.trim();
	}

	/**
	 * The method to return the health points of this Creature
	 * 
	 * @return the healthPoints
	 * 
	 */
	public int getHealthPoints() {
		return healthPoints;
	}

	/**
	 * The method to increase the health points of this Creature
	 * 
	 * @param increment The amount of health points to increase by
	 * @return the new health point amount
	 * 
	 */
	public int increaseHealthPoints(int increment) {
		
		// Add increment amount to healthPoints
		this.healthPoints += increment;
		
		// Get random number between 0 and 3
		int rando = (int)(Math.random() * 3);
		
		// Conditional if random number = 3
		if (rando == 0) {
			// Increase maxHealthPoints by 1
			this.maxHealthPoints++;
		}
		
		// Do not allow healthPoints to be higher than maxHealthPoints
		if (this.healthPoints > this.maxHealthPoints) {
			this.healthPoints = this.maxHealthPoints;
		}
		
		// Return the new amount of health points
		return this.healthPoints;
	}

	/**
	 * The method to get the strength of the Creature's attacks
	 * 
	 * @return the strength
	 * 
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * The method to set the strength of the Creature's attacks
	 * 
	 * @param strength the strength to set
	 * 
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	/**
	 * The method to get the catchPhrase of the Creature
	 * 
	 * @return the catch phrase of the Creature
	 * 
	 */
	public String getCatchPhrase() {
		return catchPhrase;
	}

	/**
	 * The method to set the catchPhrase of the creature
	 * 
	 * @param catchPhrase the new catch phrase to be set
	 * 
	 */
	private void setCachePhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
		
	}

	/**
	 * The method to get the inventory of the Creature
	 * 
	 * @return the inventory of the Creature
	 * 
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	/**
	 * The method to add an Item to the Inventory
	 * 
	 * @param item the item to add
	 * 
	 */
	public void addToInventory(Item item) {
		PRINTER.narrateln("\n" + item.getName() + " added to inventory.");
		this.inventory.add(item);
	}
	
	/**
	 * The method to remove an Item from the Creature's inventory
	 * 
	 * @param item the item to remove
	 * 
	 */
	public void removeFromInventory(Item item) {
		this.inventory.remove(item);
	}

	/**
	 * The method to get the conversations that this Creature can have
	 * 
	 * @return the conversations
	 * 
	 */
	public ArrayList<ConversationEvent> getConversations() {
		return conversations;
	}

	/**
	 * The method to add a ConversationEvent to the Creature's conversations
	 * 
	 * @param conversation the conversation to be added
	 * 
	 */
	public void addConversation(ConversationEvent conversation) {
		this.conversations.add(conversation);
	}
	
	/**
	 * The method to start a conversation with this Creature
	 * 
	 */
	public void converse() {
		
		// Conditional if the Creature has no available conversations
		if (conversations.size() == 0) {
			
			PRINTER.narrateln("\n" + this.name + " was unwilling to talk.");
		
		// Conditional if the Creature has available conversations
		} else {
			
			// Get a random number between 0 and the amount of available conversations
			int rando = (int)(Math.random() * conversations.size());
			
			// Run the ConversationEvent's logic
			conversations.get(rando).doEvent();
		}
	}
}
