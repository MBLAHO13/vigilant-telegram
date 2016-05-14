package menu;

//this really should be split into two objects, menuTest and MenuSurvey, but I don't think that will be happening before the deadline

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
		if (specifier.equals("test")){
			menu2 = Arrays.asList("Create a new " + specifier, "Display a " + specifier, "Load a " + specifier, "Save a " + specifier, "Take a " + specifier,  "Tabulate a " + specifier, "Modify an Existing " + specifier, "Back", "Grade a test");
		}else{
			menu2 = Arrays.asList("Create a new " + specifier, "Display a " + specifier, "Load a " + specifier, "Save a " + specifier, "Take a " + specifier, "Tabulate a " + specifier, "Modify an Existing " + specifier, "Back");
		}
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
		        case 5: //take
		        	if(questionnaire != null){
		        		questionnaire.takeQuestionnaire();
		        	} else{
		        		System.err.println("[ERROR] No questionnaire loaded. Load or create a " + specifier + ".");
		        	}
		        	break;
		        case 6: //Tabulate
		        	if(questionnaire != null){
		        		questionnaire.tabulateQuestionnaire();
		        	} else{
		        		System.err.println("[ERROR] No questionnaire loaded. Load or create a " + specifier + ".");
		        	}
		        	break;
		        case 7: //Modify
		        	System.out.println("This will overwrite the current questionnaire loaded. Continue?\n");
		        	if(IOUtilities.choices(IOUtilities.CONFIRM) == 1){
		        		System.out.println("Do you want to edit the current questionnaire or a questionnaire on file?");
		        		if (IOUtilities.choices(Arrays.asList("Current", "On File")) == 1){
		        			if(questionnaire != null){
		        				questionnaire.editQuestionnaire();
		        			} else{
		        				System.err.println("[ERROR] No questionnaire loaded. Load or create a " + specifier + ".");
		        			}
		        		} else{
		        			if(specifier.equals("test")){
		        				Test.loadQuestionnaire().editQuestionnaire();
		        			} else if(specifier.equals("survey")){
		        				Survey.loadQuestionnaire().editQuestionnaire();
		        			}
		        		}
		        	}
		        	break;
		        case 8: // Back
		        	return new State(new Menu1(),questionnaire);
		        case 9://Grade a test
		        	if (specifier.equals("test")){
		        		if (questionnaire != null){
		        			((Test)questionnaire).gradeQuestionnaire();
		        		} else{
		        			System.err.println("[ERROR] No questionnaire loaded. Load or create a " + specifier + ".");
		        		}
		        	} else{
		        		System.out.println("Invalid choice.");
		        	}
		        	break;
		        default:
		        	System.err.println("[WARN] Bottom-out in Menu2.run(" + specifier +")"); // should never happen
		    		break;
		    }   
		    return new State(this, questionnaire); 
	}

}
