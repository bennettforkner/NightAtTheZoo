import java.util.ArrayList;

public class Person extends Creature {

	public Person(String name, int hp, int strength, String cachePhrase) {
		super(name, hp, strength, cachePhrase);
	}
	public Person(String name, int hp, int strength, String cachePhrase,ArrayList<Item> inventory) {
		super(name, hp, strength, cachePhrase,inventory);
	}

}
