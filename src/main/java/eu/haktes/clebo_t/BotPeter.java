package eu.haktes.clebo_t;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import eu.haktes.clebo_t.actions.BasicActions;
import eu.haktes.clebo_t.actions.BuildingInfo;
import eu.haktes.clebo_t.actions.Resources;
import eu.haktes.clebo_t.interaction.mouse.MoveMouse;
import eu.haktes.clebo_t.interaction.mouse.MovementPath;
import eu.haktes.clebo_t.interaction.mouse.MovementPathSimple;

public class BotPeter extends Bot {

	private static final Logger LOG = (Logger) LogManager.getLogger(BotPeter.class);

	public void start() {
		LOG.info("Peter Lazy BOT started");

		getProperties();
		startDriver();

		//login
		BasicActions basicActions = new BasicActions(driver);
		basicActions.loginUser(properties.getProperty("s1.nick"), properties.getProperty("s1.pass"),
				properties.getProperty("s1.address"));
		Resources resources = new Resources();
		basicActions.getResources(resources);

		
		MoveMouse moveMouse = new MoveMouse(driver);
		MovementPath pathGenerator = new MovementPathSimple();
		
		//initialization of empty object field
		BuildingInfo[] buildingInfo = new BuildingInfo[21];

		
		for(int i=1;i<21;i++) {
			
			//click on the button - village center
			WebElement weVillageCenter = driver.findElement(By.xpath("//*[@id='n2']/a"));
			//moveMouse.moveMouse(lastMousePos, pathGenerator.getMovementArray(lastMousePos, weCentrumDediny));
			weVillageCenter.click();
			
			String xpath="//*[@id=\"clickareas\"]/area["+i+"]";
			WebElement building = driver.findElement(By.xpath(xpath));
			//moveMouse.moveMouse(lastMousePos, pathGenerator.getMovementArray(lastMousePos, hlavnaBudova));
			building.click();
			
			//get name of building
			WebElement buildingName = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
			String name=buildingName.getText();
			System.out.println(name);

			//initialization of i-object
			buildingInfo[i] = new BuildingInfo();
			//set the name of i-object
			buildingInfo[i].setBuildingName(name);

			if(name.equals("Postaviť novú budovu")) {
				//do nothing
			}else {
				
				WebElement buildingLevel = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
				String level=buildingLevel.getText();
				level=level.substring(level.length() - 2);
				level=level.trim();
				int levelNum=Integer.parseInt(level);
				buildingInfo[i].setBuildingLevel(levelNum);
				
				WebElement buildingNextWood = driver.findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/span[1]"));
				String Nwood=buildingNextWood.getText();
				int NwoodNum=Integer.parseInt(Nwood);
				buildingInfo[i].setNextLevelWood(NwoodNum);
				
				WebElement buildingNextClay = driver.findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/span[2]"));
				String Nclay=buildingNextClay.getText();
				int NclayNum=Integer.parseInt(Nclay);
				buildingInfo[i].setNextLevelClay(NclayNum);
				
				WebElement buildingNextIron = driver.findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/span[3]"));
				String Niron=buildingNextIron.getText();
				int NironNum=Integer.parseInt(Niron);
				buildingInfo[i].setNextLevelIron(NironNum);
				
				WebElement buildingNextCrop = driver.findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/span[4]"));
				String Ncrop=buildingNextCrop.getText();
				int NcropNum=Integer.parseInt(Ncrop);
				buildingInfo[i].setNextLevelCrop(NcropNum);
				
				WebElement buildingNextCropConsumption = driver.findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/span[5]"));
				String NcropConsum=buildingNextCropConsumption.getText();
				int NcropConsumNum=Integer.parseInt(NcropConsum);
				buildingInfo[i].setNextLevelCorpConsumption(NcropConsumNum);
				
				WebElement buildingNextTime = driver.findElement(By.xpath("//*[@id=\"build\"]/div[3]/div[4]/div[1]/span"));
				String Ntime=buildingNextTime.getText();
				buildingInfo[i].setNextLevelTime(Ntime);
				
				WebElement buildingNextTimeVideo = driver.findElement(By.xpath("//*[@id=\"build\"]/div[3]/div[4]/div[2]/span[1]"));
				String NtimeVideo=buildingNextTimeVideo.getText();
				buildingInfo[i].setNextLevelTimeVideo(NtimeVideo);
			}
		}
		
		//print the info about building
		
		String nazov= buildingInfo[8].getBuildingName();
		int level= buildingInfo[8].getBuildingLevel();
		int nextLevelWood= buildingInfo[8].getNextLevelWood();
		int nextLevelClay= buildingInfo[8].getNextLevelClay();
		int nextLevelIron= buildingInfo[8].getNextLevelIron();
		int nextLevelCrop= buildingInfo[8].getNextLevelCrop();
		int nextLevelCropConsum= buildingInfo[8].getNextLevelCorpConsumption();
		String time= buildingInfo[8].getNextLevelTime();
		String timeVideo= buildingInfo[8].getNextLevelTimeVideo();
		
		System.out.println("Názov budovy: "+nazov);
		System.out.println("Level budovy je:"+level);
		System.out.println("Wood: "+nextLevelWood);
		System.out.println("Clay: "+nextLevelClay);
		System.out.println("Iron: "+nextLevelIron);
		System.out.println("Crop: "+nextLevelCrop);
		System.out.println("Crop consume: "+nextLevelCropConsum);
		System.out.println("Time: "+time);
		System.out.println("Time after video: "+timeVideo);
		
		//WebElement weKupZlatky = driver.findElement(By.id("n7"));
		//moveMouse.moveMouse(lastMousePos, pathGenerator.getMovementArray(lastMousePos, weKupZlatky));
		//weKupZlatky.click();

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
