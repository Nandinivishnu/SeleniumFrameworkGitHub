package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.Webdriver_Utility;

public class ValidationAndVerificationPage {
	public ValidationAndVerificationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "dtlview_Product Name")
	private WebElement actualProductData;
	
	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement actualcampaignName;
	
	@FindBy(id="dtlview_Product")
	private WebElement actProductData;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement actualOrganizationName;
	
	public WebElement getActualProductData() {
		return actualProductData;
	}
	
	
	public WebElement getActualcampaignName() {
		return actualcampaignName;
	}

	

	public WebElement getActProductData() {
		return actProductData;
	}
	
	public WebElement getActualOrganizationName() {
		return actualOrganizationName;
	}


	/**
	 * 
	 * product name validation page
	 * @param driver
	 * @param data
	 */
	public void productValidation(WebDriver driver,String data)
	{
		String actData = actualProductData.getText();
		if (actData.contains(data)) {

			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		
	}
	/**
	 * 
	 * delete product validation page
	 * @param products
	 * @param data
	 */
	public void productDeleteValidation(List<WebElement> products ,String data ) {
		 boolean flag=false;
			
			for(WebElement web :products){
				String all = web.getText();
				if(all.contains(data)) {
					flag=true;
					break;
				}
			}
			if(flag) {
				System.out.println("deleted");
			}
			else {
				System.out.println("not deleted");
			} 
	}
	/**
	 * 
	 * campaign name validation page
	 * @param driver
	 * @param data
	 */
	public void campaignValidation(WebDriver driver,String data) {
		String actData = actualcampaignName.getText();
		if (actData.contains(data)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}
	/**
	 * 
	 * product data validation page
	 * @param driver
	 * @param data
	 */
	public void productDataValidation(WebDriver driver,String data) {
		String actData = actProductData.getText();
		if (actData.contains(data)) {

			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}
	
	public String organizationDataValidation(WebDriver driver,String Data) {
		String actData=actualOrganizationName.getText();
		if(actData.contains(Data)) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		return Data;
	}
	
	
	
}
