package GeneralStore;

import java.net.MalformedURLException;

import org.Appium.Utils.BaseClass;
import org.Appium.pageObjects.formPage;
import org.Appium.pageObjects.productCatalogue;
import org.testng.annotations.Test;

public class eCommerce_TC1_fillFormPositive extends BaseClass {

	@Test(groups = { "sanity" })
	public void fillForm() throws MalformedURLException, InterruptedException {

		formPage form = new formPage(driver);
		form.Selectcountry("Australia");
		form.setName("Panda");
		form.gender("Female");
		form.submitForm();
		productCatalogue catalogue = new productCatalogue(driver);
		catalogue.AddToCartText();
	}
}
