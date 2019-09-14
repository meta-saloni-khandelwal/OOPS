package survey;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestSurvey1 {

	List<Participants> participantList ;
	static FileOperations file;
	static List<Question> questionList;
	static Participants p1;
	static Participants p2;
	static Participants p3;
	static List<ArrayList<String>> listOfAnswers;
		
	@BeforeClass
	 public static void doBefore() {
		ArrayList<Object> participantList = new ArrayList<>();
		FileOperations file = new FileOperations();
		file.readFile("./inputFile/surveyfile");
		questionList = file.getListOfQuestions();
		p1 = new Participants();
		p2 = new Participants();
		p3 = new Participants();
		participantList.add(p1);
		participantList.add(p2);
		participantList.add(p3);
	}

	
	@Test
	/**
	 * This function simulates the test given by the participants
	 * it also calculates the result and compares it with the expected result
	 */
	public void testToCheckAnswerOfParticipant(){
		ArrayList<String> expectedAnswerForParticipant1 = new ArrayList<String>(
			    Arrays.asList("1","Saloni","5","a b c"));
		ArrayList<String> expectedAnswerForParticipant2 = new ArrayList<String>(
			    Arrays.asList("2","Manisha","2","a b"));
		ArrayList<String> expectedAnswerForParticipant3 = new ArrayList<String>(
			    Arrays.asList("3","Jaya","5","a"));
		List<ArrayList<String>> listOfAnswers = new ArrayList<ArrayList<String>>();
		
		listOfAnswers.add(expectedAnswerForParticipant1);
		listOfAnswers.add(expectedAnswerForParticipant2);
		listOfAnswers.add(expectedAnswerForParticipant3);
		
		for (int i = 0; i < 3; i++){
			p1.setAnswerByParticipantId(i, listOfAnswers.get(i));
			p2.setAnswerByParticipantId(i, listOfAnswers.get(i));
			p3.setAnswerByParticipantId(i, listOfAnswers.get(i));
		}
		List<String> actualAnswerForParticipant1 = p1.mapOfIdAndListOfAnswers.get(0);
		List<String> actualAnswerForParticipant2 = p2.mapOfIdAndListOfAnswers.get(1);
		List<String> actualAnswerForParticipant3 = p3.mapOfIdAndListOfAnswers.get(2);
		assertEquals(expectedAnswerForParticipant1,actualAnswerForParticipant1);
		assertEquals(expectedAnswerForParticipant2,actualAnswerForParticipant2);
		assertEquals(expectedAnswerForParticipant3,actualAnswerForParticipant3);
	}
}
