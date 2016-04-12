import java.util.ArrayList;


public abstract class Questionnaire {

	protected ArrayList<Question> questionList;
	protected int numberOfQuestions;
	protected ArrayList<String> reportData; //raw report data

	public abstract void createQuestionnaire();
	public abstract void editQuestionnaire();
	public abstract void loadQuestionnaire();
	public abstract void takeQuestionnaire();
	public abstract void tabulateQuestionnaire();
	

	public ArrayList<Question> getQuestionList() {
		return questionList;
	}
	
}
