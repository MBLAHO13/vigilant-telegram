package result;

public class ShortAnswerResult extends EssayResult {
	public ShortAnswerResult() {}
	
	public ShortAnswerResult(String userInput){
		super(userInput);
	}

	@Override
	public boolean isCorrect(Result toCompare) {
		//make both inputs lowercase, then check if they're equal. better spell it right.
		return (this.getData().toLowerCase().equals( ((String) toCompare.getData()).toLowerCase()));
	}
}
