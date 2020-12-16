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
		ArrayList<Control> availableControls = new ArrayList<Control>();
		for (Control c : CONTROLLER.GAME.controls.getControls()) {
			if (c.isAvailable()) {
				availableControls.add(c);
				c.setAvailable(false);
			}
		}
		
		Control say = new Control("SAY", "say one of the text options listed.", 's', true, null);
		CONTROLLER.GAME.controls.addControl(say);
		PRINTER.narrateln("\n" + introduction);
		ConversationNode currentNode = conversations.get(0);
		
		PRINTER.narrateln(CONTROLLER.GAME.controls.toString());
			
		while(true) {
			
			int nextNode = currentNode.converse(subject);
			
			if (nextNode == -1) {
				break;
			}
			
			currentNode = conversations.get(nextNode);
		}
		CONTROLLER.GAME.controls.removeControl(say);
		for (Control c : availableControls) {
			c.setAvailable(true);
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
