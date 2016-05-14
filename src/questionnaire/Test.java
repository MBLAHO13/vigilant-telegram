package questionnaire;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import driverclasses.IOUtilities;
import question.Question;
import result.Result;


public class Test extends Survey { //for once, "test" is a final name...
private int questionCount =0;
private int points = 0;

	public Test() {
		super();
	}
	
	public Test(Map<Question, List<Result>> question2Responses) {
		super(question2Responses);
	}
	
	public static Survey createQuestionnaire() {
		Test newTest = new Test();
		int doAnotherQuestion; 
		List<Result> validResponses;
		do {
			Question newQuestion = newTest.addQuestion();
			if (newQuestion != null){
				validResponses = newQuestion.buildCorrectResponseList();
				newTest.question2Responses.put(newQuestion, validResponses);
				System.out.println("Add another question?");
				doAnotherQuestion = IOUtilities.choices(IOUtilities.CONFIRM); //Asks the user Yes or no, returns 1 or 2
			} else{
				doAnotherQuestion = 2;
			}
		} while (doAnotherQuestion != 2); //signifies "Add a new question: no"
		if(newTest.question2Responses.isEmpty()){
			System.out.println("Question list is empty");
			return null;
		}
		return newTest;
	}

	@Override
	public void editQuestionnaire() {
		//TODO add logic that picks the number of question you want to fix
		// LinkedHashMap means that there's insertion order
		for (Question q : question2Responses.keySet()){
			q.reviseEntireQuestion();
			List<Result> newChoices = null;
			System.out.println("Change Correct Answers?");
			switch(IOUtilities.choices(IOUtilities.CONFIRM)){
				case 1:
					newChoices= q.buildCorrectResponseList();
					question2Responses.put(q, newChoices);
					break;
				case 2:
					break;
			}
		}
	}
	
	public static Survey loadQuestionnaire() {
		return (Test) (IOUtilities.deserialize(IOUtilities.slurp(new File("./Storage" + System.getProperty("file.separator") + IOUtilities.chooseFile())), Test.class));
	}
	
	public double scoreQuestionnaire(){
		//taken from http://stackoverflow.com/a/8061414
		//trims down all the binary math inaccuracy to two places
		DecimalFormat df2 = new DecimalFormat("###.##");
		return Double.valueOf(df2.format(points/questionCount));
	}
	
	public List<Result> getCorrectResponse(Question q) {
		return this.question2Responses.get(q);
	}

	public void addCorrectResponse(Result correctResponse, Question question) {
		if(this.question2Responses.get(question) != null){
			this.question2Responses.put(question, new ArrayList<Result>());
		} else{
			this.question2Responses.get(question).add(correctResponse);
		}
	}
	
	public void clearCorrectResponse(Integer question){
		question2Responses.get(question).clear();
	}
	
	public Map<Question, List<Result>> getQuestionMap(){
		return question2Responses;
	}
	
	@Override
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
			for (Result r : this.question2Responses.get(q)){
				System.out.println("Correct Answer:");
				System.out.println(r.ppResponse());
			}
			System.out.println("---End of Question---");
		}
	}
	
	@Override
	public void gradeQuestionnaire(){
		for(Question q : question2Responses.keySet()){
			List<Result> answerList = question2Responses.get(q);
			tallyCorrectAnswer(answerList, q);
		}
		System.out.println("Your score is " + questionCount + "/" + points + ": " + scoreQuestionnaire());
	}
	
	public boolean tallyCorrectAnswer(List<Result> answerList, Question q){
		for (Result r : answerList){
			if(r.isGradeable()){
				questionCount++;
				if (r.isCorrect(q.getUserResponse())){
					points++; //TODO check the point values in the assignment...
					return true; //we found a correct answer
				}
			}else{
				return false; //we cannot grade this question
			}
		}
		return false; // we did not find a correct answer
	}
}
