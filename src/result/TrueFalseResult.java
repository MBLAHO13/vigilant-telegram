package result;

public class TrueFalseResult extends MultipleChoiceResult {

	public TrueFalseResult() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isCorrect(Result toCompare) {
		// TODO Auto-generated method stub
		//make sure only T XOR F
		return false;
	}
	@Override
	public void build() {
		//TODO not sure if I need this
		System.out.println();
		
	}

}
