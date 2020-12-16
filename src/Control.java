public class Control {
		
	public String controlName;
	
	public String desc;
	
	public char oneChar;
	
	private Runner functionality;
	
	public Control(String controlName,String desc,char oneChar,Runner functionality) {
		this.controlName = controlName;
		this.desc = desc;
		this.oneChar = oneChar;
		this.functionality = functionality;
	}
	
	public void run(String arg) {
		this.functionality.run(arg);
	}
}