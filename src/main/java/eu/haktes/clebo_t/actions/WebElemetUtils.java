package eu.haktes.clebo_t.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class WebElemetUtils {

	public static boolean elementExistByXpath(String xpath, WebDriver driver) {

		try {
			driver.findElement(By.xpath(xpath));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

}
