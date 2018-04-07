package eu.haktes.clebo_t.actions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuildResourcesFromTravianAnswers {

	static WebDriver driver;

	public BuildResourcesFromTravianAnswers(WebDriver pageDriver) {

	    driver=pageDriver;
	}
	
	public void getBuildResources() {
		String resources[][]= new String[20][20];
			
		//go through the gid1 - gid40 (1-42)
		for(int i=1;i<42;i++) {
			String url="http://t4.answers.travian.sk/index.php?view=toolkit&action=building&gid="+i+"&mb=1&speed=1&linkdescription=tu";
					
			driver.get(url);
			int gid=i;
			
		
			if(gid>0 && gid <5) {
				resources=getResourcesOfBuildings(20, 6);
				saveResourcesToCsvFile(resources, ";", gid);
				System.out.println("1-5");
				
			} else if(gid>4 && gid<10){
				resources=getResourcesOfBuildings(5, 6);
				saveResourcesToCsvFile(resources, ";", gid);
				System.out.println("5-9");
				
			} else if(gid>9 && gid<12){
				resources=getResourcesOfBuildings(20, 6);
				saveResourcesToCsvFile(resources, ";", gid);
				System.out.println("10-11");
				
			} else if(gid==12){
				System.out.println("12 - do nothing");
				
			} else if(gid>12 && gid<15){
				resources=getResourcesOfBuildings(19, 6);
				saveResourcesToCsvFile(resources, ";", gid);
				System.out.println("13-14");
				
			} else if(gid==15){
				resources=getResourcesOfBuildings(20, 6);
				saveResourcesToCsvFile(resources, ";", gid);
				System.out.println("15 - main building - special function - need update reading from table");
				
			} else if(gid>15 && gid<23){
				resources=getResourcesOfBuildings(20, 6);
				saveResourcesToCsvFile(resources, ";", gid);
				System.out.println("16-22");
				
			} else if(gid==23 || gid==35){
				resources=getResourcesOfBuildings(10, 6);
				saveResourcesToCsvFile(resources, ";", gid);
				System.out.println("23 or 35");
				
			} else if(gid>23 && gid<35){
				resources=getResourcesOfBuildings(20, 6);
				saveResourcesToCsvFile(resources, ";", gid);
				System.out.println("24-34");
				
			} else if(gid>35 && gid<40){
				resources=getResourcesOfBuildings(20, 6);
				saveResourcesToCsvFile(resources, ";", gid);
				System.out.println("36-39");
				
			} else if(gid==40){
				resources=getResourcesOfBuildings(100, 6);
				saveResourcesToCsvFile(resources, ";", gid);
				System.out.println("40 - special function");
				
			} else if(gid==41){
				resources=getResourcesOfBuildings(20, 6);
				saveResourcesToCsvFile(resources, ";", gid);
				System.out.println("41");
				
			}else {

			}
		}
		}

		public String[][] getResourcesOfBuildings(int a, int b){
			String[][] resources = new String [a][b];
			int poleX=0;

			//set position of column
			for(int x=1;x<resources.length+1;x++) {
				
				
				int poleY=0;
				//set position of row
				for(int y=2;y<(resources[0].length)+2;y++) {
					
				String xpath="//*[@id=\"contentRight\"]/div[5]/div/table/tbody/tr["+x+"]/td["+y+"]";
				//get value from table based on position
				WebElement buildingName = driver.findElement(By.xpath(xpath));
				String resource=buildingName.getText();
				
				//store time in array
				resources[poleX][poleY]=resource;
				System.out.println(x+" "+y+ " - "+ resources[poleX][poleY]);
				poleY++;
								
										
			}
				poleX++;
		}
				return resources;
		}

	
	public void saveResourcesToCsvFile(String[][] array, String delimiter, int gid) {

			String[][] timesField=array;
			
			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter("C:\\workspace-sts\\Clebo-T\\ResourcesOfBuild\\gid"+gid+"_resources.txt"));
				
				for(int i = 0; i < timesField.length; i++){
					   for(int j = 0; j < timesField[0].length; j++){
					      if(timesField[i][j]==null){
					    	  //don´t append nothing
					      }else {
					    	  writer.write(timesField[i][j]+"");
					    	  writer.write(delimiter);

					      }
					}
					   writer.newLine();
				}
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		}
	
}
