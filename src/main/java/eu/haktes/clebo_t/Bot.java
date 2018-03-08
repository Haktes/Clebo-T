package eu.haktes.clebo_t;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import eu.haktes.clebo_t.actions.BasicActions;
import eu.haktes.clebo_t.actions.Resources;
import eu.haktes.clebo_t.interaction.mouse.MoveMouse;
import eu.haktes.clebo_t.interaction.mouse.MovementPath;
import eu.haktes.clebo_t.interaction.mouse.MovementPathSimple;
import eu.haktes.clebo_t.utils.GetPropertyValues;

public class Bot {

	private static final Logger LOG = (Logger) LogManager.getLogger(Bot.class);
	private static final String DRIVER_PATH = "C:\\Java\\chromedriver.exe";
	protected Properties properties;
	protected WebDriver driver;
	protected Point lastMousePos = new Point(3, 500);

	public void start() {
		LOG.info("BOT started");
		getProperties();
		startDriver();

		BasicActions basicActions = new BasicActions(driver);
		basicActions.loginUser(properties.getProperty("s1.nick"), properties.getProperty("s1.pass"),
				properties.getProperty("s1.address"));
		Resources resources = new Resources();
		basicActions.getResources(resources);

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

	protected void startDriver() {
		LOG.info("DRIVER - Locate driver.");

		File f = new File(DRIVER_PATH);
		if (f.exists() && f.isFile()) {
			LOG.info("DRIVER - Driver located at defined path, starting.");
			System.setProperty("webdriver.chrome.driver", DRIVER_PATH);

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--mute-audio");

			// System.setProperty("webdriver.chrome.args", "--disable-logging");
			// System.setProperty("webdriver.chrome.silentOutput", "true");// disable red
			// console messages
			this.driver = new ChromeDriver(chromeOptions);
			// driver.get("C:\\workspace-sts\\Clebo-T\\mouseTest.html");
			// driver.manage().window().setSize(new Dimension(1024,768));
		} else {
			LOG.error("DRIVER - Not found at defined path! Download chromedriver.exe to " + DRIVER_PATH);
			LOG.error("Terminating application");
			System.exit(1);
		}

		// ChromeOptions chromeOptions = setupChromeOptions();
		// System.setProperty("webdriver.chrome.logfile", "\\path\\chromedriver.log");
		// System.setProperty("webdriver.chrome.driver", "\\path\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.args", "--disable-logging");
		// System.setProperty("webdriver.chrome.silentOutput", "true");
		// driver = new ChromeDriver(chromeOptions);
	}

	protected void getProperties() {
		try {
			this.properties = new GetPropertyValues().getPropValues();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			LOG.error("application.properties not found! read application_sample");
			e1.printStackTrace();
		}
	}

	protected void closeDriver() {
		LOG.info("Closing driver");
		driver.close();
	}

	protected void quitDriver() {
		LOG.info("Quitting driver");
		driver.quit();
	}

}
