
/**
 * Menu is the main class of this program
 * 
 * @author BennettForkner
 * @since 12/21/2020
 *
 */
public class Menu {
	
	/**
	 * The main method of the entire program
	 * @param args the argument array that is passed along with a call to this program
	 * 
	 */
	public static void main(String[] args) {
		
		// Initialize the GUI
		GameInterface gi = new GameInterface();
		
		// Set the PRINTER to use the GUI
		PRINTER.setUI(gi);
		
		// Set the welcome text
		gi.setScreenText("Welcome to Night at the Zoo.");
		
		// Initialize the Game Object
		CONTROLLER.GAME = new Game();
		CONTROLLER.GAME.init();
		
		// Run the pre-game scenario
		CONTROLLER.GAME.playPreGame();
		
		// Run the game
		CONTROLLER.GAME.playGame();

	}

}
