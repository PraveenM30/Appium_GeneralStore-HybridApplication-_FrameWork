package org.Appium.RahulShetty.Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AppiumUtils {
	AppiumDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	public AppiumUtils(AndroidDriver driver) {
		this.driver = driver;
	}

	public double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	public void waitTillVisibilityOfWebElement(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitTillVisibilityOfWebElement(String locator, String Attribute, String text) {
		wait.until(ExpectedConditions.attributeContains(By.id(locator), Attribute, text));
	}

}
