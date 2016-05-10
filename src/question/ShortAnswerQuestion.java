package question;

import java.util.Scanner;
import driverclasses.IOUtilities;
import result.Result;
import result.ShortAnswerResult;



public class ShortAnswerQuestion extends EssayQuestion {
	private int maxLength = 1000; //whatever man
	public ShortAnswerQuestion() {	}

	@Override
	public Result acceptInput() {
		Scanner userReader = IOUtilities.safeScanner(System.in);
		System.out.println("Your answer (" + this.maxLength + " characters maximum) or " + IOUtilities.SENTINEL + " on it's own line to quit.");
		StringBuilder sb = new StringBuilder();
		String userInput = userReader.nextLine();
		while(!userInput.equals(IOUtilities.SENTINEL)){
			sb.append(userInput);
			userInput = userReader.nextLine();
		}
		userReader.close();
		//store user's input as a result object for later, truncate to maxlength or actual length, whichever is smaller
		return new ShortAnswerResult(sb.toString().substring(0, Math.min(sb.toString().length(), maxLength)));
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	
	}
	

}
