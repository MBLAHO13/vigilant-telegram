package result;
import java.util.ArrayList;
import java.util.List;

public class MatchingResult extends RankingResult {

	private List<Integer> correctResponse ;
	public MatchingResult() {
		this.correctResponse = new ArrayList<Integer>();
	}
	
	public MatchingResult(List<Integer> choices) {
		this.correctResponse = choices;
	}	

	@Override
	public String ppResponse() {
		StringBuilder sb = new StringBuilder();
		for (Integer entry : correctResponse)
		{
			String digits = String.valueOf(entry);
				sb.append( entry);  //fuck this bullshit, we're just printing it
				sb.append("\n");
		}
		return sb.toString();
	}
	
	protected List<Integer> getData(){
		return correctResponse;
	}

}
