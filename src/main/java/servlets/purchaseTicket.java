package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import DB.DBtickets;
import DB.DBtrips;
import models.fareConfig;
import tickets.Ticket;
import tickets.TicketFactory;

/**
 * Servlet implementation class purchaseTicket
 */
@WebServlet("/purchaseTicket")
public class purchaseTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public purchaseTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		RequestDispatcher rq = request.getRequestDispatcher("purchaseStatus.jsp");
		
		int tripNumber = Integer.parseInt(request.getParameter("tripNumber"));
		String ticketType = request.getParameter("ticketType");
		String category = request.getParameter("category");
		
		DBtrips DBtest = new DBtrips();
		Connection conn = (Connection)request.getServletContext().getAttribute("connection");
		if(conn == null) {conn = DBtest.makeConnection(); request.setAttribute("connection" , conn);}
		
		ResultSet rs = DBtest.getSpecificTrip(conn , tripNumber);
		
		try {
//			(String type , String user , String purchaseDate, String travelType , String category , Boolean evening)
			rs.next();
			
			fareConfig fare_config = (fareConfig)request.getServletContext().getAttribute("fare_config");
			
			String user = (String)request.getSession().getAttribute("username");
			String travelType = rs.getString("travelType");
			Boolean evening = false;
			
			LocalDate purchaseDate = LocalDate.now();
			String purchaseDateStr = purchaseDate + "";
			
			Timestamp tripDateTime = rs.getTimestamp("departureTime");
			LocalTime tripTime = tripDateTime.toLocalDateTime().toLocalTime();
			LocalTime fixedTime = LocalTime.of(19, 0, 0);
			if(tripTime.isAfter(fixedTime)) evening = true;
			
			int seats = Integer.parseInt(rs.getString("seats"));
			
			synchronized (this){
				if(seats>0) DBtest.updateTripNumOfSeats(conn, tripNumber , --seats);
				else {
					System.out.println("No availiable seats are left!");
					request.setAttribute("status", "failed");
					rq.forward(request, response);
					return;
				}
			}
			
			TicketFactory factory = new TicketFactory();
			Ticket ticket = factory.getTicket(ticketType , user , purchaseDateStr , travelType , category , evening , tripNumber);
			ticket.calcPrice(fare_config);
			
			DBtickets dbTickets = new DBtickets();
			dbTickets.addTicketsToDB(conn, ticket);
			
			request.setAttribute("status", "success");
			
			if(rs != null) rs.close();
			rq.forward(request, response);
		}
		catch(SQLException e) {
			System.out.println("An error occured while retrieving OR adding the ticket/trip from/to the database to purchase a ticket!");
			e.printStackTrace();
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
