public class Control {
		
	public String controlName;
	
	public String desc;
	
	public char oneChar;
	
	private Runner functionality;
	
	private boolean available;
	
	public Control(String controlName,String desc,char oneChar, boolean available,Runner functionality) {
		this.controlName = controlName;
		this.desc = desc;
		this.oneChar = oneChar;
		this.functionality = functionality;
		this.available = available;
	}

	public void run() {
		this.functionality.run();
		
	}

	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
}