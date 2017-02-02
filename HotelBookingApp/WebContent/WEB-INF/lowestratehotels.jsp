<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.*" %>
    <%@page import="com.hotel.beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HotelsBooking | Lowest-Priced-Hotels</title>
</head>
<body style="background-color:#fffffff;color:#00000ff;">
<div style="text-align:center;">
<p align="left"> <a href="./home">HOME</a></p>
<center>

<center><h1>Lowest Price hotels</h1></center>
        <table cellspacing="5" cellpadding="6" border="1">
<tr><th>Hotel Name</th><th>City</th><th>Number Of Rooms</th><th>Star Rating</th>
<th>Tarrif Per Day</th></tr>
<% ArrayList<TarrifBeans> lstl = (ArrayList<TarrifBeans>)request.getAttribute("list"); 
  for(TarrifBeans tb:lstl){
  
  %><tr>
      <td style="width:200px;"><%=(tb.getName())%></td>
	  <td style="width:200px;"><%=(tb.getCity())%></td>
	  <td style="width:200px;"><%=(tb.getNoofrooms())%></td>
	  <td style="width:200px;"><%=(tb.getStarrating())%></td>
	  <td style="width:200px;"><%=tb.getTarrifperday()%></td>
      </tr>
  <% } %>
  
  </table></center>
  </div>
</body>
</html>