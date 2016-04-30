import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import com.google.gson.*;

public class IOUtilities {

	public static String serialize(Object obj){
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	
	public static Object deserialize(String slurp, Class<?> targetClass){ //this needs to be cast properly on the other end
		Gson gson = new Gson();
		return gson.fromJson(slurp, targetClass);   
	}
	
	public static String slurp(String location) {
		Scanner scanner  = null;
		String contents = null;
		try {

			scanner = new Scanner(new File(location));
			contents = scanner.useDelimiter("\\A").next();

        } //EOT
        catch(IOException ex) {
            System.out.println("Unable to open file '" + location + "'");                
        }
		finally {
			if(scanner != null){
				scanner.close();    
			}
		}//EO file read
		
		return contents;
		
	}
	
	public static void spew(String contents, String filename){
		PrintWriter writer = null;
		File f = new File(filename);
		if(f.exists() && !f.isDirectory()) { 
			//not sure if I want this to overwrite or preserve...
		  System.err.println("[WARN] Overwriting file " + filename );
		}
		
		try {
			writer = new PrintWriter(filename, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.err.println("Something's gone horribly wrong in Spew!");
			e.printStackTrace();
		}
		if (writer != null){
			writer.write(contents);
		}
	}
	
}
