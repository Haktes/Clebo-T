package eu.haktes.clebo_t.interaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class Movement {
	
	/**
	 * Class to move the mouse
	 * from x,y (related to html element)
	 * to desired element
	 * in the number of steps
	 * Point, WebElement, int 
	 */
	public static List<int[]> getMovementArray(Point startPosition, WebElement elementMoveTo, int steps) {
		
	//TODO y=e^x
	List<int[]> list = new ArrayList<>();
	list.add(new int[] {80,36});
	list.add(new int[] {85,38});
	list.add(new int[] {90,40});
	list.add(new int[] {100,42});
	list.add(new int[] {90,44});
	list.add(new int[] {85,45});
	list.add(new int[] {75,40});
	list.add(new int[] {78,35});
	list.add(new int[] {80,40});
	list.add(new int[] {80,40});
		
	return list;	
	}
	
	/**
	 * Distance between two points as int
	 * */
	private static int getDistance(Point startPosition, Point destinationPositiotn) {
		
		//Pythagorean theorem a^2 + b^2 = c^2		
		int a = 0; //x dsitance between objects
		int b = 0; //y distance between objects
		int c = 0; 
		a = Math.abs(startPosition.x - destinationPositiotn.x);
		b = Math.abs(startPosition.y - destinationPositiotn.y);
		c = (int) Math.sqrt(a*a + b*b);
		
		return c;		
	}
	
	/**
	 * Get a random location within a web element as Position
	 */
	private static Point getRandomPositionInElement(WebElement element) {
		
		Random rand = new Random();
		int posX = element.getLocation().x;
		int posY = element.getLocation().y;
		int width = element.getSize().width;
		int height = element.getSize().height;
		
		//pos is related to upper left point of element
		int x = posX + rand.nextInt(width)+1;	
		int y = posY + rand.nextInt(height)+1;
		Point resultingPoint = new Point(x, y);
		
		return resultingPoint;
	}

}
