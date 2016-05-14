package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import result.Result;



public class TrueFalseQuestion extends MultipleChoiceQuestion {
	public TrueFalseQuestion() {
		super(Arrays.asList("True", "False"));
		this.whoami = "TrueFalseQuestion";
	}
	@Override
	public Question build(){
		//skip building choices
		if(this.buildPrompt() == null){ return null;}
		return this;
	}
	@Override
	protected void buildChoices(){
		System.out.println("The answer choices for a True-False question are always \"True\" and \"False\".");
	}
	@Override 
	public List<Result> buildCorrectResponseList(){
		List<Result> validResponses = new ArrayList<Result>();
		validResponses.add(this.acceptInput());
		return validResponses;
	}
}
