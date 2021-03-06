package completedResponse;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Date;

import driverclasses.IOUtilities;

public class TestGrade {
	private Double score;
	private Integer numberOfQuestions;
	private Integer pointsEarned;
	
	public TestGrade(){
		this.score = (double) 0;
		this.numberOfQuestions = 0;
		this.pointsEarned = 0;
	}
	public TestGrade(Double score){
		this.score = score;
		this.numberOfQuestions = 0;
		this.pointsEarned = 0;
	}
	
	public TestGrade(Integer numberOfQuestions, Integer pointsEarned){
		this.numberOfQuestions = numberOfQuestions;;
		this.pointsEarned = pointsEarned;
		recalculateScore();
	}
	
	public Double getScore() {
		return score;
	}
	public Integer getNumberOfQuestions() {
		return numberOfQuestions;
	}
	public void setNumberOfQuestions(Integer numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	public Integer getPointsEarned() {
		return pointsEarned;
	}
	public void setPointsEarned(Integer pointsEarned) {
		this.pointsEarned = pointsEarned;
	};
	
	public void recalculateScore(){
		if (numberOfQuestions == 0){ //prevent divide by 0 exception
			this.score = (double) 0;
			return;
		}
		this.score = (double) ((int) ((pointsEarned *10)/(numberOfQuestions *10))) * 100; //double cast to truncate any leading decimal pts
	}
	
	public String toString(){
		return "Your score is " + numberOfQuestions * 10+ "/" + pointsEarned *10 + ": " + score;
	}
	
	public void saveGrade(){
		File f = new File("./Grades" + System.getProperty("file.separator") + "attempt" + (new Date()).getTime());
		IOUtilities.spew(IOUtilities.serialize(this), f);
	}
}
