package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignWithProductPage {

	// initialization
	public CreateCampaignWithProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// declaration
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createCampaignImage;

	@FindBy(name = "campaignname")
	private WebElement campaignNameTextField;

	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement productLinkImage;

	@FindBy(id = "search_txt")
	private WebElement searchTextField;

	@FindBy(name = "search")
	private WebElement searchButton;

	@FindBy(xpath = "//a[text()='\" + productData + \"']")
	private WebElement productDataText;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	// utilization
	public WebElement getCreateCampaignImage() {
		return createCampaignImage;
	}

	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getProductLinkImage() {
		return productLinkImage;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getProductDataText() {
		return productDataText;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	// business logic
	/**
	 * This method is used to click on create campaign link
	 * 
	 * 
	 */
	public void createCampaignImageLink() {
		createCampaignImage.click();
	}

	/**
	 * 
	 * This method is used to type campaign name in campaign name text field
	 * 
	 * @param campName
	 */
	public void campaignNameTextFieldBox(String campName) {
		campaignNameTextField.sendKeys(campName);
	}

	/**
	 * This method is used to click on create product link
	 * 
	 */
	public void productLinkImageLink() {
		productLinkImage.click();
	}

	/**
	 * This method is used to type campaign name in product name text field
	 * 
	 * @param productData
	 */
	public void searchTextFieldBox(String productData) {
		searchTextField.sendKeys(productData);
	}

	/**
	 * 
	 * This method is used to click on search button
	 */
	public void searchButtonLink() {
		searchButton.click();
	}

	/**
	 * 
	 * This method is used to fetch product data
	 * 
	 */
	public void productDataTextLink() {
		productDataText.click();
	}

	/**
	 * 
	 * this method is used to click on save button
	 */
	public void saveButtonLink() {
		saveButton.click();
	}

}
