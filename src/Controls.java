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
	
	public Control getControl(String controlName) {
		for (Control c : controls) {
			if (c.controlName.compareToIgnoreCase(controlName) == 0 ) {
				return c;
			}
		}
		return null;
	}
	
	public Control getControl(char oneChar) {
		for (Control c : controls) {
			if (Character.toLowerCase(c.oneChar) == Character.toLowerCase(oneChar)) {
				return c;
			}
		}
		return null;
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