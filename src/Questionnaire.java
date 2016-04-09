import java.util.ArrayList;


public abstract class Questionnaire {

	protected ArrayList<Question> questionList;
	protected int numberOfQuestions;
	protected ArrayList<String> reportData; //raw report data

	public abstract void ppReport(); // Pretty Print the report

	public ArrayList<Question> getQuestionList() {
		return questionList;
	}
	
}
