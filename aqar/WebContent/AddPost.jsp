<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="AddPost.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<div class = container>
        <form action="AddPost">
        
        <div class="field">
        <label>Type : </label>
        <select name="type" id="type" required="required" class = "input">
                  <option value="house">house</option>
                  <option value="villa">villa</option>
                <option value="apartment">apartment</option>
        </select>
        </div>
        <div class="field">  
          <label>Size : </label>
          <input type = "number" name = "size" max = "500" required="required" default = "60">
        </div>
        
        <div class="field">
        <label>Location : </label>
            <select name="location" id="location" required="required" class = "input">
                <option value="amman">Amman</option>
                <option value="irbid">Irbid</option>
                <option value="zarqa">Zarqa</option>
                <option value="mafraq">Mafraq</option>
                <option value="ajloun">Ajloun</option>
                <option value="jerash">Jerash</option>
                <option value="madaba">Madaba</option>
                <option value="balqa">Balqa</option>
                <option value="karak">Karak</option>
                <option value="tafileh">Tafileh</option>
                <option value="maan">Maan</option>
                <option value="aqaba">Aqaba</option>
            </select>
        </div>
        <div class="field">
          <label>Rooms : </label>
          <input type = "number" name = "rooms" max = "10" required="required">
        </div>
        <div class="field">
          <label>Bathrooms : </label>
          <input type = "number" name = "bathrooms" max = "10" required="required">
        </div>
        <div class="field">
          <label>Floor : </label>
          <input type = "number" name = "floor" max = "10" required="required">
        </div>
        <div class="field">
          <label>Price : </label>
          <input type = "number" name = "price" max = "5000000" required="required">
        </div>
        <div class="field">
          <label>Image Url :  </label>
          <input type = "text" name = "image" required="required">
        </div>
        <div class = btns>
            <a href = "Main.jsp" class="btn">Back</a>
            <input type="submit" value="Submit" class = "btn">
        </div>
        </form>
        </div>
</body>
</html>