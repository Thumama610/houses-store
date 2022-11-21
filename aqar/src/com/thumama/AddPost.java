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

@WebServlet("/AddPost")
@MultipartConfig(maxFileSize = 16177216)
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddPost() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int houseId = 0;
		HttpSession hs = request.getSession();
		if(hs.getAttribute("houseId")!= null){
			houseId = (int) hs.getAttribute("houseId");
		}
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
			if(HousesDao.checkHouse(houseId))
			{
				HousesDao.editHouse(houseId, house);
				response.sendRedirect("Main.jsp");
			}
			else
			{
				HousesDao.addHouse(house);
				response.sendRedirect("Main.jsp");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			
			e1.printStackTrace();
		}
	}

}
