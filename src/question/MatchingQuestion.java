package question;
import java.util.ArrayList;

import result.Result;


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
	public void ppUserInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public Result acceptInput() {
		// TODO Auto-generated method stub
		return this.userResponse;
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
