
/**
 * HelpControl is the Control class to manage the Control for the help functionality
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public class HelpControl extends Control {

	public HelpControl(String controlName, String desc, char oneChar, Runner functionality) {
		
		// Call the superclass's constructor with relevant data and
		// always true availability
		super(controlName, desc, oneChar, true, functionality);
		
	}
	
	@Override
	public void setAvailable(boolean available) {
		
		// Do nothing
		
	}

}
