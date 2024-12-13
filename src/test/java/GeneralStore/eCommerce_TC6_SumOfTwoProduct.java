package GeneralStore;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
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

public class eCommerce_TC6_SumOfTwoProduct extends BaseClass {

	@Test(dataProvider = "getJSONData")
	public void SumOfTwoProduct(HashMap<String, String>input) throws InterruptedException, MalformedURLException {

		formPage form = new formPage(driver);
		form.Selectcountry(input.get("country"));
		form.setName(input.get("name"));
		form.gender(input.get("gender"));
		form.submitForm();

		productCatalogue catalogue = new productCatalogue(driver);
		catalogue.AddToCartText();
		catalogue.AddItemToCartByIndex(0);
		catalogue.AddItemToCartByIndex(1);
		catalogue.CartIcon();

		Cart cart = new Cart(driver);
		cart.toolBarTitle();
		double finalPrice = cart.getproductSum();
		double totalSum = cart.getTotalAmountDisplay();
		Assert.assertEquals(finalPrice, totalSum);
		cart.longpress();
		cart.checkbox();
		cart.purchase();
		long sleepTime = Long.parseLong(input.get("ThreadSleep"));
		Thread.sleep(sleepTime);
	}
}
