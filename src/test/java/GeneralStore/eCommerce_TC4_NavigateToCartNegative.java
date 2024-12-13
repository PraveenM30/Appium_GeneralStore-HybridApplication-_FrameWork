package GeneralStore;

import org.Appium.Utils.BaseClass;
import org.Appium.pageObjects.formPage;
import org.Appium.pageObjects.productCatalogue;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_TC4_NavigateToCartNegative extends BaseClass{

	@Test
	public void navigateToCart() {
		formPage form = new formPage(driver);
		form.Selectcountry("Australia");
		form.setName("Panda");
		form.gender("Female");
		form.submitForm();
		productCatalogue catalogue = new productCatalogue(driver);
		catalogue.AddToCartText();
		catalogue.CartIcon();
		String ToastMessage=catalogue.ToastMessage();
		Assert.assertEquals(ToastMessage, "Please add some product at first");
	}
}
