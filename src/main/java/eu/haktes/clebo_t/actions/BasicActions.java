package eu.haktes.clebo_t.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import eu.haktes.clebo_t.utils.BasicUtils;

public class BasicActions {

    private static final Logger LOG =
        (Logger) LogManager.getLogger(BasicActions.class);

    static WebDriver driver;

    public BasicActions(WebDriver passDriver) {

        driver = passDriver;
    }

    /**
     * Login
     */
    public void loginUser(String name, String password, String link) {

        driver.get(link);
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@name='password']"))
            .sendKeys(password);
        driver.findElement(By.xpath("//input[@name='password']"))
            .sendKeys(Keys.ENTER);
    }

    /**
     * Get resources in current village or null if cant
     */
    public Resources getResources(Resources resources) {
        // By.xpath("//div[@class='alert alert-count']/p/b)

        try {
            WebElement weResourcePanel =
                driver.findElement(By.xpath("//ul[@id='stockBar']"));

            String max = weResourcePanel
                .findElement(By.xpath("//span[@id='stockBarWarehouse']"))
                .getText();
            String maxCrop = weResourcePanel
                .findElement(By.xpath("//span[@id='stockBarGranary']"))
                .getText();
            String res1 = weResourcePanel
                .findElement(By.xpath("//li[@id='stockBarResource1']"))
                .getText();
            String res2 = weResourcePanel
                .findElement(By.xpath("//li[@id='stockBarResource2']"))
                .getText();
            String res3 = weResourcePanel
                .findElement(By.xpath("//li[@id='stockBarResource3']"))
                .getText();
            String res4 = weResourcePanel
                .findElement(By.xpath("//li[@id='stockBarResource4']"))
                .getText();

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

}
