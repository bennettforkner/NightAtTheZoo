import java.util.ArrayList;

/**
 * Player is the class to store unique information about a user
 * 
 * @author Bennett Forkner
 *
 */
public class Player extends Person {
	
	/**
	 * The cash on-hand that the Player has
	 */
	private int cash;
	
	/**
	 * The constructor for a Player Object with an empty Inventory 
	 * 
	 * @param name The friendly name of the Creature
	 * @param hp The Health Points of the Creature
	 * @param strength The Strength of the Creature's attacks
	 * @param catchPhrase The catch phrase of the Creature
	 * @param cash The starting cash on-hand that a Player has
	 * 
	 */
	public Player(String name, int hp, int strength, String catchPhrase,int cash) {
		
		// Call the superclass's constructor with relevant data
		super(name, hp, strength, catchPhrase);
		
		// Set the instance variables to passed parameters
		this.setCash(cash);
		
	}
	
	/**
	 * The constructor for a Player Object with an Inventory 
	 * 
	 * @param name The friendly name of the Creature
	 * @param hp The Health Points of the Creature
	 * @param strength The Strength of the Creature's attacks
	 * @param catchPhrase The catch phrase of the Creature
	 * @param cash The starting cash on-hand that a Player has
	 * @param inventory The starting inventory of a Player
	 * 
	 */
	public Player(String name, int hp, int strength, String catchPhrase,int cash,ArrayList<Item> inventory) {
		
		// Call the superclass's constructor with relevant data
		super(name, hp, strength, catchPhrase, inventory);
		
		// Set the instance variables to passed parameters
		this.setCash(cash);
		
	}
	
	/**
	 * The method to increase the strength of the Player's attacks by one level
	 * 
	 */
	public void increaseStrength() {
		
		// Increase the instance variable for attack strength
		this.strength++;
		
		// Delay for one second
		CONTROLLER.sleep(1000);
		
		// Display message on the GUI
		PRINTER.narrateln("\nYou leveled up to level " + this.strength + " (+1)");
		
	}
	
	/**
	 * The method to increase the strength of the Player's attacks by multiple levels
	 * 
	 * @param levels The amount of levels to add
	 */
	public void increaseStrength(int levels) {
		// Increase the instance variable for attack strength
		this.strength += levels;
		
		// Delay for one second
		CONTROLLER.sleep(1000);
		
		// Display message on the GUI
		PRINTER.narrateln("\nYou leveled up to level " + this.strength + " (+1)");
	}

	/**
	 * The method to get the Player's cash on-hand
	 * 
	 * @return the cash
	 * 
	 */
	public int getCash() {
		return cash;
	}

	/**
	 * The method to set the Player's cash on-hand
	 * 
	 * @param cash the cash to set
	 * 
	 */
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	/**
	 * The method to check if the Player can buy a certain Item
	 * 
	 * @param i The Item to be checked
	 * @return true if the Player can buy the Item, else false
	 */
	public boolean canBuy(Item i) {
		
		// Conditional if the Item price is less than or equal to
		// the Player's cash on-hand
		if (i.getPrice() <= getCash()) {
			return true;
		
		// Conditional if the Item price is more than the Player's cash on-hand
		} else {
			return false;
		}
	}
	
	/**
	 * The method to lower a Player's cash on-hand by the amount that an Item costs
	 * 
	 * @param i The Item to be paid for
	 * @return The cash that a Player has left if they can buy the Item, else -1
	 */
	public int payFor(Item i) {
		
		// Conditional if the Player can buy the Item in question
		if (this.canBuy(i)) {
			
			// Subtract the price of the Item from the Player's cash on-hand
			this.cash -= i.getPrice();
			
			return this.cash;
			
		// Conditional if the Player cannot buy the Item in question
		} else {
			
			return -1;
			
		}
	}
	
}
