package eu.haktes.clebo_t;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {    	
    	System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        System.out.println( "Hello World!" );
        driver.get("https://google.com");
    }
}
