package result;
import java.util.ArrayList;
import java.util.List;


public class RankingResult extends Result {

	private List<Integer> userResponse;
	public RankingResult() {
		this.userResponse = new ArrayList<Integer>();
	}
	
	public RankingResult(List<Integer> userInput){
		this.userResponse = userInput;
	}
	
	public RankingResult(int[] userInput){
		for (int i = 0; i < userInput.length; i++)
		{
		    this.userResponse.add(userInput[i]);
		}
	}

	@Override
	public String ppResponse() {
		StringBuilder sb = new StringBuilder();
		for (Integer s : this.userResponse)
		{
		    sb.append(s);
		    sb.append("\n");
		}
		return sb.toString();
	}

	public void setCorrectResponse(List<Integer> correctResponse) {
		this.userResponse = correctResponse;
	}

	@Override
	protected List<Integer> getData(){
		return userResponse;
	}

}
