package eu.haktes.clebo_t.interaction;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class for getting the element values like:
 * position x,y 
 * size width and height
 */
public class ElementValues {

	public static void getCoordinates(WebElement element) throws Exception {
		// Used points class to get x and y coordinates of element.
		Point classname = element.getLocation();
		int xcordi = classname.getX();
		System.out.println(element.getTagName()+" Element's Position from left side" + xcordi + " pixels.");
		int ycordi = classname.getY();
		System.out.println(element.getTagName()+" Element's Position from top" + ycordi + " pixels.");
	}

	public static void getSize(WebElement element) throws Exception {
		// Get width of element.
		int elementWidth = element.getSize().getWidth();
		System.out.println(element.getTagName()+" width Is " + elementWidth + " pixels");
		// Get height of element.
		int elementHeight = element.getSize().getHeight();
		System.out.println(element.getTagName()+"height Is " + elementHeight + " pixels");
	}

}
