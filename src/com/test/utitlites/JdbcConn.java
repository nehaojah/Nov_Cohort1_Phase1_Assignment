package com.test.utitlites;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcConn {
	
	public Statement openConnection(String URL, String user, String password) {
	    Connection conn = null;
	    Statement statement = null;
	    try {
	        conn = DriverManager.getConnection(URL, user, password);
	        statement = conn.createStatement();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statement;
	}
	

	
	

}
