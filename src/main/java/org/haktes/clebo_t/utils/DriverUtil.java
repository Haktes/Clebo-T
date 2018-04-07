package org.haktes.clebo_t.utils;

import java.lang.annotation.Target;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.haktes.clebo_t.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverUtil {
	
	private static final Logger LOG = (Logger) LogManager.getLogger(DriverUtil.class);
	private WebDriver driver;
	
	public DriverUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public DriverUtil() {
		
	}
	
	public void setDriver(WebDriver driver) {
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
	
	public String getElementByClass(String class_name) {
		WebElement weResult = null;
		String exist="";
		
		try {
			weResult=driver.findElement(By.className(class_name));
			exist="yes";
			
		} catch (NoSuchElementException e) {
			LOG.warn("No such element getElementByClass: "+class_name+" field is not empty");
			exist="no";
		}
		return exist;
	}
	
	public boolean existElementByXpath(String xpath, WebDriver driver) {
		System.out.println(driver);
		//Boolean isPresent = driver.findElements(By.xpath(xpath)).size() > 0;
		
		try {
	        driver.findElement(By.xpath(xpath));
	        System.out.println("existuje");
	        return true;
	    } catch (NoSuchElementException e) {
	    	System.out.println("neexistuje");
	    	return false;
	        
	    }
	   
		
		
	}

}
