package com.assignment1.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class UtilityMethods {
	/**
	 * Open the .properties file
	 * @param filePath
	 * @return
	 */
	public static Properties OpenProperties(String filePath) {
		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(filePath);
			prop.load(file);
		} catch (FileNotFoundException e) {
			Reporter.log("FileNotFoundException" + e.getMessage(),true);
		} catch (IOException e) {
			Reporter.log("IOException" + e.getMessage(),true);
		}
		return prop;
	}
	
}
