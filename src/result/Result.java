package result;

public abstract class Result {

	public Result() {}
	
	public abstract boolean isCorrect(Result toCompare);
	//returns string because we don't know who's printing
	public abstract String ppResponse();
	public abstract void acceptInput();
	public abstract void build();
}
