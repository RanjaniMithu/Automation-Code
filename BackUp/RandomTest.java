package com.testflow;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RandomTest {
	static Iterator<?> questionIterator,ansIterator,sortedQuestion ;
	static Object questionOrder;
	static Set<Integer> question;
	
	public static void main(String[] args) throws Exception {
		//Using the Array list to Display the Answers
		ArrayList<String> correctAnswer = new ArrayList<String>();
		//set file reader object for question.json and mcqAnswer
		String questionOrderJSON="/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/StaticTestAssesment/Order.json";
        String answerJSON="/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/StaticTestAssesment/Answer.json";
        //creating object for JSON Parser
        JSONParser qParser=new JSONParser();    
        //parsing JSON file using JSON Parser Object
        JSONObject questionOrderObj=(JSONObject)qParser.parse(new FileReader(questionOrderJSON));
        //Print the JSON Content
        System.out.println(questionOrderObj);
        //Iterate the Key
        questionIterator= questionOrderObj.keySet().iterator();
        question=new HashSet<Integer>();
        while(questionIterator.hasNext())
        {
            //Iterate the Key Value using Iterator
            String qList=(String)questionIterator.next();
            System.out.println(qList);
            question.add((Integer.parseInt(qList)));
        }
        //Using TreeSet Sorted the Key in Array Format
        TreeSet<Integer> sortedSet = new TreeSet<Integer>(question);
        //Iterate the Array Format of Sorted TreeSet
        sortedQuestion=sortedSet.iterator();
        System.out.println(sortedSet);
        while(sortedQuestion.hasNext())
        {	
        	//Iterate the Sorted Key
            String qList=sortedQuestion.next().toString();
            questionOrder=questionOrderObj.get(qList);
            //System.out.println(qList);
            //Print the Key and Value
            System.out.println(qList+"->"+questionOrder);
            //Take the First JsonFile Value to get the Second JsonFile Key
            JSONObject answerObj=(JSONObject)qParser.parse(new FileReader(answerJSON));
            String value=(String) answerObj.get(questionOrder);
            //Print the Key With order and Answer
            System.out.println(qList+" Question Placed in "+questionOrder+" Place and this Answer is:"+value);
            //Add the AnswerObj to ArrayList
            correctAnswer.add((String) answerObj.get(questionOrder));
        }
        System.out.println(correctAnswer);
	}
	
	}
	
        



