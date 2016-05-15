package driverclasses;

import java.lang.reflect.Type;
import result.Result;

import com.google.gson.*;
import driverclasses.IOUtilities;

// Taken from http://stackoverflow.com/a/8683689
// This is someone else's code! They had the same problem and spent a lot of time 
// thinking about it. I do understand how this works, and this is the most elegant thing i've found to make it work!
//This class was created by: Menelaos Perdikeas, 2015
//For use with Google's GSON library, which is not good at polymorphism.
public class ResultAdapter implements JsonSerializer<Result>, JsonDeserializer<Result>{

private static final String CLASSNAME = "CLASSNAME";
private static final String INSTANCE  = "INSTANCE";

@Override
public JsonElement serialize(Result src, Type typeOfSrc,
        JsonSerializationContext context) {
		JsonObject retValue = new JsonObject();
		String className = src.getClass().getName();
		retValue.addProperty(CLASSNAME, className);
		JsonElement elem = context.serialize(src); 
		retValue.add(INSTANCE, elem);
		return retValue;
}

@Override
public Result deserialize(JsonElement json, Type typeOfT,
        JsonDeserializationContext context) throws JsonParseException  {
		JsonObject jsonObject =  json.getAsJsonObject();
		JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
		String className = prim.getAsString();
		//the meaty bits of the function
		Class<?> targetClass = null;
		try {
			targetClass = Class.forName(className); 
		} catch (ClassNotFoundException e) {
			IOUtilities.errorReporter(new JsonParseException(e.getMessage()));
    }
    return context.deserialize(jsonObject.get(INSTANCE), targetClass); //recursively do the rest of the object with defaults
}
 }