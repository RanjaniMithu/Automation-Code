package com.testflow.Create_NewTest_MCQ;

import java.io.FileReader;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Create_New_Test_MCQ {
	static WebDriver driver;
	public static void Create_NewQuestion(WebDriver driver) throws Exception
    {			
				//Create the Log File with date and time
		        Logger logger = Logger.getLogger("MyLog");  
		        FileHandler fh;  
		        try {  
		        	// This block configure the logger with handler and formatter  
		            fh = new FileHandler("/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Create_NewTest_MCQ/Message.log");  
		            logger.addHandler(fh);
		            SimpleFormatter formatter = new SimpleFormatter();  
		            fh.setFormatter(formatter);  
		            } 
		        catch (SecurityException e) {  
		            e.printStackTrace();  
		        }
				//Create New Test
			    driver.findElement(By.id("challengename")).sendKeys("Test1");
			    Thread.sleep(4000);
			    String Type=driver.findElement(By.id("plan")).getText();
			    System.out.println("TestTypes are : "+"\n"+Type);
			    String[] length=driver.findElement(By.id("plan")).getText().split("\n");
			    int Typelength=length.length;
			    System.out.println(Typelength);
			    if(Typelength==7)
			    	if(Type.contains("Only Mcq Round")&&Type.contains("Only Programming Round")&&Type.contains("Only Summary Round")
			    		&&Type.contains("Both Round With Break")&&Type.contains("Both Round Without Break")
			    		&&Type.contains("Both Round With Break and Summary Test"))
				    	{
						    Select TestType=new Select(driver.findElement(By.id("plan")));
						    TestType.selectByVisibleText("Only Mcq Round");
						    Thread.sleep(4000);
						    driver.findElement(By.id("mcq-time")).sendKeys("2");
						    Thread.sleep(4000);
						    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/div[4]/div/input")).sendKeys("Interface");
						    Thread.sleep(4000);
						    driver.findElement(By.linkText("Create Test")).click();
						 }
			    	else
				    {
				    	System.out.println("Not Displayed All Type of Test...");
				    }
			    else
			    {
			    	System.out.println("Length is Wrong...");
			    }
			    String ExpectedTitle=driver.getTitle();
			    if(ExpectedTitle.contains("GUVI - Online Test - Admin Panel - gofrugal"))
			    	logger.info("Sucessfully Create the Test");
				else
			    	logger.info("Some thing Went Wrong..");
			    }
      
	public static void main(String[] args) throws Exception {
		//Launch the FireFox
 		System.setProperty("webdriver.gecko.driver", "/home/guvi/Downloads/geckodriver");
        driver=new FirefoxDriver();
        driver.get("http://10.7.150.41/guvi");
        /*//Start the record - Create the ATUTestRecorder Object with Date Time Format
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	    Date date = new Date();
	    ATUTestRecorder recorder=new ATUTestRecorder("/home/guvi/eclipse-workspace/TestFlow/ScriptVideos","Create_NewTest_MCQ-"+dateFormat.format(date),false);
	    recorder.start(); */
        driver.manage().window().maximize();
        //Read the UserInfo in JSON File
        String File="/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Create_NewTest_MCQ/UserInfo.json";
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
        //Click the Test
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[1]/div[2]/button")).click();
        Thread.sleep(4000);
        //Call the Method
        Create_NewQuestion(driver);
        Thread.sleep(4000);
        //Stop the Record
        //recorder.stop();
        //Close the Driver
        driver.close();
}
}
