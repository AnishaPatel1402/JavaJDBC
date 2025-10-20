package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseQuery4 {  //select query
	public static void main(String args[]) {
		try(Connection con = GetConnection.getConnection()){
			Statement st = con.createStatement();
			String sql = "select * from employee";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String name =  rs.getString("name");
				int salary = rs.getInt("salary");
				System.out.println("Name = "+ name + "\t Salary = "+ salary);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
