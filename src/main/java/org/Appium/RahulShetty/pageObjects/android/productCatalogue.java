package org.Appium.RahulShetty.pageObjects.android;

import java.util.List;

import org.Appium.RahulShetty.Utils.AndroidActions;
import org.Appium.RahulShetty.Utils.BaseClass;
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
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> AddToCart;
	
	public void AddItemToCartByIndex(int Index) {
		AddToCart.get(Index).click();
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement CartIcon;
	
	public Cart CartIcon() {
		CartIcon.click();
		return new Cart(driver);
	}
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	public WebElement AddToCar;
	
}
