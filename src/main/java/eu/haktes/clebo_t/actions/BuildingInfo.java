package eu.haktes.clebo_t.actions;

/**
 * Class to store resources
 */

public class BuildingInfo {	
	
	private String buildingName="";
	private int buildingLevel=0;
	private int nextLevelWood=0;
	private int nextLevelClay=0;
	private int nextLevelIron=0;
	private int nextLevelCrop=0;
	private String nextLevelTime="";
	private String nextLevelTimeVideo="";
	private int nextLevelCorpConsumption=0;
		
	public void Resources() {		
	}
	
	public void Resources(String buildingName, int buildingLevel, int nextLevelWood, int nextLevelClay, int nextLevelIron, int nextLevelCrop, String nextLevelTime, String nextLevelTimeVideo, int nextLevelCorpConsumption) {		
		this.buildingName = buildingName;
		this.buildingLevel = buildingLevel;
		this.nextLevelWood = nextLevelWood;
		this.nextLevelClay = nextLevelClay;
		this.nextLevelIron = nextLevelIron;
		this.nextLevelCrop = nextLevelCrop;
		this.nextLevelTime = nextLevelTime;
		this.nextLevelTimeVideo=nextLevelTimeVideo;
		this.nextLevelCorpConsumption=nextLevelCorpConsumption;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public int getBuildingLevel() {
		return buildingLevel;
	}

	public void setBuildingLevel(int buildingLevel) {
		this.buildingLevel = buildingLevel;
	}

	public int getNextLevelWood() {
		return nextLevelWood;
	}

	public void setNextLevelWood(int nextLevelWood) {
		this.nextLevelWood = nextLevelWood;
	}

	public int getNextLevelClay() {
		return nextLevelClay;
	}

	public void setNextLevelClay(int nextLevelClay) {
		this.nextLevelClay = nextLevelClay;
	}

	public int getNextLevelIron() {
		return nextLevelIron;
	}

	public void setNextLevelIron(int nextLevelIron) {
		this.nextLevelIron = nextLevelIron;
	}

	public int getNextLevelCrop() {
		return nextLevelCrop;
	}

	public void setNextLevelCrop(int nextLevelCrop) {
		this.nextLevelCrop = nextLevelCrop;
	}

	public String getNextLevelTime() {
		return nextLevelTime;
	}

	public void setNextLevelTime(String nextLevelTime) {
		this.nextLevelTime = nextLevelTime;
	}
	
	public String getNextLevelTimeVideo() {
		return nextLevelTimeVideo;
	}

	public void setNextLevelTimeVideo(String nextLevelTimeVideo) {
		this.nextLevelTimeVideo = nextLevelTimeVideo;
	}

	public int getNextLevelCorpConsumption() {
		return nextLevelCorpConsumption;
	}

	public void setNextLevelCorpConsumption(int nextLevelCorpConsumption) {
		this.nextLevelCorpConsumption = nextLevelCorpConsumption;
	}
	
		
	
	
	
	

}
