<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="DB.DBtickets , java.sql.Connection , java.sql.ResultSet , java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BusCo</title>
<link rel="stylesheet" href="styles/styleShowRevenue.css"/>
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
 
 <div class="container">
 	 <div class="card">
 	 	<%
 	 		String type = (String)request.getAttribute("type");
 	 	
 	 		ResultSet rs = (ResultSet)request.getAttribute("rs");
 	 		DecimalFormat df = new DecimalFormat("#.##");
 	 		
 	 		float sum = 0 ;
 	 		while(rs.next()){ sum += rs.getFloat("ticketPrice");}
 	 	%>
 	 	<h2 class="text">The revenue generated in the last <%=type%> is</h2>
 	 	<h2 class="revenue text"><%=df.format(sum)%>$</h2>
 	 </div>
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