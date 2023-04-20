package product;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Property_Utility;
import generic_utility.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.CreateProductAndDeleteProductPage;
import pom.HomePage;
import pom.LoginPage;
import pom.ValidationAndVerificationPage;

@Test(groups= {"smoketest","sanitytest","regressiontest"})
public class CreateProductDeleteProductTest extends BaseClass {

	public void createProductDeleteProduct() throws Throwable {

		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.implicitlywait(driver);

		HomePage homepage = new HomePage(driver);
		homepage.homePageLinkOfProd();

		CreateProductAndDeleteProductPage createAndDelete = new CreateProductAndDeleteProductPage(driver);
		createAndDelete.createProductImageLink();

		Java_Utility jlib = new Java_Utility();
		int RanNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String productData = elib.getExcelDataFormatter("product", 0, 0) + RanNum;

		createAndDelete.productNameTextFieldLink(productData);

		createAndDelete.saveButtonLink();

		ValidationAndVerificationPage vpage = new ValidationAndVerificationPage(driver);
		vpage.productValidation(driver, productData);

		createAndDelete.productsLink();

		driver.findElement(By.xpath("//table[@class='lvt small']//tbody//td//a[text()='" + productData+ "']/../preceding-sibling::td//input[@type='checkbox']")).click();

		createAndDelete.deleteButtonlink();

		wlib.alertWindow(driver);

		List<WebElement> ele1 = driver.findElements(By.xpath("(//table[@class=\"lvt small\"]/tbody/tr/td[3])[position()>1]"));
		vpage.productDeleteValidation(ele1, productData);

	}

}
