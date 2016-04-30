package question;
import java.util.ArrayList;




public class RankingQuestion extends Question {
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
	protected ArrayList<String> leftChoices;

	public RankingQuestion() {
		// TODO Auto-generated constructor stub
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
	public void ppPrompt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reviseEntireQuestion() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<String> getLeftChoices() {
		return leftChoices;
	}

	public void setLeftChoices(ArrayList<String> leftChoices) {
		this.leftChoices = leftChoices;
	}

	@Override
	public Question build() {
		// TODO Auto-generated method stub
		return null;
	}

}
