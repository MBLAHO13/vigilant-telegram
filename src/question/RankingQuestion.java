package question;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import driverclasses.IOUtilities;

import result.*;




public class RankingQuestion extends MatchingQuestion {
	//two columns, rightChoices is a series of numbers
	/*
	 * 
	 * A bit like this:
	 * 
	 * a. Firefly			1. ____
	 * b. Star Wars		2. ____
	 * c. Star Trek		3. ____
	 * 
	 */
	
	public RankingQuestion() {
		super();
	}
	
	protected void buildRightChoices(){
		this.rightChoices.clear();
		for (int i = 0; i < leftChoices.size(); i++){
			this.rightChoices.add(i + ""); //i just want it to be a string :(
		}
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
				userInput = userReader.nextLine();
			}catch (NumberFormatException e){
				System.err.println("Not an integer. Please type an integer or " + IOUtilities.SENTINEL + ".");
				userInput= userReader.nextLine();
			}
		}
		userReader.close();
		return new RankingResult(choices);
	}

}
