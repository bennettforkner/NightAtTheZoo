
public class CONTROLLER {
	public static Game GAME;
	
	public static Player player;
	
	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
