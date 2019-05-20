package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Base.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class loginStepDefination extends Base{

	
	@Given("^user initiate browser and Opens the application$")
	public void user_initiate_browser_and_Opens_the_application() throws Exception {
		initiateWebdriver();
	}
}
