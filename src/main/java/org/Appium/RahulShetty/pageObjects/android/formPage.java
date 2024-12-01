package org.Appium.RahulShetty.pageObjects.android;

import java.time.Duration;

import org.Appium.RahulShetty.Utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class formPage extends AndroidActions {

	AndroidDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

	public formPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// super will call its parent driver
		/*
		 * this.driver will get the life for driver from the test script driver(we
		 * created constructor and and using this constructor in Test Script so when we
		 * trigger that script, first this constructor will run and load all the element
		 * which is in @AndroidFindBy)
		 */
		// initelement will load all our FindBy element to the driver
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement CountryDropdown;
	// driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement Name;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text=\"Male\"]")
	private WebElement Female;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement submit;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_back")
	private WebElement backButton;

	public void backButton() {
		wait.until(ExpectedConditions.visibilityOf(backButton));
		backButton.click();
	}

	public void Selectcountry(String countryName) {
		CountryDropdown.click();
		scrollTillText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + countryName + "\"]")).click();
	}

	public void setName(String name) {
		Name.sendKeys(name);
		driver.hideKeyboard();
	}

	public void gender(String Gender) {
		driver.findElement(By.xpath("//android.widget.RadioButton[@text=\"" + Gender + "\"]")).click();
	}

	public productCatalogue submitForm() {
		submit.click();
		return new productCatalogue(driver);
	}

	public void setActivity() {
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
				"com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
	}
}
