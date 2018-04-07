package org.haktes.clebo_t.actions;

import org.haktes.clebo_t.utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Quests {
	
	private DriverUtil driverUtil;
	
	
	
	public Quests(DriverUtil driverUtil) {
		this.driverUtil = driverUtil;		
	}
	
	/**
	 * Check for finished quests
	 */
	public boolean areThereFinishedQuests() {
		
		if(driverUtil.getElementByXpath("//*[@id=\"mentorTaskList\"]") != null) {
			WebElement weQuestList = driverUtil.getElementByXpath("//ul[@id=\"mentorTaskList\"]");
			
			if (weQuestList.findElements(By.xpath("//img[@class=\"reward\"]"))!= null ) {
				return true;
			}			
		}		
		return false;		
	}
	
}
