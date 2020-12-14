import java.util.ArrayList;

public class Hippo extends Animal implements Enemy {

	public Hippo(String name, int hp, int strength, String cachePhrase) {
		super(name, hp, strength, cachePhrase);
	}
	
	public Hippo(String name, int hp, int strength, String cachePhrase,ArrayList<Item> inventory) {
		super(name, hp, strength, cachePhrase,inventory);
	}
	
}
