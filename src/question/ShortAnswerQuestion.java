package question;

import result.Result;



public class ShortAnswerQuestion extends EssayQuestion {
	private int maxLength = 100; //whatever man
	public ShortAnswerQuestion() {
		// TODO Auto-generated constructor stub
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

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

}
