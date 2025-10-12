package models;

import javax.servlet.ServletContext;

public class fareConfig {
	float cityFare , innerCityFare ,  oneTripFare , dailyFare, weeklyFare , monthlyFare  , regularFare, studentFare, seniorFare, eveningFare;
	
	public fareConfig(float cityFare , float innerCityFare , float oneTripFare , float dailyFare , float weeklyFare , float monthlyFare , float regularFare , float studentFare , float seniorFare , float eveningFare) {
		this.cityFare = cityFare;
		this.innerCityFare = innerCityFare;
		this.oneTripFare = oneTripFare;
		this.dailyFare = dailyFare;
		this.weeklyFare = weeklyFare;
		this.monthlyFare = monthlyFare;
		this.regularFare = regularFare;
		this.studentFare = studentFare;
		this.seniorFare = seniorFare;
		this.eveningFare = eveningFare;
	}
	
	public fareConfig(ServletContext context) {
		this.cityFare = Float.parseFloat(context.getInitParameter("travelTypeCity"));
		this.innerCityFare = Float.parseFloat(context.getInitParameter("travelTypeInnerCity"));
		this.oneTripFare = Float.parseFloat(context.getInitParameter("oneTrip"));
		this.dailyFare = Float.parseFloat(context.getInitParameter("dailyPass"));
		this.weeklyFare = Float.parseFloat(context.getInitParameter("weeklyPass"));
		this.monthlyFare = Float.parseFloat(context.getInitParameter("monthlyPass"));
		this.regularFare = Float.parseFloat(context.getInitParameter("regular"));
		this.studentFare = Float.parseFloat(context.getInitParameter("student"));
		this.seniorFare = Float.parseFloat(context.getInitParameter("senior"));
		this.eveningFare = Float.parseFloat(context.getInitParameter("eveningFare"));
	}

	public float getCityFare() {
		return cityFare;
	}

	public void setCityFare(ServletContext context , float cityFare) {
		System.out.println("The old value is " + this.cityFare);
		this.cityFare = cityFare;
		System.out.println("The new value is " + this.cityFare);
	}

	public float getInnerCityFare() {
		return innerCityFare;
	}

	public void setInnerCityFare(ServletContext context , float innerCityFare) {
		System.out.println("The old value is " + this.innerCityFare);
		this.innerCityFare = innerCityFare;
		System.out.println("The new value is " + this.innerCityFare);
	}

	public float getOneTripFare() {
		return oneTripFare;
	}

	public void setOneTripFare(ServletContext context ,float oneTripFare) {
		System.out.println("The old value is " + this.oneTripFare);
		this.oneTripFare = oneTripFare;
		System.out.println("The new value is " + this.oneTripFare);
	}

	public float getDailyFare() {
		return dailyFare;
	}

	public void setDailyFare(ServletContext context , float dailyFare) {
		System.out.println("The old value is " + this.dailyFare);
		this.dailyFare = dailyFare;
		System.out.println("The new value is " + this.dailyFare);
	}

	public float getWeeklyFare() {
		return weeklyFare;
	}

	public void setWeeklyFare(ServletContext context , float weeklyFare) {
		System.out.println("The old value is " + this.weeklyFare);
		this.weeklyFare = weeklyFare;
		System.out.println("The new value is " + this.weeklyFare);
	}

	public float getMonthlyFare() {
		return monthlyFare;
	}

	public void setMonthlyFare(ServletContext context , float monthlyFare) {
		System.out.println("The old value is " + this.monthlyFare);
		this.monthlyFare = monthlyFare;
		System.out.println("The new value is " + this.monthlyFare);
	}

	public float getRegularFare() {
		return regularFare;
	}

	public void setRegularFare(ServletContext context , float regularFare) {
		System.out.println("The old value is " + this.regularFare);
		this.regularFare = regularFare;
		System.out.println("The new value is " + this.regularFare);
	}

	public float getStudentFare() {
		return studentFare;
	}

	public void setStudentFare(ServletContext context ,float studentFare) {
		System.out.println("The old value is " + this.studentFare);
		this.regularFare = studentFare;
		System.out.println("The new value is " + this.studentFare);
	}

	public float getSeniorFare() {
		return seniorFare;
	}

	public void setSeniorFare(ServletContext context , float seniorFare) {
		System.out.println("The old value is " + this.seniorFare);
		this.seniorFare = seniorFare;
		System.out.println("The new value is " + this.seniorFare);
	}

	public float getEveningFare() {
		return eveningFare;
	}

	public void setEveningFare(ServletContext context ,float eveningFare) {
		System.out.println("The old value is " + this.eveningFare);
		this.eveningFare = eveningFare;
		System.out.println("The new value is " + this.eveningFare);
	}
	
	public String toString() {
		return "city:" + this.cityFare + " InnerCity:" + this.innerCityFare + " oneTrip:" + this.oneTripFare + " daily:" +  this.dailyFare + " weekly:" + this.weeklyFare + " monthly:" + this.monthlyFare + " regular:" + this.regularFare + " student:" + this.studentFare + " senior:" + this.seniorFare;
	}

}
