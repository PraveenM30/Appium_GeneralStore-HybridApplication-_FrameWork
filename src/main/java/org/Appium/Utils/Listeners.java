package org.Appium.Utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;

public class Listeners extends BaseClass implements ITestListener {
	AppiumDriver driver;
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReporterObject();

	@Override
	public void onTestStart(ITestResult result) {
		 test=extent.createTest(result.getMethod().getMethodName());
		//this will get the name of the Test method, with that name the entry will be created
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		
		try {
			driver=(AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}catch(Exception e1){
			e1.printStackTrace();
		}
		try {
			test.addScreenCaptureFromPath(getScreenShot(result.getMethod().getMethodName(), driver),result.getMethod().getMethodName());
		//getScreenShot>> will take Screenshot and addScreenCaptureFromPath>> it will add it to the report 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,"Test Skipped	");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	extent.flush();
	}
}
