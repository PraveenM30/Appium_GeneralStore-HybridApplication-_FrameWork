package GeneralStore;

import java.net.MalformedURLException;

import org.Appium.RahulShetty.Utils.BaseClass;
import org.Appium.RahulShetty.pageObjects.android.formPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_TC2_ToastMessage extends BaseClass {
	@Test
	public void FillFormNegative() throws MalformedURLException, InterruptedException {

		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Australia\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Thread.sleep(2000);
		Assert.assertEquals(toastMsg, "Please enter your name");
	}

	@Test
	public void fillFormPositive() throws MalformedURLException, InterruptedException {

		formPage form = new formPage(driver);
		form.Selectcountry("Australia");
		form.setName("Panda");
		form.submitForm();

		Thread.sleep(2000);
	}
}