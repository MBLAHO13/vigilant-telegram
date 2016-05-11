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
	public String ppResponse() {
		return userResponse;
	}

	public String getResponse() {
		return userResponse;
	}

	public void setResponse(String essayResponse) {
		this.userResponse = essayResponse;
	}

	@Override
	public void build() {
		//TODO: Part 2
		
	}
	

}
