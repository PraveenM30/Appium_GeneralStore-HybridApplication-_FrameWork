package GeneralStore;

import java.util.HashMap;

import org.Appium.Utils.BaseClass;
import org.Appium.pageObjects.formPage;
import org.Appium.pageObjects.productCatalogue;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_TC4_NavigateToCartNegative extends BaseClass{

	@Test(dataProvider = "getJSONData")
	public void NavigateToCartNegative(HashMap<String, String>input) {
		formPage form = new formPage(driver);
		form.Selectcountry(input.get("country"));
		form.setName(input.get("name"));
		form.gender(input.get("gender"));
		form.submitForm();
		productCatalogue catalogue = new productCatalogue(driver);
		catalogue.AddToCartText();
		catalogue.CartIcon();
		String ToastMessage=catalogue.ToastMessage();
		Assert.assertEquals(ToastMessage, input.get("toastMessageInProductCataloguePage"));
	}
}
