package models;

import java.text.DecimalFormat;

import javax.servlet.ServletContext;

public class fareCalc {
	
	float fare;
	DecimalFormat df = new DecimalFormat("#.##");
	
	public void clacFare(ServletContext context , String travelType) {}
	public float getFare() { return this.fare; }

}
