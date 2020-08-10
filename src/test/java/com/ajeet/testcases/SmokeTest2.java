package com.ajeet.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mobile.base.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SmokeTest2 {
public static AndroidDriver<AndroidElement> driver=null;
	
	public void beforeTest() throws IOException, InterruptedException {
		driver= Base.openApp();
	//	driver.findElement(By.xpath("//android.widget.Button[text()='DENY']")).click();
	//  driver.findElement(By.xpath("//android.widget.Button[text()='DENY']")).click();
	//	driver.findElement(By.xpath("//android.widget.Button[text()='DENY']")).click();
	//	String packageName= ((AndroidDriver) driver).getCurrentPackage();
	//	 String grantCameraPermission= "adb shell pm grant " + packageName +" android.permission.CAMERA";
//		 String grantLocationPermission= "adb shell pm grant " + packageName +" android.permission.ACCESS_FINE_LOCATION";
	//	 String revokeCameraPermission= "adb shell pm grant " + packageName +" android.permission.CAMERA";
	//	 String revokeLocationPermission= "adb shell pm grant " + packageName +" android.permission.ACCESS_FINE_LOCATION";
		/*        try {
		            Runtime.getRuntime().exec(grantCameraPermission);
		          //  Runtime.getRuntime().exec(revokeLocationPermission);
		            System.out.println("Camera Permisson Granted");

		        } catch (IOException e) {
		            e.printStackTrace();
		        } */
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
