import java.util.ArrayList;

/**
 * ConversationEvent is the GameEvent class that stores logic to run
 * conversations between the player and other Creatures
 * 
 * @author b4knah
 *
 */
public class ConversationEvent implements GameEvent {
	
	/**
	 * The ConversationNodes that occur in this ConversationEvent
	 */
	public ArrayList<ConversationNode> nodes;
	
	/**
	 * The introduction String that will be printed when the conversation commences
	 */
	private String introduction;
	
	/**
	 * The Creature that the conversation is had with
	 */
	private Creature subject;
	
	/**
	 * The unique title of this conversation
	 */
	private String title;
	
	/**
	 * The static variable to keep track of the titles that have already been used
	 */
	private static ArrayList<String> titles = new ArrayList<String>();
	
	/**
	 * The constructor for a ConversationEvent
	 * 
	 * @param title The unique title of the ConversationEvent
	 * @param subject The Creature that the conversation is had with
	 * @param introduction The introductory text of the ConversationEvent
	 */
	@SuppressWarnings("static-access")
	public ConversationEvent(String title, Creature subject, String introduction) {
		
		// Instantiate instance variables with passed parameters
		this.introduction = introduction;
		this.subject = subject;
		this.title = title;
		nodes = new ArrayList<ConversationNode>();
		
		// Check if the title has already been used
		this.addTitle(introduction);
	}
	
	@Override
	public void doEvent() {
		
		// Display the introduction String
		PRINTER.narrateln("\n" + introduction);
		
		// Set the current node
		ConversationNode currentNode = nodes.get(0);
			
		// Loop while there are nodes left to coverse with
		while(true) {
			
			// Run the piece of the conversation and save the return
			// as the next node's index
			int nextNode = currentNode.converse(subject);
			
			// Conditional if the next node's index is -1 (there is no next node)
			if (nextNode == -1) {
				
				// Break out of the loop
				break;
			}
			
			// Move on to the next ConversationNode
			currentNode = nodes.get(nextNode);
		}
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public int getUsesLeft() {
		return 1;
	}

	/**
	 * Method to get the subject Creature of the conversation
	 * 
	 * @return the subject
	 * 
	 */
	public Creature getSubject() {
		return subject;
	}
	
	/**
	 * Static method to check if a ConversationEvent title is valid and
	 * add it to the static list of titles
	 * 
	 * @param newTitle The title to be checked and added
	 * @return true if title is not already in the list, else false
	 */
	public static boolean addTitle(String newTitle) {
		
		// Conditional if newTitle is already in titles list
		if (titles.contains(newTitle)) {
			
			// Print to the error output and notify programmer that there is an issue
			System.err.println("The title '" + newTitle + "' is already in use.");
			
			return false;
			
		// Conditional if newTitle is not already in titles list
		} else {
			
			// Add title to static titles list
			titles.add(newTitle);
			
			return true;
			
		}
	}

}
