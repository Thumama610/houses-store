<%@page import="com.thumama.HousesDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
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
        <div class="left">AQAR.COM</div>
        <div class="right">
            <div><a href = "AddPost.jsp">add post</a></div>
            <div><a href = "Profile.jsp">Profile </a></div>
            <div class="logOut"><a href = "LogOut">log out</a></div>
        </div>
</nav>



<div class = "posts">

 	<%
 	if(session.getAttribute("username")!= null){
 		int postId = 0;
		StringBuilder sb = new StringBuilder();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aqar_members","root","");
		Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = st.executeQuery("select * from houses");
		while(rs.next()) {
			postId =(int)rs.getInt(10);
			sb.append("<div class = \"post\">"
					+"<img src="+rs.getString(9)+">"
					+"<div class = \"content\">"
					+"<label> Seller : "+HousesDao.getHouseOwnerFirstName(rs.getInt(1)) + " "+HousesDao.getHouseOwnerLastName(rs.getInt(1))+ " </label>"
					+"<label> Phone : "+HousesDao.getHouseOwnerPhoneNumber(rs.getInt(1))+"</label>"
					+"<label> Type: "+rs.getString(2)+" </label>"
					+"<label> Size: "+rs.getInt(3)+" m</label>"
					+"<label> Location : "+rs.getString(4)+ " </label>"
					+"<label> Rooms : "+rs.getInt(5)+ " </label>"
					+"<label> Bathrooms : "+rs.getInt(6)+" </label>"
					+"<label> Floor : "+rs.getInt(7)+" </label>"
					+"<label> Price : "+rs.getInt(8)+" $</label>");
			if(session.getAttribute("username").equals(HousesDao.getHouseOwnerUsername(rs.getInt(1)))){
				sb.append("<form action=\"DeletePost\" class = \"delete\">"
						+"<input type=\"hidden\" name=\"postId\" value=\""+postId+"\" id = \"hidden\">"
						+"<input type=\"submit\" value = \"delete\" onclick = \"check()\" >"
						+"</form>");
					};
					sb.append("</div>"
							+"</div>");
						}
		connection.close();
		out.append(sb);	
 		}
		%>
</div>
<script type="text/javascript" src="Main.js"></script>
</body>
</html>