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
				new DistanceAndHeadingService();
		DistanceAndHeading dAndH = service.computeDistanceAndHeading(getOntarioAirport(), getSacramentoAirport());
		assertEquals(338,dAndH.getDistance(),0.5);
		assertEquals(326,dAndH.getHeading(),0.5);
	}
	
	@Test
	public void smfToOntTest(){
		DistanceAndHeadingService service = 
				new DistanceAndHeadingService();
		DistanceAndHeading dAndH = service.computeDistanceAndHeading(getSacramentoAirport(), getOntarioAirport());
		assertEquals(338,dAndH.getDistance(),0.5);
		assertEquals(144,dAndH.getHeading(),0.5);		
	}
	
	@Test
	public void smfToEugTest(){
		DistanceAndHeadingService service = 
				new DistanceAndHeadingService();
		DistanceAndHeading dAndH = service.computeDistanceAndHeading(getSacramentoAirport(), getEugeneAirport());
		assertEquals(334, dAndH.getDistance(), 0.5);
		assertEquals(348,dAndH.getHeading(),0.5);			
	}
	
	@Test
	public void sanToAtlTest(){
		DistanceAndHeadingService service = 
				new DistanceAndHeadingService();
		DistanceAndHeading dAndH = service.computeDistanceAndHeading(getSanDiegoAirport(), getAtlantaAirport());
		assertEquals(1639, dAndH.getDistance(), 0.5);
		assertEquals(79,dAndH.getHeading(),0.5);		
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
	
	private ConvertedAirport getSanDiegoAirport(){
		ConvertedAirport ksan = new ConvertedAirport();
		ksan.setIdentifier("KSAN");
		ksan.setLatitudeRadians(0.57130831);
		ksan.setLongitudeRadians(-2.04534553);
		return ksan;
	}
	
	private ConvertedAirport getAtlantaAirport(){
		ConvertedAirport katl = new ConvertedAirport();
		katl.setIdentifier("KATL");
		katl.setLatitudeRadians(0.58713653);
		katl.setLongitudeRadians(-1.47352817);
		return katl;
	}
}
