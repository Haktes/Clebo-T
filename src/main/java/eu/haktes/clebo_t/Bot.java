package eu.haktes.clebo_t;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import eu.haktes.clebo_t.interaction.ElementValues;
import eu.haktes.clebo_t.interaction.Movement;

public class Bot {
	
	private static Logger LOGGER = (Logger) LogManager.getLogger(BotAppStart.class);
	

	
	public void start() {
		
		LOGGER.debug("Log4j debug");
		LOGGER.info("Log4j info");
		LOGGER.warn("Log4j warn");
		LOGGER.error("Log4j error");
		
		

		// Properties properties = new Properties();
		// try {
		// properties = new GetPropertyValues().getPropValues();
		// } catch (IOException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// System.out.println(properties.getProperty("s1.address"));

		System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Hello World!");
		driver.get("C:\\workspace-sts\\Clebo-T\\mouseTest.html");
		
		//driver.manage().window().setSize(new Dimension(1024,768));
		
		
		List<int[]> list = new ArrayList<>();
		list = Movement.getMovementArray(new Point(1,1), driver.findElement(By.id("absolute")), 30);
		
		WebElement weblementBody = driver.findElement(By.cssSelector("body"));
		Actions moveMouse = new Actions(driver);
		moveMouse.moveToElement(weblementBody, 1, 1).perform(); // initial position		
		
		for (int[] pole: list) {
			moveMouse.pause(150).moveByOffset(pole[0], pole[1]).perform();
			System.out.println(pole[0] + " a "+pole[1] );
		}
		moveMouse = null;
		
		

		Actions builder = new Actions(driver);
		// builder.keyDown(Keys.CONTROL)
		// .click(driver.findElement(By.id("paint")))
		// .moveByOffset( 40, 40 ).moveByOffset( 40, 10 ).moveByOffset( 40, 0 )
		// .click(driver.findElement(By.id("paint")))
		// .keyUp(Keys.CONTROL).build().perform();		
		
		//builder.moveToElement( (driver.findElement(By.cssSelector("body"))), 10, 10).moveByOffset(10, 20).moveByOffset(10, 30).perform();
		
		// System.out.println("wait start");
		// try {
		// Thread.sleep(1);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// LOGGER.debug("Log4j debug");
		// LOGGER.info("Log4j info");
		// LOGGER.warn("Log4j warn");
		//
		// builder.click(driver.findElement(By.cssSelector("body"))).moveByOffset(40,
		// 40).moveByOffset(40, 10)
		// .moveByOffset(40, 0).build().perform();
		//
		// System.out.println("wait end");
		//
		// // builder.moveByOffset(-80, -40).moveByOffset(-70, -10).moveByOffset(-50,
		// 0).build().perform();
		// builder.moveByOffset(-80, -40).pause(100).perform();
		// builder.moveByOffset(-180, -140).pause(100).perform();
		// builder.moveByOffset(-280, -140).pause(100).perform();
		// builder.moveByOffset(-20, -140).pause(100).perform();
		// builder.moveByOffset(-40, -130).pause(100).perform();
		// builder.moveByOffset(-60, -120).pause(100).perform();
		//
		// driver.close();
		// driver.quit();

	}

}
