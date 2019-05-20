package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


public class Base {

	public static WebDriver driver; 
	public static Properties configData=new Properties();
	
	public Base(){
		ReadConfigData();
	}
	
	public void initiateWebdriver(){
		DesiredCapabilities cap;
//		public String Node;
		try{
//			String test=System.getProperty("user.dir")+"\\chromedriver.exe";
//			System.out.println(test);
			String browserName=configData.getProperty("Browser");
			if(browserName.equalsIgnoreCase("Chrome")){
				if(configData.getProperty("ParallelExecution").equalsIgnoreCase("Yes")){
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");	

					cap = DesiredCapabilities.chrome();
					cap.setBrowserName("chrome");
					cap.setPlatform(Platform.WIN10);
//					cap.setBrowserName(browserName);
//					cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
					String nodeUrl=configData.getProperty("seleniumGridNodeURL");
					driver = new RemoteWebDriver(new URL(nodeUrl),cap);
					// Puts an Implicit wait, Will wait for 10 seconds before throwing exception
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.manage().window().maximize();
					driver.get(configData.getProperty("URL"));
				}else{
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");				
					driver=new ChromeDriver();					
					// Puts an Implicit wait, Will wait for 10 seconds before throwing exception
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.manage().window().maximize();
					System.out.println(configData.getProperty("URL"));
					driver.get(configData.getProperty("URL"));
				}
				
			}else if (browserName.equalsIgnoreCase("FF")){
				System.out.println("\nBrower=FF");				
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");	
				driver = new FirefoxDriver(); 
				driver.manage().window().maximize();
				System.out.println("Login URL::-"+configData.getProperty("URL"));
				driver.get(configData.getProperty("URL"));
			}else{
				System.out.println("Invalid Browser");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
//		return driver;
	}
	
	
	public static void ReadConfigData(){
		File configFile = new File(System.getProperty("user.dir")+"\\Config.xml");
		//File configFile = new File("config.properties");
		
		try {
			FileInputStream reader = new FileInputStream(configFile);
			//Properties props = new Properties();
			configData.loadFromXML(reader);
		
			String url = configData.getProperty("URL");		
			System.out.print("\nLogin url is: " + url);
			reader.close();
		} catch (FileNotFoundException ex) {
			// file does not exist
		} catch(IOException ex){
			// I/O exception
		}
	}
	
	
	
}
