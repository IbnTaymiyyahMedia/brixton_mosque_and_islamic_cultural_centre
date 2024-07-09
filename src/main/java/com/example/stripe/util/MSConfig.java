package com.example.stripe.util;

public class MSConfig implements IConfig {

	
	
	private static IConfig INSTANCE = null;
	
	private MSConfig() {
		
	}
	
	public static IConfig getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MSConfig();
		}
		return INSTANCE;
	}
	
}
