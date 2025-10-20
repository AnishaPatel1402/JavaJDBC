package com;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseQuery1 {  //insert record

	public static void main(String[] args) {
		try(Connection con = GetConnection.getConnection();) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Name: ");
			String ename = sc.next();
			System.out.print("Enter Salary: ");
			int esalary = sc.nextInt();
			Statement st = con.createStatement();
			String sql = "insert into employee(name, salary) values ('"+ename+"',"+ esalary+")";
			int x = st.executeUpdate(sql);
			if(x!=0) {
				System.out.println("Record inserted");
			}else {
				System.out.println("Record not inserted");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
