import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * GameControlButton is the JButton class that adds the styling and actions
 * for the NightAtTheZoo Game
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public class GameControlButton extends JButton {

	/**
	 * The constructor for a GameControlButton with no text
	 * 
	 */
	public GameControlButton() {
		
		// Call below constructor with empty string
		this("");
	}
	
	/**
	 * Constructor for a GameControlButton with text
	 * 
	 * @param text The text to be displayed on the button
	 * 
	 */
	public GameControlButton(String text) {
		
		// Create a new JButton with the passed text
		super(text);
		
		// Set this button to visible and opaque (both required)
		this.setVisible(true);
		this.setOpaque(true);
		
		// Set the cursor to change to a pointer on hover
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		// Clear the content area so that the background can be displayed
		this.setContentAreaFilled(false);
		
		// Set the text color to white
		this.setForeground(Color.WHITE);
    	
		// Add an anonymous mouse listener that changes the background color to green
		// when the button is hovered over
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			
			@Override
    	    public void mouseEntered(java.awt.event.MouseEvent evt) {
				
    	    	setBackground(Color.GREEN);
    	    	
    	    }

			@Override
    	    public void mouseExited(java.awt.event.MouseEvent evt) {
				
				// Set the background to default
    	    	setBackground(UIManager.getColor("control"));
    	    	
    	    }
			
    	});
		
		// Add an anonymous listener to monitor when the button is clicked
    	this.addChangeListener(new ChangeListener() {
    		
            @Override
            public void stateChanged(ChangeEvent evt) {
            	
            	// Conditional if the button is pressed
                if (getModel().isPressed()) {
                	
                	setBackground(Color.GREEN);
                	
                // Conditional if the model is roll over
                } else if (getModel().isRollover()) {
                
                	setBackground(Color.PINK);
                	
                // Conditional all other cases
                } else {
                	
                	setBackground(UIManager.getColor("control"));
                	
                }
            }
        });
	}

}
