package com.testflow.Edit_Question;

import java.io.FileReader;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Edit_Question {
static WebDriver driver;
	public static void main(String[] args) throws Exception {
				//Create the Log File with date and time
		        Logger logger = Logger.getLogger("MyLog");  
		        FileHandler fh;  
		        try {  
		        	// This block configure the logger with handler and formatter  
		            fh = new FileHandler("/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Edit_Question/Message.log");  
		            logger.addHandler(fh);
		            SimpleFormatter formatter = new SimpleFormatter();  
		            fh.setFormatter(formatter);  
		            } 
		        catch (SecurityException e) {  
		            e.printStackTrace();  
		        }
				//Launch the FireFox
		 		System.setProperty("webdriver.gecko.driver", "/home/guvi/Downloads/geckodriver");
		        driver=new FirefoxDriver();
		        driver.get("http://10.7.150.41/guvi");
		        /*//Start the record - Create the ATUTestRecorder Object with Date Time Format
	            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
			    Date date = new Date();
			    ATUTestRecorder recorder=new ATUTestRecorder("/home/guvi/eclipse-workspace/TestFlow/ScriptVideos","Question_Edit-"+dateFormat.format(date),false);
			    recorder.start(); */
		        driver.manage().window().maximize();
		        Thread.sleep(4000);
		        //Read the UserInfo in JSON File
		        String File="/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Edit_Question/UserInfo.json";
		        JSONParser parser=new JSONParser();
		        JSONObject UserInfo=(JSONObject) parser.parse(new FileReader(File));
		        String UserName=(String) UserInfo.get("UserName");
		        String Password=(String) UserInfo.get("Password");
			    //click the SignIn Button
		        driver.findElement(By.linkText("Sign In")).click();
		        Thread.sleep(4000);
		        driver.findElement(By.id("login_email")).sendKeys(UserName);
		        Thread.sleep(4000);
		        driver.findElement(By.id("login_password")).sendKeys(Password);
		        Thread.sleep(4000);
		        driver.findElement(By.id("login_button")).click();
		        Thread.sleep(4000);
		        //Click the TestLink
		        driver.findElement(By.xpath("/html/body/div/div/div[1]/ul[2]/li[2]/a/span")).click();
		        Thread.sleep(4000);
		        //Click the Test
		        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/ul[1]/li[2]/div/div[1]/div/a")).click();
   		        Thread.sleep(4000);
   		        try
   		        {
		        //Click the Edit Option
		        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div/ul[1]/li/div/div[1]/div/a/div/div[4]/div/div[1]/span")).click();
		        Thread.sleep(4000);
		        String Title=driver.getTitle();
		        if(Title.equals("GUVI - Questions - gofrugal"))
		        {
		        //Change the Title
		        WebElement element1=driver.findElement(By.id("question_title"));
		        element1.clear();
		        element1.sendKeys("Object Oriented Concepts");
		        Thread.sleep(4000);
		        driver.findElement(By.id("create_question")).click();
		        Thread.sleep(4000);
		        driver.findElement(By.cssSelector(".search")).sendKeys("Object Oriented Concepts");
		        Thread.sleep(4000);
		        String EditedTitle=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div/ul[1]/li[1]/div/div[1]/div/a/div/div[1]/p")).getText();
		        System.out.println(EditedTitle);
		        if(EditedTitle.equals("Object Oriented Concepts"))
		        {
		        	logger.info("Sucessfully Edit the Question...");
		        }
		        else
		        {
		        	String ErrorMsg=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div/div[3]")).getText();
		        	System.out.println(ErrorMsg);
		        	logger.info(ErrorMsg);
		        }
		        }
		        else
		        	logger.info("Edit option not Working....");
   		        }
   		        catch(Exception e)
   		        {
   		        	System.out.println(e);
   		        	logger.info("No Questions are Presented in the Test");
   		        }
		        
		        //Stop the record
		        //recorder.stop();
   		        //Close the Driver
   		        driver.close();
		        
		        
}
}
