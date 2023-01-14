package cucumbertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginTest {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver-v0.32.0-win64\\geckodriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("http://adactinhotelapp.com");

		driver.manage().window().maximize();
		WebElement uName = driver.findElement(By.id("username"));
		uName.sendKeys("raniselen");
		driver.findElement(By.id("password")).sendKeys("adactin");
		driver.findElement(By.cssSelector("input#login")).click();
	}

}
