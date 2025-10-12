<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="DB.DBtickets , java.sql.Connection , java.sql.ResultSet , java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BusCo</title>
<link rel="stylesheet" href="styles/styleFilteredTickets.css"/>
<link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,400..700;1,400..700&display=swap"
      rel="stylesheet"
    />
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

<div class="tickets">
	<%
		DBtickets dbTest = new DBtickets();
		Connection conn = (Connection)request.getServletContext().getAttribute("connection");
		if(conn == null) {conn = dbTest.makeConnection(); request.getServletContext().setAttribute("connection" , conn);}
	
		DecimalFormat df = new DecimalFormat("#.##");
		
		ResultSet rs = (ResultSet)request.getAttribute("rs");
		
		int cnt = 0 ;
		float sum = 0;
		while (rs.next()) {
			sum += rs.getFloat("ticketPrice");
	%>
		
       <div class="ele" style="<%if(cnt++%2 == 0){%>background-color:#FFF8DC;<%}else{%>background-color:#D3D3D3;<%}%>">Ticket Number: <%=rs.getString("ticketID")%> -- Ticket Type: <%=rs.getString("ticketType")%> -- Owner Category: <%=rs.getString("userCategory")%> -- Ticket Owner: <%=rs.getString("ticketOwner")%> --  Ticket Price: <%=rs.getString("ticketPrice")%>$ -- Purchase Date: <%=rs.getString("purchaseDate")%></div>
    <% }
	
	if(rs != null) rs.close();
		%>
</div>

<div class="report">
	<p class="reportText">Number of tickets sold is <%=cnt%></p>
	<p class="reportText">Their revenue is <%=df.format(sum)%>$</p>
</div>

<div class="footer">
      <div class="footerText">
        <p>BusCo &copy; 2025  || All rights reserved</p>
      </div>
      <form action="logout" method="GET" >
      	<input type="submit" value="LogOut" name="logOut" id="logout"/>
      </form>
 </div>
</body>
</html>