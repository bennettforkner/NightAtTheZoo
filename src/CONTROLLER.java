
public class CONTROLLER {
	
	public static Game GAME;
	
	public static Player player;
	
	public static String gameTitle = "Night at the Zoo";
	
	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
