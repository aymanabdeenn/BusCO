package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;

import DB.DBfare;
import models.fareConfig;

/**
 * Servlet implementation class changeFareRules
 */
@WebServlet("/changeFareRules")
public class changeFareRules extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */  
    public changeFareRules() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		
		try {
			String fareType = request.getParameter("fareType");
			float newFare = Float.parseFloat(request.getParameter("newFare"));
			
			ServletContext context = request.getServletContext();
			fareConfig fare_config = (fareConfig)context.getAttribute("fare_config");
			
			Connection conn = (Connection)request.getServletContext().getAttribute("connection");
			
			DBfare dbTest = new DBfare();
			
			switch(fareType) {
				case "city": {fare_config.setCityFare(context , newFare); dbTest.updateFare(conn , "cityFare" , newFare); break;}
				case "innerCity":{fare_config.setInnerCityFare(context , newFare); dbTest.updateFare(conn , "innerCityFare" , newFare); break;}
				case "oneTrip":{fare_config.setOneTripFare(context , newFare); dbTest.updateFare(conn , "oneTripFare" , newFare); break;}
				case "daily":{fare_config.setDailyFare(context , newFare); dbTest.updateFare(conn , "dailyFare" , newFare); break;}
				case "weekly":{fare_config.setWeeklyFare(context , newFare); dbTest.updateFare(conn , "weeklyFare" , newFare); break;}
				case "monthly":{fare_config.setMonthlyFare(context , newFare); dbTest.updateFare(conn , "monthlyFare" , newFare); break;}
				case "regular":{fare_config.setRegularFare(context , newFare); dbTest.updateFare(conn , "regularFare" , newFare); break;}
				case "student":{fare_config.setStudentFare(context , newFare); dbTest.updateFare(conn , "studentFare" , newFare); break;}
				case "senior":{fare_config.setSeniorFare(context , newFare); dbTest.updateFare(conn , "seniorFare" , newFare); break;}
				case "evening":{fare_config.setEveningFare(context , newFare); dbTest.updateFare(conn , "eveningFare" , newFare); break;}
			}
			
			RequestDispatcher rq = request.getRequestDispatcher("AdminChangeFareRules.html");
			rq.forward(request , response);
		}
		catch(NumberFormatException e) {
			System.out.println("Enter a number for the new fare!");
			RequestDispatcher rq2 = request.getRequestDispatcher("invalidNumber.html");
			rq2.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
