package org.haktes.clebo_t.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class FileUtil {

	private static final Logger LOG = (Logger) LogManager.getLogger(FileUtil.class);

	/**
	 * Check if file on path exist
	 */
	public static boolean doesFileExits(String path) {
		File file = new File(path);
		if (file.exists() && !file.isDirectory()) {
			return true;
		}
		return false;
	}

	/**
	 * Creates a file in the path with the file name
	 */
	public static boolean createNewFile(String pathToFile) {

		File fileToCreate = new File(pathToFile);

		try {
			fileToCreate.getParentFile().mkdirs(); // creates folders
			fileToCreate.createNewFile();
			LOG.debug("Made new file" + pathToFile);
			return true;
		} catch (IOException e) {
			LOG.error("Failed making new file" + pathToFile);
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * This will add the text to the file ON NEW LINE!
	 */
	public static boolean appendFileWithLine(String pathToFile, String textToAdd) {

		try {
			FileWriter fw = new FileWriter(pathToFile, true); // the true will append the new data
			fw.write("\n" + textToAdd);
			fw.close();
			return true;
		} catch (IOException ioe) {
			LOG.error("Failed appending file: " + pathToFile);
			ioe.printStackTrace();
		}
		return false;
	}

	public static String readFirstLineFromFile(String pathToFile) {
		BufferedReader brTest;
		String text = "";
		File file = new File(pathToFile);

		if (doesFileExits(pathToFile) && file.length() != 0) {
			try {
				brTest = new BufferedReader(new FileReader(pathToFile));
				text = brTest.readLine();
			} catch (IOException e) {
				LOG.error("Error reading file: " + pathToFile + " ", e);
			}
		}
		return text;
	}

	public static String readLastLineFromFile(String pathToFile) {

		String last = "";
		String line;

		if (doesFileExits(pathToFile)) {
			try {
				BufferedReader input = new BufferedReader(new FileReader(pathToFile));

				while ((line = input.readLine()) != null) {
					last = line;
				}
				input.close();

			} catch (IOException e) {
				LOG.error("Error reading file: " + pathToFile + " ", e);
			}
		}
		return last;
	}

}
