package Guru99Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class guruDemoSiteTestCases {
	
	public static WebDriver driver;
	String Customer_ID;
	String expectedTextadd = "Congratulation you add Tariff Plan";
	String expectedTxtassigned = "Congratulation Tariff Plan assigned";
	
	@BeforeTest
	public void browserSetup() {
//		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver","D:\\Flutter\\AppiumDemo\\drivers\\chromedriver-win64\\chromedriver.exe");
//		driver = new ChromeDriver();
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://demo.guru99.com/telecom/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test(priority = 1)
	public void addCustomer(){
		driver.findElement(By.xpath("//section[@id=\"one\"]/descendant::a[text()='Add Customer']")).click();
//		WebElement frame = driver.findElement(By.xpath("//iframe[@id=\"google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0\"]"));
//		driver.switchTo().frame(frame);
//		driver.findElement(By.xpath("//div[@id=\"dismiss-button\"]/child::div")).click();
//		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//label[text()='Done']")).click();
		driver.findElement(By.xpath("//input[@id=\"fname\"]")).sendKeys("Guru");
		driver.findElement(By.xpath("//input[@id=\"lname\"]")).sendKeys("Telecom");
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("guru.telecom@gmail.com");
		driver.findElement(By.xpath("//textarea[@id=\"message\"]")).sendKeys("123 Main Street Sector 45 Gurgaon Haryana 122018");
		driver.findElement(By.xpath("//input[@id=\"telephoneno\"]")).sendKeys("9822347836");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		Customer_ID = driver.findElement(By.xpath("//b[text()='Customer ID']/parent::td/following-sibling::td[@align=\"center\"]/child::h3")).getText();
		System.out.println(Customer_ID);
		driver.findElement(By.xpath("//li[@style=\"text-align:center\"]/child::a[text()='Home']")).click();
	}
	
	@Test(priority = 2)
	public void addTariffPlan() {
		driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();
		driver.findElement(By.xpath("//input[@id=\"rental1\"]")).sendKeys("249");
		driver.findElement(By.xpath("//input[@id=\"local_minutes\"]")).sendKeys("35");
		driver.findElement(By.xpath("//input[@id=\"inter_minutes\"]")).sendKeys("12");
		driver.findElement(By.xpath("//input[@id=\"sms_pack\"]")).sendKeys("100");
		driver.findElement(By.xpath("//input[@id=\"minutes_charges\"]")).sendKeys("1");
		driver.findElement(By.xpath("//input[@id=\"inter_charges\"]")).sendKeys("3");
		driver.findElement(By.xpath("//input[@id=\"sms_charges\"]")).sendKeys("4");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		String confirmation = driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']")).getText();
		Assert.assertEquals(confirmation, expectedTextadd);
		driver.findElement(By.xpath("//li[@style=\"text-align:center\"]/child::a[text()='Home']")).click();
	}
	
	@Test(priority = 3)
	public void addTariffPlantoCustomer() {
		driver.findElement(By.xpath("//section[@id='one']/descendant::a[text()='Add Tariff Plan to Customer']")).click();
		driver.findElement(By.xpath("//input[@id=\"customer_id\"]")).sendKeys(Customer_ID);
		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
		WebElement label = driver.findElement(By.xpath("//label[@for='sele']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", label);
		driver.findElement(By.xpath("//input[@value='Add Tariff Plan to Customer']")).click();
		String AssignedPlan = driver.findElement(By.xpath("//h2[text()='Congratulation Tariff Plan assigned']")).getText();
		Assert.assertEquals(AssignedPlan, expectedTxtassigned);
		driver.findElement(By.xpath("//li[@style=\"text-align:center\"]/child::a[text()='Home']")).click();
        }
		
	
	@AfterTest
	public void closetheBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
}
