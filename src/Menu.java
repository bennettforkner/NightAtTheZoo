
public class Menu {
	public static void main(String[] args) {
		
		GameInterface gi = new GameInterface();
		PRINTER.setUI(gi);
		
		gi.setScreenText("Welcome to Night at the Zoo.");
		
		if (System.getProperty("os.name").substring(0,6).compareToIgnoreCase("mac os") == 0) {
			//PRINTER.initMAC();
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
