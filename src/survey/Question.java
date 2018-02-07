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
	String type;
	int questionId;
	String questionHeading;
	ArrayList<String> listOfOptions = new ArrayList<String>();
	@Override
	public int compareTo(Question ques) {
		// TODO Auto-generated method stub
		return (this.questionHeading).compareTo(ques.questionHeading);
	}
	
}
