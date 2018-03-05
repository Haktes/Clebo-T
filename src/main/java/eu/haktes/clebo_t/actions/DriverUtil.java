package eu.haktes.clebo_t.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import eu.haktes.clebo_t.Bot;

public class DriverUtil {
	
	private static final Logger LOG = (Logger) LogManager.getLogger(DriverUtil.class);
	private WebDriver driver;
	
	public DriverUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * get element by xpath
	 */
	public WebElement getElementByXpath(String xpath) {
		WebElement weResult = null;
		
		try {
			weResult=driver.findElement(By.xpath(xpath));
		} catch (NoSuchElementException e) {
			LOG.warn("No such element getElementByXpath: "+xpath);
		}
		return weResult;
	}

}
