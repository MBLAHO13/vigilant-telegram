package menu;

import java.util.Arrays;
import driverclasses.State;
import java.util.List;
import questionnaire.Survey;
import driverclasses.IOUtilities;

public class Menu1 implements Menu {
	List<String> menu1 = Arrays.asList("Survey", "Test", "Quit");
	int numberOfChoices = menu1.size();
	public Menu1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public State run(Survey questionnaire) {
		    switch (IOUtilities.choices(menu1)){
		        case 1: //Test
		        	return new State (new Menu2("test"), Survey.createQuestionnaire()) ;
		        case 2: // Survey
		            return new State (new Menu2("survey"), questionnaire) ;
		        case 3: //Quit
		        	return null;
		        default:
		        	System.err.println("[WARN] Bottom-out in Menu1.run()");
		    }   
		return new State(this, questionnaire); // should never happen
	}

}
