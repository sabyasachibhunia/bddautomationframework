package stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import helpers.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void beforeScenario() {

	}

	@After(order = 1)
	public void afterScenario1(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver())
						.getScreenshotAs(OutputType.FILE);

				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/"
						+ screenshotName + ".png");

				Files.copy(sourcePath, destinationPath);

				//Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Screenshot capture is not successful");
			}
		}
	}

	@After(order = 0)
	public void afterScenario2() {
		testContext.getWebDriverManager().closeDriver();
	}}
