<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Travel Cost</title>
<link rel="stylesheet" href="styles/styleEstimatedCost.css"/>
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
			String fare = (String)session.getAttribute("fare");
		%>
		<h2 class="text">Your total cost will be:</h2>
		<h2 class="cost text"><%=fare%>$</h2>
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