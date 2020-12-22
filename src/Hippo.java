import java.util.ArrayList;

/**
 * Hippo is the Creature class to represent a hippo enemy
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public class Hippo extends Animal implements Enemy {
	
	/**
	 * The constructor for a Hippo without an inventory
	 * 
	 * @param name The friendly name of the Creature
	 * @param hp The Health Points of the Creature
	 * @param strength The Strength of the Creature's attacks
	 * @param catchPhrase The catch phrase of the Creature
	 */
	public Hippo(String name, int hp, int strength, String catchPhrase) {
		
		// Call the superclass's constructor with relevant data
		super(name, hp, strength, catchPhrase);
		
	}
	
	/**
	 * The constructor for a Hippo with an inventory
	 * 
	 * @param name The friendly name of the Creature
	 * @param hp The Health Points of the Creature
	 * @param strength The Strength of the Creature's attacks
	 * @param catchPhrase The catch phrase of the Creature
	 * @param inventory The starting inventory of this Creature
	 * 
	 */
	public Hippo(String name, int hp, int strength, String catchPhrase,ArrayList<Item> inventory) {

		// Call the superclass's constructor with relevant data
		super(name, hp, strength, catchPhrase,inventory);
		
	}
	
}
