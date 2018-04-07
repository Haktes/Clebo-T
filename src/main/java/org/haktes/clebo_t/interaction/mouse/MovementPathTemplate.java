package org.haktes.clebo_t.interaction.mouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class MovementPathTemplate implements MovementPath {

	/**
	 * Class to calculate steps for mouse movement from x,y (related to html
	 * element) to desired element in the # number of steps
	 */

	protected static final int PIXEL_PER_STEP = 30; // 300px will be done in 10

	/**
	 * Should return a list of points - path - from starting point to element !!!
	 * OVERIDE THIS METHOD IN YOUR CUSTOM MOVEMENT CLASS
	 */
	public List<int[]> getMovementArray(Point startPosition, WebElement elementMoveTo, int steps) {

		// dummy data
		List<int[]> list = new ArrayList<>();
		list.add(new int[] { 80, 36 });
		list.add(new int[] { 85, 38 });
		list.add(new int[] { 90, 40 });
		list.add(new int[] { 100, 42 });
		list.add(new int[] { 90, 44 });
		list.add(new int[] { 85, 45 });
		list.add(new int[] { 75, 40 });
		list.add(new int[] { 78, 35 });
		list.add(new int[] { 80, 40 });
		list.add(new int[] { 80, 40 });

		return list;
	}

	/**
	 * Same as  @see eu.haktes.clebo_t.interaction#getMovementArray()  but the steps are calculated
	 * {@link org.haktes.clebo_t.interaction.mouse#getMovementArray(Point startPosition, WebElement elementMoveTo, int steps)}
	 */
	public List<int[]> getMovementArray(Point startPosition, WebElement elementMoveTo) {

		int steps = (int) getDistance(startPosition, getRandomPositionInElement(elementMoveTo)) / PIXEL_PER_STEP;

		return getMovementArray(startPosition, elementMoveTo, steps);

	}

	/**
	 * Distance between two points as int
	 */
	protected int getDistance(Point startPosition, Point destinationPositiotn) {

		// Pythagorean theorem a^2 + b^2 = c^2
		int a = 0; // x dsitance between objects
		int b = 0; // y distance between objects
		int c = 0;
		a = Math.abs(startPosition.x - destinationPositiotn.x);
		b = Math.abs(startPosition.y - destinationPositiotn.y);
		c = (int) Math.sqrt(a * a + b * b);

		return c;
	}

	/**
	 * Get a random location within a web element as Position
	 */
	protected Point getRandomPositionInElement(WebElement element) {

		Random rand = new Random();
		int posX = element.getLocation().x;
		int posY = element.getLocation().y;
		int width = element.getSize().width;
		int height = element.getSize().height;

		// pos is related to upper left point of element, so the range is its width and
		// height
		int x = posX + rand.nextInt(width) + 1;
		int y = posY + rand.nextInt(height) + 1;
		Point resultingPoint = new Point(x, y);

		return resultingPoint;
	}
}
