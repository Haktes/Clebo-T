package org.haktes.clebo_t.final_proposed.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverUtils {

	
	private static final Logger LOG = (Logger) LogManager.getLogger(DriverUtils.class);
	private WebDriver driver = null;
	private WebElement lastElement = null;
	private String lastFindBy = null;
	private WebElement savedWebElement = null;
	private String savedFindBy = null;
	private int step = 0;

	public DriverUtils(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method works same as driver
	 */
	public DriverUtils findElement(By by) throws Exception {
		try {
			if (!driver.findElements(by).isEmpty()) { // if not empty
				step++;
				lastFindBy = by.toString();
				lastElement = driver.findElement(by);
				return this;
			} else { // element not found
				throw new Exception("Element not found, step: " + step + ", by: " + by.toString());
			}

		} catch (Exception e) {
			throw new Exception("EXCEPTION! ", e); // this is worse WIP
		}
	}
	
	public DriverUtils findElementAndSave(By by) throws Exception {
		findElement(by);
		save();
		return this;
	}
	
	public DriverUtils save() {
		savedFindBy = lastFindBy;
		savedWebElement = lastElement;
		return this;
	}
	
	// ---------------------------- getters ---------------------------------
	public WebElement getElement() {
		return savedWebElement;
	}
	public String getSavedOperation() {
		return savedFindBy;
	}
	
	public WebElement getLastElement() {
		return lastElement;
	}
	public String getLastOperation() {
		return lastFindBy;
	}

}
