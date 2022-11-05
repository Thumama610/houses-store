package com.thumama;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MembersDao {
	private static String url = "jdbc:mysql://localhost/aqar_members";
	private static String username = "root";
	private static String password = "";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	public static void addMember(Member member) throws SQLException, ClassNotFoundException{
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,username,password);
		PreparedStatement ps = connection.prepareStatement("INSERT INTO `members`( `First_Name`, `Last_Name`, `Email`, `Phone`, `city`, `username`, `password`) VALUES (?,?,?,?,?,?,?)");
		ps.setNString(1, member.getFname());
		ps.setNString(2, member.getLname());
		ps.setNString(3, member.getEmail());
		ps.setNString(4, member.getPhone());
		ps.setNString(5, member.getCity());
		ps.setNString(6, member.getUsername());
		ps.setNString(7, member.getPassword());
		ps.executeUpdate();
		connection.close();
	}
	public static boolean check(Member member) throws ClassNotFoundException, SQLException{
		boolean checker = false;
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,username,password);
		PreparedStatement ps = connection.prepareStatement("select password from members where username = ?");
		ps.setNString(1, member.getUsername());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			if(rs.getNString(1).equals(member.getPassword())){
				checker = true;
			}
		}
		connection.close();
		return checker;
	}
	public static String getFirstName(String user) throws ClassNotFoundException, SQLException{
		String firstName;
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,username,password);
		PreparedStatement ps = connection.prepareStatement("select First_Name from members where username = ?");
		ps.setNString(1, user);
		ResultSet rs = ps.executeQuery();
		rs.next();
		firstName = rs.getNString(1);
		connection.close();
		return firstName;
	}
	public static String getLastName(String user) throws ClassNotFoundException, SQLException{
		String lastName;
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,username,password);
		PreparedStatement ps = connection.prepareStatement("select Last_Name from members where username = ?");
		ps.setNString(1, user);
		ResultSet rs = ps.executeQuery();
		rs.next();
		lastName = rs.getNString(1);
		connection.close();
		return lastName;
	}
	public static String getEmail(String user) throws ClassNotFoundException, SQLException{
		String email;
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,username,password);
		PreparedStatement ps = connection.prepareStatement("select Email from members where username = ?");
		ps.setNString(1, user);
		ResultSet rs = ps.executeQuery();
		rs.next();
		email = rs.getNString(1);
		connection.close();
		return email;
	}
	public static String getPhone(String user) throws ClassNotFoundException, SQLException{
		String phone;
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,username,password);
		PreparedStatement ps = connection.prepareStatement("select Phone from members where username = ?");
		ps.setNString(1, user);
		ResultSet rs = ps.executeQuery();
		rs.next();
		phone = rs.getNString(1);
		connection.close();
		return phone;
	}
	public static String getCity(String user) throws ClassNotFoundException, SQLException{
		String city;
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,username,password);
		PreparedStatement ps = connection.prepareStatement("select city from members where username = ?");
		ps.setNString(1, user);
		ResultSet rs = ps.executeQuery();
		rs.next();
		city = rs.getNString(1);
		connection.close();
		return city;
	}
	public static int getId(String user) throws ClassNotFoundException, SQLException{
		int id;
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,username,password);
		PreparedStatement ps = connection.prepareStatement("select id from members where username = ?");
		ps.setNString(1, user);
		ResultSet rs = ps.executeQuery();
		rs.next();
		id = rs.getInt(1);
		connection.close();
		return id;
	}
}
