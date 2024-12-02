package DataDriven;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.Appium.Utils.BaseClass;
import org.Appium.Utils.MobileBrowserBaseClass;
import org.Appium.pageObjects.formPage;
import org.testng.annotations.Test;

public class Json {
	public class JSON_fillForm extends BaseClass {

		@Test(dataProvider = "getJSONData")
		public void fillForm1(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

			formPage form = new formPage(driver);
			form.Selectcountry(input.get("country"));
			form.setName(input.get("name"));
			form.gender(input.get("gender"));
			form.submitForm();
			form.backButton();
			Thread.sleep(2000);
		}
	}
}
