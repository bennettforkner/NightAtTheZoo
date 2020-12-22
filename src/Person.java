import java.util.ArrayList;

/**
 * Person is a Creature that represents a person
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public class Person extends Creature {

	/**
	 * The constructor for a Person with an empty inventory
	 * 
	 * @param name The name of the Person
	 * @param hp The health points of the person
	 * @param strength The strength of the Person's attacks
	 * @param cachePhrase The phrase that the person says when they win a fight
	 * 
	 */
	public Person(String name, int hp, int strength, String cachePhrase) {

		// Call the super class's constructor and pass relevant data
		super(name, hp, strength, cachePhrase);
	}

	/**
	 * The constructor for a Person with an inventory
	 * 
	 * @param name The name of the Person
	 * @param hp The health points of the person
	 * @param strength The strength of the Person's attacks
	 * @param cachePhrase The phrase that the person says when they win a fight
	 * @param inventory The starting ArrayList of Items in the Player's inventory
	 * 
	 */
	public Person(String name, int hp, int strength, String cachePhrase,ArrayList<Item> inventory) {
		
		// Call the super class's constructor and pass relevant data
		super(name, hp, strength, cachePhrase,inventory);
	}

}
