package com.testflow.Remove_Library;

import java.io.FileReader;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Remove_Library {
static WebDriver driver;
	public static void main(String[] args) throws Exception {
		//Launch the FireFox
		System.setProperty("webdriver.gecko.driver", "/home/guvi/Downloads/geckodriver");
        driver=new FirefoxDriver();
        driver.get("http://10.7.150.41/guvi");
        //Create the Log File with date and time
        Logger logger = Logger.getLogger("MyLog");  
        FileHandler fh;  
        try {  
        	// This block configure the logger with handler and formatter  
            fh = new FileHandler("/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Remove_Library/Message.log");  
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
		ATUTestRecorder recorder=new ATUTestRecorder("/home/guvi/eclipse-workspace/TestFlow/ScriptVideos","RemoveLibrary-"+dateFormat.format(date),false);
		recorder.start();*/
        driver.manage().window().maximize();
        Thread.sleep(4000);
        //Read the UserInfo in JSON File
        String File="/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Remove_Library/UserInfo.json";
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
        driver.findElement(By.className("glyphicon-pencil")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/ul[1]/li[1]/div/div[1]/div/a")).click();
        Thread.sleep(4000);
        //Remove from the Test
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/a[2]")).click();
        Thread.sleep(4000);
        try
        {
        String QuestionTitle=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[2]/ul[1]/li[1]/div/div[1]/div/div/a/div[1]/p")).getText();
        System.out.println(QuestionTitle);
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[2]/ul[1]/li[1]/div/div[1]/div/div/div/button")).click();
        Thread.sleep(4000);
        System.out.println("Removed the Added Question From Library");
        //Check Removed or Not
        driver.findElement(By.className("glyphicon-pencil")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/ul[1]/li[1]/div/div[1]/div/a")).click();
        Thread.sleep(4000);
        try
        {
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div/div[1]/div/input")).sendKeys(QuestionTitle);
        Thread.sleep(4000);
        String ErrorMsg=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div/div[3]")).getText();
        if((ErrorMsg!=null))
        	logger.info("Sucessfully Remove the Question from Library");
        else
        	logger.info("Question Not Removed from Library");
        }
        catch(Exception e)
        {
        	System.out.println(e);
        	logger.info("Sucessfully Remove the Question from Library");
        }
        }
        catch(Exception e)
        {
        	System.out.println(e);
        	logger.info("Plz Find the Correct Question Title");
        }
        //Stop the Record
        //recorder.stop();
        //Close the Driver
        driver.close();
}
}
