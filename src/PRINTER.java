
public class PRINTER {
	public static String RESET = "";
	public static String BLACK = "";
	public static String RED = "";
	public static String GREEN = "";
	public static String YELLOW = "";
	public static String BLUE = "";
	public static String PURPLE = "";
	public static String CYAN = "";
	public static String WHITE = "";
	
	public static void initMAC() {
		RESET = "\u001B[0m";
		BLACK = "\u001B[30m";
		RED = "\u001B[31m";
		GREEN = "\u001B[32m";
		YELLOW = "\u001B[33m";
		BLUE = "\u001B[34m";
		PURPLE = "\u001B[35m";
		CYAN = "\u001B[36m";
		WHITE = "\u001B[37m";
	}
	
	public static void initWIN() {
		RESET = "\u001B[0m";
		BLACK = "\u001B[30m";
		RED = "\u001B[31m";
		GREEN = "\u001B[32m";
		YELLOW = "\u001B[33m";
		BLUE = "\u001B[34m";
		PURPLE = "\u001B[35m";
		CYAN = "\u001B[36m";
		WHITE = "\u001B[37m";
	}
	
	public static void prompt(String in) {
		System.out.print(WHITE + in.replace(RESET, WHITE) + RESET);
	}
	
	public static void promptln(String in) {
		System.out.println(WHITE + in.replace(RESET, WHITE) + RESET);
	}
	
	public static void narrate(String in) {
		System.out.print(CYAN + in.replace(RESET, CYAN) + RESET);
	}
	
	public static void narrateln(String in) {
		System.out.println(CYAN + in.replace(RESET, CYAN) + RESET);
	}
	
	public static void say(String in,Creature c) {
		System.out.print(YELLOW + in.replace(RESET, YELLOW) + RESET);
	}
	
	public static void sayln(String in,Creature c) {
		System.out.println(YELLOW + in.replace(RESET, YELLOW) + RESET);
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
