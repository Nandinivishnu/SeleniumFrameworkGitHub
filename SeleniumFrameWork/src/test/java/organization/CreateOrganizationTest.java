package organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Property_Utility;
import generic_utility.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.CreateOrganizationPage1;
import pom.CreateProductPage1;
import pom.HomePage;
import pom.LoginPage;
import pom.ValidationAndVerificationPage;
@Listeners(generic_utility.ListenerClass.class)
public class CreateOrganizationTest extends BaseClass {
	
	//@Test(groups = "smoketest")
	@Test(retryAnalyzer = generic_utility.RetryExample.class)
	public void createOrganization() throws Throwable {

		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.implicitlywait(driver);

		HomePage homepage = new HomePage(driver);
		homepage.homePageLinksOfOrg();
		homepage.getOrganizationlink();
		Assert.assertEquals(false,true);
		CreateOrganizationPage1 org = new CreateOrganizationPage1(driver);
		org.OrganizationCreatelink();

		Java_Utility jlib = new Java_Utility();
		int RanNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String exceldata = elib.getExcelDataFormatter("organization", 0, 0) + RanNum;

		org.organizationName(exceldata);

		org.savelink();

		ValidationAndVerificationPage vpage = new ValidationAndVerificationPage(driver);
		String actData = vpage.organizationDataValidation(driver, exceldata);
		Assert.assertEquals(actData, exceldata);
		Thread.sleep(5000);
	

	}
	
	
	
	
	

}
