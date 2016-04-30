package result;

public class EssayResult extends Result {
	private String essayResponse;
	public EssayResult() {
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

	public String getEssayResponse() {
		return essayResponse;
	}

	public void setEssayResponse(String essayResponse) {
		this.essayResponse = essayResponse;
	}

	@Override
	public void build() {
		// TODO Auto-generated method stub
		
	}

}
