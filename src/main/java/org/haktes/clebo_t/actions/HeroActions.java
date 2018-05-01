package org.haktes.clebo_t.actions;

import org.haktes.clebo_t.utils.BasicUtils;
import org.haktes.clebo_t.utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

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
	//returns boolean value if any expedition exists
	String xpathExpedition="//*[@class=\"layoutButton auctionWhite green  \"]";
	
	WebElement weHome = driver.findElement(By.xpath("//*[@id=\"n1\"]/a"));
	weHome.click();
		
	DriverUtil util=new DriverUtil();
	boolean expeditionExist=util.existElementByXpath(xpathExpedition, driver);
		
	return expeditionExist;
}

public void setHeroBonusProductionWood() {
	//set hero bonus on wood resource
	WebElement weHome = driver.findElement(By.xpath("//*[@id=\"n1\"]/a"));
	weHome.click();
	WebElement weHero = driver.findElement(By.xpath("//*[@id=\"heroImageButton\"]"));
	weHero.click();
	WebElement weRadioWood = driver.findElement(By.xpath("//*[@id=\"resourceHero1\"]"));
	weRadioWood.click();
	WebElement weSaveButton = driver.findElement(By.xpath("//*[@id=\"saveHeroAttributes\"]/div/div[2]"));
	weSaveButton.click();
}

public void setHeroBonusProductionClay() {
	//set hero bonus on clay resource
	WebElement weHome = driver.findElement(By.xpath("//*[@id=\"n1\"]/a"));
	weHome.click();
	WebElement weHero = driver.findElement(By.xpath("//*[@id=\"heroImageButton\"]"));
	weHero.click();
	WebElement weRadioWood = driver.findElement(By.xpath("//*[@id=\"resourceHero2\"]"));
	weRadioWood.click();
	WebElement weSaveButton = driver.findElement(By.xpath("//*[@id=\"saveHeroAttributes\"]/div/div[2]"));
	weSaveButton.click();
}

public void setHeroBonusProductionIron() {
	//set hero bonus on iron resource
	WebElement weHome = driver.findElement(By.xpath("//*[@id=\"n1\"]/a"));
	weHome.click();
	WebElement weHero = driver.findElement(By.xpath("//*[@id=\"heroImageButton\"]"));
	weHero.click();
	WebElement weRadioWood = driver.findElement(By.xpath("//*[@id=\"resourceHero3\"]"));
	weRadioWood.click();
	WebElement weSaveButton = driver.findElement(By.xpath("//*[@id=\"saveHeroAttributes\"]/div/div[2]"));
	weSaveButton.click();
}

public void setHeroBonusProductionCrop() {
	//set hero bonus on crop resource
	WebElement weHome = driver.findElement(By.xpath("//*[@id=\"n1\"]/a"));
	weHome.click();
	WebElement weHero = driver.findElement(By.xpath("//*[@id=\"heroImageButton\"]"));
	weHero.click();
	WebElement weRadioWood = driver.findElement(By.xpath("//*[@id=\"resourceHero4\"]"));
	weRadioWood.click();
	WebElement weSaveButton = driver.findElement(By.xpath("//*[@id=\"saveHeroAttributes\"]/div/div[2]"));
	weSaveButton.click();
}

public void setHeroBonusProductionAvg() {
	//set average hero bonus on each resource
	WebElement weHome = driver.findElement(By.xpath("//*[@id=\"n1\"]/a"));
	weHome.click();
	WebElement weHero = driver.findElement(By.xpath("//*[@id=\"heroImageButton\"]"));
	weHero.click();
	WebElement weRadioWood = driver.findElement(By.xpath("//*[@id=\"resourceHero0\"]"));
	weRadioWood.click();
	WebElement weSaveButton = driver.findElement(By.xpath("//*[@id=\"saveHeroAttributes\"]/div/div[2]"));
	weSaveButton.click();
}

public String getHeroBonusProduction() {
	//returns resource on which is currently applied hero bonus
	int resource=-1;
	String resourceName="";
	
	WebElement weHero = driver.findElement(By.xpath("//*[@id=\"heroImageButton\"]"));
	weHero.click();
	
	for(int i=0;i<5;i++) {
    boolean bonusResource = driver.findElement(By.xpath("//*[@id=\"resourceHero"+i+"\"]")).isSelected();
	if(bonusResource==true) {
		resource=i;
	}else {
		
	}
	}
	switch (resource) {
    case 0:  resourceName="avg";
            break;
    case 1:  resourceName="wood";
    		break;
    case 2:  resourceName="clay";
    		break;
    case 3:  resourceName="iron";
    		break;
    case 4:  resourceName="crop";
    		break;
	}
	
	return resourceName;
	
}

public boolean isHeroAtHome() {
	boolean atHome=true;
	DriverUtil util=new DriverUtil(driver);
	boolean result=util.getElementByClass("heroStatus100");	
	if(result=true) {
		atHome=true;
	}else {
		atHome=false;
	}
	return atHome;
}
public String inWhichWillageIsHero() {
	String willage="";
	boolean home=isHeroAtHome();
	if(home=true) {
		WebElement weHeroInfo = driver.findElement(By.xpath("//*[@id=\"heroImageButton\"]"));
		weHeroInfo.click();
		
		WebElement weWillage = driver.findElement(By.xpath("//*[@id=\"attributes\"]/div[1]/div[1]/div/span/a"));
		willage=weWillage.getText();
	}else {
		willage="Hero is not at home.";
	}
	
	
	return willage;
}

public int getNumberOfExpeditions() {
	int number=0;
	WebElement heroTable = driver.findElement(By.xpath("//*[@id=\"sidebarBoxHero\"]/div[2]/div[1]"));
	String num = heroTable.findElement(By.className("speechBubbleContent")).getText();
	number=Integer.parseInt(num);
	return number;
}

public String[][] getListOfExpeditions(){
	
	String[][] listOfExpeditions;
	if(existExpedition()==true) {
		
		listOfExpeditions= new String[getNumberOfExpeditions()][9];
		WebElement weHeroBar = driver.findElement(By.xpath("//*[@id=\"heroImageButton\"]"));
		weHeroBar.click();
		
		WebElement weExpeditions=driver.findElement(By.xpath("//button[@class=\"layoutButton adventureWhite green  \"]"));
		weExpeditions.click();
				
		WebElement weTableOfExp = driver.findElement(By.xpath("//*[@id=\"adventureListForm\"]/table/tbody"));
		
		List<WebElement>weExpTable = weTableOfExp.findElements(By.tagName("tr"));
	
		for(int i=0;i<getNumberOfExpeditions()-1;i++) {
			String tr="";
			tr=weExpTable.get(i).getText();
			String[] detailOfExp=tr.split(" ");
			
			for(int j=0;j<detailOfExp.length;j++) {
				detailOfExp[j]=listOfExpeditions[i][j];	
			}
			
		}
		System.out.println(weExpTable.get(2).getText());
		for(int p=0;p<listOfExpeditions.length;p++) {
			for(int o=0;o<listOfExpeditions[p].length;o++) {
				System.out.println(listOfExpeditions[p][o]);	
			}System.out.println();
		}
	}else {
		System.out.println("No Expedition available.");
		listOfExpeditions= new String[0][0];
	}
	return listOfExpeditions;
}
}
