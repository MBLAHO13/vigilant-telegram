package result;

public abstract class Result implements Cloneable{
	public Result() {}
	
	public abstract boolean isCorrect(Result toCompare);
	//returns string because we don't know who's printing
	public abstract String ppResponse();
	
	public abstract void build(); //TODO: this vs Constructor?

}
