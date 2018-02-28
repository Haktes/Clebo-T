package eu.haktes.clebo_t.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import eu.haktes.clebo_t.Bot;

public class BasicActionsPeter {

	private static final Logger LOG = (Logger) LogManager.getLogger(BasicActionsPeter.class);
	static WebDriver driver;

	public BasicActionsPeter(WebDriver passDriver) {
		driver = passDriver;
	}

	/**
	 * Login
	 */
	public void loginUser(String name, String password, String link) {

		driver.get(link);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.ENTER);
	}

	/**
	 * Get resources in current village
	 */
	public Resources getResources(Resources resources) {
		//int number = Integer.parseInt(numberAsString);

		// Xpath=//tagname[@attribute='value']
		// By.xpath("//div[@class='alert alert-count']/p/b)
		// <li id="stockBarWarehouseWrapper" class="stock">
		WebElement weResourcePanel = driver.findElement(By.xpath("//ul[@id='stockBar']"));
		String max = weResourcePanel.findElement(By.xpath("//span[@id='stockBarWarehouse']")).getText();
		LOG.info("sklad: "+max);
		
		String res1 = weResourcePanel.findElement(By.xpath("//li[@id='stockBarResource1']")).getText();

		LOG.info("drev: "+res1);

		
		String res2 = weResourcePanel.findElement(By.xpath("//li[@id='stockBarResource2']")).getText();
		LOG.info("hlin: "+res2);		
		resources.setClay(Integer.parseInt(res2.replaceAll("[^0-9\\-]","")));
		LOG.info("Parsed:"+resources.getClay());
		
		
		String res3 = weResourcePanel.findElement(By.xpath("//li[@id='stockBarResource3']")).getText();
		LOG.info("zel: "+res3);
		String res4 = weResourcePanel.findElement(By.xpath("//li[@id='stockBarResource4']")).getText();
		LOG.info("obil: "+res4);
		String maxC = weResourcePanel.findElement(By.xpath("//span[@id='stockBarGranary']")).getText();
		LOG.info("skladObMax: "+maxC);

		return resources;

	}

}
