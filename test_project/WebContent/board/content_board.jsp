<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	request.setCharacterEncoding("utf-8");	
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/jspdb";
	String id = "jspid";
	String pass = "jsppass";
	
	String name = request.getParameter("name");
	try{
		
	} catch(Exception e){
		e.printStackTrace();
	}
	%>
</body>
</html>