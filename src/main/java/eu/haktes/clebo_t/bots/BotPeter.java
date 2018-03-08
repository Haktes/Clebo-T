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

		//login
		BasicActions basicActions = new BasicActions(driver);
		basicActions.loginUser(properties.getProperty("s1.nick"), properties.getProperty("s1.pass"),
				properties.getProperty("s1.address"));
		Resources resources = new Resources();
		basicActions.getResources(resources);

		
		MoveMouse moveMouse = new MoveMouse(driver);
		MovementPath pathGenerator = new MovementPathSimple();
		
		//initialization of empty object field for buildings
		BuildingInfo[] buildingInfo = new BuildingInfo[21];
		//initialization of empty object field for ResourceFields
		ResourceFieldInfo[] resourceFieldInfo = new ResourceFieldInfo[21];
		
		
		//initialize driverUtil object
		DriverUtil driverUtil = new DriverUtil(driver);
		
		
		//---------------------------------Building Info Part---------------------------------------
		
		for(int i=1;i<21;i++) {
			String name="";
			//click on the button - village center
			WebElement weVillageCenter = driver.findElement(By.xpath("//*[@id='n2']/a"));
			//moveMouse.moveMouse(lastMousePos, pathGenerator.getMovementArray(lastMousePos, weCentrumDediny));
			weVillageCenter.click();
			
			String xpath="//*[@id=\"clickareas\"]/area["+i+"]";
			WebElement building = driver.findElement(By.xpath(xpath));
			//moveMouse.moveMouse(lastMousePos, pathGenerator.getMovementArray(lastMousePos, building));
			building.click();
			
			//get name of building
			WebElement buildingName = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
			name=buildingName.getText();
			
			//initialization of i-object
			buildingInfo[i] = new BuildingInfo();
			//check if gid0 class exists		
			String result = driverUtil.getElementByClass("gid0");
			
			if(result.equals("yes")) {
				buildingInfo[i].setBuildingName("Empty field");
				
			}else {
				buildingInfo[i].setBuildingName(name);
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
		
		//-------------------------------------End of BuildingInfo part---------------------------------
		
		//-------------------------------------ResourceFieldInfo part-----------------------------------
		
		
		
		for(int i=1;i<18;i++) {
			//click on the button - village Resources
			WebElement weVillageResources = driver.findElement(By.xpath("//*[@id=\"n1\"]/a"));
			//moveMouse.moveMouse(lastMousePos, pathGenerator.getMovementArray(lastMousePos, weCentrumDediny));
			weVillageResources.click();
			
			String xpathResource="//*[@id=\"rx\"]/area["+i+"]";
			WebElement resourceField = driver.findElement(By.xpath(xpathResource));
			//moveMouse.moveMouse(lastMousePos, pathGenerator.getMovementArray(lastMousePos, building));
			resourceField.click();
			
			//get name of building
			WebElement resourceFieldName = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
			String fieldName=resourceFieldName.getText();
			
			//initialization of i-object
			resourceFieldInfo[i] = new ResourceFieldInfo();
			
			
			resourceFieldInfo[i].setFieldType(fieldName);
			
			
			String fieldlevel=fieldName.substring(fieldName.length() - 2);
			fieldlevel=fieldlevel.trim();
			int fieldLevel=Integer.parseInt(fieldlevel);
			resourceFieldInfo[i].setFieldLevel(fieldLevel);
																	
			WebElement fieldNextWood = driver.findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/span[1]"));
			String fieldNwood=fieldNextWood.getText();
			int fieldNwoodNum=Integer.parseInt(fieldNwood);
			resourceFieldInfo[i].setNextFieldLevelWood(fieldNwoodNum);
			
			WebElement fieldNextClay = driver.findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/span[2]"));
			String fieldNclay=fieldNextClay.getText();
			int fieldNclayNum=Integer.parseInt(fieldNclay);
			resourceFieldInfo[i].setNextFieldLevelClay(fieldNclayNum);
			
			WebElement fieldNextIron = driver.findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/span[3]"));
			String fieldNiron=fieldNextIron.getText();
			int fieldNironNum=Integer.parseInt(fieldNiron);
			resourceFieldInfo[i].setNextFieldLevelIron(fieldNironNum);
			
			WebElement fieldNextCrop = driver.findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/span[4]"));
			String fieldNcrop=fieldNextCrop.getText();
			int fieldNcropNum=Integer.parseInt(fieldNcrop);
			resourceFieldInfo[i].setNextFieldLevelCrop(fieldNcropNum);
			
			WebElement fieldNextCropConsum = driver.findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/span[5]"));
			String fieldNcropConsum=fieldNextCropConsum.getText();
			int fieldNcropConsumNum=Integer.parseInt(fieldNcropConsum);
			resourceFieldInfo[i].setNextFieldLevelCropConsumption(fieldNcropConsumNum);
			
			
			WebElement fieldNextTime = driver.findElement(By.xpath("//*[@id=\"build\"]/div[3]/div[4]/div[1]/span"));
			String fieldNtime=fieldNextTime.getText();
			resourceFieldInfo[i].setNextFieldLevelTime(fieldNtime);

			WebElement fieldNextTimeVideo = driver.findElement(By.xpath("//*[@id=\"build\"]/div[3]/div[4]/div[2]/span[1]"));
			String fieldNtimeVideo=fieldNextTimeVideo.getText();
			resourceFieldInfo[i].setNextFieldLevelTimeVideo(fieldNtimeVideo);
			
						
		}
		
		String fnazov= resourceFieldInfo[8].getFieldType();
		int flevel= resourceFieldInfo[8].getFieldLevel();
		int fnextLevelWood= resourceFieldInfo[8].getNextFieldLevelWood();
		int fnextLevelClay= resourceFieldInfo[8].getNextFieldLevelClay();
		int fnextLevelIron= resourceFieldInfo[8].getNextFieldLevelIron();
		int fnextLevelCrop= resourceFieldInfo[8].getNextFieldLevelCrop();
		int fnextLevelCropConsum= resourceFieldInfo[8].getNextFieldLevelCropConsumption();
		String ftime= resourceFieldInfo[8].getNextFieldLevelTime();
		String ftimeVideo= resourceFieldInfo[8].getNextFieldLevelTimeVideo();
		
		System.out.println("Názov budovy: "+fnazov);
		System.out.println("Level budovy je:"+flevel);
		System.out.println("Wood: "+fnextLevelWood);
		System.out.println("Clay: "+fnextLevelClay);
		System.out.println("Iron: "+fnextLevelIron);
		System.out.println("Crop: "+fnextLevelCrop);
		System.out.println("Crop consume: "+fnextLevelCropConsum);
		System.out.println("Time: "+ftime);
		System.out.println("Time after video: "+ftimeVideo);
		
		
		
		
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
