package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// create constructor(initialization)
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// pageFactory --> class
		// initElements -->static method
	}

	// declaration
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement organizationlink;

	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productlink;

	@FindBy(linkText = "More")
	private WebElement morelink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignslink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signout;

	// utilization
	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getProductlink() {
		return productlink;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getCampaignslink() {
		return campaignslink;
	}

	public WebElement getSignoutimg() {
		return signoutimg;
	}

	public WebElement getSignout() {
		return signout;
	}

	// business logic
	/**
	 * 
	 * click organization link
	 */
	public void homePageLinksOfOrg() {
		organizationlink.click();
	}

	/**
	 * 
	 * click product link
	 */
	public void homePageLinkOfProd() {
		productlink.click();

	}

	/**
	 * 
	 * click more link
	 */
	public void homePageLinkOfmore() {
		morelink.click();
	}

	/**
	 * 
	 * click campaigns link
	 */
	public void homePageLinkOfcampaigns() {
		campaignslink.click();
	}
	/**
	 * sign out image link
	 */
	public void signoutimglink() {
		signoutimg.click();
	}
	/**
	 * 
	 *sign out link
	 */
	public void signoutlink() {
		signout.click();
	}
}
