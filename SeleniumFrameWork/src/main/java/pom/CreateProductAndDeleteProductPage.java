package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductAndDeleteProductPage {
	public CreateProductAndDeleteProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProductImage;
	
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	@FindBy(xpath = "(//a[.='Products'])[2]")
	private WebElement products;
	
	@FindBy(xpath = "//input[@class='crmbutton small delete']")
	private WebElement deleteButton;

	public WebElement getCreateProductImage() {
		return createProductImage;
	}

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	//business logic
	/**
	 * 
	 * THIS METHOD IS USED TO CLICK ON CREATE ORGANIZATION LINK
	 */
	public void createProductImageLink() {
		createProductImage.click();
	}
	/**
	 * 
	 *  This method is used to type product name in the text field
	 * @param productData
	 */
	public void productNameTextFieldLink(String productData) {
		productNameTextField.sendKeys(productData);
		
	}
	/**
	 * 
	 * This method is used to click save button
	 */
	public void saveButtonLink() {
		savebutton.click();
	}
	/**
	 * this method is used to click on products link
	 * 
	 */
	public void productsLink() {
		products.click();
	}
	/**
	 * 
	 * this button is used to delete
	 */
	public void deleteButtonlink() {
		deleteButton.click();
	}
	
	
	
	
}
