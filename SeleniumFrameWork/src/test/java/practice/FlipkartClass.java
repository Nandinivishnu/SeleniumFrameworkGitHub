package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.Webdriver_Utility;

public class FlipkartClass  {
	public static void main(String[] args) throws Throwable {
		String key = "webdriver.chrome.driver";
		String Value = "./src/main/resources/chromedriver.exe";
		System.setProperty(key, Value);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//div[@class='_36HLxm col col-3-5']")).click();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		 driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("iphone");
		
		 driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).submit();
		
		List<WebElement> products = driver.findElements(By.xpath("div[class='_2kHMtA']"));
		
		String iphoneName = driver.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 13 (Starlight, 128 GB)')]")).getText();
	
		FileInputStream fes = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.createSheet("sheetname");
		Row rowNum = sheet.createRow(0);
	//	 Cell cell = rowNum.createCell(0).setAsActiveCell();;
	
		
		
		
	
	
	
	
	}

	

}
