package GeneralStore;

import java.net.MalformedURLException;

import org.Appium.Utils.BaseClass;
import org.Appium.pageObjects.formPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_TC2_ToastMessage extends BaseClass {
	@Test
	public void FillFormNegative() throws MalformedURLException, InterruptedException {
		formPage form = new formPage(driver);
		form.Selectcountry("Algeria");
		form.gender("Female");
		form.submitForm();
		String toastMsg = form.ToastMessage();
		Assert.assertEquals(toastMsg,"Please enter your name");// it will fail
	}	
}