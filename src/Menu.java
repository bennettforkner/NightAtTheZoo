
public class Menu {
	public static void main(String[] args) {
		
		UserInterface ui = new UserInterface();
		PRINTER.setUI(ui);
		
		ui.setScreenText("Welcome to the game game.");
		
		if (System.console() == null) System.setProperty("jansi.passthrough", "true");
		if (System.getProperty("os.name").substring(0,6).compareToIgnoreCase("mac os") == 0) {
			PRINTER.initMAC();
		} else if (System.getProperty("os.name").substring(0,10).compareToIgnoreCase("windows 10") == 0) {
			PRINTER.initWIN10();
		}
		System.out.println();
		CONTROLLER.GAME = new Game();
		CONTROLLER.GAME.init();
		CONTROLLER.GAME.playPreGame();
		CONTROLLER.GAME.playGame();

	}

}
