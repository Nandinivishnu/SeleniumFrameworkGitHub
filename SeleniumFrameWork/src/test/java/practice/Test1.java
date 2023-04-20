package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Test1 {

	public static void main(String[] args) throws IOException {
		
	/*//WebDriver driver=new ChromeDriver();
	String key = "Webdriver.chrome.driver";
	 String value = "./src/main/resources/chromedriver.exe";
	 System.setProperty(key, value);
	 WebDriver driver=new ChromeDriver();
	 
	 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/
	 
		
		String key = "Webdriver.ie.driver";
		 String value = "./src/main/resources/IEDriverServer.exe.exe//";
		 System.setProperty(key, value);
		WebDriver driver=new InternetExplorerDriver();
		
		 driver.manage().window().maximize();
			
	/*WebDriver driver=new FirefoxDriver();
	
	 
	 FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties");
	  
	 Properties pro=new Properties();
	 
	  pro.load(fis);
	  
	  String url = pro.getProperty("url");
	 driver.get(url);
	  String username=pro.getProperty("username");
	  driver.get(username);
	  String password=pro.getProperty("password");
	driver.get(password);
	
	driver.get("url");
	driver.findElement(By.id("email")).sendKeys("username");
	driver.findElement(By.id("pass")).sendKeys("password");
	driver.findElement(By.id("u_0_5_Cv")).click();*/
	
	}

}
