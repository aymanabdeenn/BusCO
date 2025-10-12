package servlets;

import java.sql.Connection;

import DB.DBtrips;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteTrip
 */
@WebServlet("/deleteTrip")
public class deleteTrip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteTrip() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		int tripID = Integer.parseInt(request.getParameter("trips"));
		
		DBtrips dbTest = new DBtrips();
		Connection conn = (Connection)request.getServletContext().getAttribute("connenction");
		if(conn == null) {conn = dbTest.makeConnection(); request.getServletContext().setAttribute("connection", conn);}
		
		dbTest.deleteATripFromDB(conn , tripID);
		
		RequestDispatcher rq = request.getRequestDispatcher("AdminModifyTrips.jsp");
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
