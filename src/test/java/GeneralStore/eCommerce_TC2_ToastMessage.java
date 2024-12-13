package GeneralStore;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.Appium.Utils.BaseClass;
import org.Appium.pageObjects.formPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_TC2_ToastMessage extends BaseClass {
	@Test(dataProvider = "getJSONData")
	public void FillFormNegative(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
		formPage form = new formPage(driver);
		form.Selectcountry(input.get("country"));
		form.gender(input.get("gender"));
		form.submitForm();
		String toastMsg = form.ToastMessage();
		Assert.assertEquals(toastMsg, input.get("toastMessageInFormPage"));// it will fail
	}
}