package com.mobile.base;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	public static int port;
	public static String deviceName;
	public static AppiumDriverLocalService service;

	private static AppiumDriverLocalService startService() {
		service = AppiumDriverLocalService.buildDefaultService();
		port = 4723;
		if (!isServerRunning(port)) {
			service.start();
		}
		return service;
	}

	public static AndroidDriver<AndroidElement> openApp() throws IOException, InterruptedException {
		deviceName = "real1";

		startService();
		File file = new File("Z:\\Testing Material\\Andriod apps\\app-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		if (!deviceName.equalsIgnoreCase("real")) {
			startEmulator();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "AjeetPixel");
		} else {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "TKS44SS8DAVWNRMZ");
		}
		System.out.println(file.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		//cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("appWaitDuration", 30000);
		// cap.setCapability("appWaitActivity", "*.SplashActivity");
		System.out.println("URL get from service: " + getURL());
		URL url = new URL("http://127.0.1.1:4723/wd/hub");
		System.out.println("Hardcoded URL: " + url);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);
		System.out.println("driver Status: " + driver.getStatus());
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		return driver;
	}

	public static boolean isServerRunning(int port) {
		boolean isServerUp = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
			isServerUp = true;
		} finally {
			{
				serverSocket = null;
				return isServerUp;
			}
		}

	}

	public static void startEmulator() throws IOException, InterruptedException {
		closeService();
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\startEmulator.bat");
		Thread.sleep(55500);
	}

	public static URL getURL() {
		return service.getUrl();
	}

	
	public static void closeService() throws IOException {
		service.stop();
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	}

}
