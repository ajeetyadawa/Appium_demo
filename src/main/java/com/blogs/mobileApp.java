package com.blogs;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mobile.base.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class mobileApp extends Base {

	//AndroidDriver<WebElement> driver;
	@BeforeTest
	public void startApp() throws IOException, InterruptedException {
	//	startEmulator();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "TKS44SS8DAVWNRMZ");
		cap.setCapability("appPackage", "com.android.bbkcalculator");
		cap.setCapability("appActivity", "com.android.bbkcalculator.Calculator");
		URL url = new URL("http://127.0.1.1:4723/wd/hub");
		System.out.println("Hardcoded URL: " + url);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void doTesting() {
		System.out.println("Testing Started");
	}
	
	
}
