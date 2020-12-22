import java.util.ArrayList;

/**
 * Animal is the abstract class that extends Creature and is used for
 * collecting logic and instance variables that will be shared
 * among all Animal subclasses.
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 * 
 */
public abstract class Animal extends Creature {
	
	/**
	 * Constructor for Animal w/o inventory
	 * 
	 * @param name The friendly name of the Animal
	 * @param hp The integer value representing the remaining health of the animal
	 * @param strength The integer value representing the strength of the Animal
	 * @param cachePhrase The phrase that an Animal will say when they beat another creature
	 * 
	 */
	public Animal(String name, int hp, int strength, String cachePhrase) {

		// Pass all of the data into the superclass's constructor
		super(name, hp, strength, cachePhrase);
		
	}
	
	/**
	 * Constructor for Animal with inventory
	 * 
	 * @param name The friendly name of the Animal
	 * @param hp The integer value representing the remaining health of the animal
	 * @param strength The integer value representing the strength of the Animal
	 * @param cachePhrase The phrase that an Animal will say when they beat another creature
	 * @param inventory The arraylist containing the items in the Animal's inventory
	 * 
	 */
	public Animal(String name, int hp, int strength, String cachePhrase,ArrayList<Item> inventory) {
		
		// Pass all of the data into the superclass's constructor
		super(name, hp, strength, cachePhrase,inventory);
		
	}

}
