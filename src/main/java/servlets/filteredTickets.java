package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;

import DB.DBtickets;

/**
 * Servlet implementation class filteredTickets
 */
@WebServlet("/filteredTickets")
public class filteredTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filteredTickets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String filter = request.getParameter("filter");
		DBtickets dbTest = new DBtickets();
		
		Connection conn = (Connection)request.getServletContext().getAttribute("connection");
		if(conn == null) {conn = dbTest.makeConnection() ; request.getServletContext().setAttribute("connection", conn);}
		
		ResultSet rs = null;
		
		if(filter.equals("dateRange")) {
			LocalDate startDate = LocalDate.parse(request.getParameter("start"));
			LocalDate endDate = LocalDate.parse(request.getParameter("end"));
			rs = dbTest.getTicketsInDateRange(conn , startDate, endDate); 
			} 
		else if(filter.equals("ticketType")) {
			String ticketType = request.getParameter("ticketType"); 
			rs = dbTest.getTicketsWithTicketType(conn, ticketType);
			}
		else if(filter.equals("userCategory")) {
			String userCategory = request.getParameter("userCategory");
			rs = dbTest.getTicketsWithUserCategory(conn, userCategory);
		}
		request.setAttribute("rs" , rs);

		
		RequestDispatcher rq = request.getRequestDispatcher("displayFilteredTickets.jsp");
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
