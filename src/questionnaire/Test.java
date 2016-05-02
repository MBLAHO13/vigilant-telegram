package questionnaire;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import driverclasses.IOUtilities;
import question.Question;
import result.Result;
import result.TrueFalseResult;


public class Test extends Survey { //for once, "test" is a final name...

	Map<Question, List<Result>> question2Responses;
	
	public Test() {
		super(new ArrayList<Question>());
		question2Responses = new HashMap<Question, List<Result>>();
	}
	
	public Test(Map<Question, List<Result>> question2Responses) {
		super(new ArrayList<Question>(question2Responses.keySet()));
		this.question2Responses = question2Responses;
	}
	
	public static Survey createQuestionnaire() {
		Test newTest = new Test();
		int doAnotherQuestion; 
		List<Result> validResponses = new ArrayList<Result>();
		do {
			Question newQuestion = newTest.addQuestion();
			
			int doAnotherResponse;
			do {
				validResponses.add(newQuestion.acceptInput());
				System.out.println("Add another correct answer?");
				doAnotherResponse = IOUtilities.choices(IOUtilities.CONFIRM);
			}while (doAnotherResponse !=2);
			newTest.question2Responses.put(newQuestion, validResponses);
			System.out.println("Add another question?");
			doAnotherQuestion = IOUtilities.choices(IOUtilities.CONFIRM); //Asks the user Yes or no, returns 1 or 2
		} while (doAnotherQuestion != 2); //signifies "Add a new question: no"
		return newTest;

		
	}

	@Override
	public void editQuestionnaire() {
		// TODO Part 3
		
	}
	
	public static Survey loadQuestionnaire() {
		return (Test) (IOUtilities.deserialize(IOUtilities.slurp(new File("./Storage" + System.getProperty("file.separator") + IOUtilities.recieveFilename())), Test.class));
	}
	
	public double scoreQuestionnaire(){
		return 0; //TODO Part 3
		
	}
	
	public List<Result> getCorrectResponse(Question q) {
		return question2Responses.get(q);
	}

	public void setCorrectResponse(Result correctResponse, Question question) {
		if(question2Responses.get(question) != null){
			this.question2Responses.put(question, new ArrayList<Result>());
		} else{
			this.question2Responses.get(question).add(correctResponse);
		}
	}
	
	public void clearCorrectResponse(Integer question){
		question2Responses.get(question).clear();
	}
	
	public List<Question> getQuestionList() {
		return questionList;
	}

}
