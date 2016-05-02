package question;

import java.util.Arrays;



public class TrueFalseQuestion extends MultipleChoiceQuestion {
	public TrueFalseQuestion() {
		super(Arrays.asList("True", "False"));
	}
	@Override
	public Question build(){
		//skip building choices
		if(this.buildPrompt() == null){ return null;}
		return this;
	}
}
