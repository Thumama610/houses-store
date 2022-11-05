package com.thumama;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/AddPost")
@MultipartConfig(maxFileSize = 16177216)
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddPost() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		String username = hs.getAttribute("username").toString();
		int publisher_id = (int) hs.getAttribute("id");
		String type = request.getParameter("type");
		int size = Integer.parseInt(request.getParameter("size"));
		String location = request.getParameter("location");
		int rooms = Integer.parseInt(request.getParameter("rooms"));
		int bathrooms = Integer.parseInt(request.getParameter("bathrooms"));
		int floor = Integer.parseInt(request.getParameter("floor"));
		int price = Integer.parseInt(request.getParameter("price"));
		String img_url = request.getParameter("image");
		House house = new House(publisher_id,type,size,location,rooms,bathrooms,floor,price,img_url);
		try {
			HousesDao.addHouse(house);
			response.sendRedirect("Main.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
