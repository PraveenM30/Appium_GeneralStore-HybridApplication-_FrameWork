package org.Appium.Utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.WebSocket;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileBrowserBaseClass {
	private AppiumDriverLocalService service;
	public AndroidDriver driver;

	@BeforeClass
	public void StartAppiumAndInvokeApp() throws MalformedURLException {

//	AppiumDriverLocalService service = new AppiumServiceBuilder()
//			.withAppiumJS(
//					new File("C:\\Users\\user\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//			.withIPAddress("127.0.0.1").usingPort(4723).build();
//	service.start();

		try {
			AppiumServiceBuilder builder = new AppiumServiceBuilder();
			builder.withIPAddress("127.0.0.1");
			builder.usingPort(4723);
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

		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		//options.setChromedriverExecutable("C:\\Users\\user\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win");
		//options.setDeviceName("Pixel8");
		options.setUdid("RZ8W1077NCV");
		options.setCapability("browserName", "Chrome");
		//options.setApp("C:\\Users\\user\\eclipse-workspace\\Appium_RahulShetty1\\resources\\ApiDemos-debug.apk");
		//options.setApp("C:\\Users\\user\\eclipse-workspace\\Appium_RahulShetty1\\resources\\General-Store.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
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
}
