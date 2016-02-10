package com.crimsonpig.fs.service.generate;

import com.crimsonpig.fs.domain.airport.ConvertedAirport;
import com.crimsonpig.fs.domain.route.DistanceAndHeading;

public class DistanceAndHeadingService {
	
	private double originLatitude;
	private double originLongitude;
	private double destinationLatitude;
	private double destinationLongitude;

	public DistanceAndHeadingService(ConvertedAirport originAirport, ConvertedAirport destinationAirport){
		originLatitude = originAirport.getLatitudeRadians();
		originLongitude = originAirport.getLongitudeRadians();
		destinationLatitude = destinationAirport.getLatitudeRadians();
		destinationLongitude = destinationAirport.getLongitudeRadians();
	}

	public DistanceAndHeading computeDistanceAndHeading(){

		double temp1 = (Math.sin(originLatitude) * Math.sin(destinationLatitude)) 
				+ (Math.cos(originLatitude) * Math.cos(destinationLatitude) * Math.cos(originLongitude - destinationLongitude));
		
		//prevent acos overflow
	    if(temp1 > 1.0){
	    	temp1 = 1.0;
	    } else if(temp1 < -1.0){
	    	temp1 = -1.0;
	    }
	    
	    double d = Math.acos(temp1);
	    
	    double distance = d * 180 * 60 / Math.PI;
	    
		double h = 0;

		if(Math.cos(originLatitude) < 0.000001){
			if(originLatitude > 0){
				h = Math.PI;
			}else{
				h = 2 * Math.PI;
			}
		}else{
			//(sin(End->Lat) - (sin(Start->Lat) * cos(d))) / (sin(d) * cos(Start->Lat));  
			double temp2 = 
					(Math.sin(destinationLatitude) - (Math.sin(originLatitude) * Math.cos(d))) 
							/ (Math.sin(d) * Math.cos(originLatitude));
			//prevent acos overflow
			if(temp2 > 1.0){
				temp2 = 1.0;
			}else if(temp2 < -1.0){
				temp2 = -1.0;
			}
			
			h = Math.acos(temp2);
			
			if(Math.sin(originLongitude - destinationLongitude) >= 0){
				h = (2 * Math.PI) - h;
			}
		}
		
		double heading = ( h / (2 * Math.PI) ) * 360;
		return new DistanceAndHeading(distance, heading);
	}
}
