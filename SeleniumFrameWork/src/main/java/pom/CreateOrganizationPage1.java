package pom;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage1 {
//initialization
	public CreateOrganizationPage1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrganisationImage;

	@FindBy(name = "accountname")
	private WebElement organizationNameTextField;

	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement savebutton;

//getter methods
	/**
	 * 
	 * 
	 * @return
	 */
	public WebElement getCreateOrganisationImage() {
		return createOrganisationImage;
	}

	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	// business logic
	/**
	 * 
	 * THIS METHOD IS USED TO CLICK ON CREATE ORGANIZATION LINK
	 * 
	 */
	public void OrganizationCreatelink() {
		createOrganisationImage.click();
	}
	/**
	 * This method is used to type organization name in the text field
	 * @param orgName
	 */
	public void organizationName(String orgName) {
		organizationNameTextField.sendKeys(orgName);
	}
	/**
	 * This method is used to click save button
	 */
	public void savelink() {
		savebutton.click();
	}
}
