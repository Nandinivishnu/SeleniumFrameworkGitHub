package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Property_Utility;
import generic_utility.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.CreateCampaignWithProductPage;
import pom.HomePage;
import pom.LoginPage;
import pom.ValidationAndVerificationPage;

public class CreateCampaignTest extends BaseClass {
	@Test(groups = {"smoketest","regressiontest","sanitytest"})
	public void createCampaign() throws Throwable {

		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.implicitlywait(driver);

		HomePage homepage = new HomePage(driver);
		homepage.homePageLinkOfmore();

		homepage.homePageLinkOfcampaigns();

		CreateCampaignWithProductPage campaignwithProductPage = new CreateCampaignWithProductPage(driver);
		campaignwithProductPage.createCampaignImageLink();

		Java_Utility jlib = new Java_Utility();
		int RanNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String campData = elib.getExcelDataFormatter("campaign", 0, 0) + RanNum;

		campaignwithProductPage.campaignNameTextFieldBox(campData);

		campaignwithProductPage.saveButtonLink();

		ValidationAndVerificationPage vpage = new ValidationAndVerificationPage(driver);
		vpage.campaignValidation(driver, campData);

		
	}

}
