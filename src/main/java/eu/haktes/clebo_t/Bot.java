package eu.haktes.clebo_t;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import eu.haktes.clebo_t.interaction.MovementPathSimple;

public class Bot {

	private static final Logger LOG = (Logger) LogManager.getLogger(Bot.class);
	private static final String DRIVER_PATH = "C:\\Java\\chromedriver.exe";
	public WebDriver driver;

	public void start() {
		LOG.info("BOT started");
		// Properties properties = new Properties();
		// try {
		// properties = new GetPropertyValues().getPropValues();
		// } catch (IOException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// System.out.println(properties.getProperty("s1.address"));

		startDriver();

		driver.get("C:\\workspace-sts\\Clebo-T\\mouseTest.html");
		// driver.manage().window().setSize(new Dimension(1024,768));

		List<int[]> list = new ArrayList<>();
		list = new MovementPathSimple().getMovementArray(new Point(3, 500), driver.findElement(By.id("absolute")));

		WebElement weblementBody = driver.findElement(By.cssSelector("body"));
		Actions moveMouse = new Actions(driver);
		moveMouse.moveToElement(weblementBody, 3, 500).perform(); // initial position

		for (int[] pole : list) {
			moveMouse.pause(10).moveByOffset(pole[0], pole[1]).perform();
		}
		moveMouse = null;

		Actions builder = new Actions(driver);
		// builder.keyDown(Keys.CONTROL)
		// .click(driver.findElement(By.id("paint")))
		// .moveByOffset( 40, 40 ).moveByOffset( 40, 10 ).moveByOffset( 40, 0 )
		// .click(driver.findElement(By.id("paint")))
		// .keyUp(Keys.CONTROL).build().perform();

		// builder.moveToElement( (driver.findElement(By.cssSelector("body"))), 10,
		// 10).moveByOffset(10, 20).moveByOffset(10, 30).perform();

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
		// LOGGER.info("Closing driver");
		// driver.close();
		// LOGGER.info("Quitting driver");
		// driver.quit();

	}

	private void startDriver() {
		LOG.info("DRIVER - Locate driver.");

		File f = new File(DRIVER_PATH);
		if (f.exists() && f.isFile()) {
			LOG.info("DRIVER - Driver located at defined path, starting.");
			System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
			this.driver = new ChromeDriver();
		} else {
			LOG.error("DRIVER - Not found at defined path! " + DRIVER_PATH);
			LOG.error("Terminating application");
			System.exit(1);
		}

		// String currentDirectory;
		// File file = new File(".");
		// currentDirectory = file.getAbsolutePath();
		// System.out.println("Current working directory : " + currentDirectory);
	}

}
