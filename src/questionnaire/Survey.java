package questionnaire;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import driverclasses.IOUtilities;

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
		return (Survey) (IOUtilities.deserialize(IOUtilities.slurp(IOUtilities.recieveFilename()), Survey.class));
	}
	
	public void saveQuestionnaire(Survey questionnaire){
		Scanner scanner = IOUtilities.safeScanner(System.in);
		
		File f = new File("Storage" + System.getProperty("file.separator") + scanner.nextLine() + (new Date()).getTime());
		IOUtilities.spew(IOUtilities.serialize(questionnaire), f);
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
