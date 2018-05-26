package com.testflow.Share_Test;

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

public class Share_Test {
static WebDriver driver;
	public static void Sharetest(WebDriver driver) throws Exception
	{
				//Create the Log File with date and time
		        Logger logger = Logger.getLogger("MyLog");  
		        FileHandler fh;  
		        try {  
		        	// This block configure the logger with handler and formatter  
		            fh = new FileHandler("/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Share_Test/Message.log");  
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
				 try
				 {
				 String TitleMsg=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/p")).getText();
				 logger.info(TitleMsg);
				 }
				 catch(Exception e)
				 {
					 System.out.println(e);
					 logger.info("Questions are Presented in the Test...Proceed to Share the Test");
					 driver.findElement(By.linkText("Share Test")).click();
					 Thread.sleep(4000);
					 //Type the Data
					 driver.findElement(By.id("college")).sendKeys("ChennaiRegion");
					 Thread.sleep(4000);
					 driver.findElement(By.id("college")).sendKeys(Keys.TAB);
					 Thread.sleep(4000);
					 driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[5]/td[5]/a")).click();
					 Thread.sleep(4000);
					 driver.findElement(By.id("custom_url")).sendKeys("SRM_StaffTes9001");
					 Thread.sleep(4000);
					 Select select11=new Select(driver.findElement(By.id("expiry_limit")));
					 select11.selectByVisibleText("In 24 hours");
					 Thread.sleep(4000);
					 driver.findElement(By.id("invite_access_code")).sendKeys("SRMUsers");
					 Thread.sleep(4000);
					 driver.findElement(By.id("create_access_code")).click();
					 Thread.sleep(2000);
					 String Result=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div/div/div[4]/div")).getText();
	 				 if(Result!=null)
	 					 logger.info(Result);
	 				 else
	 					 logger.info("Test Not Shared..");
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
				 ATUTestRecorder recorder=new ATUTestRecorder("/home/guvi/eclipse-workspace/TestFlow/ScriptVideos","ShareTest-"+dateFormat.format(date),false);
				 recorder.start();*/
		         driver.manage().window().maximize();
		         Thread.sleep(4000);
		         //Read the UserInfo in JSON File
		         String File="/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Share_Test/UserInfo.json";
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
		         driver.findElement(By.className("glyphicon-pencil")).click();
		         Thread.sleep(4000);
		         //Call the Method
		         Sharetest(driver);
		         //Stop the Record
		         //recorder.stop();
		         //Close the Driver
		         driver.close();

}
}
