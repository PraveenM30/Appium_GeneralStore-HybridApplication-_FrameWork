package org.Appium.pageObjects;

import java.util.List;

import org.Appium.Utils.AndroidActions;
import org.Appium.Utils.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class productCatalogue extends AndroidActions{
	
 AndroidDriver driver;
	public productCatalogue(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> AddToCart;
	
	public void AddItemToCartByIndex(int Index) {
		AddToCart.get(Index).click();
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement CartIcon;
	
	public void CartIcon() {
		CartIcon.click();
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private WebElement AddToCar;
	 
	public void AddToCartText() {
		AddToCar.isDisplayed();
	}
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/productName")
	public WebElement productss;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/productName")
	public List<WebElement> products;
	
	public int  getProductCount() {
		return products.size();
	}
	
	@AndroidFindBy(xpath = "(//android.widget.Toast)[1]")
	private WebElement ToastMessage;
	
	public String ToastMessage() {
		waitTillPresenceOfWebElement("(//android.widget.Toast)[1]");
		return ToastMessage.getText();
	}
	
	
}
