package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class searchTrips
 */
@WebServlet("/searchTrips")
public class searchTrips extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchTrips() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String origin = request.getParameter("origin").replaceAll("[^a-zA-Z]", "").toLowerCase();
		String destination = request.getParameter("destination").replaceAll("[^a-zA-Z]", "").toLowerCase();
		String travelType = request.getParameter("choices");
		String date = request.getParameter("date");
		
	    request.setAttribute("origin" , origin);
		request.setAttribute("destination" , destination);
		request.setAttribute("travelType" , travelType);
		request.setAttribute("date" , date);
		
		RequestDispatcher rd = request.getRequestDispatcher("searchTripsUI.jsp");
		rd.forward(request , response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		doGet(request, response);	
		
	}

}
