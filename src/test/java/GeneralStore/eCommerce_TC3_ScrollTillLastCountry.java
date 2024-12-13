package GeneralStore;

import java.util.HashMap;

import org.Appium.Utils.BaseClass;
import org.Appium.pageObjects.formPage;
import org.testng.annotations.Test;

public class eCommerce_TC3_ScrollTillLastCountry extends BaseClass{

	@Test(dataProvider = "getJSONData")
	public void ScrollTillLastCountry(HashMap<String, String>input) {
		formPage form = new formPage(driver);
		form.Selectcountry(input.get("lastCountry"));
	}
}
