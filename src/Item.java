
/**
 * Item is the interface to collect data and functionality
 * that is common between all Item subclasses
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public interface Item {
	
	/**
	 * The method to return the price of the Item
	 * 
	 * @return the price of the Item
	 * 
	 */
	public int getPrice();

	/**
	 * The method to return the name of the Item
	 * 
	 * @return the name of the Item
	 */
	public String getName();
	
}
