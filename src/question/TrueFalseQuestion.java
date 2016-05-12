package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import result.Result;



public class TrueFalseQuestion extends MultipleChoiceQuestion {
	String whoami = "TrueFalseQuestion";
	public TrueFalseQuestion() {
		super(Arrays.asList("True", "False"));
	}
	@Override
	public Question build(){
		//skip building choices
		if(this.buildPrompt() == null){ return null;}
		return this;
	}
	
	@Override 
	public List<Result> buildCorrectResponseList(){
		List<Result> validResponses = new ArrayList<Result>();
		validResponses.add(this.acceptInput());
		return validResponses;
	}
}
