package com.hellofresh.challenge;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.BaseConnection;

public class Listeners extends BaseConnection implements ITestListener  {
	


	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		// Taking a screenshot on testfailure
		
		try {
			//this.driver=super.driver;
			getScreenshot(result.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

}
