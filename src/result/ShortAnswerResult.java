package result;

public class ShortAnswerResult extends EssayResult {
	public ShortAnswerResult() {}
	
	public ShortAnswerResult(String userInput){
		super(userInput);
	}

	@Override
	public boolean isCorrect(Result toCompare) {
		// TODO Part3
		return false;
	}

}
