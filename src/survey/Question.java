package survey;

import java.util.ArrayList;
/**
 * Class name-Question
 * Created on - 06/02/18
 * Reference no - OOPS-2
 * 
 * @version 1.0
 * @author Saloni Khandelwal
 */

/*
 * This class represents various Questions
 */
public class Question implements Comparable<Question> {
	public String type;
	public int questionId;
	public String questionHeading;
	ArrayList<String> listOfOptions = new ArrayList<String>();
	
	public int compareTo(Question question) {
		// TODO Auto-generated method stub
		return (this.questionHeading).compareTo(question.questionHeading);
	}
	
}

