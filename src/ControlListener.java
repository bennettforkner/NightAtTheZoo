import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ControlListener is the ActionListener class that waits for the activation of
 * a control button on the interface and executes that Control's logic when activated.
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public class ControlListener implements ActionListener {
	
	/**
	 * The Control to be activated when this action is enacted
	 */
	private Control control;
	
	/**
	 * The constructor for a ControlListener
	 * 
	 * @param c The Control to be attached to this ControlListener
	 */
	public ControlListener(Control c) {
		
		// Set instance variables to passed parameters
		this.control = c;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Create a new thread so that the interface does not need
		// to wait for the action to finish
		new Thread(() -> {
			
			// Run the logic stored in the control
			control.run();
			
			// Set the global variable to stop waiting for the logic to finish
			CONTROLLER.WAIT = false;
			
        }).start();
		
		// Wait for 0.1s
		CONTROLLER.sleep(100);
		
		// Refresh the controls that the user is allowed to use
		PRINTER.displayControls();
		
	}

}
