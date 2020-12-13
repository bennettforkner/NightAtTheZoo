
public class PRINTER {
	public static final String RESET = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	
	public static void prompt(String in) {
		System.out.print(in);
	}
	
	public static void promptln(String in) {
		System.out.println(in);
	}
	
	public static void narrate(String in) {
		System.out.print(in);
	}
	
	public static void narrateln(String in) {
		System.out.println(in);
	}
	
	public static void say(String in,Creature c) {
		System.out.print(in);
	}
	
	public static void sayln(String in,Creature c) {
		System.out.println(in);
	}
	
	public static void think(String in) {
		System.out.print(in);
	}
	
	public static void thinkln(String in) {
		System.out.println(in);
	}
	
	public static void error(String in) {
		System.err.print(in);
	}
	
	public static void errorln(String in) {
		System.err.println(in);
	}
}
