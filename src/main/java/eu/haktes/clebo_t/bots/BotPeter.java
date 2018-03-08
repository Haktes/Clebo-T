package eu.haktes.clebo_t.bots;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import eu.haktes.clebo_t.Bot;
import eu.haktes.clebo_t.actions.BasicActions;
import eu.haktes.clebo_t.actions.BuildingInfo;
import eu.haktes.clebo_t.actions.ResourceFieldInfo;
import eu.haktes.clebo_t.actions.Resources;
import eu.haktes.clebo_t.interaction.mouse.MoveMouse;
import eu.haktes.clebo_t.interaction.mouse.MovementPath;
import eu.haktes.clebo_t.interaction.mouse.MovementPathSimple;
import eu.haktes.clebo_t.utils.DriverUtil;

public class BotPeter extends Bot {

	private static final Logger LOG = (Logger) LogManager.getLogger(BotPeter.class);

	public void start() {
		LOG.info("Peter Lazy BOT started");

		getProperties();
		startDriver();

		//initialize driverUtil object
		DriverUtil driverUtil = new DriverUtil(driver);
		
		String times[][]= new String[10][10];
		//go through the gid1 - gid40
		for(int i=1;i<4;i++) {
			
			String url="http://t4.answers.travian.sk/index.php?view=toolkit&action=buildingconstructiontimes&gid="+i+"&speed=1&linkdescription=tento+odkaz+pre+server+s+1x+r%C3%BDchlos%C5%A5ou ";
			driver.get(url);
			
			//set position of column
			for(int x=1;x<times.length;x++) {
				//set position of row
				for(int y=1;y<times.length;y++) {
					
				String xpath="//*[@id=\"contentRight\"]/div[5]/div/table/tbody/tr["+y+"]/td["+x+"]";
				//get value from table based on position
				WebElement buildingName = driver.findElement(By.xpath(xpath));
				String time=buildingName.getText();
				
				//store time in array
				times[x][y]=time;
				
				
				
				//when table will be in 2D array than finction writeTableToFile(array,nameOfFile) will save the times to csv file
				
				
			}
		}
				
			
			
			
			
				
			
		}
		
		System.out.println(times[1][1]);	
		System.out.println(times[1][3]);	
		System.out.println(times[1][5]);	
		System.out.println(times[1][7]);	
		System.out.println(times[2][1]);	
		System.out.println(times[2][5]);	
		
		
		
		
		//login
		/*
		BasicActions basicActions = new BasicActions(driver);
		basicActions.loginUser(properties.getProperty("s1.nick"), properties.getProperty("s1.pass"),
				properties.getProperty("s1.address"));
		Resources resources = new Resources();
		basicActions.getResources(resources);

		
		MoveMouse moveMouse = new MoveMouse(driver);
		MovementPath pathGenerator = new MovementPathSimple();
		
		
*/
		// close after 10 seconds
		try {
			/*
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
			*/
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
