package com.webqaf;

import java.util.Set;

import org.testng.Reporter;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ProductDetailPage  extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	@FindBy(locator = "filter.lowestOrder.btn")
	private QAFWebElement lowestOrder;
	
	@FindBy(locator = "filter.lowestPrice.btn")
	private QAFWebElement lowestPrice;
	
	@FindBy(locator = "select.productdetailpage.img")
	private QAFWebElement Productdetail;
	
	public QAFWebElement getlowestOrder() {
		return lowestOrder;
	}
	
	public QAFWebElement getlowestPrice() {
		return lowestPrice;
	}
	
	public QAFWebElement getProductdetailpage() {
		return Productdetail;
	}
	
	
	@QAFTestStep(description = "Select Lowest Price Item From List")
	 public void sortproductwithlowprice() {
			// //Sort
			getlowestOrder().click();
			waitForPageToLoad();
			waitForAjaxToComplete();
			// Display lowest Price
			String lowestprice1 = getlowestPrice().getText();
			Reporter.log("lowestprice price is :" + lowestprice1);
			
			waitForPageToLoad();
			waitForAjaxToComplete();
		
		 
	 }
	 
	 @QAFTestStep(description = "user select product from product list")
	 public void productdetailpage() {
			// go to product detail page
			getProductdetailpage().waitForVisible(4000);
			getProductdetailpage().click();
			 waitForPageToLoad();
			// Move to 2nd tab
			Set<String> AllWindowHandles = driver.getWindowHandles();
			 String window1 = (String) AllWindowHandles.toArray()[0];
			 Reporter.log("window1 handle code = "+AllWindowHandles.toArray()[0]);
			 String window2 = (String) AllWindowHandles.toArray()[1];
			 Reporter.log("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
			 	
			 driver.switchTo().window(window2);
			 driver.switchTo().window(window1).close();
			 driver.switchTo().window(window2);
			 waitForPageToLoad();
	 }

	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
