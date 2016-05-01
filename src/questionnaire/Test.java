package questionnaire;
import java.util.ArrayList;
import java.util.List;

import driverclasses.IOUtilities;

import result.Result;


public class Test extends Survey { //for once, "test" is a final name...

	//RRRRRGH I WANT A ONE TO MANY DATA STRUCTURE. NOT A STUPID KLUDGE.
	List<List<Result>> questionResponse = new ArrayList<List<Result>>();
	
	public Test() {
		// TODO Auto-generated constructor stub
	}

	
	public static Survey createQuestionnaire() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editQuestionnaire() {
		// TODO Auto-generated method stub
		
	}
	
	public static Survey loadQuestionnaire() {
		return (Test) (IOUtilities.deserialize(IOUtilities.slurp(IOUtilities.recieveFilename()), Test.class));
	}
	@Override
	public void takeQuestionnaire() {
		// TODO Auto-generated method stub
		
	}
	
	public double scoreQuestionnaire(){
		return 0; //TODO implement meeeee
		
	}
	
	public List<Result> getCorrectResponse(Integer number) {
		return questionResponse.get(number);
	}

	public void setCorrectResponse(Result correctResponse, Integer question) {
		if(questionResponse.get(question) != null){
			this.questionResponse.add(question, new ArrayList<Result>());
		} else{
			this.questionResponse.get(question).add(correctResponse);
		}
	}
	
	public void clearCorrectResponse(Integer question){
		questionResponse.get(question).clear();
	}

}
