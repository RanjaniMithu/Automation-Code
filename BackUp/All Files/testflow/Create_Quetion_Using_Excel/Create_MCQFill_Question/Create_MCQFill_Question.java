package com.testflow.Create_Quetion_Using_Excel.Create_MCQFill_Question;

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

public class Create_MCQFill_Question {
	static WebDriver driver;
	static HSSFWorkbook workbook;
    static HSSFSheet sheet;
	public static void mcqQuestionFill(WebDriver driver) throws Exception
    {			
				//Create the Log File with date and time
		        Logger logger = Logger.getLogger("MyLog");  
		        FileHandler fh;  
		        try {  
		        	// This block configure the logger with handler and formatter  
		            fh = new FileHandler("/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Create_Quetion_Using_Excel/Create_MCQFill_Question/Message.log");  
		            logger.addHandler(fh);
		            SimpleFormatter formatter = new SimpleFormatter();  
		            fh.setFormatter(formatter);  
		            } 
		        catch (SecurityException e) {  
		            e.printStackTrace();  
		        }
		        //Create New Question Option
			    File file=new File("/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Create_Quetion_Using_Excel/Create_MCQFill_Question/MCQ_Fill_Question.xls");
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
			    //Create the Question for Fill Type
			    if(Question_Type_length==1)
			    if(Question_type.equals("Multiple Choice Question"))
			    {
		    	String Question_Type = sheet.getRow(row).getCell(0).getStringCellValue();
	            String Question_title = sheet.getRow(row).getCell(1).getStringCellValue();
	            String Question = sheet.getRow(row).getCell(2).getStringCellValue();
	            String MCQ_Type = sheet.getRow(row).getCell(3).getStringCellValue();
	            String Answer = sheet.getRow(row).getCell(4).getStringCellValue();
	            int Score = (int) sheet.getRow(row).getCell(5).getNumericCellValue();
	            String Group_Title = sheet.getRow(row).getCell(6).getStringCellValue();
	            String Tags = sheet.getRow(row).getCell(7).getStringCellValue();
	            System.out.println(Question_Type+","+Question_title+","+Question+","+MCQ_Type+","+Score+","+Answer+","+Group_Title+","+Tags);
	    		Select question_type=new Select(driver.findElement(By.id("insert_question_type")));
			    question_type.selectByVisibleText(Question_Type);
			    driver.findElement(By.id("question_title")).sendKeys(Question_title);
			    Thread.sleep(2000);
			    driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+Question);
			    Thread.sleep(2000);
			    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[1]/div/div/span[1]/span[2]/span[4]/span[3]/a[4]/span[1]")).click();
			    Thread.sleep(2000);
			    driver.findElement(By.id("cke_135_label")).click();
			    Thread.sleep(2000);
			    Select select6=new Select(driver.findElement(By.id("mcq_type")));
			    select6.selectByVisibleText(MCQ_Type);
			    Thread.sleep(2000);
			    driver.findElement(By.id("fill_in_answer")).sendKeys(Answer);
			    Thread.sleep(2000);
			    driver.findElement(By.id("mcq_score")).sendKeys(String.valueOf(Score));
			    Thread.sleep(2000);
			    Select select7=new Select(driver.findElement(By.id("group_title_select")));
			    select7.selectByVisibleText(Group_Title);
			    Thread.sleep(2000);
			    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]/div[2]/div/input")).sendKeys(Tags);
			    Thread.sleep(2000);
			    driver.findElement(By.id("create_question")).click();
			    Thread.sleep(3000);
			    String ExpectedTitle=driver.getTitle();
		        System.out.println(ExpectedTitle);
		        if(ExpectedTitle.contains("Online Test - Admin Panel - gofrugal"))
			    {	
	        	sheet.getRow(row).createCell(8).setCellValue("PASS");
	        	logger.info("Fill option Done : "+Question_title);	
		        }
		        else
		        {
	        	sheet.getRow(row).createCell(8).setCellValue("FAIL");
	        	logger.info("Some thing Went Wrong...");
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
			    System.out.println("Fill Option Done");
				Thread.sleep(2000);
	            }
    }
	public static void main(String[] args) throws Exception {
				//Launch the FireFox
		 		System.setProperty("webdriver.gecko.driver", "/home/guvi/Downloads/geckodriver");
		        driver=new FirefoxDriver();
		        driver.get("http://121.242.232.164/guvi-dev/");
		        driver.manage().window().maximize();
		        //Read the UserInfo in JSON File
		        String File="/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/Create_Quetion_Using_Excel/Create_MCQFill_Question/UserInfo.json";
		        JSONParser parser=new JSONParser();
		        JSONObject UserInfo=(JSONObject) parser.parse(new FileReader(File));
		        String UserName=(String) UserInfo.get("UserName");
		        String Password=(String) UserInfo.get("Password");
		        //click the SignIn Button
		        driver.findElement(By.linkText("Sign In")).click();
		        Thread.sleep(2000);
		        driver.findElement(By.id("login_email")).sendKeys(UserName);
		        Thread.sleep(2000);
		        driver.findElement(By.id("login_password")).sendKeys(Password);
		        Thread.sleep(2000);
		        driver.findElement(By.id("login_button")).click();
		        Thread.sleep(2000);
		        //Click the TestLink
		        driver.findElement(By.className("glyphicon-pencil")).click();
		        Thread.sleep(2000);
		        //Click the MCQ Test
		        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/ul[1]/li[4]/div/div[1]/div/a")).click();
				Thread.sleep(2000);
		        //Call the Method
		        mcqQuestionFill(driver);
		        //Close the Driver
		        //driver.close();
	}
}
