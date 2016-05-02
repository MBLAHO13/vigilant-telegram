package question;

import java.util.List;
import java.util.Scanner;

import driverclasses.IOUtilities;

import result.*;

public class EssayQuestion extends Question {
	//no answer choices needed

	public EssayQuestion() {
	}

	@Override
	public void ppUserInput() {
		System.out.println(this.userResponse.ppResponse());
	}

	@Override
	public Result acceptInput() {
			Scanner userReader = IOUtilities.safeScanner(System.in);
			System.out.println("Your answer or " + IOUtilities.SENTINEL + " on it's own line to quit.");
			StringBuilder sb = new StringBuilder();
			String userInput = userReader.nextLine();
			while(!userInput.equals(IOUtilities.SENTINEL)){
				sb.append(userInput);
				userInput = userReader.nextLine();
			}
			userReader.close();
			//store user's input as a result object for later
			return new EssayResult(sb.toString());
	}

	@Override
	public void reviseEntireQuestion() {
		// TODO Part3
		
	}

	@Override
	public Question build() {
		Scanner userReader = IOUtilities.safeScanner(System.in);
		System.out.println("Your question or " + IOUtilities.SENTINEL + " on it's own line to quit.");
		String userInput = userReader.nextLine();
		if (userInput.equals(IOUtilities.SENTINEL)){ return null;	} //we decided against making a question
		this.setPrompt(userInput);
		System.out.println("No choices to input for type Essay.\n");
		return this;
	}

	@Override
	protected void ppAnswerChoices() {
		return;
	}


}
