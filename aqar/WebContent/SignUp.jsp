<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="SignUp.css">
<title>Insert title here</title>
</head>
<body>
    <div class="container">
    <form action="SignUpServlet" method = "post">
        <div class="field">
        	<label for="fname">First Name:</label>
        	<input type="text" id="fname" name="fname" required="required">
        </div>
        <div class="field">
        	<label for="lname">Last Name:</label>
        	<input type="text" id="lname" name="lname" required="required">
        </div>
        <div class="field">
        	<label for="fname">Email:</label>
        	<input type="text" id="email" name="email" required="required">
        </div>
        <div class="field">
        	<label for="fname">Phone Number:</label>
        	<input type="text" id="phone" name="phone" required="required">
        </div>
        <div class="field">
        	<label>City:</label>
          	<select name="city" id="city" required="required">
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
          	<label for="fname">Username:</label>
            <input type="text" id="username" name="username" required="required">
          </div>
          <div class="field">
            <label for="fname">Password:</label>
            <input type="password" id="password" name="password" required="required">
          </div>
          <div class="field">
            <label for="fname">Retype Password:</label>
            <input type="password" id="retype" name="retype" required="required" oninput="check(this)">
          </div>
          <div class="btns">
            <input type="submit" value="Submit" class = "btn">
          </div>
            <label class="foot">already have an account? <a href = "LogIn.jsp">log in</a></label>
            <script language='javascript' type='text/javascript'>
          function check(input) {
              if (input.value != document.getElementById('password').value) {
                  input.setCustomValidity('Password Must be Matching.');
              } else {
                  input.setCustomValidity('');
              }
          }
      </script>
      </form>
    </div>
</body>
</html>