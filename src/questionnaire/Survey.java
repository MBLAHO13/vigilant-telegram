package questionnaire;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import completedResponse.SurveyResponse;

import driverclasses.IOUtilities;

import question.*;
import result.Result;

public class Survey {
	
	protected Map<Question, List<Result>> question2Responses;
	protected SurveyResponse reportData; //raw report data
	protected List<String> options = Arrays.asList("Add a new T/F question", "Add a new Multiple Choice question", 
			"Add a new Short Answer question", "Add a new Essay Question", "Add a new Ranking Question",
			"Add a new Matching Question", "Back");


	public Survey() {
		this.question2Responses = new LinkedHashMap<Question, List<Result>>();
	}
	
	public Survey(Map<Question, List<Result>> questionList) {
		this.question2Responses = questionList;
	}

	
	public static Survey createQuestionnaire() {
		Survey newSurvey = new Survey();
		int doAnother; 
		do {
			Question newQuestion = newSurvey.addQuestion();
			if (newQuestion != null){
				newSurvey.question2Responses.put(newQuestion, null); //we add null because this is a survey. no correct answer.
				System.out.println("Add another Question?");
				doAnother = IOUtilities.choices(IOUtilities.CONFIRM); //Asks the user Yes or no, returns 1 or 2
			} else{
				doAnother = 2; //signifies "Add a new question: no" because they've selected "back" or something broke
			}
		} while (doAnother != 2); //signifies "Add a new question: no"
		if(newSurvey.getQuestionList().isEmpty()){
			return null;
		}
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
		for (Question q : question2Responses.keySet()){
			q.reviseEntireQuestion();
		}
	}

	
	public static Survey loadQuestionnaire() {
		return (Survey) (IOUtilities.deserialize(IOUtilities.slurp(new File("./Storage" + System.getProperty("file.separator") + IOUtilities.chooseFile())), Survey.class));
	}
	
	public void saveQuestionnaire(){		
		File f = new File("./Storage" + System.getProperty("file.separator") + IOUtilities.recieveFilename(System.in));
		IOUtilities.spew(IOUtilities.serialize(this), f);
	}

	
	public void takeQuestionnaire() {
		if (this.question2Responses.isEmpty()){
			System.err.println("Empty Questionnaire.");
			return;
		}
		for(Question q : this.question2Responses.keySet()){
			q.ppQuestion();
			q.setUserResponse(q.acceptInput());
		}
	}
	
	public void tabulateQuestionnaire() {
		this.reportData = new SurveyResponse();
		for(Question q : question2Responses.keySet()){
			this.reportData.addResponse(q, q.getUserResponse());
			this.reportData.printReport();
			this.reportData.saveTabulation();
		}
	}
	
	public void ppQuestionnaire(){
		if (this.question2Responses.isEmpty() || this.question2Responses == null){
			System.err.println("Empty Questionnaire.");
			return;
		}
		for(Question q : this.question2Responses.keySet()){
			if (q == null){
				System.err.println("Question is null!");
				return;
			}
			q.ppQuestion();
		}
	}

	public List<Question> getQuestionList() {
		//thankfully, ArrayList has a constructor that takes in a Set<Object>
		// see http://stackoverflow.com/a/1026736
		return new ArrayList<Question>(question2Responses.keySet());
	}
	
	public void gradeQuestionnaire(){
		System.out.println("You cannot grade Surveys. You may tabulate a survey, or create a test.");
	}
}
