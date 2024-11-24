package StepDEf;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class guruAppHooks {
	public static WebDriver driver;
    String Host = "192.168.0.105";
    
    @Before
    public void browserSetup() {
        try {
            // Set up the desired capabilities
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome"); // or "firefox"
//            if(System.getProperty("HUB_HOST")!=null) {
//            	Host = System.getProperty("HUB_HOST"); 
//            }
            // Connect to the Selenium Grid Hub
            driver = new RemoteWebDriver(new URL("http://"+Host+":4444/wd/hub"), capabilities);
            driver.get("https://demo.guru99.com/telecom/index.html");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    
    @After
    public void closetheBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit(); // Use quit instead of close to ensure all resources are released
    }
    
}
