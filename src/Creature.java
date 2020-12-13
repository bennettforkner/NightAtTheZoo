import java.util.ArrayList;

public abstract class Creature {
private String name;
	
	protected int healthPoints;
	
	protected int maxHealthPoints;
	
	protected int strength;

	protected String catchPhrase;
	
	protected ArrayList<Item> inventory;
	
	private ArrayList<ConversationEvent> conversations;
	
	public Creature(String name,int hp,int strength,String cachePhrase) {
		setName(name);
		this.healthPoints = hp;
		this.maxHealthPoints = hp;
		setStrength(strength);
		setCachePhrase(cachePhrase);
		inventory = new ArrayList<Item>();
		conversations = new ArrayList<ConversationEvent>();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name.trim();
	}

	/**
	 * @return the healthPoints
	 */
	public int getHealthPoints() {
		return healthPoints;
	}

	/**
	 * @param healthPoints the healthPoints to set
	 */
	public int increaseHealthPoints(int increment) {
		this.healthPoints += increment;
		int rando = (int)(Math.random() * 3);
		if (rando == 0) {
			this.maxHealthPoints++;
		}
		if (this.healthPoints > this.maxHealthPoints) {
			this.healthPoints = this.maxHealthPoints;
		}
		return this.healthPoints;
	}

	/**
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * @param strength the strength to set
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	private void setCachePhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
		
	}

	/**
	 * @return the inventory
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	/**
	 * @param item the item to add
	 */
	public void addToInventory(Item item) {
		PRINTER.narrateln("\n" + item.getName() + " added to inventory.");
		this.inventory.add(item);
	}
	
	/**
	 * @param item the item to remove
	 */
	public void removeFromInventory(Item item) {
		this.inventory.add(item);
	}

	/**
	 * @return the conversations
	 */
	public ArrayList<ConversationEvent> getConversations() {
		return conversations;
	}

	/**
	 * @param conversations the conversations to set
	 */
	public void addConversation(ConversationEvent conversation) {
		this.conversations.add(conversation);
	}
	
	public void converse() {
		if (conversations.size() == 0) {
			PRINTER.narrateln("\n" + this.name + " was unwilling to talk.");
		} else {
			int rando = (int)(Math.random() * conversations.size());
			conversations.get(rando).doEvent();
		}
	}
}
