package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import driverclasses.IOUtilities;
import result.Result;


// Because of GSON, this CANNOT BE ABSTRACT
// Based on design principles, this should be abstract for code reuse.
// However, my options are A) make this abstract B) make a custom adapter
// Utility of GSON >>> having the prettiest code
// TODO: Part 3, rework this so it's less of a
public class Question {
	private String prompt;
	protected Result userResponse;
	private String directions;
	// ppFoo == pretty print FOO
	
	// ----- SHOULD BE ABSTRACT -------
	// these will all cough up exceptions to be trapped
	// these methods should never be executed, since they are overridden
	// this just makes certain of that
	protected void ppAnswerChoices() {
		throw new UnsupportedOperationException("Do not call Question.ppAnswerChoices().");
	}
	public void ppUserInput() {
		throw new UnsupportedOperationException("Do not call Question.ppUserInput().");
	}
	
	protected void buildChoices(){
		throw new UnsupportedOperationException("Do not call Question.buildChoices().");
	}

	public Result acceptInput() {
		throw new UnsupportedOperationException("Do not call Question.acceptInput().");
	}
	public void reviseEntireQuestion() {
		throw new UnsupportedOperationException("Do not call Question.reviseEntireQuestion().");
	} //and i mean it!
	// ----- SHOULD BE ABSTRACT -------
	
	
	public Question build() {
		if(buildPrompt() == null){ return null;} // attempt to build , if it bombs out, bomb out
		buildChoices();
		return this;
	}
	 
	public Question(){
		
	}
	protected void ppPrompt(){
		System.out.println("\nQuestion: " + prompt);
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
	
	public Question buildPrompt(){
		Scanner userReader = IOUtilities.safeScanner(System.in);
		System.out.println("Your question or " + IOUtilities.SENTINEL + " on it's own line to quit.");
		String userInput = userReader.nextLine();
		if (userInput.equals(IOUtilities.SENTINEL)){ return null;	} //we decided against making a question
		this.setPrompt(userInput);
		return this;
	}
	
	public List<Result> buildCorrectResponseList(){
		List<Result> validResponses = new ArrayList<Result>();
		int doAnotherResponse;
		do {
			validResponses.add(this.acceptInput());
			System.out.println("Add another correct answer?");
			doAnotherResponse = IOUtilities.choices(IOUtilities.CONFIRM);
		}while (doAnotherResponse !=2);
		return validResponses;
	}

	public String ppResult(){
		if (userResponse != null){
			return userResponse.ppResponse();
		}else{
			return null;
		}
	}
}
