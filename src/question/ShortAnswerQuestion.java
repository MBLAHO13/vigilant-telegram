package question;



public class ShortAnswerQuestion extends EssayQuestion {
	private int maxLength = 100; //whatever man
	public ShortAnswerQuestion() {
		// TODO Auto-generated constructor stub
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

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

}
