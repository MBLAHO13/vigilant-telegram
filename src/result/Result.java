package result;

public abstract class Result {

	public Result() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract boolean isCorrect(Result toCompare);
	public abstract void ppResponse();
	public abstract void acceptInput();
	public abstract void build();
}
