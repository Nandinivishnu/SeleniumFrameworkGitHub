package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.Property_Utility;

public class FirefoxBrowser {

	public static void main(String[] args) {
		String key = "webdriver.gecko.driver";
		String Value = "./src/main/resources/geckodriver1.exe";
		System.setProperty(key, Value);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://online.qspiders.com/classes/d35ad98c-d79c-4380-a3b9-413bdccafdea");
	}

}
