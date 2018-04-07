package org.haktes.clebo_t.interaction.mouse;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MoveMouse {

	WebDriver driver;

	public MoveMouse(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Move the mouse
	 * from , list (result from a MovementPathxxxx)
	 */
	public void moveMouse(Point lastPos, List<int[]> listForMovement) {		

		WebElement weblementBody = driver.findElement(By.cssSelector("body"));// initial position element
		Actions moveMouse = new Actions(driver);		
		moveMouse.moveToElement(weblementBody, lastPos.x, lastPos.y).perform(); // initial position

		for (int[] pole : listForMovement) {
			moveMouse.pause(10).moveByOffset(pole[0], pole[1]).perform();
		}
	}

}
