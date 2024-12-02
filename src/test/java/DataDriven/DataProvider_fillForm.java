package DataDriven;

import java.net.MalformedURLException;

import org.Appium.Utils.BaseClass;
import org.Appium.pageObjects.formPage;
import org.testng.annotations.Test;

public class DataProvider_fillForm extends BaseClass{

	@Test(dataProvider = "getData")
	public void fillForm1(String country,String name,String gender) throws MalformedURLException, InterruptedException {
				
		formPage form=new formPage(driver);
		form.Selectcountry(country);
		form.setName(name);
		form.gender(gender);
		form.submitForm();
		form.backButton();
		Thread.sleep(2000);
	}
	
//	@DataProvider
//	public Object[] [] getData() {
//		return new Object[][] {{"Australia","Panda","Female"},{"Bahamas","Pandaaaaaa","Male"}};
//	}
}
