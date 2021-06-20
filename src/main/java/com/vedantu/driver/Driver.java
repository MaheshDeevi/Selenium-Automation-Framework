package com.vedantu.driver;

import java.util.Collections;
import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.vedantu.constants.FrameworkConstants;
import com.vedantu.utils.PropertyUtils;

public final class Driver {
	
	private Driver() {
		
	}
	
	
	
	
	public static void initDriver() throws Exception {
		if(Objects.isNull(DriverManager.getDriver())) {
		System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
				
		DriverManager.setDriver(new ChromeDriver(options));
		DriverManager.getDriver().get(PropertyUtils.getValue("url"));
		DriverManager.getDriver().manage().window().maximize();
		
		}
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
		DriverManager.getDriver().quit();
		DriverManager.unload();
		}
	}

}
