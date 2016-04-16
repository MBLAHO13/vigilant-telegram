
public class ShortAnswerResult extends EssayResult {
	private String shortAnswerResponse;
	public ShortAnswerResult() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isCorrect(Result toCompare) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void acceptInput() {
		// TODO Auto-generated method stub
		
	}

	public String getShortAnswerResponse() {
		return shortAnswerResponse;
	}

	public void setShortAnswerResponse(String shortAnswerResponse) {
		this.shortAnswerResponse = shortAnswerResponse;
	}

}
