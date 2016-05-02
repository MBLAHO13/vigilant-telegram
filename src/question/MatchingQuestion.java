package question;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import driverclasses.IOUtilities;

import result.MatchingResult;
import result.RankingResult;
import result.Result;


public class MatchingQuestion extends Question {
	
	//two columns
	protected List<String> rightChoices; 
	protected List<String>leftChoices;

	public MatchingQuestion() {
		this.leftChoices = new ArrayList<String>();
		this.rightChoices = new ArrayList<String>();
	}

	@Override
	public void ppAnswerChoices() {
		for(int i = 0; i < leftChoices.size(); i++){
			System.out.println(i + ") " + leftChoices.get(i) + "\t" + i + "] " + rightChoices.get(i));
		}
	}

	@Override
	public void ppUserInput() {
		// TODO Part 3

	}

	@Override
	public Result acceptInput() {
		Scanner userReader = IOUtilities.safeScanner(System.in);
		System.out.println("Enter your choices, each on it's own line. Type " + IOUtilities.SENTINEL + " to quit.");
		String userInput = userReader.nextLine();
		List<Integer> choices = new ArrayList<Integer>();
		while(!userInput.equals(IOUtilities.SENTINEL)){
			try {
				choices.add(Integer.parseInt(userInput.trim()));
			}catch (NumberFormatException e){
				System.err.println("Not an integer. Please type an integer or " + IOUtilities.SENTINEL + ".");
			}
		}
		userReader.close();
		return new MatchingResult(choices);
	}

	@Override
	public void reviseEntireQuestion() {
		// TODO Part3
		
	}

	public List<String> getRightChoices() {
		return rightChoices;
	}
	protected void buildChoices(){
		buildLeftChoices();
		buildRightChoices();
	}

	public void setRightChoices(ArrayList<String> rightChoices) {
		this.rightChoices = rightChoices;
	}

	protected void buildLeftChoices(){
		Scanner userReader = IOUtilities.safeScanner(System.in);
		System.out.println("Enter your left-hand choices, each on it's own line. Type " + IOUtilities.SENTINEL + " to quit.");
		String userInput = userReader.nextLine();
		List<String> choices = new ArrayList<String>();
		while(!userInput.equals(IOUtilities.SENTINEL)){
				choices.add(userInput.trim());
		}
		userReader.close();
		this.leftChoices = choices;
	}
	
	protected void buildRightChoices(){
		Scanner userReader = IOUtilities.safeScanner(System.in);
		System.out.println("Enter your right-hand choices, each on it's own line. Type " + IOUtilities.SENTINEL + " to quit.");
		String userInput = userReader.nextLine();
		List<String> choices = new ArrayList<String>();
		while(!userInput.equals(IOUtilities.SENTINEL)){
				choices.add(userInput.trim());
		}
		userReader.close();
		this.rightChoices = choices;
	}
	
}
