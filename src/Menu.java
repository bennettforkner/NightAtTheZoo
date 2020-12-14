
public class Menu {
	public static void main(String[] args) {
		if (System.console() == null) System.setProperty("jansi.passthrough", "true");
		System.out.println(System.getProperty("os.name"));
		if (System.getProperty("os.name").substring(0,6).compareToIgnoreCase("mac os") == 0) {
			PRINTER.initMAC();
		} else if (System.getProperty("os.name").substring(0,10).compareToIgnoreCase("windows 10") == 0) {
			PRINTER.initWIN10();
		}
		CONTROLLER.GAME = new Game();
		CONTROLLER.GAME.init();
		CONTROLLER.GAME.playPreGame();

	}

}
