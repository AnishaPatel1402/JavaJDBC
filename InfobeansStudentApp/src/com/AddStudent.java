package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddStudent {
	public static void add() {
		Scanner sc = new Scanner(System.in);
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
			String sql = "insert into infostudent(name, batch, college, degree, mobile) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, batch);
			ps.setString(3, college);
			ps.setString(4, degree);
			ps.setString(5, mobile);
			
			int x = ps.executeUpdate();
			if(x!=0) {
				System.out.println("Student added successfully!");
			}else System.out.println("Student not added");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
