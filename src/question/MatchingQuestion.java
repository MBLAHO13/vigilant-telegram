package question;
import java.util.ArrayList;


public class MatchingQuestion extends RankingQuestion {
	
	//two columns
	private ArrayList<String> rightChoices; 

	public MatchingQuestion() {
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
	public boolean acceptInput() {
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

	public ArrayList<String> getRightChoices() {
		return rightChoices;
	}

	public void setRightChoices(ArrayList<String> rightChoices) {
		this.rightChoices = rightChoices;
	}

}
