package driverclasses;
import menu.Menu;
import questionnaire.Survey;


public class State {
	Menu menu;
	Survey questionnaire;
	
	public State(Menu menu, Survey questionnaire){
		this.menu = menu;
		this.questionnaire = questionnaire;
	}
	
	public State run(){
		return this.menu.run(this.questionnaire);
	}
}
