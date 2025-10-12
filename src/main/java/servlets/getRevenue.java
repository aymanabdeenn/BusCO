package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.DBtickets;

/**
 * Servlet implementation class getRevenue
 */
@WebServlet("/getRevenue")
public class getRevenue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getRevenue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String type = request.getParameter("revenue");
		
		DBtickets dbTest = new DBtickets();
		Connection conn = (Connection)request.getServletContext().getAttribute("connection");
		if(conn == null) {conn = dbTest.makeConnection(); request.getServletContext().setAttribute("connection", conn);}
		
		ResultSet rs = null;
		
		if(type.equals("day")) rs = dbTest.getTicketsInTheLastDay(conn);
		if(type.equals("week")) rs = dbTest.getTicketsInTheLastWeek(conn);
		if(type.equals("month")) rs = dbTest.getTicketsInTheLastMonth(conn);
		request.setAttribute("type", type);
		request.setAttribute("rs" , rs);
		
		RequestDispatcher rq = request.getRequestDispatcher("showRevenue.jsp");
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
