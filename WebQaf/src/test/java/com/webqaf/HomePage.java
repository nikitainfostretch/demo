package com.webqaf;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class HomePage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	@FindBy(locator = "login.close.btn")
	private QAFWebElement close;
	
	@FindBy(locator = "homepage.subcategory.btn")
	private QAFWebElement Subcategoryelement;
	
	@FindBy(locator = "select.subcategory.btn")
	private QAFWebElement Searchipad;	
		
	@FindBy(locator = "homepage.category.btn")
	private QAFWebElement Homepage;
	
	@FindBy(locator = "verifycart.Product.img")
	private QAFWebElement VerifyProduct;
	
	@FindBy(locator = "productdetail.Productlist.img")
	private List<DisplayName> Productlist;
	
	public QAFWebElement getSubcategoryelement() {
		return Subcategoryelement;
	}	
	
	public QAFWebElement getSearchipad() {
		return Searchipad;
	}	

	public QAFWebElement getHomepage() {
		return Homepage;
	}

	public QAFWebElement getVerifyProduct() {
		return VerifyProduct;
	}
	
	public List<DisplayName> getProductlist() {
		return Productlist;
	}
	
	 @QAFTestStep(description = "navigate to home page category")
	public void launch() throws InterruptedException {
		 driver.get("/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	
	try
	{
	close.waitForEnabled(3000);
		close.click();
	} catch (Exception e) {
		   
	  }

	  Actions actions = new Actions(driver);
      QAFWebElement moveonmenu = Homepage;
	  QAFWebElement subcategory = Subcategoryelement;
	
	  moveonmenu.waitForVisible();
	  actions.moveToElement(moveonmenu).build().perform();
	
	  subcategory.waitForVisible();
	  actions.moveToElement(subcategory).click().perform();
		 
	}
	
	
	 @QAFTestStep(description = "Select category {0}")
	public void Searchitem(String category) throws InterruptedException {
		waitForPageToLoad();
		// for data Driven
		QAFWebElement ele = new QAFExtendedWebElement(String.format(
				ConfigurationManager.getBundle().getString("select.subcategory.btn"), category));
	
		ele.waitForVisible(10000);
		ele.click();
		waitForPageToLoad();
		waitForAjaxToComplete();
		// create list
		Reporter.log("list of products>>>>>>>"+getProductlist().size());
		
		for (int i = 0; i < getProductlist().size(); i++) {
			Reporter.log(
					"product name:" + getProductlist().get(i).getProductname().getText());
			Reporter.log("product Price:"
					+ getProductlist().get(i).getproductPrice().getText());
		}
		waitForPageToLoad();
		waitForAjaxToComplete();
	
	}
	 
	 
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
	}

}
