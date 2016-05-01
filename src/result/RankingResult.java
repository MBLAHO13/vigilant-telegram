package result;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import driverclasses.IOUtilities;


public class RankingResult extends Result {

	private List<Integer> userResponse;
	public RankingResult() {
		this.userResponse = new ArrayList<Integer>();
	}
	
	public RankingResult(List<Integer> userInput){
		this.userResponse = userInput;
	}
	
	public RankingResult(int[] userInput){
		for (int i = 0; i < userInput.length; i++)
		{
		    this.userResponse.add(userInput[i]);
		}
	}

	@Override
	public boolean isCorrect(Result toCompare) {
		// TODO Part 3
		return false;
	}

	@Override
	public String ppResponse() {
		StringBuilder sb = new StringBuilder();
		for (Integer s : this.userResponse)
		{
		    sb.append(s);
		    sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public void acceptInput() {
		Scanner userReader = IOUtilities.safeScanner(System.in);
		System.out.println("Enter your choices, each on it's own line. Type " + IOUtilities.SENTINEL + " to quit.");
		String userInput = userReader.nextLine();
		while(!userInput.equals(IOUtilities.SENTINEL)){
			try {
				this.userResponse.add(Integer.parseInt(userInput.trim()));
			}catch (NumberFormatException e){
				System.err.println("Not an integer. Please type an integer or " + IOUtilities.SENTINEL + ".");
			}
		}
		userReader.close();
		
	}

	public List<Integer> getCorrectResponse() {
		return userResponse;
	}

	public void setCorrectResponse(List<Integer> correctResponse) {
		this.userResponse = correctResponse;
	}

	@Override
	public void build() {
		// TODO Part2
		
	}

}
