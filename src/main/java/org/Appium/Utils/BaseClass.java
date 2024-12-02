package org.Appium.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	private AppiumDriverLocalService service;
	public AndroidDriver driver;
	
	@BeforeClass
	public void StartAppiumAndInvokeApp() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\TestData\\data.properties");
		prop.load(fis);
		String ipAddress=prop.getProperty("ipAddress");
		String port=prop.getProperty("port");
		String deviceUDID=prop.getProperty("deviceUDID");
		String platformName=prop.getProperty("platformName");


//	AppiumDriverLocalService service = new AppiumServiceBuilder()
//			.withAppiumJS(
//					new File("C:\\Users\\user\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//			.withIPAddress("127.0.0.1").usingPort(4723).build();
//	service.start();

		try {
			AppiumServiceBuilder builder = new AppiumServiceBuilder();
			builder.withIPAddress(ipAddress);
			builder.usingPort(Integer.parseInt(port));
			builder.withArgument(() -> "--base-path", "/wd/hub");
			service = AppiumDriverLocalService.buildService(builder);
			service.start();
			Thread.sleep(5000);

			if (service.isRunning()) {
				System.out.println("Appium Server started on: " + service.getUrl());
			} else {
				throw new RuntimeException("Appium Server failed to start!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

//	DesiredCapabilities capabilities = new DesiredCapabilities();
//	capabilities.setCapability("deviceName", "Pixel8");
//	capabilities.setCapability("platformName", "Android");
//	capabilities.setCapability("automationName", "uiautomator2"); // Set the automation engine to uiautomator2
//	capabilities.setCapability("", "Android");
//	capabilities.setCapability("app",
//			"C:\\Users\\user\\eclipse-workspace\\Appium_RahulShetty1\\resources\\ApiDemos-debug.apk");

		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName(platformName);
		// options.setDeviceName("Pixel8");
		options.setUdid(deviceUDID);
		options.setApp("C:\\Users\\user\\eclipse-workspace\\Appium_GeneralStore_FrameWork\\org.resources\\General-Store.apk");
		

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

	public void longPress(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	public void ScrollTillEnd() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 1.0));

		} while (canScrollMore);
	}

	public void swipe(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.25));
	}

	public void dragByCoOrdinate(WebElement ele, int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "endX", x, "endY", y));
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "Australia", "Panda", "Female" }, { "Bahamas", "Pandaaaaaa", "Male" } };
	}

	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
		// System.getProperty("user.dir")+"\\src\\main\\java\\org\\TestData\\eCommerce.json"
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	@DataProvider
	public Object[][] getJSONData() throws IOException {

		List<HashMap<String, String>> data = getJsonData(
				System.getProperty("user.dir") + "\\src\\main\\java\\org\\TestData\\eCommerce.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
	
	public String getScreenShot(String testCaseName,AppiumDriver  driver) throws IOException {
		File src=driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + File.separator + "reports" + File.separator + testCaseName + ".png";
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
	}
}
