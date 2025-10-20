package com;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseQuery3 {   //update record

	public static void main(String[] args) {
		try(Connection con = GetConnection.getConnection();) {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the id of employee which you want to update: ");
			int id = sc.nextInt();
			System.out.print("Enter Name: ");
			String ename = sc.next();
			System.out.print("Enter Salary: ");
			int esalary = sc.nextInt();
			Statement st = con.createStatement();
			String sql = "update employee set name ='"+ ename +"', salary ="+ esalary+" where id ="+ id;
			int x = st.executeUpdate(sql);
			if(x!=0) {
				System.out.println("Record updated");
			}else {
				System.out.println("Record not updated");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
