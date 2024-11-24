package StepDEf;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class guru99StepDef {

	
	String Customer_ID;
	String expectedTextadd = "Congratulation you add Tariff Plan";
	String expectedTxtassigned = "Congratulation Tariff Plan assigned";

	@Given("Run Scenario to add customer")
	public void run_scenario_to_add_customer() {
		guruAppHooks.driver.findElement(By.xpath("//section[@id='one']/descendant::a[text()='Add Customer']")).click();
//      WebElement frame = guruAppHooks.driver.findElement(By.xpath("//iframe[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']"));
//      guruAppHooks.driver.switchTo().frame(frame);
//      guruAppHooks.driver.findElement(By.xpath("//div[@id='dismiss-button']/child::div")).click();
//      guruAppHooks.driver.switchTo().parentFrame();
		guruAppHooks.driver.findElement(By.xpath("//label[text()='Done']")).click();
		guruAppHooks.driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("Guru");
		guruAppHooks.driver.findElement(By.xpath("//input[@id='lname']")).sendKeys("Telecom");
		guruAppHooks.driver.findElement(By.xpath("//input[@id='email']")).sendKeys("guru.telecom@gmail.com");
		guruAppHooks.driver.findElement(By.xpath("//textarea[@id='message']"))
				.sendKeys("123 Main Street Sector 45 Gurgaon Haryana 122018");
		guruAppHooks.driver.findElement(By.xpath("//input[@id='telephoneno']")).sendKeys("9822347836");
		guruAppHooks.driver.findElement(By.xpath("//input[@type='submit']")).click();
		Customer_ID = guruAppHooks.driver
				.findElement(By
						.xpath("//b[text()='Customer ID']/parent::td/following-sibling::td[@align='center']/child::h3"))
				.getText();
		System.out.println(Customer_ID);
		guruAppHooks.driver.findElement(By.xpath("//li[@style='text-align:center']/child::a[text()='Home']")).click();
	}

	@Given("Run Scenario To Add Tariff Plan")
	public void run_scenario_to_add_tariff_plan() {
		guruAppHooks.driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();
		guruAppHooks.driver.findElement(By.xpath("//input[@id='rental1']")).sendKeys("249");
		guruAppHooks.driver.findElement(By.xpath("//input[@id='local_minutes']")).sendKeys("35");
		guruAppHooks.driver.findElement(By.xpath("//input[@id='inter_minutes']")).sendKeys("12");
		guruAppHooks.driver.findElement(By.xpath("//input[@id='sms_pack']")).sendKeys("100");
		guruAppHooks.driver.findElement(By.xpath("//input[@id='minutes_charges']")).sendKeys("1");
		guruAppHooks.driver.findElement(By.xpath("//input[@id='inter_charges']")).sendKeys("3");
		guruAppHooks.driver.findElement(By.xpath("//input[@id='sms_charges']")).sendKeys("4");
		guruAppHooks.driver.findElement(By.xpath("//input[@type='submit']")).click();
		String confirmation = guruAppHooks.driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']"))
				.getText();
		Assert.assertEquals(confirmation, expectedTextadd);
		guruAppHooks.driver.findElement(By.xpath("//li[@style='text-align:center']/child::a[text()='Home']")).click();
	}

	@Then("Run scenario to add tarrif plan to customer")
	public void run_scenario_to_add_tarrif_plan_to_customer() {
		guruAppHooks.driver.findElement(By.xpath("//section[@id='one']/descendant::a[text()='Add Tariff Plan to Customer']"))
				.click();
		guruAppHooks.driver.findElement(By.xpath("//input[@id='customer_id']")).sendKeys(Customer_ID);
		guruAppHooks.driver.findElement(By.xpath("//input[@name='submit']")).click();
		WebElement label = guruAppHooks.driver.findElement(By.xpath("//label[@for='sele']"));
		JavascriptExecutor js = (JavascriptExecutor) guruAppHooks.driver;
		js.executeScript("arguments[0].click();", label);
		guruAppHooks.driver.findElement(By.xpath("//input[@value='Add Tariff Plan to Customer']")).click();
		String AssignedPlan = guruAppHooks.driver.findElement(By.xpath("//h2[text()='Congratulation Tariff Plan assigned']"))
				.getText();
		Assert.assertEquals(AssignedPlan, expectedTxtassigned);
		guruAppHooks.driver.findElement(By.xpath("//li[@style='text-align:center']/child::a[text()='Home']")).click();
	}

}
