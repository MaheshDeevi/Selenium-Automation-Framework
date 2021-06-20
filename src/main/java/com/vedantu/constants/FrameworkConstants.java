package com.vedantu.constants;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}
	
	private static final String CHROMEDRIVERPATH  = "./src/test/resources/executables/chromedriver.exe";

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}
	
	

}
