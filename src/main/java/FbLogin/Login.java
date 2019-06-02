package FbLogin;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.CommonClass;

public class Login extends CommonClass{
	public Login() throws IOException {
		super();
	}

	static WebDriver driver;
	//private static WebElement element;



	public void getUrl() {
	 driver.get("https://www.facebook.com");
	}
	
	public void loginCheck() {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sulekha.sharma.9");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("lamakbhai");
		driver.findElement(By.xpath("//input[@value='log in']")).click();
	}
	

}
