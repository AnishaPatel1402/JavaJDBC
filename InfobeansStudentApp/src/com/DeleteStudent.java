package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteStudent {
	public static void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the roll of student which you want to delete: ");
		int roll = sc.nextInt();
		sc.nextLine();
		
		try (Connection con = GetDbConnection.getConnection();){
			String sql = "delete from infostudent where roll = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, roll);
			
			int x = ps.executeUpdate();
			if(x!=0) {
				System.out.println("Student deleted successfully!");
			}else System.out.println("Student not delete");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
