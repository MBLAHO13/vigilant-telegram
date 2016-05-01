package questionnaire;
import java.util.ArrayList;

import question.Question;

public class Survey {
	
	protected ArrayList<Question> questionList;
	protected ArrayList<String> reportData; //raw report data


	public Survey() {
		// TODO Auto-generated constructor stub
	}

	
	public static Survey createQuestionnaire() {
		return null;
		// TODO Auto-generated method stub
		
	}


	public void editQuestionnaire() {
		// TODO Auto-generated method stub
		
	}

	
	public static Survey loadQuestionnaire() {
		return null;
		//static because we don't want to make a questionnaire to load it cuz that's fuckin dumb
		// TODO Auto-generated method stub
		
	}
	
	public void saveQuestionnaire(){
		//TODO Implement
	}

	
	public void takeQuestionnaire() {
		// TODO Auto-generated method stub
		
	}

	
	public void tabulateQuestionnaire() {
		// TODO Auto-generated method stub
		
	}
	
	public void ppQuestionnaire(){
		//TODO Implement me
	}

	public ArrayList<Question> getQuestionList() {
		return questionList;
	}
}
