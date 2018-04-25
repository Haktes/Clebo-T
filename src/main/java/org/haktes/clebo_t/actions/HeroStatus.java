package org.haktes.clebo_t.actions;

public class HeroStatus {


int health;
int xp;
int speedPerField;
int heroPlusProduction;
boolean heroHidden;
int strength;
int offBonus;
int deffBonus;
int productionPoints;

public HeroStatus() {
	
}

public HeroStatus(int health, int xp, int speedPerField, int heroPlusProduction, boolean heroHidden, int strength,
		int offBonus, int deffBonus, int productionPoints) {
	super();
	this.health = health;
	this.xp = xp;
	this.speedPerField = speedPerField;
	this.heroPlusProduction = heroPlusProduction;
	this.heroHidden = heroHidden;
	this.strength = strength;
	this.offBonus = offBonus;
	this.deffBonus = deffBonus;
	this.productionPoints = productionPoints;
}

public int getHealth() {
	return health;
}

public void setHealth(int health) {
	this.health = health;
}

public int getXp() {
	return xp;
}

public void setXp(int xp) {
	this.xp = xp;
}

public int getSpeedPerField() {
	return speedPerField;
}

public void setSpeedPerField(int speedPerField) {
	this.speedPerField = speedPerField;
}

public int getHeroPlusProduction() {
	return heroPlusProduction;
}

public void setHeroPlusProduction(int heroPlusProduction) {
	this.heroPlusProduction = heroPlusProduction;
}

public boolean isHeroHidden() {
	return heroHidden;
}

public void setHeroHidden(boolean heroHidden) {
	this.heroHidden = heroHidden;
}

public int getStrength() {
	return strength;
}

public void setStrength(int strength) {
	this.strength = strength;
}

public int getOffBonus() {
	return offBonus;
}

public void setOffBonus(int offBonus) {
	this.offBonus = offBonus;
}

public int getDeffBonus() {
	return deffBonus;
}

public void setDeffBonus(int deffBonus) {
	this.deffBonus = deffBonus;
}

public int getProductionPoints() {
	return productionPoints;
}

public void setProductionPoints(int productionPoints) {
	this.productionPoints = productionPoints;
}


}
