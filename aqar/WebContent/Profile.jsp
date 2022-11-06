<%@page import="com.thumama.MembersDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="main.css">
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0"); 
if (session.getAttribute("username") == null){
	response.sendRedirect("LogIn.jsp");
}
%>
<nav class="nav">
        <div class="left"><a href="Main.jsp">AQAR.COM</a></div>
        <div class="right">
            <div><a href = "AddPost.jsp">add post</a></div>
            <div><a href = "Profile.jsp">Profile </a></div>
            <div class="logOut"><a href = "LogOut">log out</a></div>
        </div>
</nav>
<div class = "info">
<label for="fname" class = "profileInfo">First Name: <%if(session.getAttribute("username")!= null){out.append(MembersDao.getFirstName(session.getAttribute("username").toString()));}; %></label>
<label for="fname" class = "profileInfo">Last Name: <%if(session.getAttribute("username")!= null){out.append(MembersDao.getLastName(session.getAttribute("username").toString()));}; %></label>
<label for="fname" class = "profileInfo">Email: <%if(session.getAttribute("username")!= null){out.append(MembersDao.getEmail(session.getAttribute("username").toString()));}; %></label>
<label for="fname" class = "profileInfo">Phone: <%if(session.getAttribute("username")!= null){out.append(MembersDao.getPhone(session.getAttribute("username").toString()));}; %></label>
<label for="fname" class = "profileInfo">city: <%if(session.getAttribute("username")!= null){out.append(MembersDao.getCity(session.getAttribute("username").toString()));}; %></label>
</div>
</body>
</html>