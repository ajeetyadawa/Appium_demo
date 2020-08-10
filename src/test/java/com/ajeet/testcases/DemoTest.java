package com.ajeet.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mobile.base.Base;

public class DemoTest extends Base {
	@Test
	   public  void doLogin() throws IOException, InterruptedException {
	        try {
	            openApp();
	        }finally {
	            closeService();
	        }
	   }
	
	@BeforeTest
	public void killAllNodes() throws IOException {
		
	    Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	   
	}
	
	//@AfterTest
	public void closeEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("adb kill-server");
		Thread.sleep(35000);
	}
	
	
}
