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
		
		//inicializacia pola objektov (zatial prazdne pole)
		BuildingInfo[] buildingInfo = new BuildingInfo[21];

		
		for(int i=1;i<21;i++) {
			
			//kliknut na button centrum dediny
			WebElement weCentrumDediny = driver.findElement(By.xpath("//*[@id='n2']/a"));
			//moveMouse.moveMouse(lastMousePos, pathGenerator.getMovementArray(lastMousePos, weCentrumDediny));
			weCentrumDediny.click();
			//postupne generovat vsetky policka budov
			String xpath="//*[@id=\"clickareas\"]/area["+i+"]";
			WebElement budova = driver.findElement(By.xpath(xpath));
			//moveMouse.moveMouse(lastMousePos, pathGenerator.getMovementArray(lastMousePos, hlavnaBudova));
			budova.click();
			
			//ziskat nazov budovy
			WebElement budovaNazov = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
			String nazov=budovaNazov.getText();
			System.out.println(nazov);

			//inicializacia i-teho objektu
			buildingInfo[i] = new BuildingInfo();
			//nastavim nazov policka (ci je na nom budova postavena alebo nie)
			buildingInfo[i].setBuildingName(nazov);

			if(nazov.equals("Postaviť novú budovu")) {
				//do nothing
			}else {
				
				WebElement budovaLevel = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
				String level=budovaLevel.getText();
				int levelNum=Integer.parseInt(level);
				buildingInfo[i].setBuildingLevel(levelNum);
				
				WebElement budovaNextWood = driver.findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/span[1]"));
				String Nwood=budovaNextWood.getText();
				int NwoodNum=Integer.parseInt(Nwood);
				buildingInfo[i].setNextLevelWood(NwoodNum);
				
				WebElement budovaNextClay = driver.findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/span[2]"));
				String Nclay=budovaNextClay.getText();
				int NclayNum=Integer.parseInt(Nclay);
				buildingInfo[i].setNextLevelClay(NclayNum);
				
				WebElement budovaNextIron = driver.findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/span[3]"));
				String Niron=budovaNextIron.getText();
				int NironNum=Integer.parseInt(Niron);
				buildingInfo[i].setNextLevelIron(NironNum);
				
				WebElement budovaNextCrop = driver.findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/span[4]"));
				String Ncrop=budovaNextCrop.getText();
				int NcropNum=Integer.parseInt(Ncrop);
				buildingInfo[i].setNextLevelCrop(NcropNum);
				
				WebElement budovaNextCropConsumption = driver.findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/span[5]"));
				String NcropConsum=budovaNextCropConsumption.getText();
				int NcropConsumNum=Integer.parseInt(NcropConsum);
				buildingInfo[i].setNextLevelCorpConsumption(NcropConsumNum);
				
				WebElement budovaNextTime = driver.findElement(By.xpath("//*[@id=\"build\"]/div[3]/div[4]/div[1]/span"));
				String Ntime=budovaNextTime.getText();
				int NtimeNum=Integer.parseInt(Ntime);
				buildingInfo[i].setNextLevelTime(NtimeNum);
				
				WebElement budovaNextTimeVideo = driver.findElement(By.xpath("//*[@id=\"build\"]/div[3]/div[4]/div[2]/span[1]"));
				String NtimeVideo=budovaNextTimeVideo.getText();
				int NtimeVideoNum=Integer.parseInt(NtimeVideo);
				buildingInfo[i].setNextLevelTimeVideo(NtimeVideoNum);
			}
		}
		
		//vypis informacii pre policko (napr. 13)
		
		String nazov= buildingInfo[13].getBuildingName();
		int level= buildingInfo[13].getBuildingLevel();
		
		System.out.println("Názov budovy: "+nazov);
		System.out.println("Level budovy je:"+level);
		
		/*
		System.out.println("suroviny potrebne na dalsi lvl: w:"+Nwood+" c:"+Nclay+" i:"+Niron+" c:"+Ncorp);
		System.out.println("Cas potrebny na vystavbu je: "+Ntime);
		System.out.println("Zrýchleny cas potrebny na vystavbu po pozreti videa je: "+NtimeVideo);
		System.out.println("Spotreba obilia pre budovu je:"+NcorpConsum);
		*/
		
		
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeDriver();
		quitDriver();

	}

}
