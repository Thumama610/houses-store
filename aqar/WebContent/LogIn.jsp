<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="login.css">
<title></title>
</head>
<body>
<div class="container">
    <form action="LogIn" method = "post">
        <div class="field">
            <label for="fname">Username:</label>
            <input type="text" id="username" name="username" required="required">
          </div>
          <div class="field">
              <label for="fname">Password:</label>
              <input type="password" id="password" name="password" required="required">
          </div>
          
          <div class="btns">
              <input type="submit" value="Submit" class="btn">
          </div>
    </form>
    <label>don't have an account? <a href = "SignUp.jsp">sign up</a></label>
    <%
		if(session.getAttribute("error")!= null){
		out.append("<h4 class = \"warning\">"+session.getAttribute("error").toString()+"</h4>");
		session.removeAttribute("error");
		}
	%>
    </div>
</body>
</html>