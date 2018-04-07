package org.haktes.clebo_t.actions;

import org.haktes.clebo_t.utils.BasicUtils;
import org.haktes.clebo_t.utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeroActions {

	static WebDriver driver;

	public HeroActions(WebDriver passDriver) {

		driver = passDriver;
	}
	
public void getHeroStatus(HeroStatus hero) {
    	
    	WebElement weHeroStats = driver.findElement(By.xpath("//*[@id=\"heroImageButton\"]"));
		//moveMouse.moveMouse(lastMousePos, pathGenerator.getMovementArray(lastMousePos, weCentrumDediny));
		weHeroStats.click();
    	
    	////*[@id="attributes"]/div[1]/div[3]/table/tbody/tr[1]/td[2]/span
    	WebElement heroStats =
                driver.findElement(By.xpath("//*[@id=\"content\"]"));
    	
    	String health = heroStats
                .findElement(By.xpath("//*[@id=\"attributes\"]/div[1]/div[3]/table/tbody/tr[1]/td[2]/span"))
                .getText();
    	health=health.replace("%", "");
    	int healthInt=BasicUtils.stringToInt(health);
    	hero.setHealth(healthInt);
    	
    	String experiences = heroStats
                .findElement(By.xpath("//*[@id=\"attributes\"]/div[1]/div[3]/table/tbody/tr[2]/td[2]/span"))
                .getText();
    	int experiencesInt=BasicUtils.stringToInt(experiences);
    	hero.setXp(experiencesInt);
    	
    	String speedPerField = heroStats
                .findElement(By.xpath("//*[@id=\"heroSpeedValueNumber\"]"))
                .getText();
    	int speedPerFieldInt=BasicUtils.stringToInt(speedPerField);
    	hero.setSpeedPerField(speedPerFieldInt);
    	
    	String plusProduction = heroStats
                .findElement(By.xpath("//*[@id=\"attributes\"]/div[1]/div[3]/table/tbody/tr[3]/td[2]/span/span[1]/span"))
                .getText();
    	int plusProductionInt=BasicUtils.stringToInt(plusProduction);
    	hero.setHeroPlusProduction(plusProductionInt);
    	
    	Boolean heroHidden = heroStats
                .findElement(By.xpath("//*[@id=\"attackBehaviourHide\"]"))
                .isSelected();
    	hero.setHeroHidden(heroHidden);
    	
    	String strength = heroStats
                .findElement(By.xpath("//*[@id=\"attributepower\"]/td[2]/span"))
                .getText();
    	int strengthInt=BasicUtils.stringToInt(strength);
    	hero.setStrength(strengthInt);
    	
    	String offBonus = heroStats
                .findElement(By.xpath("//*[@id=\"attributeoffBonus\"]/td[2]/span"))
                .getText();
    	offBonus=offBonus.replace("%", "");
    	int offBonusInt=BasicUtils.stringToInt(offBonus);
    	hero.setOffBonus(offBonusInt);
    	
    	String deffBonus = heroStats
                .findElement(By.xpath("//*[@id=\"attributedefBonus\"]/td[2]/span"))
                .getText();
    	deffBonus=deffBonus.replace("%", "");
    	int deffBonusInt=BasicUtils.stringToInt(deffBonus);
    	hero.setDeffBonus(deffBonusInt);
    	
    	String productionPoints = heroStats
                .findElement(By.xpath("//*[@id=\"attributeproductionPoints\"]/td[2]/span"))
                .getText();
    	int productionPointsInt=BasicUtils.stringToInt(productionPoints);
    	hero.setProductionPoints(productionPointsInt);
    	
    	
    }

public boolean existExpedition() {
	////*[@id="button5ac89e9ae5664"]/div[2]/div[2]
	String xpathExpedition="//*[@class=\"layoutButton auctionWhite green  \"]";
	
	WebElement weHome = driver.findElement(By.xpath("//*[@id=\"n1\"]/a"));
	weHome.click();
		
	DriverUtil util=new DriverUtil();
	boolean expeditionExist=util.existElementByXpath(xpathExpedition, driver);
		
	return expeditionExist;
}

}
