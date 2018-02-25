package eu.haktes.clebo_t.interaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import eu.haktes.clebo_t.BotAppStart;

public class MovementPathSimple extends MovementPathTemplate implements MovementPath {
	
	/**
	 * Class to calculate steps for mouse movement
	 * from x,y (related to html element) to desired element
	 * in the # number of steps 
	 */
	
	private static Logger LOG = (Logger) LogManager.getLogger(MovementPathSimple.class);
	
	/**
	 * Returns a list of points - path - from starting point to element
	 */
	@Override
	public List<int[]> getMovementArray(Point startPosition, WebElement elementMoveTo, int steps) {
		
		Point endPosition = super.getRandomPositionInElement(elementMoveTo);
		//LOG.trace("Start x:"+startPosition.x+" y:"+startPosition.y+" End x:"+endPosition.x+" y:"+endPosition.y);
		int distance = getDistance(startPosition, endPosition);
		int pathPartA = (int) ((endPosition.x - startPosition.x) / steps);
		int pathPartB = (int) ((endPosition.y - startPosition.y) / steps);
		int pathPartC = (int) (distance / (steps));
		
		Random rand = new Random();
		final int NOISE = 10; 
		
		List<int[]> list = new ArrayList<>();		
		int x = startPosition.x;
		int y = startPosition.y;

		for (int i = 0; i <= steps; i++) {			
			x = pathPartA+rand.nextInt(NOISE);
			y = pathPartB+rand.nextInt(NOISE);
			LOG.trace("step:"+i+  " x:"+x+" y:"+y);
			list.add(new int[] { x, y });
		}


		return list;
	}


}
