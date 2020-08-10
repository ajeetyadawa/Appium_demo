package com.ajeet.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mobile.base.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SmokeTest {

	public static AndroidDriver<AndroidElement> driver=null;
	
	
	public void beforeTest() throws IOException, InterruptedException {
		driver= Base.openApp();
		driver.switchTo().alert().accept();
	}
	
	
	public  void Preferences() throws InterruptedException {
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text ='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("Ajeet");
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		driver.closeApp();
	}
	
	
	
	
}
