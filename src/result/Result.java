package result;

//This should be abstract as well, but GSON. 
public class Result{
	public Result() {}
	
	//returns string because we don't know who's printing
	public String ppResponse(){
		throw new UnsupportedOperationException("Do not call Result.ppResponse()");
	}
	public void build(){
		throw new UnsupportedOperationException("Do not call Result.build()");
	}
	//this returns whatever data type the object uses to store the data: string, list, etc
	protected Object getData(){
		throw new UnsupportedOperationException("Do not call Result.getData()");
	}
	
	public boolean isCorrect(Result toCompare) {
		return (this.getData().equals( toCompare.getData())); //check if data objects are equal
	}
	
	public boolean isGradeable(){
		return true;
	}
}
