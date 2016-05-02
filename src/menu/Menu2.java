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
	
	public Menu2(String specifier) {
		this.specifier = specifier;
		menu2 = Arrays.asList("Create a new " + specifier, "Display a " + specifier, "Load a " + specifier, "Save a " + specifier, "Take a " + specifier, "Back");
				
	}

	@Override
	public State run(Survey questionnaire) {
		    switch (IOUtilities.choices(menu2)){
		        case 1: //Create a new survey -- Menu 3!
		        	if (specifier.equals("test")){
		        		return new State(this, Test.createQuestionnaire());
		        	}else if (specifier.equals("survey")){
		        		return new State(this, Survey.createQuestionnaire());
		        	}
		        	break;
		        case 2: // Display a Questionnaire
		        	if (questionnaire != null){
		        		questionnaire.ppQuestionnaire();
		        	} else{
		        		System.err.println("[ERROR] No questionnaire loaded. Load or create a " + specifier + ".");
		        	}
		        	break;
		        case 3: //Load a Questionnaire
		        	if (specifier.equals("test")){
		        		return new State(this, Test.loadQuestionnaire());
		        	}else if (specifier.equals("survey")){
		        		return new State(this, Survey.loadQuestionnaire());
		        	}
		        	break;
		        case 4: // Save a Questionnaire
		        	if (questionnaire != null){
		        		questionnaire.saveQuestionnaire();
		        	} else{
		        		System.err.println("[ERROR] No questionnaire loaded. Load or create a " + specifier + ".");
		        	}
		        	break;
		        case 5:
		        	questionnaire.takeQuestionnaire();
		        	break;
		        case 6: // Back
		        	return new State(new Menu1(),questionnaire);
		        default:
		        	System.err.println("[WARN] Bottom-out in Menu2.run(" + specifier +")"); // should never happen
		    		break;
		    }   
		    return new State(this, questionnaire); 
	}

}
