package result;

//This should be abstract as well, but GSON. 
public class Result{
	public Result() {}
	
	//These should be overridden in all subclasses.
	public boolean isCorrect(Result toCompare){
		throw new UnsupportedOperationException("Do not call Result.toCompare().");
	}
	//returns string because we don't know who's printing
	public String ppResponse(){
		throw new UnsupportedOperationException("Do not call Result.ppResponse().");
	}
	public void build(){
		throw new UnsupportedOperationException("Do not call Result.build().");
	}
}
