package com.thumama;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogIn() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		Member member = new Member(username,password);
		HttpSession hs = request.getSession();
		try {
			if(MembersDao.check(member)){
				hs.setAttribute("username", username);
				hs.setAttribute("id", member.getId());
				response.sendRedirect("Main.jsp");
			}
			else{
				hs.setAttribute("error", "please check your username or password!!");
				response.sendRedirect("LogIn.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
