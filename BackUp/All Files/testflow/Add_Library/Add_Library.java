package com.testflow.Add_Library;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import atu.testrecorder.ATUTestRecorder;

public class Add_Library {
static WebDriver driver;
	public static void main(String[] args) throws Exception {
		//Launch the FireFox
		System.setProperty("webdriver.gecko.driver", "/home/guvi/Downloads/geckodriver");
        driver=new FirefoxDriver();
        //Create the Log File with date and time
        Logger logger = Logger.getLogger("MyLog");  
        FileHandler fh;  
        try {  
        	// This block configure the logger with handler and formatter  
            fh = new FileHandler("/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Add_Library/Message.log");  
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  
            } 
        catch (SecurityException e) {  
            e.printStackTrace();  
        }
        driver.get("http://10.7.150.41/guvi");
        //Start the record - Create the ATUTestRecorder Object with Date Time Format
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		ATUTestRecorder recorder=new ATUTestRecorder("/home/guvi/eclipse-workspace/TestFlow/ScriptVideos","AddLibrary-"+dateFormat.format(date),false);
		recorder.start();
        driver.manage().window().maximize();
        Thread.sleep(4000);
        //Read the UserInfo in JSON File
        String File="/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Add_Library/UserInfo.json";
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
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/ul[1]/li[2]/div/div[1]/div/a")).click();
        Thread.sleep(4000);
        //Click the Add from library Button
        driver.findElement(By.linkText("Add from Library")).click();
        Thread.sleep(4000);
        String PageTitle=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/h3")).getText();
        System.out.println(PageTitle);
        if(PageTitle.contentEquals("Library Questions"))
        {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[2]/ul[1]/li[1]/div/div[1]/div/div/div/button")).click();	
        Thread.sleep(4000);
        String QuestionTitle=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[2]/ul[1]/li[3]/div/div[1]/div/div/a/div[1]/p")).getText();
        System.out.println(QuestionTitle);
        //Select the Group
        Select add=new Select(driver.findElement(By.id("group_title_selectself_3")));
        add.selectByVisibleText("Topic1");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[2]/ul[1]/li[3]/div/div[1]/div/div/div/div/div[2]/button")).click();
        Thread.sleep(4000);
        System.out.println("Added Sucess");
        //Check Added or Not
        driver.findElement(By.className("glyphicon-pencil")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/ul[1]/li[2]/div/div[1]/div/a")).click();
        Thread.sleep(4000);
        try
        {
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div/div[1]/div/input")).sendKeys(QuestionTitle);
        String AddedTitle=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div/ul[1]/li[1]/div/div[1]/div/a/div/div[1]/p")).getText();
        System.out.println(AddedTitle);
        if(QuestionTitle.equals(AddedTitle))
        	logger.info("Question Added From Library");
        else
        	logger.info("No result Found");
        }
        catch(Exception e)
        {
        	System.out.println(e);
        	logger.info("No Question Added...");
        }
        }
        else
        	logger.info("Please Select the Guvi Library...");
        Thread.sleep(2000);
        //Stop the Record
    	recorder.stop();
        //Close the Driver
        driver.close();
}
}
