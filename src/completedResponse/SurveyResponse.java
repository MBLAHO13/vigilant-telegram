package completedResponse;
import question.Question;
import result.Result;

import java.io.File;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import driverclasses.IOUtilities;

public class SurveyResponse {
	
	//maps questions to maps of Results and number of times seen
	protected Map<Question, Map<Result,Integer>> responses;
	public SurveyResponse(){
		this.responses = new LinkedHashMap<Question, Map<Result, Integer>>();
	}
	
	public void addResponse(Question q, Result r){
		if(q == null || r == null){ //this is an incomplete questionnaire
			return;
		}
		if(!this.responses.containsKey(q)){ //if this question is not in the map
			Map<Result, Integer> tempMap =  new LinkedHashMap<Result, Integer>();
			tempMap.put(r,1); //if the question-key does not exist, this is the first time we've seen an answer for it
			this.responses.put(q, tempMap);
		}else{ //the question is in the map
			Map<Result, Integer> currentData = this.responses.get(q);
			if(currentData.containsKey(r)){ // we've seen this response before
				System.out.println("We've seen response before");
				this.responses.get(q).put(r, currentData.get(r) + 1); //update the map to reflect that we've seen this one more time
			} else{ // we have not seen this response before
				System.out.println("We've haven't seen response before");
				this.responses.get(q).put(r, 1); //add in the new key with 1 signifying that this is the first time
			}
		}
	}
	
	public void printReport(){
		if(this.responses.isEmpty()){
			System.out.println("No report data found for this questionnaire.");
			return; // we must move on to the next
		}
		for (Map.Entry<Question, Map<Result,Integer>> entry : this.responses.entrySet()){
			entry.getKey().ppPrompt();
			//now we iterate over the stored responses
			if(entry.getValue().isEmpty()){
				System.out.println("No report data found for this question.");
			} else{
				for(Map.Entry<Result, Integer> responseTally : entry.getValue().entrySet()){
					
					System.out.println(responseTally.getKey().ppResponse() + " was given " + responseTally.getValue() + " time(s).");
				}
			}
		}
	}
	
	public void saveTabulation(){
		File f = new File("./Tabulations" + System.getProperty("file.separator") + "tabulation" + (new Date()).getTime());
		IOUtilities.spew(IOUtilities.serialize(this), f);
	}
	
}
