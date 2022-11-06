package com.thumama;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;


public abstract class Tester {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		boolean regex = Pattern.matches("(^07)[0-9]{8}", "0877755577");
		System.out.println(regex);
	}

}
