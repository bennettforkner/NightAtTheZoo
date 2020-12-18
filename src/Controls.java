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
	
	public void removeControl(Control c) {
		controls.remove(c);
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
		String[] controlStringArr = new String[controls.size()];
		String toReturn = "\n+------------------------------------------------+";
		toReturn += "\n|";
		toReturn += "\n|  " + CONTROLLER.gameTitle + " controls:\n|";
		int count = 0;
		for (Control c : controls) {
			if (c.isAvailable()) {
				controlStringArr[count++] = c.controlName;
				if (c.controlName.length() > 4) {
					toReturn += "\n|  " + c.controlName + "\t[" + c.oneChar + "]: " + c.desc;
				} else {
					toReturn += "\n|  " + c.controlName + "\t\t[" + c.oneChar + "]: " + c.desc;
				}
			}
		}
		toReturn += "\n|";
		toReturn += "\n+------------------------------------------------+";
		
		PRINTER.displayControls();
		return toReturn;
	}
	
	
	
}