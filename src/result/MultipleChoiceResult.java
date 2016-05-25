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
		
		return (this.result.equals(toCompare.getData()));
	}

	public String ppResponse() {
		return result.toString();
	}

	@Override
	protected List<Integer> getData() {
		return result;
	}

}
