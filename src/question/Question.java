package question;
import java.util.List;

import result.Result;




public abstract class Question {
	private String prompt;
	
	protected Result userResponse;
	private String directions;
	
	// ppFoo == pretty print FOO
	
	protected abstract void ppAnswerChoices();
	public abstract void ppUserInput();

	public abstract Result acceptInput();
	public abstract void reviseEntireQuestion(); //and i mean it!
	public abstract Question build();
	 
	protected void ppPrompt(){
		System.out.println(prompt);
	}
	
	
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
	}
	
	public boolean checkUserResponse(Result correctResult){
		return this.userResponse.isCorrect(correctResult);
	}
}
