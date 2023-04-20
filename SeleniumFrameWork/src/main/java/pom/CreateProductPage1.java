package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class CreateProductPage1 {
	public CreateProductPage1(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProductImage;
	
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	/**
	 * 
	 * THIS METHOD IS USED TO CLICK ON CREATE ORGANIZATION LINK
	 */
	public WebElement getCreateProductImage() {
		return createProductImage;
	}
	/**
	 * 
	 *  This method is used to type product name in the text field
	 * 
	 */
	public WebElement getProductNameTextField() {
		return productNameTextField;
	}
	/**
	 * 
	 * This method is used to click save button
	 */
	public WebElement getSavebutton() {
		return savebutton;
	}
	/**
	 * this method is used to click on products link
	 * 
	 */
	public void productCreateLink() {
		createProductImage.click();
	}
	/**
	 * 
	 *  This method is used to type product name in the text field
	 * @param prodName
	 */
	public void productNameText(String prodName) {
	productNameTextField.sendKeys(prodName);
	}
	/**
	 * 
	 * This method is used to click save button
	 */
	public void savelink() {
		savebutton.click();
	}
}
