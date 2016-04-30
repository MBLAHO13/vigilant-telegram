package result;

public class MultipleChoiceResult extends Result {

	private String correctResult;
	public MultipleChoiceResult() {
		// TODO Auto-generated constructor stub
	}

	public boolean isCorrect(Result toCompare) {
		// TODO Auto-generated method stub
		return false;
	}

	public String ppResponse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void acceptInput() {
		// TODO Auto-generated method stub
		
	}

	public String getCorrectResult() {
		return correctResult;
	}

	public void setCorrectResult(String correctResult) {
		this.correctResult = correctResult;
	}

	@Override
	public void build() {
		// TODO Auto-generated method stub
		
	}

}
