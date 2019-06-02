package FbLogin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	static WebDriver driver;
	static Properties prop;
	
	public BaseClass() throws IOException {
		//get propertiesFilepath
		String propFilePath = System.getProperty("user.dir")+"//src//main//java//testData//env.properties";
		FileInputStream fis =new FileInputStream(propFilePath);
		prop = new Properties();
		prop.load(fis);	
	}
	
	public void invokeBrowser(String browser, String hPath) {
		if (browser.equals("chrome")) {
			String driverPath = System.getProperty("user.dir") + "//src//" + hPath;
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		} else if (browser.equals("Internet Explorer")) {

			String driverPath = System.getProperty("user.dir") + "//src//Browsers//IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", driverPath);
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Install required driver");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void launchApplication(String Url) {
		driver.get(Url);
	}

}
