package testSelenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test2 {
	static WebDriver driver;
	//Taking Screenshot Method
		public static void getScreenShot(WebDriver driver, String screenShotName) throws IOException 
		{
					
			TakesScreenshot src = ((TakesScreenshot) driver);
			File file = src.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(screenShotName));
					
		}
	  
	public static void mcqQuestionChoice(WebDriver driver) throws Exception
     {
		
	//Create new Question to Option Form
     driver.findElement(By.id("challengename")).sendKeys("Test1");
     Select select=new Select(driver.findElement(By.id("plan")));
     select.selectByVisibleText("Only Mcq Round");
     driver.findElement(By.id("mcq-time")).sendKeys("2");
     Thread.sleep(1000);
     driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/div[4]/div/input")).sendKeys("Interface");
     driver.findElement(By.linkText("Create Test")).click();
     getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\5.png");
     	//Create New Question Option
     driver.findElement(By.linkText("Create new question")).click();
     Thread.sleep(3000);
     getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\6.png");
     	//Create the Question
     driver.findElement(By.id("question_title")).sendKeys("Interface");
     Thread.sleep(1000);
     driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+"how to call interface method?");
     Select select3=new Select(driver.findElement(By.id("mcq_type")));
     select3.selectByVisibleText("Choice");
     driver.findElement(By.id("option_1")).sendKeys("Create a subclass and must define "
     		+ "the inteface method and create the object for Subclass");
     driver.findElement(By.id("option_2")).sendKeys("Directly Access with Object");
     driver.findElement(By.id("option_3")).sendKeys("Using Constructor");
     driver.findElement(By.id("option_4")).sendKeys("All of the Above");
     driver.findElement(By.id("option_5")).sendKeys("Create a subclass and must define "
     		+ "the inteface method and create the object for Subclass");
     Select select4=new Select(driver.findElement(By.id("answer")));
     select4.selectByVisibleText("Option 5");
     Select select5=new Select(driver.findElement(By.id("group_title_select")));
     select5.selectByVisibleText("Interface");
     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/input")).sendKeys("Java");
     getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\7.png");
     driver.findElement(By.id("create_question")).click();
     getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\8.png");
     System.out.println(" Choice option Done");
     Thread.sleep(1000);
     
     //Create the New Question To Fill Option
     driver.findElement(By.linkText("Create new question")).click();
     Thread.sleep(3000);
     getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\9.png");
     //Create Fill Type
     driver.findElement(By.id("question_title")).sendKeys("Interface");
     Thread.sleep(1000);
     driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+"how to call interface method?");
     Thread.sleep(5000);
     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[1]/div/div/span[1]/span[2]/span[4]/span[3]/a[4]/span[1]")).click();
     Thread.sleep(1000);
     driver.findElement(By.id("cke_135_label")).click();
     Thread.sleep(3000);
     Select select6=new Select(driver.findElement(By.id("mcq_type")));
     select6.selectByVisibleText("Fill");
     driver.findElement(By.id("fill_in_answer")).sendKeys("Create Sub Class and should define Interface method");
     Select select7=new Select(driver.findElement(By.id("group_title_select")));
     select7.selectByVisibleText("Interface");
     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/input")).sendKeys("Java");
     getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\10.png");
     driver.findElement(By.id("create_question")).click();
     System.out.println("Fill Option Done");
     Thread.sleep(3000);
     //Check the Edit Option
     driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div/ul[1]/li[1]/div/div[1]/div/a/div/div[4]/div/div[1]/span")).click();
     Thread.sleep(2000);
     WebElement element1=driver.findElement(By.id("question_title"));
     element1.clear();
     element1.sendKeys("Interface Method");
     getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\11.png");
     driver.findElement(By.id("create_question")).click();
     getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\12.png");
     System.out.println("Edit Option Done");
     //Check the Delete Option
     driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div/ul[1]/li/div/div[1]/div/a/div/div[4]/div/div[2]/span")).click();
     getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\13.png");
     System.out.println("Delete Option Done");
     //Add from Library
     //Add the Question
     driver.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/a[1]")).click();
     driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[2]/ul[1]/li[1]/div/div[1]/div/div/a/div[1]/p")).click();
     Select sel2=new Select(driver.findElement(By.id("group_title_select3")));
     sel2.selectByVisibleText("Interface");
     Thread.sleep(1000);
     driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[2]/ul[1]/li[1]/div/div[1]/div/div/div/div/div[2]/button")).click();
     getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\14.png");
     System.out.println("Added Sucess");
     //Check Added or Not
     driver.findElement(By.className("glyphicon-pencil")).click();
     Thread.sleep(1000);
     driver.findElement(By.className("test-list qtitle")).click();
     getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\14.png");
     System.out.println("Question Added From Library");
     //Remove from the Test
     driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[2]/ul[1]/li[1]/div/div[1]/div/div/div/div/div[2]/button")).click();
     System.out.println("Remove the Added Question From Library");
     getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\15.png");
     System.out.println("Remove Sucess");
     driver.findElement(By.className("glyphicon-pencil")).click();
     Thread.sleep(1000);
     driver.findElement(By.className("test-list qtitle")).click();
     getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\Final.png");
     
     
     
     }
	 public  static void Programming(WebDriver driver) throws Exception
     {
     driver.findElement(By.id("challengename")).sendKeys("Test2");
     Select select=new Select(driver.findElement(By.id("plan")));
     select.selectByVisibleText("Only Programming Round");
     driver.findElement(By.id("pro-time")).sendKeys("30");
     driver.findElement(By.linkText("Create Test")).click();
     Thread.sleep(1000);
     
     driver.findElement(By.linkText("Create new question")).click();
     Thread.sleep(5000);
     
     driver.findElement(By.id("question_title")).sendKeys("Abstract");
     Thread.sleep(6000);
     driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+"Write Program Leap Year or Not?");
     //driver.findElement(By.className("bootstrap-tagsinput")).sendKeys("Java");
     Select select6=new Select(driver.findElement(By.id("difficulty")));
     select6.selectByVisibleText("EASY");
     WebElement option=driver.findElement(By.id("show1"));
     option.click();
     if(option.isSelected())
    	 
     {
    	driver.findElement(By.id("input1")).sendKeys("2000");
    	driver.findElement(By.id("output1")).sendKeys("Leap");
    	driver.findElement(By.id("score1")).sendKeys("5");
     }
     WebElement option1=driver.findElement(By.id("show2"));
     option1.click();
     if(option1.isSelected())
    	 
     {
    	driver.findElement(By.id("input2")).sendKeys("2001");
    	driver.findElement(By.id("output2")).sendKeys("Not Leap");
    	driver.findElement(By.id("score2")).sendKeys("5");
     }
     WebElement option2=driver.findElement(By.id("show3"));
     option2.click();
     if(option2.isSelected())
    	 
     {
    	driver.findElement(By.id("input3")).sendKeys("2002");
    	driver.findElement(By.id("output3")).sendKeys("Leap");
    	driver.findElement(By.id("score3")).sendKeys("5");
     }
     Thread.sleep(3000);
     for(int i=1;i<=2;i++)
     {
    	 if(i<=2)
    	 {
    	 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[6]/div[5]/button")).click();
    	 }
    	 else
    	 {
    		 driver.findElement(By.className("alert alert-danger add_tc_err_msg"));
    	 }
     }
     Thread.sleep(3000);
     driver.findElement(By.id("create_question")).click();
     System.out.println("Done");
           
     }
	 public  static void Summary(WebDriver driver) throws Exception
     {
     driver.findElement(By.id("challengename")).sendKeys("Test3");
     Select select=new Select(driver.findElement(By.id("plan")));
     select.selectByVisibleText("Only Summary Round");
    driver.findElement(By.id("summary-time")).sendKeys("10");
     driver.findElement(By.linkText("Create Test")).click();
     Thread.sleep(1000);
     
     driver.findElement(By.linkText("Create new question")).click();
     Thread.sleep(1000);
     
     driver.findElement(By.id("question_title")).sendKeys("Interface");
     Thread.sleep(3000);
    driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+"how to call interface method?");
     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div/div/input")).sendKeys("Java");
    driver.findElement(By.id("create_question")).click();
    System.out.println("Done");
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("Test3")).click();
		 
     
   //Share Test
	 Thread.sleep(2000);
     driver.findElement(By.linkText("Share Test")).click();
     driver.findElement(By.id("college")).sendKeys("ChennaiRegion");
     driver.findElement(By.id("college")).sendKeys(Keys.TAB);
     driver.findElement(By.id("access_code_date")).sendKeys("2-4-2018");
     driver.findElement(By.id("access_code_date")).click();
     driver.findElement(By.id("ui-datepicker-div")).click();
    
     driver.findElement(By.id("custom_url")).sendKeys("SRM_Students");
     Thread.sleep(3000);
     Select select11=new Select(driver.findElement(By.id("expiry_limit")));
     select11.selectByVisibleText("In 24 hours");
     driver.findElement(By.id("invite_access_code")).sendKeys("JosephUsers");
     driver.findElement(By.id("create_access_code")).click();
     System.out.println("Done");
    
     
     
   //update
     driver.findElement(By.id("headingTwo")).click();
     driver.findElement(By.id("code")).clear();   
     driver.findElement(By.id("code")).sendKeys("FmcetUsers");
     Select s1=new Select(driver.findElement(By.id("update_expiry_limit")));
     s1.selectByVisibleText("Custom");
     driver.findElement(By.id("update_expiry_date"));
     driver.findElement(By.className("ui-state-default"));
     Select s2=new Select(driver.findElement(By.id("update_expiry_time")));
	 s2.selectByVisibleText("01:30");
	 driver.findElement(By.id("code_submit")).click();
	 System.out.println("Done");
	
	//Share
	
	driver.findElement(By.id("headingThree")).click();
	WebElement element=driver.findElement(By.id("post_job_checkbox"));
	element.click();
	driver.findElement(By.id("job_post_title")).sendKeys("Software Engineer");
	driver.findElement(By.id("job_post_eligibility")).sendKeys("BE");
	driver.findElement(By.id("job_post_experience")).sendKeys("Fresher");
	driver.findElement(By.id("job_post_loc")).sendKeys("Chennai");
	driver.findElement(By.id("job_post_category")).sendKeys("WebDevelopment");
	driver.findElement(By.id("job_post_skills")).sendKeys("JAVA");
	driver.findElement(By.id("job_post_des")).sendKeys("Must Completed Course");
	Select sel1=new Select(driver.findElement(By.id("select_job_type")));
	sel1.selectByVisibleText("Full Time");
	driver.findElement(By.id("job_post_last_date")).click();
	driver.findElement(By.className("ui-state-default")).click();
	driver.findElement(By.id("job_post_access_code")).sendKeys("12345");
	driver.findElement(By.id("job_submit")).click();
	


    
     }
	 public  static void BothWithBreak(WebDriver driver) throws Exception
     {
     driver.findElement(By.id("challengename")).sendKeys("Test4");
     Select select=new Select(driver.findElement(By.id("plan")));
     select.selectByVisibleText("Both Round With Break");
     driver.findElement(By.id("mcq-time")).sendKeys("5");
     driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/div[4]/div/input")).sendKeys("Class");
     driver.findElement(By.id("pro-time")).sendKeys("5");
     driver.findElement(By.linkText("Create Test")).click();
     Thread.sleep(1000);
     
     driver.findElement(By.linkText("Create new question")).click();
     Thread.sleep(3000);
     
     //Create Choice Question
     Select select1=new Select(driver.findElement(By.id("insert_question_type")));
     select1.selectByVisibleText("Multiple Choice Question");
     driver.findElement(By.id("question_title")).sendKeys("Interface");
     Thread.sleep(3000);
     driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+"how to call interface method?");
     Select select3=new Select(driver.findElement(By.id("mcq_type")));
     select3.selectByVisibleText("Choice");
     driver.findElement(By.id("option_1")).sendKeys("Create a subclass and must define "
     		+ "the inteface method and create the object for Subclass");
     driver.findElement(By.id("option_2")).sendKeys("Directly Access with Object");
     driver.findElement(By.id("option_3")).sendKeys("Using Constructor");
     driver.findElement(By.id("option_4")).sendKeys("All of the Above");
     driver.findElement(By.id("option_5")).sendKeys("Create a subclass and must define "
     		+ "the inteface method and create the object for Subclass");
     Select select4=new Select(driver.findElement(By.id("answer")));
     select4.selectByVisibleText("Option 5");
     Select select5=new Select(driver.findElement(By.id("group_title_select")));
     select5.selectByVisibleText("Class");
     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/input")).sendKeys("Java");
     driver.findElement(By.id("create_question")).click();
     System.out.println(" choice option Done");
     Thread.sleep(1000);
     
     driver.findElement(By.linkText("Create new question")).click();
     Thread.sleep(3000);
     
     //Create Fill Type
     Select select2=new Select(driver.findElement(By.id("insert_question_type")));
     select2.selectByVisibleText("Multiple Choice Question");
     driver.findElement(By.id("question_title")).sendKeys("Interface");
     Thread.sleep(1000);
     driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+"how to call interface method?");
     Thread.sleep(3000);
     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[1]/div/div/span[1]/span[2]/span[4]/span[3]/a[4]/span[1]")).click();
     driver.findElement(By.id("cke_135_label")).click();
     Thread.sleep(5000);
     Select select6=new Select(driver.findElement(By.id("mcq_type")));
     select6.selectByVisibleText("Fill");
     driver.findElement(By.id("fill_in_answer")).sendKeys("Create Sub Class and should define Interface method");
     Select select7=new Select(driver.findElement(By.id("group_title_select")));
     select7.selectByVisibleText("Class");
     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/input")).sendKeys("Java");
     driver.findElement(By.id("create_question")).click();
     System.out.println("Fill Option Done");
     Thread.sleep(1000);
    
     driver.findElement(By.linkText("Create new question")).click();
     Thread.sleep(5000);
     
     //Select Programming Option
     Select select9=new Select(driver.findElement(By.id("insert_question_type")));
     select9.selectByVisibleText("Programming Question");
     driver.findElement(By.id("question_title")).sendKeys("Abstract");
     Thread.sleep(6000);
     driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+"Write Program Leap Year or Not?");
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/input")).sendKeys("Java");
     Select select8=new Select(driver.findElement(By.id("difficulty")));
     select8.selectByVisibleText("EASY");
     WebElement option=driver.findElement(By.id("show1"));
     option.click();
     if(option.isSelected())
    	 
     {
    	driver.findElement(By.id("input1")).sendKeys("2000");
    	driver.findElement(By.id("output1")).sendKeys("Leap");
    	driver.findElement(By.id("score1")).sendKeys("5");
     }
     WebElement option1=driver.findElement(By.id("show2"));
     option1.click();
     if(option1.isSelected())
    	 
     {
    	driver.findElement(By.id("input2")).sendKeys("2001");
    	driver.findElement(By.id("output2")).sendKeys("Not Leap");
    	driver.findElement(By.id("score2")).sendKeys("5");
     }
     WebElement option2=driver.findElement(By.id("show3"));
     option2.click();
     if(option2.isSelected())
    	 
     {
    	driver.findElement(By.id("input3")).sendKeys("2002");
    	driver.findElement(By.id("output3")).sendKeys("Leap");
    	driver.findElement(By.id("score3")).sendKeys("5");
     }
        driver.findElement(By.id("create_question")).click();
     System.out.println("Done");
           
    
     	 
     }
     
	 public  static void BothWithoutBreak(WebDriver driver) throws Exception
     {
     driver.findElement(By.id("challengename")).sendKeys("Test5");
     Select select=new Select(driver.findElement(By.id("plan")));
     select.selectByVisibleText("Both Round Without Break");
     driver.findElement(By.id("mcq-time")).sendKeys("5");
     driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/div[4]/div/input")).sendKeys("Class");
     driver.findElement(By.id("pro-time")).sendKeys("5");
     driver.findElement(By.id("cut-off")).sendKeys("20");
     driver.findElement(By.linkText("Create Test")).click();
     Thread.sleep(1000);
     driver.findElement(By.linkText("Create new question")).click();
     Thread.sleep(3000);
     
     Select select1=new Select(driver.findElement(By.id("insert_question_type")));
     select1.selectByVisibleText("Multiple Choice Question");
     driver.findElement(By.id("question_title")).sendKeys("Interface");
     Thread.sleep(3000);
     driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+"how to call interface method?");
     Select select3=new Select(driver.findElement(By.id("mcq_type")));
     select3.selectByVisibleText("Choice");
     driver.findElement(By.id("option_1")).sendKeys("Create a subclass and must define "
     		+ "the inteface method and create the object for Subclass");
     driver.findElement(By.id("option_2")).sendKeys("Directly Access with Object");
     driver.findElement(By.id("option_3")).sendKeys("Using Constructor");
     driver.findElement(By.id("option_4")).sendKeys("All of the Above");
     driver.findElement(By.id("option_5")).sendKeys("Create a subclass and must define "
     		+ "the inteface method and create the object for Subclass");
     Select select4=new Select(driver.findElement(By.id("answer")));
     select4.selectByVisibleText("Option 5");
     Select select5=new Select(driver.findElement(By.id("group_title_select")));
     select5.selectByVisibleText("Class");
     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/input")).sendKeys("Java");
     driver.findElement(By.id("create_question")).click();
     System.out.println(" choice option Done");
     Thread.sleep(1000);
     
     driver.findElement(By.linkText("Create new question")).click();
     Thread.sleep(3000);
     
     //Create Fill Type
     Select select2=new Select(driver.findElement(By.id("insert_question_type")));
     select2.selectByVisibleText("Multiple Choice Question");
     driver.findElement(By.id("question_title")).sendKeys("Interface");
     Thread.sleep(1000);
     driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+"how to call interface method?");
     Thread.sleep(3000);
     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[1]/div/div/span[1]/span[2]/span[4]/span[3]/a[4]/span[1]")).click();
     driver.findElement(By.id("cke_135_label")).click();
     Thread.sleep(5000);
     Select select6=new Select(driver.findElement(By.id("mcq_type")));
     select6.selectByVisibleText("Fill");
     driver.findElement(By.id("fill_in_answer")).sendKeys("Create Sub Class and should define Interface method");
     Select select7=new Select(driver.findElement(By.id("group_title_select")));
     select7.selectByVisibleText("Class");
     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/input")).sendKeys("Java");
     driver.findElement(By.id("create_question")).click();
     System.out.println("Fill Option Done");
     Thread.sleep(1000);
    
     driver.findElement(By.linkText("Create new question")).click();
     Thread.sleep(5000);
     //Select Programming Option
     Select select9=new Select(driver.findElement(By.id("insert_question_type")));
     select9.selectByVisibleText("Programming Question");
     driver.findElement(By.id("question_title")).sendKeys("Abstract");
     Thread.sleep(6000);
     driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+"Write Program Leap Year or Not?");
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/input")).sendKeys("Java");
     Select select8=new Select(driver.findElement(By.id("difficulty")));
     select8.selectByVisibleText("EASY");
     WebElement option=driver.findElement(By.id("show1"));
     option.click();
     if(option.isSelected())
    	 
     {
    	driver.findElement(By.id("input1")).sendKeys("2000");
    	driver.findElement(By.id("output1")).sendKeys("Leap");
    	driver.findElement(By.id("score1")).sendKeys("5");
     }
     WebElement option1=driver.findElement(By.id("show2"));
     option1.click();
     if(option1.isSelected())
    	 
     {
    	driver.findElement(By.id("input2")).sendKeys("2001");
    	driver.findElement(By.id("output2")).sendKeys("Not Leap");
    	driver.findElement(By.id("score2")).sendKeys("5");
     }
     WebElement option2=driver.findElement(By.id("show3"));
     option2.click();
     if(option2.isSelected())
    	 
     {
    	driver.findElement(By.id("input3")).sendKeys("2002");
    	driver.findElement(By.id("output3")).sendKeys("Leap");
    	driver.findElement(By.id("score3")).sendKeys("5");
     }
        driver.findElement(By.id("create_question")).click();
     System.out.println("Done");
           
    
     
     }
	 public  static void BothWithSummary(WebDriver driver) throws Exception
     {
     driver.findElement(By.id("challengename")).sendKeys("Test6");
     Select select=new Select(driver.findElement(By.id("plan")));
     select.selectByVisibleText("Both Round With Break and Summary Test");
     driver.findElement(By.id("mcq-time")).sendKeys("5");
     driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/div[4]/div/input")).sendKeys("Class");
     driver.findElement(By.id("pro-time")).sendKeys("5");
     driver.findElement(By.id("summary-time")).sendKeys("30");
     driver.findElement(By.linkText("Create Test")).click();
     Thread.sleep(1000);
     
     driver.findElement(By.linkText("Create new question")).click();
     Thread.sleep(5000);
     //Select Programming Option
     Select select9=new Select(driver.findElement(By.id("insert_question_type")));
     select9.selectByVisibleText("Programming Question");
     driver.findElement(By.id("question_title")).sendKeys("Abstract");
     Thread.sleep(6000);
     driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+"Write Program Leap Year or Not?");
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/input")).sendKeys("Java");
     Select select8=new Select(driver.findElement(By.id("difficulty")));
     select8.selectByVisibleText("EASY");
     WebElement option=driver.findElement(By.id("show1"));
     option.click();
     if(option.isSelected())
    	 
     {
    	driver.findElement(By.id("input1")).sendKeys("2000");
    	driver.findElement(By.id("output1")).sendKeys("Leap");
    	driver.findElement(By.id("score1")).sendKeys("5");
     }
     WebElement option1=driver.findElement(By.id("show2"));
     option1.click();
     if(option1.isSelected())
    	 
     {
    	driver.findElement(By.id("input2")).sendKeys("2001");
    	driver.findElement(By.id("output2")).sendKeys("Not Leap");
    	driver.findElement(By.id("score2")).sendKeys("5");
     }
     WebElement option2=driver.findElement(By.id("show3"));
     option2.click();
     if(option2.isSelected())
    	 
     {
    	driver.findElement(By.id("input3")).sendKeys("2002");
    	driver.findElement(By.id("output3")).sendKeys("Leap");
    	driver.findElement(By.id("score3")).sendKeys("5");
     }
        driver.findElement(By.id("create_question")).click();
     System.out.println("Done");
    //create summary Question
     driver.findElement(By.linkText("Create new question")).click();
     Thread.sleep(1000);
     Select select10=new Select(driver.findElement(By.id("insert_question_type")));
     select10.selectByVisibleText("Summary Question");
     driver.findElement(By.id("question_title")).sendKeys("Interface");
     driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+"how to call interface method?");
     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div/div/input")).sendKeys("Java");
     driver.findElement(By.id("create_question")).click();
     System.out.println("Done");

     }


	public static void main(String[] args) throws Exception {
		//Launch the FireFox
		 System.setProperty("webdriver.gecko.driver", "D:\\Java\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		        driver=new FirefoxDriver();
		        driver.get("http://10.7.150.41/guvi_web");
		        driver.manage().window().maximize();
		        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\1.png");
		        //click the SignIn Button
		        driver.findElement(By.linkText("Log In")).click();
		        driver.findElement(By.id("login_email")).sendKeys("gofrugal@guvi.in");
		        driver.findElement(By.id("login_password")).sendKeys("guviGEEK");
		        driver.findElement(By.id("login_button")).click();
		        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\2.png");
		        Thread.sleep(5000);
		        driver.findElement(By.className("glyphicon-pencil")).click();
		        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\3.png");
		        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[1]/div[2]/button")).click();
		        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\MCQ\\4.png");
		        Thread.sleep(3000);
		        mcqQuestionChoice(driver);
		        //Programming(driver);
		        //Summary(driver);
		        //BothWithBreak(driver);
		        //BothWithoutBreak(driver);
		        //BothWithSummary(driver);
		        
		        
	
		        
		       

}
}