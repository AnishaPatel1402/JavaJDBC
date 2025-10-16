package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewAllStudent {
	public static void listOFStudents() {
		
		try (Connection con = GetDbConnection.getConnection();){
			String sql = "select * from infostudent";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int roll = rs.getInt("roll");
				String name = rs.getString("name");
				int batch = rs.getInt("batch");
				String college = rs.getString("college");
				String degree = rs.getString("degree");
				String mobile = rs.getString("mobile");
				
				System.out.printf("Roll : %d\nName: %s\nBatch: %d batch\nCollege: %s\nDegree: %s\nMobile: %s\n\n",roll,name,batch,college,degree,mobile);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
}
}
