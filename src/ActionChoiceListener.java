import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionChoiceLister is the ActionListener class that will be used to handle when the user clicks an action button (to run the action).
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 * 
 */
public class ActionChoiceListener implements ActionListener {

	/**
	 * The GameEvent to enact when this action listener is enacted
	 */
	private GameEvent event;

	/**
	 * Constructor for ActionChoiceListener
	 * 
	 * @param ge The GameEvent that will be enacted when the action listener is enacted
	 */
	public ActionChoiceListener(GameEvent ge) {
		
		// Assign passed GameEvent to instance variable
		this.event = ge;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Create a new thread so that this program does not wait for the event to finish
		new Thread(() -> {
			
			// Run the logic stored inside the GameEvent
			event.doEvent();
			
			// Set global variable to false after event finishes running
			CONTROLLER.WAIT = false;
			
        }).start();
		
	}

}
