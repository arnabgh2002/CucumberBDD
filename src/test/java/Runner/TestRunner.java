package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cucumber.listener.Reporter;

import Base.Base;
import Util.constants;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Features", //the path of the feature files
		glue={"stepDefinations"}, //the path of the step definition files
		format= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
		plugin={ "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome = true, //display the console output in a proper readable format
		strict = true, //it will check if any step is not defined in step definition file
		dryRun = false, //to check the mapping is proper between feature file and step def file
		tags = {"@demo"}			
		)

public class TestRunner extends Base{

	 @AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File(configData.getProperty("reportConfigPath")));
		
     Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
     Reporter.setSystemInfo("Selenium", "3.7.0");
     Reporter.setSystemInfo("Maven", "3.5.2");
     Reporter.setSystemInfo("Java Version", "1.8.0_151");

	 }
	 
	 @Before
	 public static void initializeExtentReport(){
		//Extent Report
		  constants.extent=new ExtentReports();
	 }
}
