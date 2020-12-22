
/**
 * GameEvent is the interface to collect logic that can be called for all types of events
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public interface GameEvent {
	
	/**
	 * The method to enact the logic of this event
	 * 
	 */
	public void doEvent();
	
	/**
	 * The method to return the title of this event
	 * 
	 * @return the unique title of this event
	 * 
	 */
	public String getTitle();
	
	/**
	 * The method to get the uses left that this event has
	 * 
	 * @return the uses left of this event
	 * 
	 */
	public int getUsesLeft();
	
}
