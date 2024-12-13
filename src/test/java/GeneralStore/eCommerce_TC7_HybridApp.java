package GeneralStore;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.Appium.Utils.BaseClass;
import org.Appium.pageObjects.Cart;
import org.Appium.pageObjects.formPage;
import org.Appium.pageObjects.productCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_TC7_HybridApp extends  BaseClass{

	@Test
	public void AddToCart() throws InterruptedException, IOException {
		formPage form = new formPage(driver);
		form.Selectcountry("Australia");
		form.setName("Panda");
		form.gender("Female");
		form.submitForm();
		
		productCatalogue catalogue = new productCatalogue(driver);
		catalogue.AddToCartText();
		catalogue.AddItemToCartByIndex(0);
		catalogue.AddItemToCartByIndex(1);
		catalogue.CartIcon();

		Cart cart = new Cart(driver);
		cart.toolBarTitle();
		double finalPrice=cart.getproductSum();
		double totalSum=cart.getTotalAmountDisplay();
		Assert.assertEquals(finalPrice, totalSum);
		cart.longpress();
		cart.checkbox();
		cart.purchase();
		Thread.sleep(15000);
		
		
		Set<String> contextHandles=driver.getContextHandles();
		for(String Handles:contextHandles) {
			System.out.println(Handles);
		}
		System.out.println("current context is >>> "+driver.getContext());
		driver.context("WEBVIEW_com.androidsample.generalstore");
		System.out.println("current context is >>> "+driver.getContext());
		driver.findElement(By.name("q")).sendKeys("Appium");
		driver.findElement(AppiumBy.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//driver.context("NATIVE_APP");
			}

}
