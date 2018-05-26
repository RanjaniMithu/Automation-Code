package com.testflow.Create_Summary_Question;

import java.io.FileReader;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Create_Summary_Question {
static WebDriver driver;
	public  static void SummaryQuestions(WebDriver driver) throws Exception
    {
				//Create the Log File with date and time
		        Logger logger = Logger.getLogger("MyLog");  
		        FileHandler fh;  
		        try {  
		        	// This block configure the logger with handler and formatter  
		            fh = new FileHandler("/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Create_Summary_Question/Message.log");  
		            logger.addHandler(fh);
		            SimpleFormatter formatter = new SimpleFormatter();  
		            fh.setFormatter(formatter);  
		            } 
		        catch (SecurityException e) {  
		            e.printStackTrace();  
		        }
				//Click the Create New Question Button
				driver.findElement(By.linkText("Create new question")).click();
				Thread.sleep(4000);
				String Question_Type=driver.findElement(By.id("insert_question_type")).getText();
			    System.out.println("TestTypes are : "+"\n"+Question_Type);
			    String[] length=driver.findElement(By.id("insert_question_type")).getText().split("\n");
			    int Question_Type_length=length.length;
			    System.out.println(Question_Type_length);
			    //Create the Question
			     if(Question_Type_length==1)
				    	if(Question_Type.equals("Summary Question"))
					    	{
				    		Select question_type=new Select(driver.findElement(By.id("insert_question_type")));
						    question_type.selectByVisibleText("Summary Question");
						    Thread.sleep(4000);
				driver.findElement(By.id("question_title")).sendKeys("Interface");
				Thread.sleep(4000);
				driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+"how to call interface method? and Explain Briefly About Interface.");
				Thread.sleep(4000);
				driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]/div/div/input")).sendKeys("Java");
				Thread.sleep(4000);
				driver.findElement(By.id("create_question")).click();
				Thread.sleep(2000);
					    	}
				    	else
					    {
					    	logger.info("Displayed Unwanted Question Type...");
					    }
				    else
				    {
				    	logger.info("More than One Question Type is presented...");
				    }
				 Thread.sleep(3000);
				 String ExpectedTitle=driver.getTitle();
		         System.out.println(ExpectedTitle);
		         if(ExpectedTitle.contains("Online Test - Admin Panel - gofrugal"))
		         {
		        	logger.info("Summary Question Created...");	
		         }
		         else
		         {
		        	logger.info("Some thing Went Wrong...");
		         }
    }
	public static void main(String[] args) throws Exception {
		
				//Launch the FireFox
				System.setProperty("webdriver.gecko.driver", "/home/guvi/Downloads/geckodriver");
		        driver=new FirefoxDriver();
		        driver.get("http://10.7.150.41/guvi/");
		        /*//Start the record - Create the ATUTestRecorder Object with Date Time Format
		        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
				Date date = new Date();
				ATUTestRecorder recorder=new ATUTestRecorder("/home/guvi/eclipse-workspace/TestFlow/ScriptVideos","Create_SummaryQuestion-"+dateFormat.format(date),false);
				recorder.start();*/
		        driver.manage().window().maximize();
		        Thread.sleep(4000);
		        //Read the UserInfo in JSON File
		        String File="/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Create_Summary_Question/UserInfo.json";
		        JSONParser parser=new JSONParser();
		        JSONObject UserInfo=(JSONObject) parser.parse(new FileReader(File));
		        String UserName=(String) UserInfo.get("UserName");
		        String Password=(String) UserInfo.get("Password");
		        //click the SignIn Button
		        driver.findElement(By.linkText("Sign In")).click();
		        driver.findElement(By.id("login_email")).sendKeys(UserName);
		        Thread.sleep(4000);
		        driver.findElement(By.id("login_password")).sendKeys(Password);
		        Thread.sleep(4000);
		        driver.findElement(By.id("login_button")).click();
		        Thread.sleep(4000);
		        //Click the TestLink
		        driver.findElement(By.className("glyphicon-pencil")).click();
		        Thread.sleep(4000);
		        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/ul[1]/li[1]/div/div[1]/div/a")).click();
		        Thread.sleep(4000);
		        //Call the Method
		        SummaryQuestions(driver);
		        //Stop the Record
		    	//recorder.stop();
		        //Close the Driver
		        driver.close();

	}

}
