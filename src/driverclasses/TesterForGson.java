package driverclasses;
import java.util.Arrays;

class BagOfPrimitives2 {
	  @SuppressWarnings("unused")
	private int value1 = 8;
	  @SuppressWarnings("unused")
	private String value2 = "def";
	  @SuppressWarnings("unused")
	private transient int value3 = 9;
	  private int[] BagOfInts= {2,454};
	  BagOfPrimitives2() {
	    // no-args constructor
	  }
	  public void getBagOfInts(){
		  System.out.println("Nested class");
		  System.out.printf(Arrays.toString(BagOfInts));
	  }
	}
class BagOfPrimitives {
	@SuppressWarnings("unused")
  private int value1 = 1;
	@SuppressWarnings("unused")
  private String value2 = "abc";
	@SuppressWarnings("unused")
  private transient int value3 = 3;
  private int[] BagOfInts= {1,3,4};
  BagOfPrimitives2 nestedObj = new BagOfPrimitives2();
  public void getBagOfInts2(){
	  System.out.println("THIS IS A NESTED FUNCTION");
	  nestedObj.getBagOfInts();
  }
  BagOfPrimitives() {
    // no-args constructor
  }
  public void getBagOfInts(){
	  System.out.printf(Arrays.toString(BagOfInts));
  }
}

public class TesterForGson {

	/**
	 * @param args
	 */
	public static void TesterForGSON(String[] args) {
		BagOfPrimitives obj = new BagOfPrimitives();
		String json = IOUtilities.serialize(obj);  
		System.out.printf(json);
		BagOfPrimitives obj2 = (BagOfPrimitives) IOUtilities.deserialize(json, BagOfPrimitives.class);   
		obj2.getBagOfInts();
		obj2.getBagOfInts2();
	}

}
