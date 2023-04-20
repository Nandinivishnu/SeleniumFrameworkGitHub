package generic_utility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;



public class Webdriver_Utility {
	/**
	 * used for page to wait to load
	 * @param driver
	 * @author nandini
	 * 
	 * 
	 */
	public void implicitlywait(WebDriver driver) {
		
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void switchWindow(WebDriver driver,String partialWindowTitle) {
	/**
	 * @param driver
	 * @param partialWindowTitle
	 * @author nandini
	 * 
	 * 	
	 */
		Set<String> allID = driver.getWindowHandles();//org //cont //prod
		Iterator<String> id = allID.iterator();

		while (id.hasNext()) {
			String wid = id.next();//org //cont 
			driver.switchTo().window(wid);
			String title = driver.getTitle();

			if (title.contains(partialWindowTitle)) {
				break;
			}

		}
		
	}
		
		
		public void alertWindow(WebDriver driver) {
			Alert alr = driver.switchTo().alert();
			alr.accept();
		}
		
	
	
}
