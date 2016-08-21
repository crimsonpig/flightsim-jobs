package com.crimsonpig.fs.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.crimsonpig.fs.domain.airport.ConvertedFS9Airport;
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
	
	private ConvertedFS9Airport getOntarioAirport(){
		ConvertedFS9Airport kont = new ConvertedFS9Airport();
		kont.setIdentifier("KONT");
		kont.setLatitudeRadians(0.59438933);
		kont.setLongitudeRadians(-2.05252806);
		return kont;
	}
	
	private ConvertedFS9Airport getSacramentoAirport(){
		ConvertedFS9Airport ksmf = new ConvertedFS9Airport();
		ksmf.setIdentifier("KSMF");
		ksmf.setLatitudeRadians(0.67536243);
		ksmf.setLongitudeRadians(-2.12215942);
		return ksmf;
	}
	
	private ConvertedFS9Airport getEugeneAirport(){
		ConvertedFS9Airport keug = new ConvertedFS9Airport();
		keug.setIdentifier("KEUG");
		keug.setLatitudeRadians(0.77009599);
		keug.setLongitudeRadians(-2.15057143);
		return keug;
	}
	
	private ConvertedFS9Airport getSanDiegoAirport(){
		ConvertedFS9Airport ksan = new ConvertedFS9Airport();
		ksan.setIdentifier("KSAN");
		ksan.setLatitudeRadians(0.57130831);
		ksan.setLongitudeRadians(-2.04534553);
		return ksan;
	}
	
	private ConvertedFS9Airport getAtlantaAirport(){
		ConvertedFS9Airport katl = new ConvertedFS9Airport();
		katl.setIdentifier("KATL");
		katl.setLatitudeRadians(0.58713653);
		katl.setLongitudeRadians(-1.47352817);
		return katl;
	}
}
