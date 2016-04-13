import java.util.ArrayList;


public abstract class Question {
	private String question;
	private String answer;
	private String userAnswer;
	@SuppressWarnings("unused")
	private ArrayList<String> answerChoices;
	private String directions;
	
	// ppFoo == pretty print FOO
	public abstract void ppQuestion();
	public abstract void ppAnswerChoices();
	public abstract void ppDirections();
	public abstract void ppUserInput();
	public abstract boolean checkUserAnswer();
	public abstract boolean parseUserInput();
	public abstract String sanitizer(String rawInput);
	 
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
}