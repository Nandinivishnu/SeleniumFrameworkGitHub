package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import pom.CreateProductPage1;
import pom.HomePage;
import pom.LoginPage;
import pom.ValidationAndVerificationPage;

public class CreateCampaignWithProductTest extends BaseClass {
	@Test(groups="sanitytest")
	public void createCampaignWithProduct() throws Throwable {

		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.implicitlywait(driver);

		HomePage homepage = new HomePage(driver);
		homepage.homePageLinkOfProd();

		CreateProductPage1 prod = new CreateProductPage1(driver);
		prod.productCreateLink();

		Java_Utility jlib = new Java_Utility();
		int RanNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String productData = elib.getExcelDataFormatter("product", 0, 0) + RanNum;

		prod.productNameText(productData);

		prod.savelink();

		homepage.homePageLinkOfmore();

		homepage.homePageLinkOfcampaigns();

		CreateCampaignWithProductPage campaignwithProductPage = new CreateCampaignWithProductPage(driver);
		campaignwithProductPage.createCampaignImageLink();

		
		String campData = elib.getExcelDataFormatter("campaign", 0, 0) + RanNum;

		campaignwithProductPage.campaignNameTextFieldBox(campData);

		campaignwithProductPage.productLinkImageLink();

		wlib.switchWindow(driver, "Products&action");

		campaignwithProductPage.searchTextFieldBox(productData);

		campaignwithProductPage.searchButtonLink();

		driver.findElement(By.xpath("//a[text()='" + productData + "']")).click();

		wlib.switchWindow(driver, "Campaigns&action");

		campaignwithProductPage.saveButtonLink();

		ValidationAndVerificationPage vpage = new ValidationAndVerificationPage(driver);
		vpage.campaignValidation(driver, campData);

		vpage.productDataValidation(driver, productData);

	}

}
