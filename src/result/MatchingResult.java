package result;
import java.util.List;


public class MatchingResult extends RankingResult {

	private List<String> correctResponse ;
	public MatchingResult() {
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

	@Override
	public void build() {
		// TODO Auto-generated method stub
		
	}

}