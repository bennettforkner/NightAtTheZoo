import java.util.ArrayList;

/**
 * InteractionEvent is the class to represent actions that a Player can complete
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public abstract class InteractionEvent implements GameEvent {
	
	/**
	 * The friendly title of this InteractionEvent
	 */
	private String title;
	
	/**
	 * The number of times that this InteractionEvent can be run
	 */
	private int usesLeft;

	/**
	 * The constructor for an InteractionEvent with no usesLeft
	 * 
	 * @param title The title of the InteractionEvent
	 * 
	 */
	public InteractionEvent(String title) {
		
		// Call the below constructor with default variables appended
		this(title,1);
		
	}
	
	/**
	 * The constructor for an InteractionEvent with usesLeft
	 * 
	 * @param title The title of the InteractionEvent
	 * @param usesLeft The amount of times that this InteractionEvent can be used
	 */
	public InteractionEvent(String title, int usesLeft) {
		
		// Set instance variables to passed parameters
		this.title = title;
		this.usesLeft = usesLeft;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void doEvent() {
		
		// Decrement the amount of allowed uses left
		this.usesLeft--;
		
		// Conditional if the InteractionEvent has no uses left
		if (this.usesLeft == 0) {
			
			// Remove this InteractionEvent from the Location
			CONTROLLER.GAME.getCurrentLocation().getLocationInteractions().remove(this);
			
		}
		
		// Run the logic for this InteractionEvent
		this.runEvent();
	}
	
	/**
	 * The method to store the logic of the InteractionEvent
	 * This will be filled in subclasses (anonymous classes in data_events)
	 * 
	 */
	public abstract void runEvent();

	/**
	 * The method to return the title of this InteractionEvent
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	

	/**
	 * The method to return the uses left that this InteractionEvent allows
	 * 
	 * @return the usesLeft
	 */
	public int getUsesLeft() {
		return usesLeft;
	}

}
