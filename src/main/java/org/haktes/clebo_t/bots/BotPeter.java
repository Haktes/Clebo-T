package org.haktes.clebo_t.bots;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.haktes.clebo_t.Bot;
import org.haktes.clebo_t.actions.BasicActions;
import org.haktes.clebo_t.actions.BuildResourcesFromTravianAnswers;
import org.haktes.clebo_t.actions.BuildTimesFromTravianAnswers;
import org.haktes.clebo_t.actions.BuildingInfo;
import org.haktes.clebo_t.actions.HeroActions;
import org.haktes.clebo_t.actions.HeroStatus;
import org.haktes.clebo_t.actions.ResourceFieldInfo;
import org.haktes.clebo_t.actions.Resources;
import org.haktes.clebo_t.interaction.mouse.MoveMouse;
import org.haktes.clebo_t.interaction.mouse.MovementPath;
import org.haktes.clebo_t.interaction.mouse.MovementPathSimple;
import org.haktes.clebo_t.utils.DriverUtil;
import org.openqa.selenium.By;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BotPeter extends Bot {

	private static final Logger LOG = (Logger) LogManager.getLogger(BotPeter.class);

	public void start() {
		LOG.info("Peter Lazy BOT started");

		getProperties();
		startDriver();
		
		//Get build times of buildings from travian answers
		//BuildTimesFromTravianAnswers getTimes = new BuildTimesFromTravianAnswers(driver);
		//getTimes.getBuildTimes();
		
		//BuildResourcesFromTravianAnswers getResources = new BuildResourcesFromTravianAnswers(driver);
		//getResources.getBuildResources();
		
		BasicActions basicActions = new BasicActions(driver);
		basicActions.loginUser(properties.getProperty("s1.nick"), properties.getProperty("s1.pass"),
				properties.getProperty("s1.address"));
		
		HeroActions heroAction = new HeroActions(driver);
		
		HeroStatus hero=new HeroStatus(0, 0, 0, 0, true, 0, 0, 0, 0);
		
		
		heroAction.getListOfExpeditions();
		

		
				
				
				// close after 3 seconds
		try {
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


