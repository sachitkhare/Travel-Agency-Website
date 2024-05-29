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
UserInfo u = new UserInfo();
u.setUsername(request.getParameter("t1"));
u.setPassword(request.getParameter("t2"));
DBService db = new DBService();

boolean isValid =db.check(u);
if(isValid==true)
	{
		%>
		<jsp:forward page="home.html"></jsp:forward>
		<%	
	}
	else
	{
		request.setAttribute("sms","InValid User");
		%>
		<jsp:forward page="login.jsp"></jsp:forward>
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