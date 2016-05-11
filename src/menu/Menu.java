package menu;
import questionnaire.Survey;
import driverclasses.State;

public interface Menu {
	public abstract State run(Survey questionnaire);
}
