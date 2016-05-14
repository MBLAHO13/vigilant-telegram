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
			//thank you Dr Novak for making me do 500 billion proofs like this 
		    sb.append( digits.substring(0, (digits.length()/2)-1 )+  " -- " +  digits.substring(digits.length()/2, digits.length()-1)); 
		    sb.append("\n");
		}
		return sb.toString();
	}
	
	protected List<Integer> getData(){
		return correctResponse;
	}

}
