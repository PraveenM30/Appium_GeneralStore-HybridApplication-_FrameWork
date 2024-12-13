package GeneralStore;

import org.Appium.Utils.BaseClass;
import org.Appium.pageObjects.formPage;
import org.testng.annotations.Test;

public class eCommerce_TC3_ScrollTillLastCountry extends BaseClass{

	@Test
	public void ScrollTillLastCountry() {
		formPage form = new formPage(driver);
		form.Selectcountry("Zimbabwe");
	}
}
