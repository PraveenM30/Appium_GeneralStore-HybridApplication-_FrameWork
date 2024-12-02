package GeneralStore;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MobileBrowserTest extends org.Appium.Utils.MobileBrowserBaseClass {
	@Test
public void MobileBrowser() throws MalformedURLException {
	StartAppiumAndInvokeApp();
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.xpath("//span[@class=\"navbar-toggler-icon\"]")).click();
	driver.findElement(By.partialLinkText("Produc")).click();
	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
	String text=driver.findElement(By.partialLinkText("Devops")).getText();
	Assert.assertEquals(text, "Devops");
	tearDown();
}
}
