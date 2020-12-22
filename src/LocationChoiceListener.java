import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * LocationChoiceListener is the ActionListener to wait for
 * the player to choose a Location to go to
 * 
 * @author Bdnnett Forkner
 * @since 12/21/2020
 *
 */
public class LocationChoiceListener implements ActionListener {
	
	/**
	 * The Location Object that this LocationChoiceListener is attached to
	 */
	private Location location;
	
	/**
	 * The button for which this Listener waits
	 */
	private JButton jbutt;

	/**
	 * The constructor for a LocationChoiceListener
	 * 
	 * @param l the location that will be selected
	 * @param butt the button that this Listener applies to
	 * 
	 */
	public LocationChoiceListener(Location l,JButton butt) {
		
		// Set instance variables to passed parameters
		this.location = l;
		this.jbutt = butt;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Start a new thread so that the GUI does not have to wait for completion
		new Thread(() -> {
			
			// Set the global variable of the selected location to this location
			CONTROLLER.SELECTEDLOCATION = this.location;
			
        }).start();
	}

}
