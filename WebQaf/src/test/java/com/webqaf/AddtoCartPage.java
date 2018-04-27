package com.webqaf;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class AddtoCartPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "cart.Add.btn")
	private QAFWebElement Add;
	
	@FindBy(locator = "home.logo.img")
	private QAFWebElement  logo;
	
	@FindBy(locator = "Cart.Addto.btn")
	private QAFExtendedWebElement AddtoCart;
	
	@FindBy(locator = "cart.removeproduct.btn")
	private QAFWebElement removeproduct;
	
	public QAFWebElement getAdd() {
		return Add;
	}
	
	public QAFWebElement getlogo() {
		return  logo;
	}
	
	public QAFWebElement getAddtoCart() {
		return AddtoCart;
	}
	
	public QAFWebElement getremoveproduct() {
		return removeproduct;
	}
	
	 @QAFTestStep(description = "user add product to cart")
	 public void addproducttocart() throws InterruptedException
	 {
		 // verify its product detail page

			getAdd().verifyVisible("addtocart button visible on page");
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,150)", "");

			// Add product to cart
			getAdd().click();
			waitForPageToLoad();
	    	waitForAjaxToComplete();
			// go to home page
		    logo.click();
			waitForPageToLoad();
	    	waitForAjaxToComplete();

			// click on add to cart button
	    	try {
	    		getAddtoCart().waitForPresent(5000);
	    		getAddtoCart().click();
				  } catch (Exception e) {
				   
				  }
	    	
			waitForPageToLoad();
	    	waitForAjaxToComplete();
	    	}
	 

	 @QAFTestStep(description = "verify product has been added in cart")
	 public void verifyProduct() {
		// verify product added
			WebElement cart = getremoveproduct();
	
			if (cart.isDisplayed()) {
				Reporter.log("Product is added into cart");
			}
			waitForPageToLoad();
			getremoveproduct().waitForPresent(5000);
			
			getremoveproduct().click();
			waitForPageToLoad();
	    	waitForAjaxToComplete();
	    	
			waitForPageToLoad();
			QAFTestBase.pause(5000);
	 }

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
