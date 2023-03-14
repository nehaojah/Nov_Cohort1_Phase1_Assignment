package com.test.webpages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.utitlites.JdbcConn;

public class GetDBdetails {

	JdbcConn jdbcConnobj = new JdbcConn();
	ResultSet resultset = null;

	public ResultSet getResultSet() {

		
		String URL = "jdbc:mysql://localhost:3306/alphatester";
		String strQuery = "Select * from Products";
		try {
	    
		Statement statement = jdbcConnobj.openConnection(URL, "root", "Nasausa");
		resultset = statement.executeQuery(strQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultset;
	}

	public List<String> getDbProductNames(ResultSet resultset) {

		List<String> dbProdNameList = new ArrayList<>();
		try {
			while (resultset.next()) {
				dbProdNameList.add(resultset.getString(1));

//			 System.out.println("this is dbProdNameList" + dbProdNameList.toString());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dbProdNameList;

	}

	public List<String> getDbProdPriceList(ResultSet resultset) {
		List<String> dbProdPriceList = new ArrayList<>();
		try {
			while (resultset.next()) {
				dbProdPriceList.add(resultset.getString(2));

//			 System.out.println("this is dbProdNameList" + dbProdNameList.toString());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dbProdPriceList;

	}

}
