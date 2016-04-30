package result;
import java.util.List;


public class RankingResult extends Result {

	private List<Integer> correctResponse;
	public RankingResult() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isCorrect(Result toCompare) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String ppResponse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void acceptInput() {
		// TODO Auto-generated method stub
		
	}

	public List<Integer> getCorrectResponse() {
		return correctResponse;
	}

	public void setCorrectResponse(List<Integer> correctResponse) {
		this.correctResponse = correctResponse;
	}

	@Override
	public void build() {
		// TODO Auto-generated method stub
		
	}

}
