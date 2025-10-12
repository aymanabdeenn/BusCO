<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.Connection, java.sql.ResultSet , DB.DBtickets , java.sql.Timestamp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>BusCo</title>
    <link rel="stylesheet" href="styles\stylePassengerTripHistory.css" />
	<link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,400..700;1,400..700&display=swap"
      rel="stylesheet"
    />
<title>BusCo</title>
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
	<div class="history" style="display: block">
		<% 
		
		DBtickets dbTest = new DBtickets();
		Connection conn = (Connection)request.getServletContext().getAttribute("connection");
		if(conn == null) {conn = dbTest.makeConnection(); request.getServletContext().setAttribute("connection" , conn);}
		
		String username = (String)session.getAttribute("username");
		ResultSet rs = dbTest.getUserTicketsWithTripInfo(conn , username);
		
		int cnt = 0;
		while (rs.next()) {
			Timestamp ts = rs.getTimestamp("departureTime");
		%>
			
           <div class="ele" style="<%if(cnt++%2 == 0){%>background-color:#FFF8DC;<%}else{%>background-color:#D3D3D3;<%}%>">Origin: <%=rs.getString("origin")%> -- Destination: <%=rs.getString("destination")%> -- Date&Time: <%=ts%> --  Ticket Type: <%=rs.getString("ticketType")%> -- Ticket Price: <%=rs.getString("ticketPrice")%>$ -- Purchase Date: <%=rs.getString("purchaseDate")%></div>
        <% }
		
		if(rs != null) rs.close();
		
		%>
	</div>
	
</body>
</html>