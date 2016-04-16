import com.google.gson.*;

public class GSONWrapper {

	public static String serialize(Object obj){
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	
	public static Object deserialize(String slurp, Class<?> targetClass){ //this needs to be cast properly on the other end
		Gson gson = new Gson();
		return gson.fromJson(slurp, targetClass);   
	}
}
