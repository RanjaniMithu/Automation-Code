package com.testflow;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;

public class OldRandomTest {
	static Iterator<?> questionIterator,ansIterator ;
	static Object questionOrder;
	
	public static void main(String[] args) throws Exception {
		//Using the Array list to Display the Answers
		ArrayList<String> correctAnswer = new ArrayList<String>();
		//set file reader object for question.json and mcqAnswer
		String questionOrderJSON="/home/guvi/eclipse-workspace/TestFlow/Order.json";
        String answerJSON="/home/guvi/eclipse-workspace/TestFlow/Answer.json";
        //creating object for JSON Parser
    	JSONParser qParser=new JSONParser();
    	
    	FileReader file=new FileReader(questionOrderJSON);
    	System.out.println(file);
    	//parsing JSON file using JSON Parser Object
    	JSONObject questionOrderObj=(JSONObject)qParser.parse(file);
    	System.out.println(questionOrderObj);
    	
    	  questionIterator= questionOrderObj.keySet().iterator();
    	  HashMap<Integer,Integer> order = new HashMap<Integer,Integer>();
    	  order.putAll(questionOrderObj);
    	  System.out.println(order);
    	   	
    	while(questionIterator.hasNext())
    	{
    		//Iterate the Key Value using Iterator
    		String qList=(String)questionIterator.next();
    		System.out.println(qList);
       		questionOrder=questionOrderObj.get(qList);
       		System.out.println(questionOrder);
      		JSONObject answerObj=(JSONObject)qParser.parse(new FileReader(answerJSON));
      		String value=(String) answerObj.get(questionOrder);
       		System.out.println(qList+" Question Placed in "+questionOrder+" Place and this Answer is:"+value);
       		//Add the AnswerObj to ArrayList
    		correctAnswer.add((String) answerObj.get(questionOrder));
    		
    	}
    	Iterator<String> iter = correctAnswer.iterator();
        while (iter.hasNext()) {
           System.out.println(iter.next());
           for (int counter = 0; counter < correctAnswer.size(); counter++)
    	{ 		      
        	   correctAnswer.get(counter);
          
        	   System.out.println("counter is "+counter);
            //driver.findElement(By.xpath("//*[@id=\"mcq_submit\"]")).click();
	      	Thread.sleep(3000);
           
        }
	}
	
	}

}
