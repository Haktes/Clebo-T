package eu.haktes.clebo_t.bots;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import eu.haktes.clebo_t.Bot;
import eu.haktes.clebo_t.actions.BasicActions;
import eu.haktes.clebo_t.actions.Quests;
import eu.haktes.clebo_t.actions.Resources;
import eu.haktes.clebo_t.interaction.mouse.MoveMouse;
import eu.haktes.clebo_t.interaction.mouse.MovementPath;
import eu.haktes.clebo_t.interaction.mouse.MovementPathSimple;
import eu.haktes.clebo_t.utils.DriverUtil;
import eu.haktes.clebo_t.utils.FileUtil;
import eu.haktes.clebo_t.utils.GetPropertyValues;

/**
 * This bot will try to play new village AFTER race and place selection the firs
 * step is to disable help
 * 
 * BotNewStart.properties 
 * s.address=https://tsX.travian.sk/ 
 * s.nick=***
 * s.pass=***
 *
 */
public class BotNewStart {

	private static final String DRIVER_PATH = "C:\\Java\\chromedriver.exe";
	protected Properties properties;
	protected WebDriver driver;
	protected DriverUtil driverUtil;
	protected Point lastMousePos = new Point(800, 800);
	private static final Logger LOG = (Logger) LogManager.getLogger(BotNewStart.class);

	private static final String BOT_NEW_START_DONE = "BotNewStart\\BotNewStart.done";
	private static final String BOT_NEW_START_NEXT = "BotNewStart\\BotNewStart.next";
	private static final String BOT_NEW_START_LOG = "BotNewStart\\BotNewStart.log";

	public void start() {

		// init
		startDriver();
		driverUtil = new DriverUtil(driver);
		BasicActions basicActions = new BasicActions(driver);
		getProperties();

		// STEP - LOGIN
		if (!basicActions.loginUserWithAnswer(properties.getProperty("s.nick"), properties.getProperty("s.pass"),
				properties.getProperty("s.address")) || !driver.getCurrentUrl().contains("dorf1")) {
			// login not successful
			unrecoverableSituationExit("Could not login");
		}

		// STEP - check if its turned off
		turnOffTutorial();
		acceptTutorialReward();

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
			e.printStackTrace();
		}

		closeDriver();
		quitDriver();

	}

	protected String time() {
		Date date = new Date();
		DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS");
		String stringDate = sdf.format(date);

		return stringDate;
	}

	protected void logBot(String lineTowrite) {
		if (!FileUtil.doesFileExits(BOT_NEW_START_LOG)) {// maybe not n
			FileUtil.createNewFile(BOT_NEW_START_LOG);
		}
		FileUtil.appendFileWithLine(BOT_NEW_START_LOG, "\n" + time() + " :: " + lineTowrite);

	}

	protected void getProperties() {
		try {
			this.properties = new GetPropertyValues().getPropValues("BotNewStart.properties");
		} catch (IOException e1) {
			LOG.error("application.properties not found!");
			e1.printStackTrace();
		}
	}

	protected void startDriver() {
		LOG.info("DRIVER - Locate driver.");

		File f = new File(DRIVER_PATH);
		if (f.exists() && f.isFile()) {
			LOG.info("DRIVER - Driver located at defined path, starting.");
			System.setProperty("webdriver.chrome.driver", DRIVER_PATH);

			ChromeOptions chromeOptions = new ChromeOptions();
			// chromeOptions.setProxy(null);
			chromeOptions.addArguments("--mute-audio");
			chromeOptions.addArguments("user-data-dir=C:/ChromeDriverCace");

			this.driver = new ChromeDriver(chromeOptions);

		} else {
			LOG.error("DRIVER - Not found at defined path! Download chromedriver.exe to " + DRIVER_PATH);
			LOG.error("Terminating application");
			System.exit(1);
		}

	}

	protected void unrecoverableSituationExit(String message) {
		LOG.error("UNRECOVERABLE SITUATION: " + message);
		LOG.error("UNRECOVERABLE SITUATION - EXIT ");
		closeDriver();
		quitDriver();
		System.exit(1);
	}

	protected void closeDriver() {
		LOG.info("Closing driver");
		driver.close();
	}

	protected void quitDriver() {
		LOG.info("Quitting driver");
		driver.quit();
	}

	/**
	 * Turns off tutorial
	 */
	protected void turnOffTutorial() {
		if (!FileUtil.doesFileExits(BOT_NEW_START_DONE)) {

			FileUtil.createNewFile(BOT_NEW_START_DONE);
			logBot("Created " + BOT_NEW_START_DONE);

			// file is empty then the step is not done
			if (FileUtil.readFirstLineFromFile(BOT_NEW_START_DONE).equals("")) {

				// if both exist (are non-empty)
				if (!driver.findElements(By.xpath("//button[@id=\"questTutorialLightBulb\"]")).isEmpty() && !driver
						.findElements(By.xpath("//button[@class=\"green questButtonSkipTutorial\"]")).isEmpty()) {

					// just for case
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

					}
					// TODO Add real click
					WebElement weLightBulb = driver.findElement(By.xpath("//button[@id=\"questTutorialLightBulb\"]"));
					weLightBulb.click();

					WebElement weSkipTutorial = driver
							.findElement(By.xpath("//button[@class=\"green questButtonSkipTutorial\"]"));
					weSkipTutorial.click();

					// lots of writing, this is a big thing
					LOG.info("Tutorial turned off");
					FileUtil.appendFileWithLine(BOT_NEW_START_DONE, "Tutorial turned off");
					logBot("Tutorial turned off");
				} else {
					unrecoverableSituationExit("Tutorial not found after login");
				}
			}
		}
	}

	/**
	 * Accept quest reward for quest <button type="submit" value="Vyzdvihnúť odmenu"
	 * ... questid="Tutorial_15a">
	 */
	protected boolean acceptTutorialReward() {

		if (FileUtil.readLastLineFromFile(BOT_NEW_START_DONE).contains("Tutorial")
				&& !driver.findElements(By.xpath("//button[@questid=\"Tutorial_15a\"]")).isEmpty()) {
			LOG.info("Quest Dialog open, clicking");
			driver.findElement(By.xpath("//button[@questid=\"Tutorial_15a\"]")).click();
			FileUtil.appendFileWithLine(BOT_NEW_START_DONE, "Tutorial reward claimed");
			logBot("Tutorial reward claimed");
			return true;
		} else {
			LOG.info("Quest dialog not open, trying to open...");

			if (!driver.findElements(By.xpath("//div[@class=\"bigSpeechBubble newQuestSpeechBubble\"]")).isEmpty()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}
				LOG.info("Quest dialog open");
				driver.findElement(By.xpath("//div[@class=\"bigSpeechBubble newQuestSpeechBubble\"]")).click();
				driver.findElement(By.xpath("//button[@questid=\"Tutorial_15a\"]")).click();
				FileUtil.appendFileWithLine(BOT_NEW_START_DONE, "Tutorial reward claimed");
				logBot("Tutorial reward claimed");
				return true;
			} else {
				logBot("failed: Tutorial reward claimed");
				LOG.info("Claiming tutorial reward failed.");
				return false;
			}

		}
	}

}
