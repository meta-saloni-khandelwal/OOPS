package survey;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
/**
 * Class name-FileOperations
 * Created on - 06/02/18
 * Reference no - OOPS-2
 * 
 * @version 1.0
 * @author Saloni Khandelwal
 */

/*
 * A class to perform read and write operations on file
 */
public class FileOperations {
	public static ArrayList<Question> listOfQuestionObject = new ArrayList<Question>();
	/*
	 * Below functions read the input file and creates a list of Question object.
	 */
	public void readFile(){
		try{
			File inputFile = new File("./inputFile/surveyfile");
			FileReader filereader = new FileReader(inputFile);
			BufferedReader bufferreader = new BufferedReader(filereader);
			
			String line = bufferreader.readLine();
			Question[] questionObject = new Question[4];
			for(int i = 0; i < questionObject.length; i++){
				questionObject[i] = new Question();
			}
			
			
			int j = 0;
			while(line != null){
				ArrayList<String> listOfOptions = new ArrayList<String>();
				String []values = line.split(",");
				String questionLine = values[2];
				String questionType = values[1];
				int questionID = Integer.parseInt(values[0]);
				questionObject[j].questionId = questionID;
				questionObject[j].type = questionType;
				questionObject[j].questionHeading = questionLine;
			
				if(questionType.equals("Single select")){
					String allOptions = values[3];
					String[] options = allOptions.split("/");
					for(int i = 0; i < options.length; i++){
						listOfOptions.add(options[i]);
					}
					questionObject[j].listOfOptions = listOfOptions;
					
				}
				else if(questionType.equals("Multiple select")){
					String allOptions = values[3];
					String[] options = allOptions.split("/");
					for(int i = 0; i < options.length; i++){
						listOfOptions.add(options[i]);
					}
					questionObject[j].listOfOptions = listOfOptions;
					
				}
				else{
					questionObject[j].listOfOptions = listOfOptions;
				}
				listOfQuestionObject.add(questionObject[j]);
				j++;
				line = bufferreader.readLine();
			}
			
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	public ArrayList<Question> getListOfQuestions(){
		return listOfQuestionObject;
	}
	
	/*
	 * Below function writes the overall rating for Single select type of question in ReportA.txt file.
	 */
	public void writeToFile1(int[] percentage){
		try{
			String str = "";
			File  outputFile = new File("./inputFile/ReportA.txt"); 
			FileWriter fileWriter = new FileWriter(outputFile,true);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			for(int i = 0; i < percentage.length; i++){
				str += (i+1)+" - "+percentage[i]+"%  ";

			}
			bufferWriter.write(str);
			bufferWriter.append(System.lineSeparator());
			bufferWriter.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	/*
	 * Below function writes the list of answers given by Participants in ReportB.txt file. 
	 */
	public void writeTMultipleSelectToFile(ArrayList<Participants> listOfParticipants) {
		try{
			String str = "";
			File  outputFile = new File("./inputFile/ReportB.txt"); 
			FileWriter fileWriter = new FileWriter(outputFile,true);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			int i = 0;
			for(Participants participantObject : listOfParticipants){
				str += "Participant "+ (i+1) +" : "+participantObject.mapOfIdAndListOfAnswers.get(i).toString()+" ";
				i++;
			}
			bufferWriter.write(str);
			bufferWriter.append(System.lineSeparator());
			bufferWriter.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
}

