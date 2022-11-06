package com.thumama;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regexEmail = "^[a-zA-Z0-9+~!$%^&*_=+}{'?-[.]]{0,255}@[a-zA-Z]+\\.[a-zA-Z]{3,6}";
		String regexPassword = "[a-zA-Z0-9]{8,16}";
		String regexPhone = "(^07)[0-9]{8}";
		HttpSession hs = request.getSession();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(Pattern.matches(regexEmail, email)){
			if(Pattern.matches(regexPhone, phone)){
				if(Pattern.matches(regexPassword, password)){
			Member member = new Member(fname,lname,email,phone,city,username,password);
			try {
				if(MembersDao.checkUsername(username)){
					hs.setAttribute("error", "user name already exists!");
					response.sendRedirect("SignUp.jsp");
				}
				else{
					try {
						MembersDao.addMember(member);
						response.sendRedirect("LogIn.jsp");
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			}else{
				hs.setAttribute("error", "invalid password! password must contain (8-16) letters, numbers or both");
				response.sendRedirect("SignUp.jsp");
			}
			}
			else{
				hs.setAttribute("error", "invalid phone number! your number must start with (07) followed by 8 numbers");
				response.sendRedirect("SignUp.jsp");
			}
		}
		else{
			hs.setAttribute("error", "invalid email address! please enter a valid email address and try again ");
			response.sendRedirect("SignUp.jsp");
		}
		
		}

}
