import java.util.Scanner;

public class ConversationNode {
	private String statement;
	
	private Response[] responses;
	
	private Runnable endLogic;
	
	public ConversationNode(String statement, Response[] responses) {
		this.statement = statement;
		this.responses = responses;
		this.endLogic = () -> {};
	}
	
	public ConversationNode(String statement, Response[] responses, Runnable endLogic) {
		this.statement = statement;
		this.responses = responses;
		this.endLogic = endLogic;
	}
	
	public int converse(Creature subject) {
		if (this.statement.indexOf("\n") >= 0) {
			String[] lines = this.statement.split("\n");
			PRINTER.say("\n" + subject.getName() + ": ",subject);
			for (String line : lines) {
				CONTROLLER.sleep(2000);
				PRINTER.sayln(line,subject);
			}
			CONTROLLER.sleep(2000);
		} else {
			PRINTER.say("\n" + subject.getName() + ": ",subject);
			CONTROLLER.sleep(2000);
			PRINTER.sayln(this.statement,subject);
			CONTROLLER.sleep(3000);
		}
		
		if (responses != null) {
			PRINTER.narrateln("\nYou can respond:");
			int count = 0;
			for (Response resp : responses) {
				PRINTER.narrateln("[" + count++ + "]: " + resp.getResponse());
			}
			PRINTER.prompt("\nWhat would you like to say?: ");
			
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			String choice = in.nextLine();
			
			if (choice.compareTo("") == 0) {
				return converse(subject);
			} else if (choice.charAt(0) == 's') {
				int index = Integer.parseInt(choice.replaceAll("[\\D]", ""));
				endLogic.run();
				return responses[index].getNextNode();
			} else {
				return converse(subject);
			}
		} else {
			endLogic.run();
			return -1;
		}
	}
}
