package GeneralStore;

import java.net.MalformedURLException;

import org.Appium.RahulShetty.Utils.BaseClass;
import org.Appium.RahulShetty.pageObjects.android.formPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_TC1_fillForm extends BaseClass{

	@Test
	public void fillForm1() throws MalformedURLException, InterruptedException {
		
		
		formPage form=new formPage(driver);
		form.Selectcountry("Australia");
		form.setName("Panda");
		form.gender("Female");
		form.submitForm();
		
		Thread.sleep(2000);
	}
}
