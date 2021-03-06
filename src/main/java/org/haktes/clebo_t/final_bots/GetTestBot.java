package org.haktes.clebo_t.final_bots;

import org.haktes.clebo_t.final_proposed.get_data.FieldsView;
import org.haktes.clebo_t.final_proposed.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTestBot {

	/**
	 * Test sending data
	 */
	public static void GetTest() {
		String DRIVER_PATH = "C:\\Java\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		DriverUtils driverUtilsHero = new DriverUtils(driver);

		driver.get("https://ts3.travian.sk/hero.php");
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("middlefinger");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("middlefinger123");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.ENTER);

		try {
			String hp;
			String xp;
			String speed;
			// driverUtilsHero.findElement(By.xpath("//*[@id=\"attributes\"]"));
			// driverUtilsHero.save();
			driverUtilsHero.findElementAndSave(By.xpath("//*[@id=\"attributes\"]"));
			hp = driverUtilsHero.findElement(By.xpath("//*[@id=\"attributes\"]/div[1]/div[3]/table/tbody/tr[1]/td[2]"))
					.getLastElement().getText();
			xp = driverUtilsHero.findElement(By.xpath("//*[@id=\"attributes\"]/div[1]/div[3]/table/tbody/tr[2]/td[2]"))
					.getLastElement().getText();
			speed = driverUtilsHero.findElement(By.xpath("//*[@id=\"heroSpeedValueNumber\"]")).getLastElement()
					.getText();

			System.out.println("hp: " + hp + " xp: " + xp + " speed" + speed);

			FieldsView.getWhatIsBuiltNow(driver);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
