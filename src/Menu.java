
public class Menu {
	public static void main(String[] args) {
		
		if (System.getProperty("os.name").substring(0,6).compareToIgnoreCase("mac os") == 0) {
			PRINTER.initMAC();
		}
		System.out.println();
		CONTROLLER.GAME = new Game();
		CONTROLLER.GAME.init();
		CONTROLLER.GAME.playPreGame();
		CONTROLLER.GAME.playGame();

	}

}
