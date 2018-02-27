package eu.haktes.clebo_t.actions;

/**
 * Class to store resources
 */

public class Resources {	
	
	private int wood =0;
	private int clay =0;
	private int iron =0;
	private int crop =0;
	
	private int maximum = 0;
	private int maximumCrop =0;
	
	public void Resources() {		
	}
	
	public void Resources(int wood, int clay, int iron, int crop, int maximum, int maximumCrop) {		
		this.wood = wood;
		this.clay = clay;
		this.iron = iron;
		this.crop = crop;
		this.maximum = maximum;
		this.maximumCrop = maximumCrop;
	}
	
	public void Resources(int wood, int clay, int iron, int crop) {		
		Resources(wood, clay, iron, crop, 0, 0);
	}	
	
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getMaximumCrop() {
		return maximumCrop;
	}
	public void setMaximumCrop(int maximumCrop) {
		this.maximumCrop = maximumCrop;
	}
	public int getWood() {
		return wood;
	}
	public void setWood(int wood) {
		this.wood = wood;
	}
	public int getClay() {
		return clay;
	}
	public void setClay(int clay) {
		this.clay = clay;
	}
	public int getIron() {
		return iron;
	}
	public void setIron(int iron) {
		this.iron = iron;
	}
	public int getCrop() {
		return crop;
	}
	public void setCrop(int crop) {
		this.crop = crop;
	}
	
	

}
