package br.com.aevc.pocswing.util;

import java.io.IOException;
import java.util.Properties;

public class ApplicationPropertiesUtil {

	private static String PROPERTIES_FILE = "resources/application.properties";
	private static Properties properties;

	private static Properties loadProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				properties.load(
						Thread.currentThread()
								.getContextClassLoader()
								.getResourceAsStream(PROPERTIES_FILE)
				);
			} catch (IOException e) {
				System.out.println("Cant load properties file " + PROPERTIES_FILE);
			}
		}
		return properties;
	}

	/**
	 * Searches for the property with the specified key in this property list. If
	 * the key is not found in this property list, the default property list, and
	 * its defaults, recursively, are then checked. The method returns the default
	 * value argument if the property is not found.
	 *
	 * @param key          the hashtable key.
	 * @param defaultValue a default value.
	 *
	 * @return the value in this property list with the specified key value.
	 * @see #setProperty
	 * @see #defaults
	 */
	public static String getProperty(String key, String defaultValue) {
		return loadProperties().getProperty(key, defaultValue);
	}

	/**
	 * Searches for the property with the specified key in this property list. If
	 * the key is not found in this property list, the default property list, and
	 * its defaults, recursively, are then checked. The method returns the default
	 * value argument if the property is not found.
	 *
	 * @param key          the hashtable key.
	 * @param defaultValue a default value.
	 *
	 * @return the value in this property list with the specified key value.
	 * @see #setProperty
	 * @see #defaults
	 */
	public static String getProperty(String key) {
		return loadProperties().getProperty(key);
	}
	
}
