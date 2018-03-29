package eu.haktes.clebo_t.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import eu.haktes.clebo_t.utils.BasicUtils;

public class BasicActions {


	private static final Logger LOG = (Logger) LogManager.getLogger(BasicActions.class);

	static WebDriver driver;

	public BasicActions(WebDriver passDriver) {

		driver = passDriver;
	}

	/**
	 * Login
	 */
	public void loginUser(String name, String password, String link) {

		try {
			driver.get(link);
			driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.ENTER);
		} catch (NoSuchElementException e) {
			LOG.error("Cant login, invalid fields");
		}

	}
	
	/**
	 * Returns true on login
	 */
	public boolean loginUserWithAnswer(String name, String password, String link) {

		try {
			driver.get(link);
			driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.ENTER);
			return true;
		} catch (NoSuchElementException e) {
			LOG.error("Cant login, invalid fields.");
		}		
		return false;
	}

	/**
	 * Get resources in current village or null if cant
	 */
	public Resources getResources(Resources resources) {
		// By.xpath("//div[@class='alert alert-count']/p/b)

		try {
			WebElement weResourcePanel = driver.findElement(By.xpath("//ul[@id='stockBar']"));

			String max = weResourcePanel.findElement(By.xpath("//span[@id='stockBarWarehouse']")).getText();
			String maxCrop = weResourcePanel.findElement(By.xpath("//span[@id='stockBarGranary']")).getText();
			String res1 = weResourcePanel.findElement(By.xpath("//li[@id='stockBarResource1']")).getText();
			String res2 = weResourcePanel.findElement(By.xpath("//li[@id='stockBarResource2']")).getText();
			String res3 = weResourcePanel.findElement(By.xpath("//li[@id='stockBarResource3']")).getText();
			String res4 = weResourcePanel.findElement(By.xpath("//li[@id='stockBarResource4']")).getText();

			resources.setMaximum(BasicUtils.stringToInt(max));
			resources.setMaximumCrop(BasicUtils.stringToInt(maxCrop));
			resources.setWood(BasicUtils.stringToInt(res1));
			resources.setClay(BasicUtils.stringToInt(res2));
			resources.setIron(BasicUtils.stringToInt(res3));
			resources.setCrop(BasicUtils.stringToInt(res4));

			return resources;

		} catch (Exception e) {
			LOG.error("Can't get resources!");
		}

		return null;
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
    	System.out.println(health);
    	health=health.replace("%", "");
    	System.out.println(health);
    	int healthInt=BasicUtils.stringToInt(health);
    	System.out.println(healthInt);
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


}
