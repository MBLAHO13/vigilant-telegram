package questionnaire;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import driverclasses.IOUtilities;

import question.Question;

public class Survey {
	
	protected List<Question> questionList;
	//TODO part 3 (do I like this format?)
	protected List<String> reportData; //raw report data


	public Survey() {
		this.questionList = new ArrayList<Question>();
		this.reportData = new ArrayList<String>();
	}
	
	public Survey(List<Question> questionList) {
		this.questionList = questionList;
		this.reportData = new ArrayList<String>();
	}

	
	public static Survey createQuestionnaire() {
		return null;
		// TODO Auto-generated method stub
		
	}


	public void editQuestionnaire() {
		// TODO Part3
		
	}

	
	public static Survey loadQuestionnaire() {
		return (Survey) (IOUtilities.deserialize(IOUtilities.slurp(IOUtilities.recieveFilename()), Survey.class));
	}
	
	public void saveQuestionnaire(){
		Scanner scanner = IOUtilities.safeScanner(System.in);
		
		File f = new File("Storage" + System.getProperty("file.separator") + scanner.nextLine() + (new Date()).getTime());
		IOUtilities.spew(IOUtilities.serialize(this), f);
	}

	
	public void takeQuestionnaire() {
		for(Question q : questionList){
			q.ppQuestion();
			q.acceptInput();
		}
		
	}
	
	public void tabulateQuestionnaire() {
		// TODO part3
		
	}
	
	public void ppQuestionnaire(){
		for(Question q : questionList){
			q.ppQuestion();
		}
	}

	public List<Question> getQuestionList() {
		return questionList;
	}
}
