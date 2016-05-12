package question;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import driverclasses.IOUtilities;
import result.*;

public class EssayQuestion extends ShortAnswerQuestion {
	//no answer choices needed
	String whoami = "EssayQuestion";

	public EssayQuestion() {}

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
	public List<Result> buildCorrectResponseList(){
		System.out.println("No correct answer for Essay questions.");
		return new ArrayList<Result>();
	}



}
