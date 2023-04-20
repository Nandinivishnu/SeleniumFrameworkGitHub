package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Browserlaunch {

	public static void main(String[] args) throws Throwable {
		String key = "webdriver.chrome.driver";
		String Value = "D:\\advance selenium\\chromedriver.exe";
		System.setProperty(key, Value);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		FileInputStream fis = new FileInputStream("./src/test/resources/PropertyDataFile.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		driver.get(url);
}
}