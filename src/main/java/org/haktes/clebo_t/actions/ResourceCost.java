package org.haktes.clebo_t.actions;

public class ResourceCost {

	private int wood = 0;
	private int clay = 0;
	private int iron = 0;
	private int crop = 0;
	private int cropConsumption = 0;
	private int timeInMinutes = 0;

	public ResourceCost() {
	}

	public ResourceCost(int wood, int clay, int iron, int crop, int cropConsumption, int timeInMinutes) {
		super();
		this.wood = wood;
		this.clay = clay;
		this.iron = iron;
		this.crop = crop;
		this.cropConsumption = cropConsumption;
		this.timeInMinutes = timeInMinutes;
	}

	public ResourceCost(int wood, int clay, int iron, int crop, int cropConsumption) {
		this(wood, clay, iron, crop, cropConsumption, 0);
	}

	public ResourceCost(int wood, int clay, int iron, int crop) {
		this(wood, clay, iron, crop, 0, 0);
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

	public int getCropConsumption() {
		return cropConsumption;
	}

	public void setCropConsumption(int cropConsumption) {
		this.cropConsumption = cropConsumption;
	}

	public int getTimeInMinutes() {
		return timeInMinutes;
	}

	public void setTimeInMinutes(int timeInMinutes) {
		this.timeInMinutes = timeInMinutes;
	}

}
