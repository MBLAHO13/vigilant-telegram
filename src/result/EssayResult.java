package result;

public class EssayResult extends Result {
	protected String userResponse;
	public EssayResult() {
		this.userResponse = "";
	}
	
	public EssayResult(String userInput) {
		this.userResponse = userInput;
	}

	//if you're calling this, you dun fucked up.
	@Override
	public boolean isCorrect(Result toCompare) {
		return false;
	}

	@Override
	public String ppResponse() {
		return userResponse;
	}

	public String getResponse() {
		return userResponse;
	}

	public void setResponse(String essayResponse) {
		this.userResponse = essayResponse;
	}

	@Override
	protected String getData(){
		return userResponse;
	}
	@Override
	public boolean isGradeable(){
		return false;
	}
}
