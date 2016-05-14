package completedResponse;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Date;

import driverclasses.IOUtilities;

public class TestGrade {
	private Double score;
	private Integer numberOfQuestions;
	private Integer pointsEarned;
	//taken from http://stackoverflow.com/a/8061414
    //trims down all the binary math inaccuracy to two places
	private final DecimalFormat df2 = new DecimalFormat("###.##");
	
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
		this.numberOfQuestions = 0;
		this.pointsEarned = 0;
		this.score = Double.valueOf(df2.format(pointsEarned/numberOfQuestions));
	}
	
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
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
		this.score = Double.valueOf(df2.format(pointsEarned/numberOfQuestions));
	}
	
	public String toString(){
		return "Your score is " + numberOfQuestions + "/" + pointsEarned + ": " + score;
	}
	
	public void saveGrade(){
		File f = new File("./Storage" + System.getProperty("file.separator") + " Grades" + System.getProperty("file.separator") + "attempt" + (new Date()).getTime());
		IOUtilities.spew(IOUtilities.serialize(this), f);
	}
}
