import java.util.ArrayList;

public class Player extends Person {
	
	private int cash;
	
	public Player(String name, int hp, int strength, String cachePhrase,int cash) {
		super(name, hp, strength, cachePhrase);
		this.setCash(cash);
	}
	
	public Player(String name, int hp, int strength, String cachePhrase,int cash,ArrayList<Item> inventory) {
		super(name, hp, strength, cachePhrase,inventory);
		this.setCash(cash);
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

	/**
	 * @return the cash
	 */
	public int getCash() {
		return cash;
	}

	/**
	 * @param cash the cash to set
	 */
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	public boolean canBuy(Item i) {
		if (i.getPrice() <= getCash()) {
			return true;
		} else {
			return false;
		}
	}
	
	public int buy(Item i) {
		if (this.canBuy(i)) {
			this.cash -= i.getPrice();
			return this.cash;
		} else {
			return -1;
		}
	}
	
}
