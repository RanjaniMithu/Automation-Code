package com.testflow.Create_Quetion_Using_Excel.Create_Summary_Question;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Create_Summary_Question {
	static WebDriver driver;
	static HSSFWorkbook workbook;
    static HSSFSheet sheet;
	public  static void SummaryQuestions(WebDriver driver) throws Exception
    {
			//Create the Log File with date and time
	        Logger logger = Logger.getLogger("MyLog");  
	        FileHandler fh;  
	        try {  
	        	// This block configure the logger with handler and formatter  
	            fh = new FileHandler("/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Create_Quetion_Using_Excel/Create_Summary_Question/Message.log");  
	            logger.addHandler(fh);
	            SimpleFormatter formatter = new SimpleFormatter();  
	            fh.setFormatter(formatter);  
	            } 
	        catch (SecurityException e) {  
	            e.printStackTrace();  
	        }
	        //Create New Question Option
		    File file=new File("/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Create_Quetion_Using_Excel/Create_Summary_Question/Summary_Question.xls");
            FileInputStream fis=new FileInputStream(file);
            workbook=new HSSFWorkbook(fis);
            sheet=workbook.getSheet("Sheet1");
            int rowCount = sheet.getLastRowNum();
            System.out.println("the no of rows are : " + rowCount);
            for (int row=1; row<=rowCount; row++)
            {
			driver.findElement(By.linkText("Create new question")).click();
			Thread.sleep(2000);
			String Question_type=driver.findElement(By.id("insert_question_type")).getText();
		    System.out.println("TestTypes are : "+"\n"+Question_type);
		    String[] length=driver.findElement(By.id("insert_question_type")).getText().split("\n");
		    int Question_Type_length=length.length;
		    System.out.println(Question_Type_length);
		    //Create the Question
		     if(Question_Type_length==1)
		     if(Question_type.equals("Summary Question"))
	    	 {
	    	 String Question_Type = sheet.getRow(row).getCell(0).getStringCellValue();
             String Question_title = sheet.getRow(row).getCell(1).getStringCellValue();
             String Question = sheet.getRow(row).getCell(2).getStringCellValue();
             String Tags = sheet.getRow(row).getCell(3).getStringCellValue();
             System.out.println(Question_Type+","+Question_title+","+Question+","+Tags);
    		 Select question_type=new Select(driver.findElement(By.id("insert_question_type")));
		     question_type.selectByVisibleText(Question_Type);
		     Thread.sleep(2000);
			 driver.findElement(By.id("question_title")).sendKeys(Question_title);
			 Thread.sleep(2000);
			 driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+Question);
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]/div/div/input")).sendKeys(Tags);
			 Thread.sleep(2000);
			 driver.findElement(By.id("create_question")).click();
			 Thread.sleep(2000);
			 String ExpectedTitle=driver.getTitle();
	         System.out.println(ExpectedTitle);
	         if(ExpectedTitle.contains("Online Test - Admin Panel - gofrugal"))
	         {
	        	sheet.getRow(row).createCell(4).setCellValue("PASS");
	        	logger.info("Summary Question Created..."+Question_title);	
	         }
	         else
	         {
	        	sheet.getRow(row).createCell(4).setCellValue("FAIL");
	        	logger.info("Some thing Went Wrong..."+Question_title);
	         }
	         FileOutputStream fos=new FileOutputStream(file);
	    	 workbook.write(fos);
	    	 Thread.sleep(1000);
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
            }
    }
	public static void main(String[] args) throws Exception {
		
			//Launch the FireFox
			System.setProperty("webdriver.gecko.driver", "/home/guvi/Downloads/geckodriver");
	        driver=new FirefoxDriver();
	        driver.get("http://10.7.150.41/guvi/");
	        driver.manage().window().maximize();
	        Thread.sleep(2000);
	        //Read the UserInfo in JSON File
	        String File="/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Create_Quetion_Using_Excel/Create_Summary_Question/UserInfo.json";
	        JSONParser parser=new JSONParser();
	        JSONObject UserInfo=(JSONObject) parser.parse(new FileReader(File));
	        String UserName=(String) UserInfo.get("UserName");
	        String Password=(String) UserInfo.get("Password");
	        //click the SignIn Button
	        driver.findElement(By.linkText("Sign In")).click();
	        driver.findElement(By.id("login_email")).sendKeys(UserName);
	        Thread.sleep(2000);
	        driver.findElement(By.id("login_password")).sendKeys(Password);
	        Thread.sleep(2000);
	        driver.findElement(By.id("login_button")).click();
	        Thread.sleep(2000);
	        //Click the TestLink
	        driver.findElement(By.className("glyphicon-pencil")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/ul[1]/li[1]/div/div[1]/div/a")).click();
	        Thread.sleep(2000);
	        //Call the Method
	        SummaryQuestions(driver);
	        //Close the Driver
	        //driver.close();
	}
}
