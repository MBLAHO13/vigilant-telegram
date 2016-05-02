package question;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import driverclasses.IOUtilities;

import result.*;




public class MultipleChoiceQuestion extends Question {
	//will also be used for T/F, seeing as a true false question is simply a 2-choice question, multiple choice is n-choice
	
	public MultipleChoiceQuestion() {
	}
	
	public MultipleChoiceQuestion(List<String> choices) {
		
	}

	@Override
	public void ppAnswerChoices() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ppUserInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public Result acceptInput() {
		Scanner userReader = IOUtilities.safeScanner(System.in);
		System.out.println("Enter your choices, each on it's own line. Type " + IOUtilities.SENTINEL + " to quit.");
		String userInput = userReader.nextLine();
		List<Integer> capture = new ArrayList<Integer>();
		while(!userInput.equals(IOUtilities.SENTINEL)){
			try {
				capture.add(Integer.parseInt(userInput.trim()));
			}catch (NumberFormatException e){
				System.err.println("Not an integer. Please type an integer or " + IOUtilities.SENTINEL + ".");
			}
		}
		userReader.close();
		return new MultipleChoiceResult(capture);
	}

	@Override
	public void reviseEntireQuestion() {
		// TODO Part3
		
	}

	@Override
	public Question build() {
		// TODO Auto-generated method stub
		return null;
	}

}
