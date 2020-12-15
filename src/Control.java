public class Control {
		
	public String controlName;
	
	public String desc;
	
	public char oneChar;
	
	private Runnable functionality;
	
	public Control(String controlName,String desc,char oneChar,Runnable functionality) {
		this.controlName = controlName;
		this.desc = desc;
		this.oneChar = oneChar;
		this.functionality = functionality;
	}
	
	public void run() {
		this.functionality.run();
	}
}