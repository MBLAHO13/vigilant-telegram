package driverclasses;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.*;

public class IOUtilities {
	
	public static final String SENTINEL = "DONE";
	public static final List<String> CONFIRM = Arrays.asList("Yes", "No");

	public static String serialize(Object obj){
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
			       .create();;
		return gson.toJson(obj);
	}
	
	// to create a FOO, pass in FOO.class as targetClass!
	public static Object deserialize(String slurp, Class<?> targetClass){ //this needs to be cast properly on the other end
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
			       .create();
		return gson.fromJson(slurp, targetClass);   
	}
	
	public static String slurp(File location) {
		Scanner fileScanner = null;
		String contents = null;
		try {
			fileScanner = new Scanner(location);
			contents = fileScanner.useDelimiter("\\A").next();

        } //EOT
        catch(IOException ex) {
            System.out.println("Unable to open file '" + location + "'");                
        }
		finally {
			if(fileScanner != null){
				fileScanner.close();    
			}
		}//EO file read
		return contents;
		
	}
	//TODO: return status?
	public static void spew(String contents, File f){
		PrintWriter writer = null;
		
		try { 
			f.getParentFile().mkdirs();//forcefully write folders
			if(f.exists()) { 
				//not sure if I want this to overwrite or preserve...
			  System.err.println("[WARN] Overwriting file " + f.toString() );
			} else{
				f.createNewFile();
			}
		} catch (IOException e1) {
			System.err.println("[ERROR] Failure to write to file, you'll probably lose work!");
			e1.printStackTrace();
		}
		try {
			writer = new PrintWriter(f, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.err.println("[ERROR] Failure to write to file, you'll probably lose work!");
			e.printStackTrace();
		}
		if (writer != null){
			writer.write(contents);
			writer.flush();
		}
	}
	
	public static Integer choices(List<String> options){
		Scanner scanchoice = safeScanner(System.in);
		int choicemenu = 0;
		for (int i = 1; i<  options.size() + 1; i++) {
			System.out.println(i + ") " + options.get(i -1));
		}
		do {
			System.out.println(": ");
			while (!scanchoice.hasNextInt()) {
				System.out.println("Enter an integer.");
				System.out.print(":");
				scanchoice.next();
			}
			choicemenu = scanchoice.nextInt();
			if (choicemenu >= 1 && choicemenu <= options.size()){
				scanchoice.close();
				return choicemenu;
			}else{
				System.out.println("Choice must be a value between 1 and " + options.size() + ".");
				choicemenu = 0;
			}
		}while (choicemenu != 0);
		System.err.println("[WARN] Bottom-out in choices()"); //This should never happen
		scanchoice.close();
		return choicemenu;
	}
	
	public static Scanner safeScanner(InputStream in){
		Scanner betterScanner = new Scanner(new FilterInputStream(in) {
		    @Override
		    public void close() throws IOException {
		        // Apparently if you close a scanner attached to STDIN it nukes STDIN. Java.
		    	// This empty method keeps STDIN open for future scanners.
		    	// The `throws` will be caught by the black hole in main.
		    }
		});
		return betterScanner;
	}

	public static String recieveFilename(){
		Scanner userScanner = safeScanner(System.in);
		String path;
		System.out.println("File name: ");
		path = userScanner.nextLine();
		userScanner.close();
		return path;
	}
}
