package com.ajeet.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class SmokeTest3 {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "TKS44SS8DAVWNRMZ");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability("appPackage", "io.appium.android.apis");
	   //  cap.setCapability("appActivity", "com.wasfat.*");
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("appWaitDuration", 30000);
		//cap.setCapability("appWaitActivity", "*.SplashActivity");
		URL url = new URL("http://127.0.1.1:4723/wd/hub");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);
		System.out.println("driver Status: "+driver.getStatus());
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

	}

}
