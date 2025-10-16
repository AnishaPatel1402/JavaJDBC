package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateStudent {
	public static void update() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the roll of student which you have to update: ");
		int roll = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter stundent name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter stundent batch number: ");
		int batch = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter college: ");
		String college = sc.nextLine();
		
		System.out.println("Enter degree: ");
		String degree = sc.nextLine();
		
		System.out.println("Enter mobile: ");
		String mobile = sc.nextLine();

		
		try (Connection con = GetDbConnection.getConnection();){
			String sql = "update infostudent set name = ?, batch = ?, college = ?, degree = ?, mobile = ? where roll = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, batch);
			ps.setString(3, college);
			ps.setString(4, degree);
			ps.setString(5, mobile);
			ps.setInt(6, roll);
			
			int x = ps.executeUpdate();
			if(x!=0) {
				System.out.println("Student updated successfully!");
			}else System.out.println("Student not updated");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
