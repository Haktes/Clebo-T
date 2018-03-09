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
		String times[][]= new String[20][20];
		
		
		
		//go through the gid1 - gid40
		for(int i=1;i<2;i++) {
			String url="http://t4.answers.travian.sk/index.php?view=toolkit&action=buildingconstructiontimes&gid="+i+"&speed=1&linkdescription=tento+odkaz+pre+server+s+1x+r%C3%BDchlos%C5%A5ou ";
			driver.get(url);
			int gid=i;
			int poleX=0;
			int poleY=0;
			
					
			
			//set position of column
			for(int x=1;x<times.length;x++) {
				poleX=0;
				poleY=0;
				//set position of row
				for(int y=2;y<(times.length)+2;y++) {
					
				String xpath="//*[@id=\"contentRight\"]/div[5]/div/table/tbody/tr["+x+"]/td["+y+"]";
				//get value from table based on position
				WebElement buildingName = driver.findElement(By.xpath(xpath));
				String time=buildingName.getText();
				
				//store time in array
				times[poleX][poleY]=time;
				System.out.println(x+" "+y+ " - "+ times[poleX][poleY]);
				poleY++;
								
				//when table will be in 2D array than finction writeTableToFile(array,nameOfFile) will save the times to csv file
							
			}
				poleX++;
		}
				
				
		}
		
		System.out.println(times[1][1]);	
		System.out.println(times[1][3]);	
		System.out.println(times[1][5]);	
		System.out.println(times[1][7]);	
		System.out.println(times[2][1]);	
		System.out.println(times[2][5]);	
		
		
		
		if(gid>0 && gid <5) {
			//do the mapping of table for 
			System.out.println("1-5");
		} else if(gid>4 && gid<10){
			System.out.println("5-9");
		} else if(gid>9 && gid<12){
			System.out.println("10-11");
		} else if(gid==12){
			System.out.println("12 - do nothing");
		} else if(gid>12 && gid<15){
			System.out.println("13-14");
		} else if(gid==15){
			System.out.println("15 - main building - special function");
		} else if(gid>15 && gid<23){
			System.out.println("16-22");
		} else if(gid==23 || gid==35){
			System.out.println("23 or 35");
		} else if(gid>23 && gid<35){
			System.out.println("24-34");
		} else if(gid>35 && gid<40){
			System.out.println("36-39");
		} else if(gid==40){
			System.out.println("40 - special function");
		} else if(gid==41){
			System.out.println("41");
		}
				
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


