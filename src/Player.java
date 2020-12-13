
public class Player extends Person {

	public Player(String name, int hp, int strength, String cachePhrase) {
		super(name, hp, strength, cachePhrase);
	}
	
	public void increaseStrength() {
		this.strength++;
		CONTROLLER.sleep(1000);
		PRINTER.narrateln("\nYou leveled up to level " + this.strength + " (+1)");
	}
	
	public void increaseStrength(int levels) {
		this.strength += levels;
		CONTROLLER.sleep(1000);
		System.out.println("\nYou leveled up to level " + this.strength + " (+" + levels + ")");
	}
	
}
