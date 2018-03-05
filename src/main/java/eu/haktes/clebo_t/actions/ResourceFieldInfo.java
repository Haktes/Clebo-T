package eu.haktes.clebo_t.actions;

/**
 * Class for storing information about currently built resource fields
 */

public class ResourceFieldInfo {	
	
	private String fieldType="";
	private int fieldLevel=0;
	private int nextFieldLevelWood=0;
	private int nextFieldLevelClay=0;
	private int nextFieldLevelIron=0;
	private int nextFieldLevelCrop=0;
	private String nextFieldLevelTime="";
	private String nextFieldLevelTimeVideo="";
	private int nextFieldLevelCropConsumption=0;
		
	public void ResourceFieldInfo() {		
	}
	
	public void Resources(String fieldType, int fieldLevel, int nextFieldLevelWood, int nextFieldLevelClay, int nextFieldLevelIron, int nextFieldLevelCrop, String nextFiledLevelTime, String nextFieldLevelTimeVideo, int nextFieldLevelCorpConsumption) {		
		this.fieldType = fieldType;
		this.fieldLevel = fieldLevel;
		this.nextFieldLevelWood = nextFieldLevelWood;
		this.nextFieldLevelClay = nextFieldLevelClay;
		this.nextFieldLevelIron = nextFieldLevelIron;
		this.nextFieldLevelCrop = nextFieldLevelCrop;
		this.nextFieldLevelTime = nextFieldLevelTime;
		this.nextFieldLevelTimeVideo = nextFieldLevelTimeVideo;
		this.nextFieldLevelCropConsumption = nextFieldLevelCropConsumption;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public int getFieldLevel() {
		return fieldLevel;
	}

	public void setFieldLevel(int fieldLevel) {
		this.fieldLevel = fieldLevel;
	}

	public int getNextFieldLevelWood() {
		return nextFieldLevelWood;
	}

	public void setNextFieldLevelWood(int nextFieldLevelWood) {
		this.nextFieldLevelWood = nextFieldLevelWood;
	}

	public int getNextFieldLevelClay() {
		return nextFieldLevelClay;
	}

	public void setNextFieldLevelClay(int nextFieldLevelClay) {
		this.nextFieldLevelClay = nextFieldLevelClay;
	}

	public int getNextFieldLevelIron() {
		return nextFieldLevelIron;
	}

	public void setNextFieldLevelIron(int nextFieldLevelIron) {
		this.nextFieldLevelIron = nextFieldLevelIron;
	}

	public int getNextFieldLevelCrop() {
		return nextFieldLevelCrop;
	}

	public void setNextFieldLevelCrop(int nextFieldLevelCrop) {
		this.nextFieldLevelCrop = nextFieldLevelCrop;
	}

	public String getNextFieldLevelTime() {
		return nextFieldLevelTime;
	}

	public void setNextFieldLevelTime(String nextFieldLevelTime) {
		this.nextFieldLevelTime = nextFieldLevelTime;
	}

	public String getNextFieldLevelTimeVideo() {
		return nextFieldLevelTimeVideo;
	}

	public void setNextFieldLevelTimeVideo(String nextFieldLevelTimeVideo) {
		this.nextFieldLevelTimeVideo = nextFieldLevelTimeVideo;
	}

	public int getNextFieldLevelCropConsumption() {
		return nextFieldLevelCropConsumption;
	}

	public void setNextFieldLevelCropConsumption(int nextFieldLevelCropConsumption) {
		this.nextFieldLevelCropConsumption = nextFieldLevelCropConsumption;
	}

	
	
		
	
	
	
	

}
