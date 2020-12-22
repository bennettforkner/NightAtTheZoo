
/**
 * Response is the class to represent a possible response to a conversation statement
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public class Response {
	
	/**
	 * The test of the response
	 */
	private String response;
	
	/**
	 * The next ConversationNode that this response will lead to
	 */
	private int nextNode;
	
	/**
	 * The constructor for a Response
	 * 
	 * @param response The text of the response
	 * @param nextNode The next node that this response points to
	 */
	public Response(String response, int nextNode) {
		
		// Set instance variables to passed parameters
		this.setResponse(response);
		this.setNextNode(nextNode);
		
	}

	/**
	 * The method to get the text of this Response
	 * 
	 * @return the response text
	 * 
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * The method to set the to set the text of this Response
	 * 
	 * @param response the response text
	 * 
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * The method to get the next node of this Response
	 * 
	 * @return the nextNode
	 * 
	 */
	public int getNextNode() {
		return nextNode;
	}

	/**
	 * The method to set the next node of this Response
	 * 
	 * @param nextNode the next node to set
	 */
	public void setNextNode(int nextNode) {
		this.nextNode = nextNode;
	}
	
}
