import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * CreatureChoiceListener is the class to be activated when
 * a Creature button is pressed on the GUI
 * 
 * @author Bennett Forkner
 *
 */
public class CreatureChoiceListener implements ActionListener {
	
	/**
	 * The creature that this listener applies to
	 */
	private Creature creature;
	
	/**
	 * The button that this listener is attached to
	 */
	private JButton jbutt;
	
	/**
	 * The constructor for a CreatureChoiceListener
	 * 
	 * @param c the creature to be selected
	 * @param butt the button that this listener is for
	 */
	public CreatureChoiceListener(Creature c,JButton butt) {
		
		// Set instance variables to passed parameters
		this.creature = c;
		this.jbutt = butt;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Start a new thread to stop the GUI from waiting for completion
		new Thread(() -> {
			
			// Set the global variable representing the selected creature
			// to the relevant creature
			CONTROLLER.SELECTEDCREATURE = this.creature;
			
        }).start();
		
	}

}
