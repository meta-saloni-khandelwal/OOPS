package survey;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class name-Participants
 * Created on - 06/02/18
 * Reference no - OOPS-2
 * 
 * @version 1.0
 * @author Saloni Khandelwal
 */

/*
 * A class represents Participant who will go through survey.
 */
public class Participants {
	//A map between Participant Id and their corresponding answers.
	HashMap<Integer, ArrayList<String>> mapOfIdAndListOfAnswers = new HashMap<Integer, ArrayList<String>>();
	
	//Below function sets the list of answers for a individual participant
	public void setAnswerByParticipantId(int participantID, ArrayList<String> listOfAnswers ) {
		mapOfIdAndListOfAnswers.put(participantID, listOfAnswers);
	}

}
