package eu.haktes.clebo_t.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * https://crunchify.com/java-properties-file-how-to-read-config-properties-values-in-java/
 * Get properties
 */

public class GetPropertyValues {
	InputStream inputStream;

	public Properties getPropValues() throws IOException {
		Properties prop = new Properties();
		try {
			String propFileName = "application.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return prop;
	}
	
	public Properties getPropValues(String nameOfProperties) throws IOException {
		Properties prop = new Properties();
		try {
			String propFileName = nameOfProperties;
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return prop;
	}
}