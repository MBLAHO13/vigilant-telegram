package menu;

import java.util.Arrays;
import java.util.List;

import questionnaire.Survey;
import questionnaire.Test;
import driverclasses.State;

import driverclasses.IOUtilities;

public class Menu2 implements Menu {

	List<String> menu2 = null;
	String specifier;
	int numberOfChoices = menu2.size();
	public Menu2(String specifier) {
		this.specifier = specifier;
		menu2 = Arrays.asList("Create a new " + specifier, "Display a " + specifier, "Load a " + specifier, "Save A " + specifier, "Quit");
	}

	@Override
	public State run(Survey questionnaire) {
		    switch (IOUtilities.choices(menu2)){
		        case 1: //Create a new survey -- Menu 3!
		        	if (specifier.equals("test")){
		        		return new State(new Menu3(this.specifier), Test.createQuestionnaire());
		        	}else if (specifier.equals("survey")){
		        		return new State(new Menu3(this.specifier), Survey.createQuestionnaire());
		        	}
		        	break;
		        case 2: // Display a Questionnaire
		            
		        	break;
		        case 3: //Load a Questionnaire
		        	break;
		        case 4: // Save a Questionnaire
		        	break;
		        case 5: // Quit
		        	System.exit(0);
		        	break;
		        default:
		        	System.err.println("[WARN] Bottom-out in Menu2.run(" + specifier +")");
		    		break;
		    }   
		    return new State(this, questionnaire); // should never happen
	}

}
