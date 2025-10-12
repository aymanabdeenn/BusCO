package models;


public class weeklyPassCalc extends fareCalc{
	
	public weeklyPassCalc(fareConfig fare_config , String travelType , String category) {
		if(fare_config == null) System.out.println("An error occured while retrieving the fare_config object in the dailyPassCalc!");
		else if(travelType.equals("city")) {
			this.fare = fare_config.getCityFare() + fare_config.getWeeklyFare();
			
		}
		else {
			this.fare = fare_config.getInnerCityFare() + fare_config.getWeeklyFare();
			
		}
		
		float totalDis = calcTotalDis(category ,fare_config);
		this.fare -= this.fare*(totalDis/100);
		
		this.fare = Float.parseFloat(df.format(this.fare));
	}
	
public float calcTotalDis(String category , fareConfig fare_config) {
		
		float totalDis = 0;
		
		switch(category) {
			case "regular": totalDis += fare_config.getRegularFare(); break;
			case "student": totalDis += fare_config.getStudentFare(); break;
			case "senior": totalDis += fare_config.getSeniorFare(); break;
		}
		
		if(totalDis > 50) totalDis = 50;
		return totalDis;
		
	}

}
