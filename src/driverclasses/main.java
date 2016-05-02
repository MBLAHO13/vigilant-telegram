package driverclasses;
import java.io.File;
import java.util.Arrays;
import java.util.Date;


import menu.Menu1;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		State s = new State(new Menu1(), null);
		while(s != null){
			try {
				s = s.run();
			} catch (Throwable thrown) { 
				/* 
				 * "Your program should gracefully handle inappropriate input and NEVER crash."
				 *  Solution: black hole program errors.
				 */
				//TODO: Move to IOutilities class
				System.err.println("[ERROR] Throwable " + thrown.toString() + "thrown, something bad happened!");
				IOUtilities.spew(thrown.toString() + "\n" + Arrays.toString(thrown.getStackTrace()), new File("Dumps" + System.getProperty("file.separator") + "error" + (new Date()).getTime())); //output stacktrace to file for review
				s = new State(new Menu1(), null); 
			}
		}
	}
	//

}
/*
	public static void main(String[] args) {
		TesterForGson.TesterForGSON(args);
	}
	}
*/