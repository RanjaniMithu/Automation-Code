import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class JsonFile {
    public static void main(String[] args) throws Exception {
        //Launch the FireFox
        System.setProperty("webdriver.gecko.driver", "/home/guvi/Downloads/geckodriver");
        //Set the Preference for Downloading JSON File
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList",2);
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
        firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
        firefoxProfile.setPreference("browser.download.dir","/home/guvi/eclipse-workspace/TestFlow/src/com/testflow/StaticTestAssesment");
        firefoxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/csv,application/json, text/csv,application/json, text/plain,application/octet-stream doc xls pdf txt");
        firefoxProfile.setPreference("browser.download.useDownloadDir", true);
        firefoxProfile.setPreference("browser.helperApps.neverAsk.openFile","application/json,text/plain");
        firefoxProfile.setPreference( "browser.download.manager.showWhenStarting", false );
        firefoxProfile.setPreference( "pdfjs.disabled", true );
        firefoxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        firefoxProfile.setPreference("browser.download.manager.focusWhenStarting", false);
        firefoxProfile.setPreference("browser.download.manager.useWindow", false);
        firefoxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
        firefoxProfile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
        firefoxProfile.setPreference("browser.download.manager.closeWhenDone", false);
        FirefoxOptions option=new FirefoxOptions();
        option.setProfile(firefoxProfile);
        //Passing Preference for Driver
        WebDriver driver=new FirefoxDriver(option);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.get("http://121.242.232.164/guvi-dev/autojson_test.html");
        Thread.sleep(3000);
        driver.findElement(By.id("email")).sendKeys("varun@guvi.in");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"generate\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"order\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"answer\"]")).click();
        Thread.sleep(3000);
}
}


