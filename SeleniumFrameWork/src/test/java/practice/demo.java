package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {
		public static void main(String[] args) throws Throwable, IOException {
			String key = "webdriver.chrome.driver";
			String Value = "D:\\advance selenium\\chromedriver.exe";
			System.setProperty(key, Value);
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			FileInputStream fis = new FileInputStream("D:\\advance selenium\\PropertyDataFile.properties");
			Properties pro = new Properties();
			pro.load(fis);
			String url = pro.getProperty("url");
			String username = pro.getProperty("username");
			String password = pro.getProperty("password");
			driver.get(url);

			// driver.get("http://localhost:8888/");
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();

			driver.findElement(By.xpath("//a[text()='Organizations']")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

			FileInputStream fes = new FileInputStream("D:\\advance selenium\\ExcelData.xlsx");
			Workbook book = WorkbookFactory.create(fes);
			Sheet sheet = book.getSheet("organization");
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			String exceldata = cell.getStringCellValue();

			driver.findElement(By.name("accountname")).sendKeys(exceldata);
			driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		}

	}


