package org.Appium.pageObjects;

import java.util.List;

import org.Appium.Utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Cart extends AndroidActions {
	AndroidDriver driver;

	public Cart(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productprice;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement TotalAmount;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement terms;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement Cancel;

	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement checkbox;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement purchase;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	public WebElement cartTitleBar;
	

	public List<WebElement> productList() {
		return productprice;
	}

	public double getproductSum() {
		int count = productprice.size();
		double totalSum = 0;

		for (int i = 0; i < count; i++) {
			String amountPrice = productprice.get(i).getText();
			Double price = Double.parseDouble(amountPrice.substring(1));
			totalSum = totalSum + price;
		}
		return totalSum;
	}

	public double getTotalAmountDisplay() {
		String ExpectedAmount = TotalAmount.getText();
		Double price = Double.parseDouble(ExpectedAmount.substring(1));
		return price;
	}

	public void longpress() {
		longPress(terms);
		Cancel.click();
	}

	public void checkbox() {
		checkbox.click();
	}

	public void purchase() {
		purchase.click();
	}

}
