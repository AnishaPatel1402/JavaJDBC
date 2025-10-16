package com;

import java.util.Scanner;

public class InfobeansFoundation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*****INFOBEANS FOUNDATION*****");
		
		System.out.println("Features: ");
		System.out.println("1 : Add new student");
		System.out.println("2 : Update  existing student");
		System.out.println("3 : Delete student");
		System.out.println("4 : Search student");
		System.out.println("5 : View student list");
		char flag = 'Y';
		
		do {
			System.out.println("\nEnter a Choice: ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1: //add student 
					AddStudent.add();
				break;
			case 2: //update student
					UpdateStudent.update();
				break;
			case 3: //delete student 
					DeleteStudent.delete();
				break;
			case 4: //search student
					SearchStudent.search();
				break;
			case 5: //view list of student 
					ViewAllStudent.listOFStudents();
				break;
			default : System.out.println("Wrong choice");
			}
			System.out.println("Do you want to continue: Y - yes and N - No");
			flag = sc.next().charAt(0);
		}while(flag == 'Y');
		if(flag != 'Y') System.out.println("Byyyy Come Again");
	}

}
