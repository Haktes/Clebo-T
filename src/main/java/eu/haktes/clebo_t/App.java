package eu.haktes.clebo_t;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App {
	
	private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger("App");
		
	public static void main(String[] args) {
		
		
		LOGGER.debug("Log4j debug");
		LOGGER.info("Log4j info");
		LOGGER.warn("Log4j warn");

		Properties properties = new Properties();
		try {
			properties = new GetPropertyValues().getPropValues();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(properties.getProperty("s1.address"));

		System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Hello World!");
		driver.get("C:\\workspace-sts\\Clebo-T\\mouseTest.html");

		Actions builder = new Actions(driver);

		// builder.keyDown(Keys.CONTROL)
		// .click(driver.findElement(By.id("paint")))
		// .moveByOffset( 40, 40 ).moveByOffset( 40, 10 ).moveByOffset( 40, 0 )
		// .click(driver.findElement(By.id("paint")))
		// .keyUp(Keys.CONTROL).build().perform();
		
		builder.moveToElement( (driver.findElement(By.cssSelector("body"))), 10, 10).moveByOffset(10, 20).moveByOffset(10, 30).perform();
		
		System.out.println("wait start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LOGGER.debug("Log4j debug");
		LOGGER.info("Log4j info");
		LOGGER.warn("Log4j warn");
		
		builder.click(driver.findElement(By.cssSelector("body"))).moveByOffset(40, 40).moveByOffset(40, 10)
		.moveByOffset(40, 0).build().perform();
		
		System.out.println("wait end");

		// builder.moveByOffset(-80, -40).moveByOffset(-70, -10).moveByOffset(-50, 0).build().perform();
		builder.moveByOffset(-80, -40).pause(2000).perform();
		builder.moveByOffset(-180, -140).pause(2000).perform();
		builder.moveByOffset(-280, -140).pause(2000).perform();
		builder.moveByOffset(-20, -140).pause(1000).perform();
		builder.moveByOffset(-40, -130).pause(1000).perform();
		builder.moveByOffset(-60, -120).pause(1000).perform();
	}
	

}
