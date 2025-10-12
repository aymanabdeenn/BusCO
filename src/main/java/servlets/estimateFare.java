package servlets;

import javax.servlet.http.HttpSession;

import models.dailyPassCalc;
import models.fareCalc;
import models.fareConfig;
import models.monthlyPassCalc;
import models.oneTripCalc;
import models.weeklyPassCalc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.DBtrips;

/**
 * Servlet implementation class estimateFare
 */
@WebServlet("/estimateFare")
public class estimateFare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public estimateFare() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		int tripNumber = Integer.parseInt(request.getParameter("tripNumber"));
		String ticketType = (String)request.getParameter("ticketType");
		String category = (String)request.getParameter("category");
	
		fareConfig fare_config = (fareConfig)request.getServletContext().getAttribute("fare_config");
		
		HttpSession session = request.getSession(false);
		if(session == null) {System.out.println("The session has not been created!"); return;}
		
		DBtrips DBtest = new DBtrips();
		Connection conn = (Connection)request.getServletContext().getAttribute("connection");
		if(conn == null) {conn = DBtest.makeConnection(); request.setAttribute("connection", conn);}
		
		ResultSet rs = DBtest.getSpecificTrip(conn, tripNumber);
		
		Boolean oneTripEvening = false;
		try {
			rs.next();
			Timestamp timestamp = rs.getTimestamp("departureTime");
			LocalTime tripTime = timestamp.toLocalDateTime().toLocalTime();
			LocalTime fixedTime = LocalTime.of(19, 0, 0);
			if(tripTime.isAfter(fixedTime)) oneTripEvening = true;
			
			
			fareCalc fare = new fareCalc();
			if(ticketType.equals("one trip")) {fare = new oneTripCalc(fare_config, rs.getString("travelType") , category , oneTripEvening); }
			else if(ticketType.equals("daily pass")) {fare = new dailyPassCalc(fare_config, rs.getString("travelType") , category);}
			else if(ticketType.equals("weekly pass")) {fare = new weeklyPassCalc(fare_config, rs.getString("travelType") , category);}
			else if(ticketType.equals("monthly pass")) {fare = new monthlyPassCalc(fare_config, rs.getString("travelType") , category);}
			session.setAttribute("fare" , fare.getFare()+"");
			
			if(rs != null) rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
			
		RequestDispatcher rq = request.getRequestDispatcher("estimatedCost.jsp");
		rq.forward(request , response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
