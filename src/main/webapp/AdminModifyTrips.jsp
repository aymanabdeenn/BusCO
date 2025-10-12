<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="DB.DBtrips , java.util.ArrayList , java.sql.Connection , java.sql.ResultSet , java.sql.SQLException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify trips</title>
<link rel="stylesheet" href="styles/styleModifyTrips.css">
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
	<div class="trips">
		<%
			DBtrips DBtest = new DBtrips();
			Connection conn = (Connection)request.getServletContext().getAttribute("connection");
			if(conn == null) {conn = DBtest.makeConnection(); request.setAttribute("connection" , conn);}
			
			ResultSet rs = DBtest.getAllTrips(conn);
			ArrayList<Integer> tripsNumbers = new ArrayList<>();
			int cnt = 0;
			
				while(rs.next()){
					tripsNumbers.add(rs.getInt("tripID"));
					int numberOfSeats = rs.getInt("seats");
					%>
					 <div class="ele" style="<%if(cnt++%2 == 0){%>background-color:#FFF8DC;<%}else{%>background-color:#D3D3D3;<%}%>">Trip Number: <%=rs.getString("tripID")%> -- Origin: <%=rs.getString("origin")%> -- Destination: <%=rs.getString("destination")%> -- Travel Type: <%=rs.getString("travelType")%> -- Date&Time: <%=rs.getString("DepartureTime")%> -- <%if(numberOfSeats>0){%> Available <%}else {%> Unavailable <%}%> -- Seats: <%=numberOfSeats%></div>
					
				<% }
				
				if(rs != null) rs.close();
		%>
	</div>
	<div class="choices">
		<div class="add">
			<button class="addBtn btn">Add Trip</button>
			<form action="addTrip" method="POST" class="addForm hidden">
				<label>Origin:</label>
				<input type="text" name="origin"/>
				<label>Destination:</label>
				<input type="text" name="destination"/>
				<label>Travel Type:</label>
				<select id="travleType" name="travelType" required>
					<option value="city">City</option>
					<option value="innerCity">Inner City</option>
				</select>
				<label>Number Of Seats:</label>
				<input type="text" name="seats"/>
				<label>Departure Date:</label>
				<input type="date" id="date" name="date"/>
				<label>Departure Time:</label>
				<input type="time" id="time" name="time"/>
				<input type="submit" value="Add" id="submitAdd"></input>
			</form>
		</div>
		<div class="update">
			<button class="updateBtn btn">Update Trip</button>
			<form action="updateTrip" method="POST" class="updateForm hidden">
				<label>Trip Number:</label>
				<select class="tripsNumbers" name="trips" required>
					<%
						for(int i : tripsNumbers){ %>
							<option value= <%=i%>><%=i%></option>
						<% }
					%>
				</select>
				<label>Origin:</label>
				<input type="text" name="origin"/>
				<label>Destination:</label>
				<input type="text" name="destination"/>
				<label>Travel Type:</label>
				<select id="travleType" name="travelType" required>
					<option value="city">City</option>
					<option value="innerCity">Inner City</option>
				</select>
				<label>Number Of Seats:</label>
				<input type="text" name="seats"/>
				<label>Departure Date:</label>
				<input type="date" id="date" name="date"/>
				<label>Departure Time:</label>
				<input type="time" id="time" name="time"/>
				<input type="submit" value="Update" id="submitUpdate"></input>
			</form>
		</div>
		<div class="delete">
			<button class="deleteBtn btn">Delete Trip</button>
			<form action="deleteTrip" method="POST" class="deleteForm hidden">
				<label>Trip Number:</label>
				<select class="tripsNumbers" name="trips" required>
					<%
						for(int i : tripsNumbers){ %>
							<option value=<%=i%>><%=i%></option>
						<% }
					%>
				</select>
				<input type="submit" value="Delete" id="submitDelete"></input>
			</form>
		</div>
	</div>

</div>
<div class="footer">
      <div class="footerText">
        <p>BusCo &copy; 2025  || All rights reserved</p>
      </div>
      <form action="logout" method="GET">
      	<input type="submit" value="LogOut" name="logOut" id="logout"/>
      </form>
 </div>
 
<script src="scripts/scriptAdminModifyTrips.js"></script>
</body>
</html>