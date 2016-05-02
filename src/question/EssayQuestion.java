package question;
import java.util.Scanner;
import driverclasses.IOUtilities;
import result.*;

public class EssayQuestion extends Question {
	//no answer choices needed

	public EssayQuestion() {}

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
	protected void ppAnswerChoices() {
		System.out.println("(No answer choices for free response)");
	}
	
	protected void buildChoices(){
		System.out.println("No choices to input for free response.\n");
	}


}
