package question;

import java.util.List;

import result.Result;

public class EssayQuestion extends Question {
	//no answer choices needed
	public EssayQuestion() {
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

	@Override
	public Question build() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Result> buildResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
