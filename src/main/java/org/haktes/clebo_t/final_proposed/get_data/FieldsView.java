package org.haktes.clebo_t.final_proposed.get_data;

import org.haktes.clebo_t.final_proposed.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FieldsView {

	/**
	 * test, only the 1 will be returned
	 */
	public static String getWhatIsBuiltNow(WebDriver driver) {
		DriverUtils driverUtils = new DriverUtils(driver);
		String name = "";
		String lvl = "";
		String durationUnparsed = "";
		String timeLeft = "";
		try {

			driver.get("https://ts29.travian.sk/dorf1.php");
			if (driverUtils.exists(By.xpath("//div[@class=\"boxes buildingList\"]"))) {
				driverUtils.findElementAndSave(By.xpath("//div[@class=\"boxes buildingList\"]"));
				// here loop through elements <li> will be
				driverUtils.findElementAndSave(By.tagName("li")).getElement().getText();

				name = driverUtils.findElement(By.xpath("//*[@class=\"name\"]")).getLastElement().getText();
				lvl = driverUtils.findElement(By.xpath("//*[@class=\"lvl\"]")).getLastElement().getText();
				durationUnparsed = driverUtils.findElement(By.xpath("//*[@class=\"buildDuration\"]")).getLastElement()
						.getText();
				timeLeft = driverUtils.findElement(By.xpath("//*[@class=\"buildDuration\"]")).getLastElement()
						.getText();

				System.out.println("Name: " + name + " lvl: " + lvl + " time left: " + timeLeft);
			} else {
				System.out.println("Nothing is being built");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "test";
	}

}
