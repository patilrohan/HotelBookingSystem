<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="com.hotel.beans.*" %>
<html>
<title>HotelsBooking | BookaRoom</title>
<head>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
  
  <script type="text/javascript">
  function getHotel() {
	
  var city = $('#city').val();
    $.ajax({
  type: "POST",
  url: "./getHotelInCity",
  data: "city=" + city ,
  success: function(response){
  // we have the response
    $('#hotel').html(response);
   },
  error: function(e){
  alert('Error: ' + e);
  }
  });
 }
  
  $( function() {
    $( "#datepicker" ).datepicker({ dateFormat: 'dd-mm-yy' });
   
  } );
  $( function() {
	    $( "#datepicker1" ).datepicker({ dateFormat: 'dd-mm-yy' });
	   
	  } );
  </script>
</head>
<body>
<p align="left"> <a href="./home">HOME</a></p>
<form method="post" action="./insert">
<div style="text-align:Center;color:green;font-size:20px;font-weight:bold;">
 <%
       String msg=(String)request.getAttribute("msg");
       if(msg!=null)
       {
       %>
       <script type="text/javascript">
       alert('<%=msg%>');
       </script>
       <%} %>


</div>
<center><h1>Book hotel</h1></center>
<%
 ArrayList<String> lstl = (ArrayList<String>)request.getAttribute("list"); 
%>
<ul class="form-style-1">
    <li>
        <label>City</label>
        <select name="city" class="field-select" id="city" onchange="getHotel();">
          <option>-select city-</option>
    <% 
  for(String tb:lstl){%>
        <option><%=tb%></option>
        <% } %>
        </select>
    </li>
    <li>
        <label>Hotel</label>
        <select name="hotel" id="hotel" class="field-select" required>
           <option>-select hotel-</option>
     
        </select>
    </li>
    
      <li>
        <label>Check-in date<span class="required">*</span></label>
        <input type="text" name="checkin" id="datepicker" class="field-long" required />
    </li>
      <li>
        <label>Check-out date<span class="required">*</span></label>
        <input type="text" name="checkout" id="datepicker1" class="field-long" required />
    </li>
       <li>
        <label>Number of Rooms<span class="required">*</span></label>
        <input type="number" name="nofrooms" min="1"   id="nofrooms" class="field-long" required />
    </li>
   
    <li>
        <input type="submit" value="Submit" />
        <input type="reset" value="Cancel" />
    </li>
</ul>

</form>
</body>
</html>
<style type="text/css">
.form-style-1 {
    margin:10px auto;
    max-width: 400px;
    padding: 20px 12px 10px 20px;
    font: 13px "Lucida Sans Unicode", "Lucida Grande", sans-serif;
}
.form-style-1 li {
    padding: 0;
    display: block;
    list-style: none;
    margin: 10px 0 0 0;
}
.form-style-1 label{
    margin:0 0 3px 0;
    padding:0px;
    display:block;
    font-weight: bold;
}
.form-style-1 input[type=text],
.form-style-1 input[type=date],
.form-style-1 input[type=datetime],
.form-style-1 input[type=number],
.form-style-1 input[type=search],
.form-style-1 input[type=time],
.form-style-1 input[type=url],
.form-style-1 input[type=email],
textarea,
select{
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    border:1px solid #BEBEBE;
    padding: 7px;
    margin:0px;
    -webkit-transition: all 0.30s ease-in-out;
    -moz-transition: all 0.30s ease-in-out;
    -ms-transition: all 0.30s ease-in-out;
    -o-transition: all 0.30s ease-in-out;
    outline: none; 
}
.form-style-1 input[type=text]:focus,
.form-style-1 input[type=date]:focus,
.form-style-1 input[type=datetime]:focus,
.form-style-1 input[type=number]:focus,
.form-style-1 input[type=search]:focus,
.form-style-1 input[type=time]:focus,
.form-style-1 input[type=url]:focus,
.form-style-1 input[type=email]:focus,
.form-style-1 textarea:focus,
.form-style-1 select:focus{
    -moz-box-shadow: 0 0 8px #88D5E9;
    -webkit-box-shadow: 0 0 8px #88D5E9;
    box-shadow: 0 0 8px #88D5E9;
    border: 1px solid #88D5E9;
}
.form-style-1 .field-divided{
    width: 49%;
}

.form-style-1 .field-long{
    width: 100%;
}
.form-style-1 .field-select{
    width: 100%;
}
.form-style-1 .field-textarea{
    height: 100px;
}
.form-style-1 input[type=submit], .form-style-1 input[type=button]{
    background: #4B99AD;
    padding: 8px 15px 8px 15px;
    border: none;
    color: #fff;
}
.form-style-1 input[type=reset], .form-style-1 input[type=button]{
    background: #4B99AD;
    padding: 8px 15px 8px 15px;
    border: none;
    color: #fff;
}
.form-style-1 input[type=submit]:hover, .form-style-1 input[type=button]:hover{
    background: #4691A4;
    box-shadow:none;
    -moz-box-shadow:none;
    -webkit-box-shadow:none;
}
.form-style-1 input[type=reset]:hover, .form-style-1 input[type=button]:hover{
    background: #4691A4;
    box-shadow:none;
    -moz-box-shadow:none;
    -webkit-box-shadow:none;
}

.form-style-1 .required{
    color:red;
}
</style>