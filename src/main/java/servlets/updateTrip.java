package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;

import DB.DBtrips;
import trips.Trip;

/**
 * Servlet implementation class updateTrip
 */
@WebServlet("/updateTrip")
public class updateTrip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateTrip() {
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
			int tripID = Integer.parseInt(request.getParameter("trips"));
			String origin = request.getParameter("origin").replaceAll("[^a-zA-Z]", "").toLowerCase();
			String destination = request.getParameter("destination").replaceAll("[^a-zA-Z]", "").toLowerCase();
			String travelType = request.getParameter("travelType");
			int seats = Integer.parseInt(request.getParameter("seats"));
			
			String dateStr = request.getParameter("date");
			String timeStr = request.getParameter("time");
			
			LocalDate date = LocalDate.parse(dateStr);
			LocalTime time = LocalTime.parse(timeStr);
			LocalDateTime dateTime = LocalDateTime.of(date, time);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formattedDateTime = dateTime.format(formatter);
			
			Trip trip = new Trip(tripID , origin , destination , travelType , formattedDateTime , seats);
			DBtrips dbTest = new DBtrips();
			Connection conn = (Connection)request.getServletContext().getAttribute("connenction");
			if(conn == null) {conn = dbTest.makeConnection(); request.getServletContext().setAttribute("connection", conn);}
			dbTest.updateATrip(conn, trip);
			
			RequestDispatcher rq = request.getRequestDispatcher("AdminModifyTrips.jsp");
			rq.forward(request , response);
		}
		catch(NumberFormatException e) {
			System.out.println("Enter a number for the number of seats!");
			
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
