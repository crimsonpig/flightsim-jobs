package com.crimsonpig.fs.service.generate;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

import com.crimsonpig.fs.service.generate.DepartureTimeService;

public class DepartureTimeServiceTest {

	@Test
	public void singleIncrementTest(){
		DepartureTimeService service = new DepartureTimeService();
		LocalTime sixAmPdt = LocalTime.of(13, 0, 0);
		LocalTime sixOFiveAmPdt = LocalTime.of(13, 5, 0);
		assertEquals(sixAmPdt, service.getNextDepartureTimeAsGmt(-7));
		assertEquals(sixOFiveAmPdt, service.getNextDepartureTimeAsGmt(-7));
	}
	
	@Test
	public void rollOverTest(){
		DepartureTimeService service = new DepartureTimeService();
		LocalTime sixAmPdt = LocalTime.of(13, 0, 0);
		assertEquals(sixAmPdt, service.getNextDepartureTimeAsGmt(-7));
		LocalTime testTime = sixAmPdt;
		for(int i=0; i <= 46; i++){
			testTime = testTime.plusMinutes(5);
			assertEquals(testTime, service.getNextDepartureTimeAsGmt(-7));
		}
		assertEquals(sixAmPdt, service.getNextDepartureTimeAsGmt(-7));
	}
	
	@Test
	public void get6amEasternDaylightTimeAsGmt(){
		DepartureTimeService service = new DepartureTimeService();
		LocalTime sixAmEdt = LocalTime.of(10, 0, 0);
		assertEquals(sixAmEdt, service.getNextDepartureTimeAsGmt(-4));
	}
}
