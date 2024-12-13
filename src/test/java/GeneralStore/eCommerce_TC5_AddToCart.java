package GeneralStore;

import java.io.IOException;
import java.time.Duration;

import org.Appium.Utils.BaseClass;
import org.Appium.pageObjects.Cart;
import org.Appium.pageObjects.formPage;
import org.Appium.pageObjects.productCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class eCommerce_TC5_AddToCart extends BaseClass {

	@Test(groups = { "sanity" })
	public void AddToCart() throws InterruptedException, IOException {

		formPage form = new formPage(driver);
		form.Selectcountry("Australia");
		form.setName("Panda");
		form.gender("Female");
		form.submitForm();
		productCatalogue catalogue = new productCatalogue(driver);
		catalogue.AddToCartText();
		catalogue.scrollTillText("Jordan Lift Off");
		// to get product count
		int productCount = catalogue.getProductCount();
		// iterate to all product and get text of it.
		// in IF condition, if text matches then click on that product's "Add to cart"
		// button.
		for (int i = 0; i < productCount; i++) {
			String productName = catalogue.products.get(i).getText();
			if (productName.equalsIgnoreCase("Jordan Lift Off")) {
				catalogue.AddItemToCartByIndex(i);
			}
		}
		catalogue.CartIcon();

		Cart cart = new Cart(driver);
		cart.toolBarTitle();
		String SelectedProduct = cart.ProductName();
		Assert.assertEquals(SelectedProduct, "Jordan Lift Off");
	}
}
