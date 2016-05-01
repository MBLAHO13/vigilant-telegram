package question;
import result.Result;




public abstract class Question {
	private String prompt;
	
	private Result userResponse;
	private String directions;
	
	// ppFoo == pretty print FOO
	protected abstract void ppPrompt();
	protected abstract void ppAnswerChoices();
	protected abstract void ppDirections();
	public abstract void ppUserInput();
	public abstract boolean checkUserResponse();
	public abstract boolean acceptInput();
	public abstract String sanitizer(String rawInput);
	public abstract void reviseEntireQuestion(); //and i mean it!
	public abstract Question build();
	 
	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}


	public Result getUserResponse() {
		return userResponse;
	}

	public void setUserResponse(Result userResponse) {
		this.userResponse = userResponse;
	}
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
	
	public void ppQuestion(){
		this.ppPrompt();
		this.ppAnswerChoices();
		this.ppDirections();
	}
}
