package com.testflow.Post_Job;

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
import org.openqa.selenium.support.ui.Select;

public class Post_Job {
static WebDriver driver;
	public static void Posturl(WebDriver driver) throws Exception
	{		
			//Create the Log File with date and time
	        Logger logger = Logger.getLogger("MyLog");  
	        FileHandler fh;  
	        try {  
	        	// This block configure the logger with handler and formatter  
	            fh = new FileHandler("/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Post_Job/Message.log");  
	            logger.addHandler(fh);
	            SimpleFormatter formatter = new SimpleFormatter();  
	            fh.setFormatter(formatter);  
	            } 
	        catch (SecurityException e) {  
	            e.printStackTrace();  
	        }
			//Click the Test and Share Button
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/ul[1]/li[1]/div/div[1]/div/a")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/a[4]")).click();
			//Click the Post Job Link
			driver.findElement(By.id("headingThree")).click();
			Thread.sleep(4000);
	    	WebElement element=driver.findElement(By.id("post_job_checkbox"));
	    	element.click();
	    	Thread.sleep(4000);
	    	if(element.isSelected())
	    	{
	    	//Type the Data
	    	driver.findElement(By.id("job_post_title")).sendKeys("Software Engineer");
	    	Thread.sleep(4000);
	    	driver.findElement(By.id("job_post_eligibility")).sendKeys("BE");
	    	Thread.sleep(4000);
	    	driver.findElement(By.id("job_post_experience")).sendKeys("Fresher");
	    	Thread.sleep(4000);
	    	driver.findElement(By.id("job_post_loc")).sendKeys("Chennai");
	    	Thread.sleep(4000);
	    	driver.findElement(By.id("job_post_category")).sendKeys("WebDevelopment");
	    	Thread.sleep(4000);
	    	driver.findElement(By.id("job_post_skills")).sendKeys("JAVA");
	    	Thread.sleep(4000);
	    	driver.findElement(By.id("job_post_des")).sendKeys("Must Completed Course");
	    	Thread.sleep(4000);
	    	Select sel1=new Select(driver.findElement(By.id("select_job_type")));
	    	sel1.selectByVisibleText("Full Time");
	    	Thread.sleep(4000);
	    	driver.findElement(By.id("job_post_last_date")).click();
	    	Thread.sleep(4000);
	    	driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[5]/td[5]/a")).click();
	    	Thread.sleep(4000);
	    	driver.findElement(By.id("job_post_access_code")).sendKeys("E12345");
	    	Thread.sleep(4000);
	    	driver.findElement(By.id("job_submit")).click();	
	    	Thread.sleep(4000);
	    	String Result=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div[3]/div[2]/div/div/div/div/div/div[2]/div/h3")).getText();
	    	if(Result!=null)
	    		logger.info(Result);
	    	else
	    		logger.info("Not Posted..");
	    	}
	    	else
	    	{
	    		logger.info("Plz Click the Check Box...!");
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
			 ATUTestRecorder recorder=new ATUTestRecorder("/home/guvi/eclipse-workspace/TestFlow/ScriptVideos","PostJob-"+dateFormat.format(date),false);
			 recorder.start();*/
	         driver.manage().window().maximize();
	         Thread.sleep(4000);
	         //Read the UserInfo in JSON File
	         String File="/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Post_Job/UserInfo.json";
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
	         //Call the Method
	         Posturl(driver);
	         //Stop the Record
	         //recorder.stop();
	         //Close the Driver
	         driver.close();

}

}
