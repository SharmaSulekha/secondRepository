package utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SyncWaits extends CommonClass {
	public SyncWaits() throws IOException {
		super();
		
	}

	public static WebDriver driver;
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	public void explicitWait() {
		WebDriverWait wait = new WebDriverWait(driver,10);
	WebElement element=	wait.until(ExpectedConditions.visibilityOfElementLocated(findLocator("id","")));
	}
	
	public void fluentWaits() {
		Wait wait = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.SECONDS).ignoring(IOException.class);
		
	}
}
