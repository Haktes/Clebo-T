package eu.haktes.clebo_t.interaction;

import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public interface MovementPath {
	
	public List<int[]> getMovementArray(Point startPosition, WebElement elementMoveTo, int steps);
	
	public List<int[]> getMovementArray(Point startPosition, WebElement elementMoveTo);
	
}
