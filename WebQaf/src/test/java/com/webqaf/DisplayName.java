package com.webqaf;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class DisplayName extends QAFWebComponent {

	
	@FindBy(locator = "productdetail.Productname.img")
	private QAFWebElement Productname;

	@FindBy(locator = "productdetail.productPrice.img")
	private QAFWebElement productPrice;
	
	public QAFWebElement getProductname() {
		return Productname;
	}

	public QAFWebElement getproductPrice() {
		return productPrice;
	}
	
	public DisplayName(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
}
