package driverclasses;

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
				IOUtilities.errorReporter(thrown);
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