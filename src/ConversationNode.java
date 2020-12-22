import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * ConversationNode is the class to keep track of individual pieces
 * of a ConversationEvent (being one back-and-forth)
 * between a Creature and a Player
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 */
public class ConversationNode {
	
	/**
	 * The String that the subject of the conversation says
	 */
	private String statement;
	
	/**
	 * The available responses that the player can say
	 */
	private Response[] responses;
	
	/**
	 * The anonymous function that will be run when the ConversationNode is finished
	 */
	private Runnable endLogic;
	
	/**
	 * The constructor for a ConversationNode with no endLogic
	 * 
	 * @param statement The String that the Creature will say
	 * @param responses The available responses that the Player can choose from
	 * 
	 */
	public ConversationNode(String statement, Response[] responses) {
		
		// Set instance variables to passed parameters
		this.statement = statement;
		this.responses = responses;
		this.endLogic = () -> {};
	}
	
	/**
	 * The constructor for a ConversationNode
	 * 
	 * @param statement The String that the Creature will say
	 * @param responses The available responses that the Player can choose from
	 * @param endLogic The anonymous function that will be run when the ConversationNode ends
	 * 
	 */
	public ConversationNode(String statement, Response[] responses, Runnable endLogic) {
		
		// Set instance variables to passed parameters
		this.statement = statement;
		this.responses = responses;
		this.endLogic = endLogic;
	}
	
	/**
	 * The method to display the statement that the subject says
	 * and handle the response of the Player
	 * 
	 * @param subject The Creature that is saying the statement
	 * @return the next ConversationEvent that should be run
	 * 
	 */
	public int converse(Creature subject) {
		
		// Conditional if the statement is multiple lines
		if (this.statement.indexOf("\n") >= 0) {
			
			// Split the statement into its individual lines
			String[] lines = this.statement.split("\n");
			
			// Display the name of the creature to identify who is speaking
			PRINTER.say("\n" + subject.getName() + ": ",subject);
			
			// Loop over each line in the array of lines
			for (String line : lines) {
				
				// Delay a certain amount of milliseconds
				CONTROLLER.sleep(2000);
				
				// Display this line of the statement
				PRINTER.sayln(line,subject);
				
			}
			
			// Delay a certain amount of milliseconds
			CONTROLLER.sleep(2000);
			
		// Conditional if the statement is only one line
		} else {
			
			// Display the subject's name as an identifier
			PRINTER.say("\n" + subject.getName() + ": ",subject);
			
			// Delay a certain amount of seconds
			CONTROLLER.sleep(2000);
			
			// Display the statement
			PRINTER.sayln(this.statement,subject);
			
			// Delay a certain amount of seconds
			CONTROLLER.sleep(3000);
		}
		
		// Conditional if the Player is allowed to respond
		if (responses != null) {
			
			// Store the available responses as a List Object
			List<Response> aLResponses = Arrays.asList(this.responses);
			
			// Randomize the order of the available responses
			Collections.shuffle(aLResponses);
			
			// Set the instance variable responses to an array version of
			// the randomized response list
			this.responses = aLResponses.toArray(new Response[0]);
			
			// Set a counter to keep track of the loop index
			int count = 0;
			
			// Loop over responses in array
			for (Response resp : responses) {
				
				// Display available Responses
				PRINTER.narrateln("[" + count++ + "]: " + resp.getResponse());
			}
			//PRINTER.prompt("\nWhat would you like to say?: ");
			
			// Read input from the Player
			String choice = PRINTER.readLine();
			
			// Run the logic at the end of the ConversationNode
			endLogic.run();
			
			// Placeholder until logic can be adjusted for GUI
			return 1;
		
		// Conditional if the Player does not have an option to respond
		} else {
			
			// Run the logic at the end of the ConversationNode
			endLogic.run();
			
			// Return the -1 identifier for no next node
			return -1;
		}
	}
}
