package org.haktes.clebo_t.actions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuildTimesFromTravianAnswers {
	

static WebDriver driver;

public BuildTimesFromTravianAnswers(WebDriver pageDriver) {

    driver=pageDriver;
}


public void getBuildTimes() {
	String times[][]= new String[20][20];
		
	//go through the gid1 - gid40 (1-42)
	for(int i=1;i<42;i++) {
		String url="http://t4.answers.travian.sk/index.php?view=toolkit&action=buildingconstructiontimes&gid="+i+"&speed=1&linkdescription=tento+odkaz+pre+server+s+1x+r%C3%BDchlos%C5%A5ou ";
		driver.get(url);
		int gid=i;
		
	
		if(gid>0 && gid <5) {
			times=getTimesOfBuildings(10, 20);
			saveTimesToCsvFile(times, ";", gid);
			System.out.println("1-5");
			
		} else if(gid>4 && gid<10){
			times=getTimesOfBuildings(5, 20);
			saveTimesToCsvFile(times, ";", gid);
			System.out.println("5-9");
			
		} else if(gid>9 && gid<12){
			times=getTimesOfBuildings(20, 20);
			saveTimesToCsvFile(times, ";", gid);
			System.out.println("10-11");
			
		} else if(gid==12){
			System.out.println("12 - do nothing");
			
		} else if(gid>12 && gid<15){
			times=getTimesOfBuildings(19, 20);
			saveTimesToCsvFile(times, ";", gid);
			System.out.println("13-14");
			
		} else if(gid==15){
			times=getTimesOfMainBuilding(20, 20);
			saveTimesToCsvFile(times, ";", gid);
			System.out.println("15 - main building - special function - need update reading from table");
			
		} else if(gid>15 && gid<23){
			times=getTimesOfBuildings(20, 20);
			saveTimesToCsvFile(times, ";", gid);
			System.out.println("16-22");
			
		} else if(gid==23 || gid==35){
			times=getTimesOfBuildings(10, 20);
			saveTimesToCsvFile(times, ";", gid);
			System.out.println("23 or 35");
			
		} else if(gid>23 && gid<35){
			times=getTimesOfBuildings(20, 20);
			saveTimesToCsvFile(times, ";", gid);
			System.out.println("24-34");
			
		} else if(gid>35 && gid<40){
			times=getTimesOfBuildings(20, 20);
			saveTimesToCsvFile(times, ";", gid);
			System.out.println("36-39");
			
		} else if(gid==40){
			times=getTimesOfBuildings(100, 20);
			saveTimesToCsvFile(times, ";", gid);
			System.out.println("40 - special function");
			
		} else if(gid==41){
			times=getTimesOfBuildings(20, 20);
			saveTimesToCsvFile(times, ";", gid);
			System.out.println("41");
			
		}else {
		}
	}
}
	



public String[][] getTimesOfBuildings(int a, int b){
			String[][] times = new String [a][b];
			int poleX=0;

			//set position of column
			for(int x=1;x<times.length+1;x++) {
				
				
				int poleY=0;
				//set position of row
				for(int y=2;y<(times[0].length)+2;y++) {
					
				String xpath="//*[@id=\"contentRight\"]/div[5]/div/table/tbody/tr["+x+"]/td["+y+"]";
				//get value from table based on position
				WebElement buildingName = driver.findElement(By.xpath(xpath));
				String time=buildingName.getText();
				
				//store time in array
				times[poleX][poleY]=time;
				System.out.println(x+" "+y+ " - "+ times[poleX][poleY]);
				poleY++;
								
				//when table will be in 2D array than function writeTableToFile(array,nameOfFile) will save the times to csv file
							
			}
				poleX++;
		}
				return times;
		}



public String[][] getTimesOfMainBuilding(int a, int b){
			String[][] times = new String [a][b];
			//set position of column
			for(int x=1;x<times.length;x++) {
					
				String xpath="//*[@id=\"contentRight\"]/div[5]/div/table/tbody/tr["+x+"]/td["+(x+2)+"]";
				//get value from table based on position
				WebElement buildingName = driver.findElement(By.xpath(xpath));
				String time=buildingName.getText();
				
				//store time in array
				times[x][x]=time;
				System.out.println(x+" "+(x+2)+ " - "+ times[x][x]);
		}
				return times;
		}


		
public void saveTimesToCsvFile(String[][] array, String delimiter, int gid) {

			String[][] timesField=array;
			
			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter("C:\\workspace-sts\\Clebo-T\\TimesOfBuild\\gid"+gid+"_buildTime.txt"));
				
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
