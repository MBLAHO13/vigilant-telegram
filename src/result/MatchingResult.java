package result;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchingResult extends RankingResult {

	private Map<Integer, Integer> correctResponse ;
	public MatchingResult() {
		this.correctResponse = new HashMap<Integer, Integer>();
	}
	
	public MatchingResult(Map<Integer, Integer> userResponse) {
		this.correctResponse = userResponse;
	}

	@Override
	public boolean isCorrect(Result toCompare) {
		// TODO Part 3
		return false;
	}

	@Override
	public String ppResponse() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, Integer> entry : correctResponse.entrySet())
		{
		    sb.append(entry.getKey() + " -- " + entry.getValue());
		    sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public void build() {
		// TODO Auto-generated method stub
		
	}

}
