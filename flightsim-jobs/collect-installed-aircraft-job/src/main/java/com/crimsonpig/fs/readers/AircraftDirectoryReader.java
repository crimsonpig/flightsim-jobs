package com.crimsonpig.fs.readers;

import java.io.File;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class AircraftDirectoryReader implements ItemReader<File> {

	private String installedAircraftDirectory;
	private File[] aircraftFolders;
	private int arrayIndex;

	public void setInstalledAircraftDirectory(String installedAircraftDirectory) {
		this.installedAircraftDirectory = installedAircraftDirectory;
		this.aircraftFolders = new File(getInstalledAircraftDirectory()).listFiles();
		this.arrayIndex = -1;
	}

	public String getInstalledAircraftDirectory() {
		return installedAircraftDirectory;
	}

	public File read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		arrayIndex++;
		if(arrayIndex < aircraftFolders.length){
			return aircraftFolders[arrayIndex];
		}else{
			return null;
		}
	}

}
