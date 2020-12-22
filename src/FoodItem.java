
/**
 * FoodItem is the class to represent an Item that can be eaten
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public class FoodItem implements Item {
	
	/**
	 * The minimum amount of health points that this FoodItem can restore
	 */
	private int minRestoreHP;
	
	/**
	 * The maximum amount of health points that this FoodItem can restore
	 */
	private int maxRestoreHP;
	
	/**
	 * The name of this FoodItem
	 */
	private String foodName;
	
	/**
	 * The price of this FoodItem if it is in a store
	 */
	private int price;
	
	/**
	 * The constructor for a FoodItem
	 * 
	 * @param medianHPGain The middle value of the range of possible amounts of health points that can be restored by eating this FoodItem
	 * @param foodName The name of the FoodItem
	 * @param price The price of this FoodItem in a store
	 * 
	 */
	public FoodItem(int medianHPGain,String foodName,int price) {
		
		// Set min and max health point gains to responsible range
		this.minRestoreHP = medianHPGain - (int)(medianHPGain * 0.4);
		this.maxRestoreHP = medianHPGain + (int)(medianHPGain * 0.4);
		
		// Set instance variables to passed parameters
		this.foodName = foodName;
		this.price = price;
	}

	/**
	 * The method to eat this FoodItem
	 * 
	 */
	public void eat() {
		
		// Get a random and valid amount of health points to increase for the player
		int increase = (int)(Math.random() * (this.maxRestoreHP - this.minRestoreHP)) + this.minRestoreHP;
		
		// Increase the health points of the player by the random amount
		CONTROLLER.player.increaseHealthPoints(increase);
		
		// Remove this item from the Player's inventory
		CONTROLLER.player.getInventory().remove(this);
	}

	/**
	 * The method to get the name of this FoodItem
	 * 
	 * @return the foodName
	 * 
	 */
	public String getName() {
		return foodName;
	}

	/**
	 * The method to get the price of this FoodItem
	 * 
	 * @return the price
	 * 
	 */
	public int getPrice() {
		return price;
	}
	
}
