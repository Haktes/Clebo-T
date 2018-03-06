package eu.haktes.clebo_t;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import eu.haktes.clebo_t.actions.BasicActions;
import eu.haktes.clebo_t.actions.DriverUtil;
import eu.haktes.clebo_t.actions.Quests;
import eu.haktes.clebo_t.actions.Resources;
import eu.haktes.clebo_t.interaction.mouse.MoveMouse;
import eu.haktes.clebo_t.interaction.mouse.MovementPath;
import eu.haktes.clebo_t.interaction.mouse.MovementPathSimple;

public class BotTester extends Bot {

	private static final Logger LOG = (Logger) LogManager.getLogger(BotTester.class);

	public void start() {
		LOG.info("Lazy BOT started");

		getProperties();
		startDriver();

		DriverUtil driverUtil = new DriverUtil(driver);
		driverUtil.getElementByXpath("asd");

		BasicActions basicActions = new BasicActions(driver);
		basicActions.loginUser(properties.getProperty("s1.nick"), properties.getProperty("s1.pass"),
				properties.getProperty("s1.address"));

		Quests quests = new Quests(driverUtil);
		LOG.info("Are there finished quests?: " + quests.areThereFinishedQuests());

		Resources resources = new Resources();
		basicActions.getResources(resources);
		LOG.info(resources.toString());

		MoveMouse moveMouse = new MoveMouse(driver);
		MovementPath pathGenerator = new MovementPathSimple();

		WebElement weKupZlatky = driver.findElement(By.id("n7"));
		moveMouse.moveMouse(lastMousePos, pathGenerator.getMovementArray(lastMousePos, weKupZlatky));
		weKupZlatky.click();

		// driver.get("C:\\workspace-sts\\Clebo-T\\mouseTest.html");//test
		// driver.findElement(By.id("absolute");

		// Actions builder = new Actions(driver);
		// builder.keyDown(Keys.CONTROL)
		// .click(driver.findElement(By.id("paint")))
		// .moveByOffset( 40, 40 ).moveByOffset( 40, 10 ).moveByOffset( 40, 0 )
		// .click(driver.findElement(By.id("paint")))
		// .keyUp(Keys.CONTROL).build().perform();

		// try {
		// Thread.sleep(1);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// close after 10 seconds
		try {
			Thread.sleep(1000);
			LOG.info("exit in 10");
			Thread.sleep(1000);
			LOG.info("exit in 9");
			Thread.sleep(1000);
			LOG.info("exit in 8");
			Thread.sleep(1000);
			LOG.info("exit in 7");
			Thread.sleep(1000);
			LOG.info("exit in 6");
			Thread.sleep(1000);
			LOG.info("exit in 5");
			Thread.sleep(1000);
			LOG.info("exit in 4");
			Thread.sleep(1000);
			LOG.info("exit in 3");
			Thread.sleep(1000);
			LOG.info("exit in 2");
			Thread.sleep(1000);
			LOG.info("exit in 1");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeDriver();
		quitDriver();

	}

}
