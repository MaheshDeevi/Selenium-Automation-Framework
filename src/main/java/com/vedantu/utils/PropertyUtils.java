package com.vedantu.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

	private PropertyUtils() {

	}

	private static final Properties property = new Properties();
	private static final Map<String,String> CONFIGMAP = new HashMap<>();
 

	static {
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/com/vedantu/config/config.properties");
			property.load(fis);
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()); //remove the trailing and leading spaces
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();	
		}
	}

	public static String getValue(String key) throws Exception {
		if(Objects.isNull(key)|| Objects.isNull(property.getProperty(key))) {
			throw new Exception("Property key or value is missing, pls chk in config properties file");
		}

		return property.getProperty(key);



	}

}
