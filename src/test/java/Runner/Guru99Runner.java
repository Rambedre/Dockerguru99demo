package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features={"classpath:Guru99feature"}, 
		glue={"StepDEf"},
		plugin={"pretty",
				"html:target/cucumber-report/amazonreports.html",
				"json:target/cucumber-report.json",
				"rerun:target/failedrun.txt"}
)

public class Guru99Runner extends AbstractTestNGCucumberTests{

}
