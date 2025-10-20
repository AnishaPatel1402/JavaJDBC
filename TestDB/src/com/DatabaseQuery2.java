package com;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseQuery2 {   //delete record

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the id of employee which you want to delete: ");
		int id = sc.nextInt();
		try(Connection con = GetConnection.getConnection();) {
			Statement st = con.createStatement();
			String sql = "delete from employee where id = "+id;
			int x = st.executeUpdate(sql);
			if(x!=0) {
				System.out.println("Record Deleted successfully");
			}else {
				System.out.println("Record NOT Deleted");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
