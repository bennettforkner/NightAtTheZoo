
public class Response {
	private String response;
	
	private int nextNode;
	
	public Response(String response, int nextNode) {
		this.setResponse(response);
		this.setNextNode(nextNode);
	}

	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * @return the nextNode
	 */
	public int getNextNode() {
		return nextNode;
	}

	/**
	 * @param nextNode the nextNode to set
	 */
	public void setNextNode(int nextNode) {
		this.nextNode = nextNode;
	}
}
