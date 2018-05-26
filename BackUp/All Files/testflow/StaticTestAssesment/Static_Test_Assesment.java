package com.testflow.StaticTestAssesment;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Static_Test_Assesment {
	
	static Iterator<?> questionIterator,ansIterator,sortedQuestion ;
	static Object questionOrder;
	static Set<Integer> question;
	static ArrayList<String> correctAnswer = new ArrayList<String>();
//Create the Method for Click the Option	
public static void clickAnswer(String answer,WebDriver driver) {
	
		if (answer.equals("1"))
	  	{
	  		driver.findElement(By.id("question_0")).click();
	  	}
	  	else if (answer.equals("2"))
	  	{
	  		driver.findElement(By.id("question_1")).click();
	  	}
	  	else if (answer.equals("3"))
	  	{
	  		driver.findElement(By.id("question_2")).click();
	  	}
	  	else if (answer.equals("4"))
	  	{
	  		driver.findElement(By.id("question_3")).click();
	  	}
	  	else if (answer.equals("5"))
	  	{
	  		driver.findElement(By.id("question_4")).click();
	  	}
	  	else
	  		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/span/p/input")).sendKeys(answer);
	}

public static void main(String[] args) throws Exception {
	
			//Launch the FireFox
			System.setProperty("webdriver.chrome.driver", "/home/guvi/eclipse-workspace/chromedriver");
			//Set the Preference for Downloading JSON File
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.prompt_for_download", "false");
			chromePrefs.put("download.default_directory", "/home/guvi/Downloads");
			ChromeOptions options = new ChromeOptions();
	        Map<String, Object> prefs = new HashMap<String, Object>(); 
	        prefs.put("safebrowsing.enabled", "true"); options.setExperimentalOption("prefs", prefs);
	        ChromeDriver driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        //Create the Log File with date and time
	        Logger logger = Logger.getLogger("MyLog");  
	        FileHandler fh;  
	        try {  
	        	// This block configure the logger with handler and formatter  
	            fh = new FileHandler("/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/StaticTestAssesment/Message.log");  
	            logger.addHandler(fh);
	            SimpleFormatter formatter = new SimpleFormatter();  
	            fh.setFormatter(formatter);  
	            } 
	        catch (SecurityException e) {  
	            e.printStackTrace();  
	        }
	        /*//Start the record - Create the ATUTestRecorder Object with Date Time Format
		    DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		    Date date = new Date();
		    ATUTestRecorder recorder=new ATUTestRecorder("/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/StaticTestAssesment/ScriptVideos","TestAssesment-"+dateFormat.format(date),false);
		    recorder.start();*/
	        //Open the Page and Validate the URL and AccessCode
	        driver.get("http://121.242.232.164/guvi-dev/");
	        //click the SignIn Button
	        driver.findElement(By.linkText("Sign In")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.id("login_email")).sendKeys("gofrugal@guvi.in");
	        Thread.sleep(3000);
	        driver.findElement(By.id("login_password")).sendKeys("guviGEEK");
	        Thread.sleep(3000);
	        driver.findElement(By.id("login_button")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.className("glyphicon-pencil")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.linkText("Testtttt")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("/html/body/div/div/div[1]/ul[2]/li[7]/a/span")).click();
	        Thread.sleep(3000);
	        String URL=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[2]")).getText();
	        System.out.println("https://"+URL);
	        logger.info("Test Original URL : "+URL);
	        String AccessCode=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[3]")).getText();
	        System.out.println(AccessCode);
	        logger.info("Original Access Code : "+AccessCode);
	        String URL_AccessCode="/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/StaticTestAssesment/URL_AccessCode.json";
	        String User_Info="/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/StaticTestAssesment/UserInfo.json";
	        //creating object for JSON Parser
	        JSONParser parser=new JSONParser();
	        JSONObject UserInfo=(JSONObject) parser.parse(new FileReader(URL_AccessCode));
	        String TestUrl=(String) UserInfo.get("TestUrl");
	        String uurl="http://"+URL;
	        logger.info("Test Given URL : "+uurl);
	        String TestAccessCode=(String) UserInfo.get("TestAccessCode");
	        logger.info("Given Access Code : "+TestAccessCode);
	        driver.findElement(By.xpath("/html/body/div[1]/nav/ul/li/a")).click();
	        driver.findElement(By.xpath("//*[@id=\"logout_ment\"]")).click();
	        Thread.sleep(3000);
	        //Open the Another Tab
	        WebElement e=driver.findElement(By.cssSelector("body"));
	        e.sendKeys(Keys.CONTROL + "\t");
	        if(TestUrl.equals(uurl))
	        {
	        	driver.get(TestUrl);
	        	JSONObject UserInfo1=(JSONObject) parser.parse(new FileReader(User_Info));
		        String UserName=(String) UserInfo1.get("UserName");
		        Thread.sleep(3000);
		        String Password=(String) UserInfo1.get("Password");
		        Thread.sleep(3000);
		        //click the SignIn Button
		        driver.findElement(By.id("login_email")).sendKeys(UserName);
		        Thread.sleep(3000);
		        driver.findElement(By.id("login_password")).sendKeys(Password);
		        Thread.sleep(3000);
		        driver.findElement(By.id("login_button")).click();
		        Thread.sleep(3000);
		        //Take test and put the JobCode
		        driver.findElement(By.id("take_test")).click();
		        Thread.sleep(3000);
		        if(TestAccessCode.equals(AccessCode))
		        {
		        driver.findElement(By.id("job_code")).sendKeys(TestAccessCode);
		        Thread.sleep(3000);
		        driver.findElement(By.id("job_click")).click();
		        Thread.sleep(3000);
		        driver.findElement(By.linkText("Next")).click();
		        Thread.sleep(3000);
		        driver.findElement(By.xpath("/html/body/div[4]/div/a[2]")).click();
		        Thread.sleep(3000);
		        for(int x=1;x<=2;x++)
		        {
		        try
		        {
		        	driver.findElement(By.xpath("//*[@id=\"question_0\"]")).click();
			        Thread.sleep(1000);
			        driver.findElement(By.xpath("//*[@id=\"mcq_submit\"]")).click();
		        }
		        catch(Exception exp)
		        {
		        	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/span/p/input")).sendKeys("answer");
		        	Thread.sleep(1000);
		        	driver.findElement(By.xpath("//*[@id=\"mcq_submit\"]")).click();
		        }
		        }
		        //Open another tab for Generate JSON File
		        WebElement e1=driver.findElement(By.cssSelector("body"));
		        e1.sendKeys(Keys.CONTROL + "\t");
		        Thread.sleep(3000);
		        driver.get("http://121.242.232.164/guvi-dev/autojson_test.html");
		        Thread.sleep(3000);
		        driver.findElement(By.id("email")).sendKeys(UserName);
		        Thread.sleep(3000);
		        driver.findElement(By.xpath("//*[@id=\"generate\"]")).click();
		        Thread.sleep(3000);
		        driver.findElement(By.xpath("//*[@id=\"order\"]")).click();
		        Thread.sleep(3000);
		        driver.findElement(By.xpath("//*[@id=\"answer\"]")).click();
		        Thread.sleep(3000);
		        driver.navigate().back();
		        //Set file Path
		  		String questionOrderJSON="/home/guvi/Downloads/order.json";
		        String answerJSON="/home/guvi/Downloads/answer.json";
		        //parsing JSON file using JSON Parser Object
		        try
		        {
		        JSONObject questionOrderObj=(JSONObject)parser.parse(new FileReader(questionOrderJSON));
		        //Print the JSON Content
		        System.out.println(questionOrderObj);
		        //Iterate the Key
		        questionIterator= questionOrderObj.keySet().iterator();
		        question=new HashSet<Integer>();
		        while(questionIterator.hasNext())
		        {
		            //Iterate the Key Value using Iterator
		            String qList=(String)questionIterator.next();
		            question.add((Integer.parseInt(qList)));
		        }
		        //Using TreeSet Sorted the Key in Array Format
		        TreeSet<Integer> sortedSet = new TreeSet<Integer>(question);
		        sortedQuestion=sortedSet.iterator();
		        while(sortedQuestion.hasNext())
		        {	
		        	//Iterate the Sorted Key
		            String qList=sortedQuestion.next().toString();
		            questionOrder=questionOrderObj.get(qList);
		            //Print the Key and Value
		            System.out.println(qList+"->"+questionOrder);
		            //Take the First JsonFile Value to get the Second JsonFile Key
		            JSONObject answerObj=(JSONObject)parser.parse(new FileReader(answerJSON));
		            String value=(String) answerObj.get(questionOrder);
		            //Print the Key With order and Answer
		            System.out.println(qList+" Question Placed in "+questionOrder+" Place and this Answer is:"+value);
	                //Add the AnswerObj to ArrayList
	                correctAnswer.add((String) answerObj.get(questionOrder));
		        }
		        System.out.println(correctAnswer);
		        //Call the Method for Click the Answer
	            for(int i = 0;i<correctAnswer.size();i++)
	             {
	              clickAnswer(correctAnswer.get(i),driver);
	              driver.findElement(By.xpath("//*[@id=\"mcq_submit\"]")).click();
	              Thread.sleep(3000);
	             }
	            driver.findElement(By.id("finish_mcq")).click();
	            Thread.sleep(3000);
	            driver.findElement(By.xpath("//*[@id=\"yes\"]")).click();
	            Thread.sleep(5000);
		        String Actualtitle=driver.getTitle();
		        System.out.println(Actualtitle);
		        if(Actualtitle.contains("GUVI | MCQ"))
		        {
		        	String Result=driver.findElement(By.xpath("/html/body/div[2]/div/h2")).getText();
		        	System.out.println(Result);
		        	logger.info(Result);
		        }
		        else
		        {
		        	logger.info("Something Went Wrong....");
		        }
		        }
		        catch(Exception ex)
		        {
		        	logger.info("File Not Downloaded Plz Give the Correct Path");
		        }
		        }
		        else
		        {
		        	logger.info("Plz Enter Correct Access Code...");
		        }
	        }
	        else
	        {
	        	logger.info("Plz Enter Correct Test URL...");
	        }
	        //Finally Delete the Order and Answer File 
	        File answerFile=new File("/home/guvi/Downloads/answer.json");
			File orderFile=new File("/home/guvi/Downloads/order.json");
			answerFile.delete();
			orderFile.delete();
	        //Stop the Record
	      	//recorder.stop();
	      	//Close the Driver
	      	//driver.close();
	      	
	      	
	      	
 }

}
