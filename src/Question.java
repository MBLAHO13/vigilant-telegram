
import java.util.ArrayList;


public abstract class Question {
	private String prompt;
	private Result correctResponse;
	private Result userResponse;
	@SuppressWarnings("unused")
	private ArrayList<String> answerChoices;
	private String directions;
	
	// ppFoo == pretty print FOO
	public abstract void ppPrompt();
	public abstract void ppAnswerChoices();
	public abstract void ppDirections();
	public abstract void ppUserInput();
	public abstract boolean checkUserResponse();
	public abstract boolean parseUserInput();
	public abstract String sanitizer(String rawInput);
	 
	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public Result getCorrectResponse() {
		return correctResponse;
	}

	public void setCorrectResponse(Result correctResponse) {
		this.correctResponse = correctResponse;
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
}
