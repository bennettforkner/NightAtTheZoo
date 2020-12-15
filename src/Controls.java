import java.util.ArrayList;
	
public class Controls {
	
	private ArrayList<Control> controls;
	
	public Controls(ArrayList<Control> controls) {
		this.controls = controls;
	}

	/**
	 * @return the controls
	 */
	public ArrayList<Control> getControls() {
		return controls;
	}
	
	public void addControl(Control c) {
		controls.add(c);
	}
	
	public String toString() {
		String toReturn = "\n+------------------------------------------------+";
		toReturn += "\n|  " + CONTROLLER.gameTitle + " controls:\n|";
		for (Control c : controls) {
			toReturn += "\n|  " + c.controlName + "\t[" + c.oneChar + "]: " + c.desc;
		}
		toReturn += "\n+------------------------------------------------+";
		return toReturn;
	}
	
	
	
}