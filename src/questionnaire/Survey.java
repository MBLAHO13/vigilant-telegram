package questionnaire;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import driverclasses.IOUtilities;

import question.*;

public class Survey {
	
	protected List<Question> questionList;
	//TODO part 3 (do I like this format?)
	protected List<String> reportData; //raw report data
	protected List<String> options = Arrays.asList("Add a new T/F question", "Add a new Multiple Choice question", 
			"Add a new Short Answer question", "Add a new Essay Question", "Add a new Ranking Question",
			"Add a new Matching Question", "Back");


	public Survey() {
		this.questionList = new ArrayList<Question>();
		this.reportData = new ArrayList<String>();
	}
	
	public Survey(List<Question> questionList) {
		this.questionList = questionList;
		this.reportData = new ArrayList<String>();
	}

	
	public static Survey createQuestionnaire() {
		Survey newSurvey = new Survey();
		int doAnother; 
		do {
			Question newQuestion = newSurvey.addQuestion();
			if (newQuestion != null){
				newSurvey.questionList.add(newQuestion);
				doAnother = IOUtilities.choices(IOUtilities.CONFIRM); //Asks the user Yes or no, returns 1 or 2
			} else{
				doAnother = 2; //signifies "Add a new question: no" because they've selected "back" or something broke
			}
		} while (doAnother != 2); //signifies "Add a new question: no"
		return newSurvey;
	}

	//CHECK FOR NULL RETURN
	public Question addQuestion(){
		Question newQuestion = null; 
		switch(IOUtilities.choices(options)){
			case 1:
				newQuestion = new TrueFalseQuestion();
				break;
			case 2:
				newQuestion = new MultipleChoiceQuestion();
				break;
			case 3:
				newQuestion = new ShortAnswerQuestion();
				break;
			case 4:
				newQuestion = new EssayQuestion();
				break;
			case 5:
				newQuestion = new RankingQuestion();
				break;
			case 6:
				newQuestion = new MatchingQuestion();
				break;
			case 7:
				return null;
			default:
				System.err.println("[WARN] Bottom out in addQuestion." ); // this should never happen
				return null; //prevents null pointer exception with newQuestion.build()
		}
		return newQuestion.build();
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
		if (this.questionList.isEmpty()){
			System.err.println("Empty Questionnaire.");
			return;
		}
		for(Question q : questionList){
			q.ppQuestion();
			q.acceptInput();
		}
		
	}
	
	public void tabulateQuestionnaire() {
		// TODO part3
		
	}
	
	public void ppQuestionnaire(){
		if (this.questionList.isEmpty() || this.questionList == null){
			System.err.println("Empty Questionnaire.");
			return;
		}
		for(Question q : questionList){
			if (q == null){
				System.err.println("Question is null!");
				return;
			}
			q.ppQuestion();
		}
	}

	public List<Question> getQuestionList() {
		return questionList;
	}
}
