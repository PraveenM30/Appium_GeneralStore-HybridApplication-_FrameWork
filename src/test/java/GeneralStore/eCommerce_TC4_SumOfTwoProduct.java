package GeneralStore;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.Appium.Utils.BaseClass;
import org.Appium.pageObjects.Cart;
import org.Appium.pageObjects.formPage;
import org.Appium.pageObjects.productCatalogue;
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

public class eCommerce_TC4_SumOfTwoProduct extends BaseClass {

	@Test
	public void AddToCart() throws InterruptedException, MalformedURLException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


		formPage form=new formPage(driver);
		form.Selectcountry("Australia");
		form.setName("Panda");
		productCatalogue productCatalogue=form.submitForm();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ADD TO CART']")));
		productCatalogue.waitTillVisibilityOfWebElement(productCatalogue.AddToCar);
		productCatalogue.AddItemToCartByIndex(0);
		productCatalogue.AddItemToCartByIndex(0);
		Cart cart=productCatalogue.CartIcon();
		cart.waitTillVisibilityOfWebElement(cart.cartTitleBar);
		wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart"));
		//productCatalogue.waitTillVisibilityOfWebElement("com.androidsample.generalstore:id/toolbar_title", "text", "Cart");
		double finalPrice=cart.getproductSum();
		double totalSum=cart.getTotalAmountDisplay();
		Assert.assertEquals(finalPrice, totalSum);
		cart.longpress();
		cart.checkbox();
		cart.purchase();
		
		/*
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
		*/
		Thread.sleep(5000);
//		Set<String> contextHandles=driver.getContextHandles();
//		for(String Handles:contextHandles) {
//			System.out.println(Handles);
//		}
//		System.out.println("current context is >>> "+driver.getContext());
//		driver.context("WEBVIEW_com.androidsample.generalstore");
//		System.out.println("current context is >>> "+driver.getContext());
//		driver.findElement(By.name("q")).sendKeys("Appium");
//		driver.findElement(AppiumBy.className("//android.widget.EditText")).sendKeys(Keys.ENTER);
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//driver.context("NATIVE_APP");
			}

}
