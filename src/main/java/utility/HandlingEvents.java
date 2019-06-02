package utility;

import java.io.File;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HandlingEvents {
	public static WebDriver driver;
	public void handleDropDowns() {
		Select dd = new Select(driver.findElement(By.xpath("")));
		dd.selectByIndex(1);
		dd.selectByValue("abc");
		dd.selectByVisibleText("xyz");
	}
	
	public void dragAndDrops() {
		Actions dd = new Actions(driver);
		WebElement srcFile =  driver.findElement(By.id(""));
		WebElement destFile = driver.findElement(By.xpath(""));
		dd.dragAndDrop(srcFile, destFile);
	}
	
	public void captureScreenShots() {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File ("//E:/screenshotCapture");
		//FileUtils.copyFile(srcFile,destFile);
	}
	
	public void handleAlerts() {
		Alert alert =  driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		alert.getText();
}}
