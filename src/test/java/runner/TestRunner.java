package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import helpers.FileReaderManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/featurefiles", glue = { "stepdefinitions" })

public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		// Reporter.loadXMLConfig(new
		// File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		ExtentSparkReporter extentHtmlReporter = new ExtentSparkReporter(
				new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);

	}
}
