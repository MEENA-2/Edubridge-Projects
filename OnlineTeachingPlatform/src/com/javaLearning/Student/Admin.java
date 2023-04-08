package com.javaLearning.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;


public class Admin {
	//private String[] subjects;
	
		/* To create an array list for storing student details */
		static List<Admin> studentList = new ArrayList<Admin>();
		
		/* creating a scanner class object for getting input from user.
		 * As attributes needs to be accessed only by admin, we create it with private access specifier 
		 */
		private static Scanner scanner = new Scanner(System.in);
		private String studentName;
		private int studentId;
		private String standard;
		private long contactNo;
		
	    /* When an object is created, jvm calls default constructor.
	     * Here we prompt user to enter username and password to login
	     * Calling login method by passing parameters 
	     */
		public Admin() {
			System.out.println("!!! Login First !!!");
			System.out.print("Enter username: ");
			String userName = scanner.next();
			System.out.print("Enter password: ");
			String password = scanner.next();
			login(userName, password);
		}

		/* When a parameterized constructor is called, the attributes declared as private
		 * in this class is assigned with the parameter values.
		 * To avoid confusion of jvm in accessing attributes, 'this' keyword is used.
		 * 'This' keyword refers to current class attributes and methods 
		 */
		Admin(String studentName, int studentId, String standard,long contactNo){
			this.studentName = studentName;
			this.studentId = studentId;
			this.standard = standard;
			this.contactNo = contactNo;
		}
		
		/* Defining a login method by checking username and password, entered by user is equal or not.
		 * Only when the conditions are true, the system gets logged in and display the menu.
		 * else, the system gets failed to login 
		 */
		static void login(String userName, String password) {
			if(userName.equals("Room1") && password.equals("Login123") ) {
				System.out.println("successfully logged in");
				System.out.println("\n1. Insert a student");
				System.out.println("2. Display all students");
				System.out.println("3. search a student");
				System.out.println("4. Delete a student");
				System.out.println("5. update a student");
				System.out.println("6. Press 6 to Logout");
				
				/* Using switch case for method calling */
				byte input;
				do {
					input = scanner.nextByte();
					switch (input) {         // 1
					case 1:
						toInsert();
						break;
					case 2:
						toDisplay();
						break;
					case 3:
						toSearch();
						break;
					case 4:
						toDelete();
						break;
					case 5:
						toUpdate();
						break;
					case 6:
						logout();
						break;
					default:
						System.out.println("Enter choices from the above menu only ");
					}
				} 
				
				/* When userinput is 6, the corresponding case's method call is executed
				 * So, that the system gets logged out.
				 * Until input is not equal to 6, the do-loop gets executed
				 */
				while (input != 6);	
			}
			
			else {
				System.out.println("Login Failed!... Check your credentials");
			}
		}
		
		/* To access the private attributes of the system, public getter and setter methods are created 
		 * with the help of encapsulation
		 */
		public int getStudentId() {
			return studentId;
		}
		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}
		
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public String getStandard() {
			return standard;
		}
		public void setStandard(String standard) {
			this.standard = standard;
		}

		public long getContactNo() {
			return contactNo;
		}
		public void setContactNo(long contactNo) {
			this.contactNo = contactNo;
		}
		
		/* To return all attributes as a string to list when display method is called */
		public String toString() {
				return studentName + " "+ studentId +" "+ standard +" " + contactNo;
		}
		
		/* This method is defined for inserting student details entered by user.
		 * Adding this student details in the list 
		 */
		static void toInsert() {
			System.out.print("Enter Student Id: ");
			int studentId = scanner.nextInt();    //read the integer and cursor is here(eg: 124_ (waiting), hence nextLine
			scanner.nextLine();   //to read the left over line  /Integer.parseInt(scanner.nextLine())
			System.out.print("Enter Student Name: ");
			String studentName = scanner.nextLine();    
			System.out.print("Enter Student's Standard: ");
			String standard = scanner.nextLine();			
			System.out.print("Enter Student's Contact No: ");
			long contactNo = scanner.nextLong();
			
			/* An Anonymous object is created by calling parameterized constructor */
			studentList.add(new Admin(studentName,studentId,standard,contactNo));
		}
		
		/* This method is defined for displaying the student details in student list.
		 * Iterator can help to iterate through every element in a collection.
		 * hasNext() method is used to check the next elements present or not in list
		 * next() method is used to print the current element in the list until hasNext() returns true
		 */
		static void toDisplay() {
			System.out.println("Displaying Student List: ");
			Iterator<Admin> studentRef = studentList.iterator(); //  0 1 
			while(studentRef.hasNext()) {
				System.out.println(studentRef.next());
			}
		}
		
		/* This method is defined for searching the student details in the list.
		 * Default value of flag is false.
		 * If the student_id searched for, is found in the list, then the flag value sets to true
		 * If the flag is true, then the print statement is displayed
		 */
		static void toSearch() {
			boolean flag = false;
			System.out.println("Enter student Id to search: ");
			int studentNum = scanner.nextInt();
			Iterator<Admin> studentRef1 = studentList.iterator();  //0 1
			while(studentRef1.hasNext()) {
				Admin adminObj = studentRef1.next();           //0 - Meena 22568 10th 7530078343
				if(adminObj.getStudentId() == studentNum) {
					flag = true;
					System.out.println("Student found!");
					break;
				}
			}
			
			if(flag == false) {
				System.out.println("Student not found!");
			}
		}
		
		/* This method is defined for deleting student details entered by user.
		 * Deleting that student details in the list 
		 */
		static void toDelete() {
			boolean delFlag = false;
			System.out.println("Enter StudentId to delete: ");
			int studentIdDel = scanner.nextInt();
			Iterator<Admin> studentRef2 = studentList.iterator();
			while(studentRef2.hasNext()) {
				Admin adminObj = studentRef2.next();  
				if(adminObj.getStudentId() == studentIdDel) {
					delFlag = true;
					studentList.remove(adminObj);
					System.out.println("Deleted successfully");
					break;
				}
			}
			if(delFlag == false) {
				System.out.println("Student not found!");
			}
		}
		
		/* This method is defined for updating student details entered by user.
		 * The elements corresponding to entered student id is updated in that index itself
		 */
		static void toUpdate() {
			boolean updateflag = false;
			System.out.println("Enter Student Id to update: ");
			int studentIdUpdate = scanner.nextInt();
			Iterator<Admin> studentRef3 = studentList.iterator();
			int ctr = -1;
			while(studentRef3.hasNext()) {
				ctr++;
				Admin adminObj = studentRef3.next();  
				if(adminObj.getStudentId() == studentIdUpdate) {
					updateflag = true;
					System.out.println("Enter updated name: ");
					String updatedName = scanner.next();
					System.out.println("Enter updated Standard: ");
					String updatedStd = scanner.next();
					System.out.println("Enter updated contactNo: ");
					long updatedContact= scanner.nextLong();
					//Set() method is used to set the updated values in the current index
					studentList.set(ctr, new Admin(updatedName, studentIdUpdate, updatedStd, updatedContact));
					break;
				}
			}
			if(updateflag == false) {
				System.out.println("Student not found!");
			}
		}
		
		/* Defining logout() method for logging out the system */
		static void logout() {
			System.out.println("successfully logged out");	
		}
	
	}
