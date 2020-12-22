
/**
 * Control is the class to represent one functionality that the user can enact
 * <p>
 * Controls connect a string or char name of a control to an action
 * that can be completed such as "go","speak","do", etc
 * 
 * @author b4knah
 * @since 12/21/2020
 * 
 */
public class Control {
	
	/**
	 * The friendly name of this control
	 */
	public String controlName;
	
	/**
	 * The user-friendly description of this control
	 */
	public String desc;
	
	/**
	 * The one-character name of this control
	 */
	public char oneChar;
	
	/**
	 * The anonymous function that will be executed when this control is activated
	 */
	private Runner functionality;
	
	/**
	 * The boolean value to keep track of whether or not this Control can be used
	 */
	private boolean available;
	
	/**
	 * Constructor for a Control
	 * 
	 * @param controlName The name of the control
	 * @param desc The description to be presented to the user
	 * @param oneChar The one-character name of the control
	 * @param available A boolean value of whether or not the control can be used
	 * @param functionality The anonymous function that will be executed when this control is activated
	 */
	public Control(String controlName,String desc,char oneChar, boolean available,Runner functionality) {
		
		// Set instance variables from parameters
		this.controlName = controlName;
		this.desc = desc;
		this.oneChar = oneChar;
		this.functionality = functionality;
		this.available = available;
		
	}
	
	/**
	 * The method to execute the functionality that was
	 * passed when the Control was created
	 * 
	 */
	public void run() {
		this.functionality.run();
		
	}

	/**
	 * Method to view whether or not the Control is available to the user
	 * 
	 * @return the available
	 * 
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Method to set whether or not the Control is available to the user
	 * 
	 * @param available the available to set
	 * 
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
}