package GeneralStore;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.Appium.RahulShetty.Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_TC4_HybridApp extends  BaseClass{

	@Test
	public void AddToCart() throws InterruptedException, IOException {
		StartAppiumAndInvokeApp();

//		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
//		driver.findElement(
//				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));
//
//		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Australia\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Panda");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(5000);
		driver.findElements(By.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).get(0).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart"));

		
		List<WebElement> productPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrice.size();
		double totalSum = 0;

		for (int i = 0; i < count; i++) {
			String amountPrice = productPrice.get(i).getText();
			Double price = Double.parseDouble(amountPrice.substring(1));
			totalSum = totalSum + price;
		}

		String totalFinalAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"))
				.getText();
		Double finalPrice = Double.parseDouble(totalFinalAmount.substring(1));
		Assert.assertEquals(finalPrice, totalSum);
		
		WebElement pressAndHold=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPress(pressAndHold);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(15000);
		Set<String> contextHandles=driver.getContextHandles();
		for(String Handles:contextHandles) {
			System.out.println(Handles);
		}
		System.out.println("current context is >>> "+driver.getContext());
		driver.context("WEBVIEW_com.androidsample.generalstore");
		System.out.println("current context is >>> "+driver.getContext());
		driver.findElement(By.name("q")).sendKeys("Appium");
		driver.findElement(AppiumBy.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//driver.context("NATIVE_APP");
		
		tearDown();
	}

}
