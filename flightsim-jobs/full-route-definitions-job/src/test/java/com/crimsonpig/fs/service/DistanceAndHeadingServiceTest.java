package com.crimsonpig.fs.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.crimsonpig.fs.domain.airport.ConvertedAirport;
import com.crimsonpig.fs.domain.route.DistanceAndHeading;
import com.crimsonpig.fs.service.DistanceAndHeadingService;

public class DistanceAndHeadingServiceTest {

	@Test
	public void ontToSmfTest(){
		DistanceAndHeadingService service = 
				new DistanceAndHeadingService(getOntarioAirport(), getSacramentoAirport());
		DistanceAndHeading dAndH = service.computeDistanceAndHeading();
		assertEquals(338,dAndH.getDistance(),0.5);
		assertEquals(326,dAndH.getHeading(),0.5);
	}
	
	@Test
	public void smfToOntTest(){
		DistanceAndHeadingService service = 
				new DistanceAndHeadingService(getSacramentoAirport(), getOntarioAirport());
		DistanceAndHeading dAndH = service.computeDistanceAndHeading();
		assertEquals(338,dAndH.getDistance(),0.5);
		assertEquals(144,dAndH.getHeading(),0.5);		
	}
	
	@Test
	public void smfToEugTest(){
		DistanceAndHeadingService service = 
				new DistanceAndHeadingService(getSacramentoAirport(), getEugeneAirport());
		DistanceAndHeading dAndH = service.computeDistanceAndHeading();
		assertEquals(334, dAndH.getDistance(), 0.5);
		assertEquals(348,dAndH.getHeading(),0.5);			
	}
	
	private ConvertedAirport getOntarioAirport(){
		ConvertedAirport kont = new ConvertedAirport();
		kont.setIdentifier("KONT");
		kont.setLatitudeRadians(0.59438933);
		kont.setLongitudeRadians(-2.05252806);
		return kont;
	}
	
	private ConvertedAirport getSacramentoAirport(){
		ConvertedAirport ksmf = new ConvertedAirport();
		ksmf.setIdentifier("KSMF");
		ksmf.setLatitudeRadians(0.67536243);
		ksmf.setLongitudeRadians(-2.12215942);
		return ksmf;
	}
	
	private ConvertedAirport getEugeneAirport(){
		ConvertedAirport keug = new ConvertedAirport();
		keug.setIdentifier("KEUG");
		keug.setLatitudeRadians(0.77009599);
		keug.setLongitudeRadians(-2.15057143);
		return keug;
	}
}
