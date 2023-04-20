package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//create constructor(initialization)
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//declaration
		@FindBy(name="user_name")
		private WebElement usernameedttxt;
		
		@FindBy(name="user_password")
		private WebElement passwordedttxt;
		
		@FindBy(id="submitButton")
		private WebElement submittbtn;

		
		
		//utilization
		
		public WebElement getUsernameedttxt() {
			return usernameedttxt;
		}

		public WebElement getPasswordedttxt() {
			return passwordedttxt;
		}

		public WebElement getSubmittbtn() {
			return submittbtn;
		}
		
		//business logic
		/**
		 * 
		 * 
		 * create method
		 * @param username
		 * @param password
		 */
		public void loginToApp(String username,String password) {
			usernameedttxt.sendKeys(username);
			passwordedttxt.sendKeys(password);
			submittbtn.click();
}
}