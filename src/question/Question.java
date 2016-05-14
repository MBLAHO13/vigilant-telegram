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
// TODO: Part 3, rework this so it's less of a turd
public class Question {
	private String prompt;
	@SuppressWarnings("unused")
	protected String whoami;
	protected Result userResponse;
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
	// ----- SHOULD BE ABSTRACT -------
	
	public void reviseEntireQuestion() {
		//We can do this one UNIX-style, so it's less stupid.
		System.out.println("Type your new prompt or hit enter to keep the old input.");
		Scanner safeScanner = IOUtilities.safeScanner(System.in);
		System.out.println("Old prompt:");
		this.ppPrompt();
		System.out.println("New Prompt?");
		String userChoice = safeScanner.nextLine();
		if (userChoice != "" && userChoice != IOUtilities.SENTINEL){
			setPrompt(userChoice);
		}
		System.out.println("Change Answer Choices?");
		switch(IOUtilities.choices(IOUtilities.CONFIRM)){
			case 1:
				buildChoices();
				break;
			case 2:
				break;
		}
	} //and i mean it!
	public Question build(){
		if(buildPrompt() == null){ return null;} // attempt to build , if it bombs out, bomb out
		buildChoices();
		return this;
	}
	 
	public Question(){
		
	}
	public void ppPrompt(){
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
	
	public void ppQuestion(){
		ppPrompt();
		ppAnswerChoices();
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
		System.out.println("Input your choices one on each line, or " + IOUtilities.SENTINEL + " to quit.");
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
