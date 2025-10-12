package servlets;

import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.DBfare;
import DB.DBusers;
import models.fareConfig;

/**
 * Servlet implementation class logInUser
 */
@WebServlet("/logInUser")
public class logInUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logInUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		
		DBusers DBtest = new DBusers();
		Connection conn = DBtest.makeConnection();
		request.getServletContext().setAttribute("connection" , conn);
		
		RequestDispatcher rqPassenger = request.getRequestDispatcher("PassengerLogicUI.html");
		RequestDispatcher rqAdmin = request.getRequestDispatcher("AdminLogicUI.html");
		RequestDispatcher rq = request.getRequestDispatcher("index.html");
		
		Boolean correctUserInfo = DBtest.checkUserForLogIn(conn, username, password, type);
		if(correctUserInfo && type.equals("passenger")) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username" , username);
			getFareConfig(conn , request);
			rqPassenger.forward(request , response);
		} 
		else if(correctUserInfo && type.equals("admin")) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			getFareConfig(conn , request);
			rqAdmin.forward(request , response);
		} 
		else {System.out.println("Wrong credentials!"); rq.forward(request , response);}
		
	}
	
	public void getFareConfig(Connection conn ,HttpServletRequest request) {
		ServletContext context = request.getServletContext();
		DBfare dbTest = new DBfare();
		fareConfig fare_config = null;
		if(!dbTest.isEmpty(conn)) {
			System.out.println("NOT EMPTY!!!!!!!!!!!");
			fare_config = dbTest.getFareFromDB(conn);
		}
		else {
			fare_config = new fareConfig(context);
			dbTest.addFareToDB(conn, fare_config);
			System.out.println("EMPTY!!!!!!!!!!!");
			
		}
		context.setAttribute("fare_config", fare_config);
		
//		fareConfig fare_config = (fareConfig)context.getAttribute("fare_config"); 
//		if(fare_config == null) {fare_config = new fareConfig(context); context.setAttribute("fare_config", fare_config);}
//		else System.out.println("fare_config object has been put in the session scope without the need to be created!");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
