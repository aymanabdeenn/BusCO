<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="DB.DBtrips, java.sql.Connection, java.sql.ResultSet , java.sql.Timestamp , java.text.SimpleDateFormat , java.util.ArrayList , models.fareConfig"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>BusCo</title>
    <link href="styles/stylePassengerSearch.css" rel="Stylesheet" />
	<title>BusCo</title>
	
	<style></style>
</head>
<body>
	<div class="topBar">
      <img
        src="Images/BusCoDark.png"
        alt="logo"
        class="logo"
        draggable="false"
      />
    </div>	
	<div class="trips">
		<% 
		
		String origin = (String)request.getAttribute("origin");
		String destination = (String)request.getAttribute("destination");
		String travelType = (String)request.getAttribute("travelType");
		String date = (String)request.getAttribute("date");
		
		DBtrips dbTest = new DBtrips();
		Connection conn = (Connection)request.getServletContext().getAttribute("connection");
		if(conn == null) { conn = dbTest.makeConnection(); request.getServletContext().setAttribute("connection" , conn);}
		
		ArrayList<String> tripsNumbers = new ArrayList<>();
		
		ResultSet rs = dbTest.getAvaliableTrips(conn , origin , destination ,  travelType , date);
		
		int cnt = 0;
		while (rs.next()) {
			tripsNumbers.add(rs.getString("tripID"));
			int numberOfSeats = Integer.parseInt(rs.getString("seats"));
			
			Timestamp ts = rs.getTimestamp("departureTime");
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:SS");
			String formatted = formatter.format(ts);
		%>
           <div class="ele" style="<%if(cnt++%2 == 0){%>background-color:#FFF8DC;<%}else{%>background-color:#D3D3D3;<%}%>">Trip Number: <%=rs.getString("tripID")%> -- Origin: <%=rs.getString("origin")%> -- Destination: <%=rs.getString("destination")%> -- Time: <%=formatted%> -- <%if(numberOfSeats>0){%> Available <%}else {%> Unavailable <%}%> -- Seats: <%=numberOfSeats%></div>
        <% }
		
		if(rs != null) rs.close();
		
		%>
	</div>
	<div class="btns">
	<button class="estimateFare btn">Estimate Fare</button>
	<button class="purchaseTicket btn">Purchase Ticket</button>	
	</div>
	
	<form action="estimateFare" method="POST" class="estForm hidden">
		  <label>Trip Number:</label>
		  <select id="tripNumber" name="tripNumber" required >
          	<%	
		  		for(int i = 0 ; i < tripsNumbers.size() ; i++){
		  	%>
		  	<option value=<%= tripsNumbers.get(i)%>> <%=tripsNumbers.get(i)%></option>		
		  		<% }%>
          </select>
          <label>Ticket Type:</label>
          <select id="ticketType" name="ticketType" required >
          	<option value="one trip">One trip</option>
            <option value="daily pass">Daily pass</option>
            <option value="weekly pass">Weekly pass</option>
            <option value="monthly pass">Monthly pass</option>
          </select>
          <label>Category:</label>
          <select id="userCategory" name="category">
            <option value="regular">Regular</option>
            <option value="student">Student</option>
            <option value="senior">Senior</option>
          </select>
          <input type="submit" value="Estimate" id="estimate"></input>
	</form>
	
	<form action="purchaseTicket" method="POST" class="purchaseForm hidden">
		  <label>Trip Number:</label>
          <select id="tripNumber" name="tripNumber" required >
          	<%	
		  		for(int i = 0 ; i < tripsNumbers.size() ; i++){
		  	%>
		  	<option value=<%= tripsNumbers.get(i)%>> <%=tripsNumbers.get(i)%></option>		
		  		<% }%>
          </select>
          <label>Category:</label>
          <select id="userCategory" name="category">
            <option value="regular">Regular</option>
            <option value="student">Student</option>
            <option value="senior">Senior</option>
          </select>
          <label>Ticket Type:</label>
          <select id="ticketType" name="ticketType" required >
          	<option value="one trip">One trip</option>
            <option value="daily pass">Daily pass</option>
            <option value="weekly pass">Weekly pass</option>
            <option value="monthly pass">Monthly pass</option>
          </select>
          <input type="submit" value="Purchase" id="purchase"></input>
	</form>
	
	<script src="scripts/scriptPassengerSearch.js"></script>
</body>
</html>