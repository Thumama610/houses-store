package com.thumama;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeletePost")
public class DeletePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeletePost() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = Integer.parseInt(request.getParameter("postId"));
		if (postId == 0) {
			response.sendRedirect("Main.jsp");
		}
		else{
		try {
			HousesDao.deletePost(postId);
			response.sendRedirect("Main.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		}
		}

}
