package runner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src/test/resources/features"},
		
		plugin = {"pretty", "html:target/result.html",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		glue= {"step_definitions","pages","app_hooks",},
		dryRun = false
		)
public class TestNGrunner extends AbstractTestNGCucumberTests{

	
	@Override
	@DataProvider(parallel = false) public Object[][] scenarios() {

		return super.scenarios(); }

}
