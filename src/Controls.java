import java.util.ArrayList;

/**
 * Controls is the class to aggregate Control Objects into a manageable menu
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public class Controls {
	
	/**
	 * The list of controls that exist in this menu
	 */
	private ArrayList<Control> controls;
	
	/**
	 * The constructor for a Controls object
	 * @param controls The list of Control Objects to be attached to this Controls Object
	 */
	public Controls(ArrayList<Control> controls) {
		
		// Set instance variables to passed parameters
		this.controls = controls;
		
	}

	/**
	 * Method to access the Control Objects stored in this Controls Object
	 * 
	 * @return the controls
	 * 
	 */
	public ArrayList<Control> getControls() {
		return controls;
	}
	
	/**
	 * Method to add a Control to the list of Control Objects
	 * 
	 * @param c The Control Object to be added
	 * 
	 */
	public void addControl(Control c) {
		controls.add(c);
	}
	
	/**
	 * Method to remove a Control Object from the list of Control Objects
	 * 
	 * @param c The Control Object to be removed
	 */
	public void removeControl(Control c) {
		controls.remove(c);
	}
	
	/**
	 * Method to get a control by friendly name
	 * 
	 * @param controlName The name of the control to be found
	 * @return the control with the passed name, if it exists, else null
	 * 
	 */
	public Control getControl(String controlName) {
		
		// Loop over all Control Objects in the list
		for (Control c : controls) {
			
			// Conditional if this Control Object's name is the same as the passed name
			if (c.controlName.compareToIgnoreCase(controlName) == 0 ) {
				
				// Return that object
				return c;
			}
		}
		
		// Return null if the Control Object was not found
		return null;
		
	}
	
	/**
	 * Method to get a control by friendly name
	 * 
	 * @param oneChar The one-character name of the control to be found
	 * @return the control with the passed character, if it exists, else null
	 * 
	 */
	public Control getControl(char oneChar) {
		
		// Loop over all Control Objects in the list
		for (Control c : controls) {
			
			// Conditional if this Control Object's one-character name is
			// the same as the passed name
			if (Character.toLowerCase(c.oneChar) == Character.toLowerCase(oneChar)) {
				
				// Return the found Control Object
				return c;
			}
		}
		
		// Return null if not found
		return null;
		
	}
	
	/**
	 * The method to nicely format all of the Control Objects in the list as a String
	 * 
	 * @return the formatted string
	 */
	public String toString() {
		
		// Initialize an array of the same size as the list of Control Objects
		String[] controlStringArr = new String[controls.size()];
		
		// Add the help header
		String toReturn = "\n+------------------------------------------------+";
		toReturn += "\n|";
		toReturn += "\n|  " + CONTROLLER.gameTitle + " controls:\n|";
		
		// Set a counter variable to keep track of the index in the for loop
		int count = 0;
		
		// Loop over all Control Objects in the list
		for (Control c : controls) {
			
			// Conditional if the Control Object may be used by the user
			if (c.isAvailable()) {
				
				// Add the Control Object's name to the array at the proper index
				controlStringArr[count++] = c.controlName;
				
				// Properly position the description to be tabbed-out nicely
				if (c.controlName.length() > 4) {
					toReturn += "\n|  " + c.controlName + "\t[" + c.oneChar + "]: " + c.desc;
				} else {
					toReturn += "\n|  " + c.controlName + "\t\t[" + c.oneChar + "]: " + c.desc;
				}
				
			}
		}
		
		// Add the help footer to the return String
		toReturn += "\n|";
		toReturn += "\n+------------------------------------------------+";
		
		// Refresh the Control buttons on the interface
		PRINTER.displayControls();
		
		// Return the compiled String
		return toReturn;
		
	}
	
	
	
}