import java.util.ArrayList;

public abstract class Animal extends Creature {

	public Animal(String name, int hp, int strength, String cachePhrase) {
		super(name, hp, strength, cachePhrase);
	}
	
	public Animal(String name, int hp, int strength, String cachePhrase,ArrayList<Item> inventory) {
		super(name, hp, strength, cachePhrase,inventory);
	}

}
