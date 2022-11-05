package com.thumama;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Tester {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/aqar_members","root","");
		PreparedStatement ps = connection.prepareStatement("select m.First_Name,m.Last_Name from houses h join members m on m.id = h.publisher_id where h.publisher_id = ?");
		ps.setInt(1, 5);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString(1) + " " + rs.getString(2));
		}
	}

}
