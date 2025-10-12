package models;


public class oneTripCalc extends fareCalc{
	
	public oneTripCalc(fareConfig fare_config , String travelType , String category , Boolean evening) {
		if(fare_config == null) System.out.println("An error occured while retrieving the fare_config object in the oneTripCalc!");
		else if(travelType.equals("city")) {
			this.fare = fare_config.getCityFare() + fare_config.getOneTripFare();
			
		}
		else {
			this.fare = fare_config.getInnerCityFare() + fare_config.getOneTripFare();
			
		}
		
		
		float totalDis = calcTotalDis(category , evening ,fare_config);
		this.fare -= this.fare*(totalDis/100);
		
		this.fare = Float.parseFloat(df.format(this.fare));
	}
	
public float calcTotalDis(String category , Boolean evening ,fareConfig fare_config) {
		
		float totalDis = 0;
		
		switch(category) {
			case "regular": totalDis += fare_config.getRegularFare(); break;
			case "student": totalDis += fare_config.getStudentFare(); break;
			case "senior": totalDis += fare_config.getSeniorFare(); break;
		}
		if(evening) totalDis += fare_config.getEveningFare();
		
		if(totalDis > 50) totalDis = 50;
		return totalDis;
		
	}
	
}
