import java.util.ArrayList;

public class ConversationEvent implements GameEvent {
	
	public ArrayList<ConversationNode> conversations;
	
	private String introduction;
	
	private Creature subject;
	
	private String title;
	
	public ConversationEvent(String title, Creature subject, String introduction) {
		this.introduction = introduction;
		conversations = new ArrayList<ConversationNode>();
		this.subject = subject;
		
		this.title = title;
	}
	
	@Override
	public void doEvent() {
		PRINTER.narrateln("\n" + introduction);
		ConversationNode currentNode = conversations.get(0);
		
		while(true) {
			int nextNode = currentNode.converse(subject);
			
			if (nextNode == -1) {
				break;
			}
			
			currentNode = conversations.get(nextNode);
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
	 * @return the subject
	 */
	public Creature getSubject() {
		return subject;
	}

}
