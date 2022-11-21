package com.thumama;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HousesDao {
	private static String url = "jdbc:mysql://localhost/aqar_members";
	private static String username = "root";
	private static String password = "";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	public static void addHouse(House house) throws ClassNotFoundException, SQLException, IOException{
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,username,password);
		PreparedStatement ps = connection.prepareStatement("INSERT INTO `houses`(`publisher_id`, `type`, `size`, `location`, `rooms`, `bathrooms`, `floor`, `price`,`img_url`) VALUES (?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, house.getPublisher_id());
		ps.setNString(2, house.getType());
		ps.setInt(3, house.getSize());
		ps.setNString(4, house.getLocation());
		ps.setInt(5, house.getRooms());
		ps.setInt(6, house.getBathrooms());
		ps.setInt(7, house.getFloor());
		ps.setInt(8, house.getPrice());
		ps.setNString(9, house.getImg_url());
		ps.executeUpdate();
		connection.close();
	}
	/*public static String getHousesPosts(String username) throws ClassNotFoundException, SQLException{
		StringBuilder sb = new StringBuilder();
		Class.forName(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aqar_members","root","");
		Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = st.executeQuery("select * from houses");
		while(rs.next()) {
			sb.append("<% int postId ="+(int)rs.getInt(10)+"; %>"
					+"<div class = \"post\">"
					+"<img src="+rs.getString(9)+">"
					+"<div class = \"content\">"
					+"<label> Seller : "+getHouseOwnerFirstName(rs.getInt(1)) + " "+getHouseOwnerLastName(rs.getInt(1))+ " </label>"
					+"<label> Phone : "+getHouseOwnerPhoneNumber(rs.getInt(1))+"</label>"
					+"<label> Type: "+rs.getString(2)+" </label>"
					+"<label> Size: "+rs.getInt(3)+" m</label>"
					+"<label> Location : "+rs.getString(4)+ " </label>"
					+"<label> Rooms : "+rs.getInt(5)+ " </label>"
					+"<label> Bathrooms : "+rs.getInt(6)+" </label>"
					+"<label> Floor : "+rs.getInt(7)+" </label>"
					+"<label> Price : "+rs.getInt(8)+" $</label>");
					if(username.equals(getHouseOwnerUsername(rs.getInt(1)))){
						sb.append(""
								+"<form action=\"DeletePost\">"
								+"<input type=\"hidden\" name=\"postId\" value=\"<%=postId%>\" />"
								+"<input type=\"submit\" />"
								+"</form>");
					};
					sb.append("</div>"
					+"</div>");
		}
		connection.close();
		return sb.toString();
	}*/
	public static String getHouseOwnerFirstName(int id) throws ClassNotFoundException, SQLException{
		String firstName = null;
		Class.forName(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aqar_members","root","");
		PreparedStatement ps = connection.prepareStatement("select m.First_Name from houses h join members m on m.id = h.publisher_id where h.publisher_id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			firstName = rs.getString(1).toString();
		}
		connection.close();
		return firstName;
	}
	public static String getHouseOwnerLastName(int id) throws ClassNotFoundException, SQLException{
		String LastName = null;
		Class.forName(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aqar_members","root","");
		PreparedStatement ps = connection.prepareStatement("select m.Last_Name from houses h join members m on m.id = h.publisher_id where h.publisher_id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			LastName = rs.getString(1).toString();
		}
		connection.close();
		return LastName;
	}
	public static String getHouseOwnerPhoneNumber(int id) throws ClassNotFoundException, SQLException{
		String Phone = null;
		Class.forName(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aqar_members","root","");
		PreparedStatement ps = connection.prepareStatement("select m.Phone from houses h join members m on m.id = h.publisher_id where h.publisher_id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Phone = rs.getString(1).toString();
		}
		connection.close();
		return Phone;
	}
	public static String getHouseOwnerUsername(int id) throws ClassNotFoundException, SQLException{
		String username = null;
		Class.forName(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aqar_members","root","");
		PreparedStatement ps = connection.prepareStatement("select m.username from houses h join members m on m.id = h.publisher_id where h.publisher_id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			username = rs.getString(1).toString();
		}
		connection.close();
		return username;
	}
	public static void deletePost(int id) throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aqar_members","root","");
		PreparedStatement ps = connection.prepareStatement("delete from houses where id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		connection.close();
	}
	public static boolean checkHouse(int id) throws ClassNotFoundException, SQLException{
		boolean exists = false;
		Class.forName(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aqar_members","root","");
		PreparedStatement ps = connection.prepareStatement("select * from houses where id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			exists = true;
		}
		connection.close();
		return exists;
	}
	public static void editHouse(int id,House house) throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,username,password);
		PreparedStatement ps = connection.prepareStatement("UPDATE `houses` SET `type`=?"
				+ ",`size`=?,`location`=?,`rooms`=?,`bathrooms`=?,`floor`=?"
				+ ",`price`=?,`img_url`=? WHERE id = ?");
		ps.setNString(1, house.getType());
		ps.setInt(2, house.getSize());
		ps.setNString(3, house.getLocation());
		ps.setInt(4, house.getRooms());
		ps.setInt(5, house.getBathrooms());
		ps.setInt(6, house.getFloor());
		ps.setInt(7, house.getPrice());
		ps.setNString(8, house.getImg_url());
		ps.setInt(9, id);
		ps.executeUpdate();
		connection.close();
	}
}
