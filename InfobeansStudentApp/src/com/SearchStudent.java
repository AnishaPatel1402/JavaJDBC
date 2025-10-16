package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchStudent {
	public static void search() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the roll of student which you want to search: ");
		int rol = sc.nextInt();
		sc.nextLine();
		
		try (Connection con = GetDbConnection.getConnection();){
			String sql = "select * from infostudent where roll = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, rol);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int roll = rs.getInt("roll");
				String name = rs.getString("name");
				int batch = rs.getInt("batch");
				String college = rs.getString("college");
				String degree = rs.getString("degree");
				String mobile = rs.getString("mobile");
				
				System.out.printf("Roll : %d\nName: %s\nBatch: %d batch\nCollege: %s\nDegree: %s\nMobile: %s",roll,name,batch,college,degree,mobile);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
