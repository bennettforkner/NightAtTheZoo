
public class FoodItem implements Item {
	
	private int minRestoreHP;
	private int maxRestoreHP;
	private String foodName;
	private int price;
	
	public FoodItem(int medianHPGain,String foodName,int price) {
		this.minRestoreHP = medianHPGain - (int)(medianHPGain * 0.4);
		this.maxRestoreHP = medianHPGain + (int)(medianHPGain * 0.4);
		this.foodName = foodName;
		this.price = price;
	}

	/**
	 * @return the minRestoreHP
	 */
	public void eat() {
		int increase = (int)(Math.random() * (this.maxRestoreHP - this.minRestoreHP)) + this.minRestoreHP;
		CONTROLLER.player.increaseHealthPoints(increase);
		CONTROLLER.player.getInventory().remove(this);
	}

	/**
	 * @return the foodName
	 */
	public String getName() {
		return foodName;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	
}
