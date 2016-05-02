package result;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceResult extends Result {

	private List<Integer> result;
	public MultipleChoiceResult() {
		this.result = new ArrayList<Integer>();
	}

	public MultipleChoiceResult(List<Integer> capture) {
		this.result = capture;
	}

	public boolean isCorrect(Result toCompare) {
		
		return (this.result.equals(toCompare));
	}

	public String ppResponse() {
		// TODO part 3
		return null;
	}

	public List<Integer> getCorrectResult() {
		return result;
	}

	@Override
	public void build() {
		// TODO not sure if i need this...
		
	}

}
