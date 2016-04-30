package question;
import java.util.ArrayList;




public class MultipleChoiceQuestion extends Question {
	//will also be used for T/F, seeing as a true false question is simply a 2-choice question, multiple choice is n-choice
	
	private ArrayList<String>	answerChoices;

	public MultipleChoiceQuestion() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ppPrompt() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ppAnswerChoices() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ppDirections() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ppUserInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkUserResponse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean parseUserInput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String sanitizer(String rawInput) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reviseEntireQuestion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Question build() {
		// TODO Auto-generated method stub
		return null;
	}

}
