package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.HomePage;
import pom.LoginPage;

public class BaseClass {
	public static WebDriver sdriver;
	public  WebDriver driver;

	@BeforeSuite(groups= {"smoketest","regressiontest","sanitytest"})
	public void BS() {
		System.out.println("databse connection");
	}

	@BeforeTest(groups= {"smoketest","regressiontest","sanitytest"})
	public void BT() {
		System.out.println("parallel execution");
	}
	
	//@Parameters ("browser")
	
	@BeforeClass(groups= {"smoketest","regressiontest","sanitytest"})
//public void BC(String browser) throws Throwable {
	public void BC() throws Throwable{
		Property_Utility plib = new Property_Utility();
		String browser = plib.getKeyValue("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		System.out.println("launching browser");
		sdriver=driver;
	}

	@BeforeMethod(groups= {"smoketest","regressiontest","sanitytest"})
	public void BM() throws Throwable {
		driver.manage().window().maximize();
		Property_Utility plib = new Property_Utility();
		String url = plib.getKeyValue("url");
		String username = plib.getKeyValue("username");
		String password = plib.getKeyValue("password");
		driver.get(url);

		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApp(username, password);

		System.out.println("login to application");
	}

	@AfterMethod(groups= {"smoketest","regressiontest","sanitytest"})
	public void AM() {
		HomePage homepage = new HomePage(driver);
		homepage.signoutimglink();
		homepage.signoutlink();
		System.out.println("logout to application");
	}

	@AfterClass(groups= {"smoketest","regressiontest","sanitytest"})
	public void AC() {
		driver.quit();
		System.out.println("closing browser");
	}

	@AfterTest(groups= {"smoketest","regressiontest","sanitytest"})
	public void AT() {
		System.out.println("parallel execution is done");
	}

	@AfterSuite(groups= {"smoketest","regressiontest","sanitytest"})
	public void AS() {
		System.out.println("databse connection closed");
	}

}
