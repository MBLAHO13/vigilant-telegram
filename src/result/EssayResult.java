package result;

import java.util.Scanner;

import driverclasses.IOUtilities;

public class EssayResult extends Result {
	protected String userResponse;
	public EssayResult() {
		this.userResponse = "";
	}
	
	public EssayResult(String userInput) {
		this.userResponse = userInput;
	}

	@Override
	public boolean isCorrect(Result toCompare) {
		// TODO Part3
		return false;
	}

	@Override
	public void ppResponse() {
		System.out.println(userResponse);
	}

	public String getResponse() {
		return userResponse;
	}

	public void setResponse(String essayResponse) {
		this.userResponse = essayResponse;
	}

	@Override
	public void build() {
		
		
	}

	@Override
	public void acceptInput() {
		Scanner userReader = IOUtilities.safeScanner(System.in);
		System.out.println("Your answer (or" + IOUtilities.SENTINEL + " on it's own line to quit.");
		String userInput = userReader.nextLine();
		while(!userInput.equals(IOUtilities.SENTINEL)){
			this.userResponse = this.userResponse + userInput;
		}
		userReader.close();
		
	}

}
