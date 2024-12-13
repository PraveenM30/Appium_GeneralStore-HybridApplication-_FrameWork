package GeneralStore;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.Appium.Utils.BaseClass;
import org.Appium.pageObjects.formPage;
import org.Appium.pageObjects.productCatalogue;
import org.testng.annotations.Test;

public class eCommerce_TC1_fillFormPositive extends BaseClass {

	@Test(groups = { "sanity" }, dataProvider = "getJSONData")
	public void fillForm(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

		formPage form = new formPage(driver);
		form.Selectcountry(input.get("country"));
		form.setName(input.get("name"));
		form.gender(input.get("gender"));
		form.submitForm();
		productCatalogue catalogue = new productCatalogue(driver);
		catalogue.AddToCartText();
	}
}
