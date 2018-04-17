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
	private String url = null;
	private int step = 0; // not useful yet

	public DriverUtils(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Search in the last saved element (or in driver if nothing is saved) for
	 * element. Exception is throwed when element is not found
	 */
	public DriverUtils findElement(By by) throws Exception {
		try {
			if (!driver.findElements(by).isEmpty()) { // if not empty
				step++;
				url = driver.getCurrentUrl();
				lastFindBy = by.toString();
				if (savedWebElement != null) {// if its saved, we work with that
					lastElement = savedWebElement.findElement(by);
				} else {
					lastElement = driver.findElement(by);
				}
				return this;
			} else { // element not found
				throw new Exception("Element not found, step: " + step + ", by: " + by.toString());
			}

		} catch (Exception e) {
			throw new Exception("EXCEPTION! ", e); // this is worse WIP
		}
	}

	/**
	 * Nothing will be modified returns true when element exits, nothing will be
	 * saved!
	 */
	public boolean exists(By by) {
		try {
			if (!driver.findElements(by).isEmpty()) { // if not empty
				return true;
			} else { // element not found
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Same as findElement(By) but also saves the element in object
	 */
	public DriverUtils findElementAndSave(By by) throws Exception {
		findElement(by);
		save();
		return this;
	}

	/**
	 * Permanently save selection to object, from now every other findElement will
	 * be done on this saved WebElement
	 */
	public DriverUtils save() {
		savedFindBy = lastFindBy;
		savedWebElement = lastElement;
		LOG.debug("Saved WebElement: " + savedFindBy);
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

	public String getUrl() {
		return url;
	}

}
