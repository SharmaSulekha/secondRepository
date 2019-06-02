package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class CommonClass {
	public static WebDriver driver;
	public static Properties prop;
	public static Properties testDataProp;
	public CommonClass() throws IOException {
		//get propertiesFilepath
		String propFilePath = System.getProperty("user.dir")+"\\src\\TestData\\env.properties";
		FileInputStream fis = new FileInputStream(propFilePath); 
		prop = new Properties();
		prop.load(fis);
		
		//testData Sheet
		String propTestDataFilePath = System.getProperty("user.dir")+"\\src\\TestData\\testData.properties";
		FileInputStream fis1 = new FileInputStream(propTestDataFilePath); 
		testDataProp = new Properties();
		testDataProp.load(fis1);
		
		
	}

	
	 

	public By findLocator(String loc, String lValue) {
		By ref = null;
		switch (loc) {
		case "id":
		ref=	By.id(lValue);
			break;
		case "name":
			ref =By.name(lValue);
			break;
		case "class":
			ref = By.className(lValue);
			break;
		case "linkText":
			ref =By.linkText(lValue);
			break;
		case "partialLinkText":
			ref= By.partialLinkText(lValue);
			break;
		case "xpath":
			ref = By.xpath(lValue);
			break;
		case "CSS":
			ref = By.cssSelector(lValue);
			break;
		case "tagName":
			ref = By.tagName(lValue);
			break;
		default:
			System.out.println("Use a valid Locator");
			break;
		}
		return ref;
	}

	public void clickElm(String locator, String locValue) {
		driver.findElement(findLocator(locator,locValue)).click();
	}
	public void sendElm(String locator, String locValue, String sendVal) {
		driver.findElement(findLocator(locator,locValue)).sendKeys(sendVal);;
	}
	
	public void sendElm(String elmLocator) {
		String[] arr = elmLocator.split("####");
		driver.findElement(findLocator(arr[0],arr[1])).sendKeys(arr[2]);;
	}

	
	}
	
	
	
	
	/*public static void main(String args[]) {
		CommonClass cc = new CommonClass();
		String path = "Browsers//chromedriver.exe";
		cc.invokeBrowser("chrome", path);
		cc.launchApplication("file:///E:/Selenium_Tutorials/Documents/Practice/template_7/index.html");
		cc.clickElm("xpath", "//a/h3[text()='HTML Elements Locators']");
		cc.sendElm("xpath", "//input[@id='name']", "Sulekha");
		
	}*/


