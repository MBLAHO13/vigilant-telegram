package driverclasses;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


import questionnaire.Survey;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int choicemenu1 = 0;
		int choicemenu2A =0;
		int choicemenu2B = 0;
		int choicemenu3 = 0;
		
		ArrayList<Survey> knownQuestionnaires = new ArrayList<Survey>();
		List<String> menu1 = Arrays.asList("Survey", "Test");
		List<String> menu2A = Arrays.asList("Create a new Survey", "Display a Survey", "Load a Survey", "Save A Survey", "Quit");
		List<String> menu2B = Arrays.asList("Create a new Test", "Display a Test", "Load a Test", "Save A Test", "Quit");
		List<String> menu3 = Arrays.asList("Add a New True/False Question", "Add a new Multiple Choice Question", "Add a new Short Answer Question", "Add a new Ranking Question", "Add a new Matching Question", "Back");
		
		do {
		   choicemenu1 = IOUtilities.choices(menu1);

		    switch (choicemenu1)
		    {
		        case 1: // Survey
		        	do {
		    		    choicemenu2A = IOUtilities.choices(menu2A);
		    		    switch (choicemenu2A){
		    		        case 1: //Create a new survey -- Menu 3!
		    		        	do {
		    		        		choicemenu3 = IOUtilities.choices(menu3);
		    		        	} while (1== 1); //TODO: This makes code assplode
						case 2: // Display a Survey
		    		            break;
		    		        case 3: //Load a Survey
		    		        	break;
		    		        case 4: // Save a Survey
		    		        	break;
		    		        case 5: // Quit
		    		        	System.exit(0);
		    		        	break;
		    		        default:
		    		            System.out.println("Choice must be a value between 1 and 5.");
		    		            continue;
		    		    }   
		    		} while (choicemenu2A != 5);
		        	break;
		        case 2: //Test
		        	do {
		    		    choicemenu2B = IOUtilities.choices(menu2B);
		    		    switch (choicemenu2B){
		    		        case 1: //Create a new Test
		    		            break;
		    		        case 2: //Display a test
		    		            break;
		    		        case 3: // Load a test
		    		        	break;
		    		        case 4: // Save a test
		    		        	break;
		    		        case 5: //Quit
		    		        	System.exit(0);
		    		        default:
		    		            System.out.println("Choice must be a value between 1 and 5.");
		    		    }   
		    		} while (choicemenu2B != 5);
		            break;
		        case 3: 
		        	System.exit(0);
		        default:
		            System.out.println("Choice must be a value between 1 and 3.");
		    }   
		} while (choicemenu1 != 5);
		return;
			
	}
	

}
