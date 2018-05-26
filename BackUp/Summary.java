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

public class Summary {

	static WebDriver driver;
	//Taking Screenshot Method
		public static void getScreenShot(WebDriver driver, String screenShotName) throws IOException 
		{
					
			TakesScreenshot src = ((TakesScreenshot) driver);
			File file = src.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(screenShotName));		
		}
	 
	public static void main(String[] args) throws Exception {
		   //Launch the FireFox
		    System.setProperty("webdriver.gecko.driver", "D:\\Java\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	        driver=new FirefoxDriver();
	        driver.get("http://10.7.150.41/guvi_web");
	        driver.manage().window().maximize();
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\1.png");
	        
	        //click the SignIn Button
	        driver.findElement(By.linkText("Log In")).click();
	        driver.findElement(By.id("login_email")).sendKeys("gofrugal@guvi.in");
	        driver.findElement(By.id("login_password")).sendKeys("guviGEEK");
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\2.png");
	        driver.findElement(By.id("login_button")).click();
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\3.png");
	        Thread.sleep(5000);
	        
	        //Click the New Test
	        driver.findElement(By.className("glyphicon-pencil")).click();
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\4.png");
	        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[1]/div[2]/button")).click();
	        Thread.sleep(3000);
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\5.png");
	        Thread.sleep(1000);
	        driver.findElement(By.id("challengename")).sendKeys("Test3");
	        Select select=new Select(driver.findElement(By.id("plan")));
	        select.selectByVisibleText("Only Summary Round");
	        driver.findElement(By.id("summary-time")).sendKeys("10");
	        driver.findElement(By.linkText("Create Test")).click();
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\6.png");
	        Thread.sleep(1000);
	        
	        driver.findElement(By.linkText("Create new question")).click();
	        Thread.sleep(1000);
	        
	        //Create New Question
	        driver.findElement(By.id("question_title")).sendKeys("Interface");
	        Thread.sleep(3000);
	        driver.findElement(By.id("question_title")).sendKeys(Keys.TAB+"how to call interface method?");
	        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div/div/input")).sendKeys("Java");
	        driver.findElement(By.id("create_question")).click();
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\7.png");
	        System.out.println("Done");
	   		Thread.sleep(2000);
	   		
	   		//Check the Edit Option
	        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div/ul[1]/li[1]/div/div[1]/div/a/div/div[4]/div/div[1]/span")).click();
	        Thread.sleep(2000);
	        
	        WebElement element=driver.findElement(By.id("question_title"));
	        element.sendKeys(Keys.TAB);
	        element.clear();
	        element.sendKeys("Updated Test");
	        element.sendKeys(Keys.TAB+"Updated Test ");
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\8.png");
	        driver.findElement(By.id("create_question")).click();
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\9.png");
	        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div/ul[1]/li/div/div[1]/div/a/div/div[1]")).click();
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\10.png");
	        System.out.println("Edit Option Done");
	        
	        //Check the Delete Option
	        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div/ul[1]/li/div/div[1]/div/a/div/div[4]/div/div[2]/span")).click();
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\11.png");
	        System.out.println("Delete Option Done");
	        Thread.sleep(1000);
	        
	        //Add from Library Question
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\12.png");
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/a[1]")).click();
	        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[2]/ul[1]/li[2]/div/div[1]/div/div/a/div[1]")).click();
	        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[2]/ul[1]/li[2]/div/div[1]/div/div/div/button")).click();
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\13.png");
	        System.out.println("Added Sucess");
	        
	        //Check Added or Not
	        driver.findElement(By.className("glyphicon-pencil")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/ul[1]/li[1]/div/div[1]/div/a")).click();
	        Thread.sleep(1000);
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\14.png");
	        System.out.println("Question Added From Library");
	        Thread.sleep(1000);
	        
	        //Remove from the Test
	        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/ul[2]/li[4]/a")).click();
	        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[2]/ul[1]/li[2]/div/div[1]/div/div/div/button")).click();
	        System.out.println("Remove the Added Question From Library");
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\15.png");
	        System.out.println("Remove Sucess");
	        
	        //Final Check
	        driver.findElement(By.className("glyphicon-pencil")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/ul[1]/li[1]/div/div[1]/div/a")).click();
	        Thread.sleep(1000);
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\16.png");
	        
	   		 		        
		    //Share Test
		    Thread.sleep(2000);
	        driver.findElement(By.linkText("Share Test")).click();
	        driver.findElement(By.id("college")).sendKeys("ChennaiRegion");
	        driver.findElement(By.id("college")).sendKeys(Keys.TAB);
		    driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[4]/td[4]/a")).click();
	        driver.findElement(By.id("custom_url")).sendKeys("SRM_EEE1");
	        Thread.sleep(3000);
	        Select select11=new Select(driver.findElement(By.id("expiry_limit")));
	        select11.selectByVisibleText("In 24 hours");
	        driver.findElement(By.id("invite_access_code")).sendKeys("SRMUsers");
	        driver.findElement(By.id("create_access_code")).click();
	        getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\17.png");
	        System.out.println("Share Test Done");
	       		      	      
		    //update
	        driver.findElement(By.id("headingTwo")).click();
	        driver.findElement(By.id("code")).clear();   
	        driver.findElement(By.id("code")).sendKeys("SRMUsers");
	        Select s1=new Select(driver.findElement(By.id("update_expiry_limit")));
	        s1.selectByVisibleText("Custom");
	        driver.findElement(By.id("update_expiry_date"));
	        driver.findElement(By.className("ui-state-default"));
	        Select s2=new Select(driver.findElement(By.id("update_expiry_time")));
		   	s2.selectByVisibleText("01:30");
		   	driver.findElement(By.id("code_submit")).click();
		   	getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\18.png");
		   	System.out.println("URL Updated Done");
		   	
		   	//Share URL
		   	driver.findElement(By.id("headingThree")).click();
		   	WebElement element1=driver.findElement(By.id("post_job_checkbox"));
		   	element1.click();
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
		   	getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\19.png");
		   	System.out.println("Post Job is Done");
		   	Thread.sleep(1000);
		   	
		   	//Check the URL
	    	driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/ul[2]/li[7]/a")).click();
	    	Thread.sleep(1000);
	    	getScreenShot(driver,"D:\\ranjani\\java\\testSelenium\\ScreenShot\\TestFlow\\Summary\\20.png");
	    	
		   	

		

	}

}
