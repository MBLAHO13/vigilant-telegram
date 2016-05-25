package question;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import driverclasses.IOUtilities;

import result.*;




public class MultipleChoiceQuestion extends Question {
	//will also be used for T/F, seeing as a true false question is simply a 2-choice question, multiple choice is n-choice
	List<String> options;
	public MultipleChoiceQuestion() {
		options = new ArrayList<String>();
	}
	
	public MultipleChoiceQuestion(List<String> choices) {
		this.options = choices;
	}

	@Override
	public String ppAnswerChoices() {
		String response = "";
		for (int i = 1; i < options.size()+1; i++){
			response += ("Choice " + i + " is " + options.get(i-1) + "\n");
		}
		return response;
	}

	@Override
	public Result acceptInput() {
		Scanner userReader = IOUtilities.safeScanner(System.in);
		System.out.println("Enter your choice(s), each on its own line. Type " + IOUtilities.SENTINEL + " to quit.");
		String userInput = userReader.nextLine();
		List<Integer> capture = new ArrayList<Integer>();
		while(!userInput.equals(IOUtilities.SENTINEL)){
			try {
				capture.add(Integer.parseInt(userInput.trim()));
				userInput = userReader.nextLine();
			}catch (NumberFormatException e){
				IOUtilities.printString("Not an integer. Please type an integer or " + IOUtilities.SENTINEL + ".");
				userInput = userReader.nextLine();
			}
		}
		userReader.close();
		return new MultipleChoiceResult(capture);
	}
	
	@Override
	protected void buildChoices(){
		options.clear();
		Scanner userReader = IOUtilities.safeScanner(System.in);
		IOUtilities.printString("Your answer or " + IOUtilities.SENTINEL + " on it's own line to quit.");
		String userInput = userReader.nextLine();
		while(!userInput.equals(IOUtilities.SENTINEL)){
			this.options.add(userInput);
			userInput = userReader.nextLine();
		}
		userReader.close();
		//store user's input as a result object for later
		
	}
}
