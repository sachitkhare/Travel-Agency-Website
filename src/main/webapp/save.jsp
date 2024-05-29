<%@page import="com.dto.CustomerInfo"%>
<%@page import="com.DBService"%>
<%@page import="com.UserInfo"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>
<h1>Universal Calculator</h1>
<hr>
<br><br><br>

<%
CustomerInfo c = new CustomerInfo();
c.setName(request.getParameter("k1"));
c.setEmail(request.getParameter("k2"));
c.setDate(request.getParameter("k3"));
c.setDestination(request.getParameter("k4"));
//c.setPassno(request.getParameter("k5"));
DBService db = new DBService();
int x=0;
x=db.addCustomer(c);

if(x>=1)
	{     request.setAttribute("sms","Your booking is done ");
		%>
		<jsp:forward page="payment.jsp"></jsp:forward>
		<%	
	}
	else
	{
		request.setAttribute("sms","InValid user please check details or try again");
		%>
		<jsp:forward page="booking.jsp"></jsp:forward>
		<%
	}		

%>


<br><br><br>
<hr>
<address>
Universal Informatics,<br>
Abhayprasal Campus,<br>
Race Course Road,<br> Indore
</address>
</center>

</body>
</html>