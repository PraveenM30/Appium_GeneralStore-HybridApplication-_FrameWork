package GeneralStore;

import java.net.MalformedURLException;

import org.Appium.Utils.BaseClass;
import org.Appium.pageObjects.formPage;
import org.testng.annotations.Test;

public class eCommerce_TC1_fillForm extends BaseClass{

	@Test(groups ={"sanity"})
	public void fillForm1() throws MalformedURLException, InterruptedException {
		
		
		formPage form=new formPage(driver);
		form.Selectcountry("Australia");
		form.setName("Panda");
		form.gender("Female");
		form.submitForm();
		
		Thread.sleep(2000);
	}
}
