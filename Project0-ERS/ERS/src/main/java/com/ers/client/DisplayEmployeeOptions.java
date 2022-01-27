package com.ers.client;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Logger;

import com.ers.model.Employee;
import com.ers.model.Request;
import com.ers.service.EmployeeServiceImpl;
import com.ers.service.IEmployeeService;


public class DisplayEmployeeOptions  {
	Logger logger = Logger.getLogger(Logger.class.toString());
	public static  void empoptions() {
		System.out.println("\n1.Submit Reimbursement Request \t2.View Pending Request \t3.View details \t4.Update Details \t5.Logout");
	}
	
	public void EmpOptions(Integer id) {
		logger.info("Inside Employee option");
		IEmployeeService empcall = new EmployeeServiceImpl();
		boolean loop  = true;
		do{
			empoptions();  // showing Options
			System.out.println("Enter Your Choice : ");
			Scanner sc = new Scanner(System.in);
			Integer choice = sc.nextInt();
			switch(choice) {
			case 1 : // Employee Submit Reimbursement Request
				     logger.info("Employee Submitting Reimbursement Request");
				     System.out.println("\t\tSubmit Reimbursement Request details to Manager");
					 System.out.println("Select Reimbursement Type : ");
					 
					 String[] types = new String[] {"Travel and Mileage Reimbursements","Business Expense Reimbursements","Healthcare Reimbursements"};
					 for (int i = 0; i < types.length; i++) {
						System.out.println("Press "+(i+1)+" : "+types[i]);
					}
					Integer reqNumber = sc.nextInt();sc.nextLine();
					System.out.println(reqNumber);
					String type = types[--reqNumber]; 	 // with use of pre-decrement operator put reimbursement type	
					System.out.println("Enter Reimbursement Amount : ");
					Integer amount = sc.nextInt();       //getting amount ip from user
					sc.nextLine();
					
					if(amount > 100000) {  // manual check if user enters value more than 1 lac.
						System.out.println("Amount should be less than lac");
					}else {
						System.out.println("Entered Amount is "+amount);
						
					}
					logger.info("Calling Submit Request");
					int count =empcall.submitRequest(type,amount,id);
					if(count > 0) {
						System.out.println("Your Request Submited to Manager...Thank You");
					}else {
						System.out.println("Internal Error...");
					}
					break;
					
			case 2 : System.out.println("View Your Pending request"); 
					 ArrayList<Request> e= empcall.getPendingRequest(id); // storing pending request
					 System.out.println("Your Total Pending ReImbursement Requests : "+e.size());
					 for (Iterator iterator = e.iterator(); iterator.hasNext();) {
						Request request = (Request) iterator.next();
						System.out.println("Reimbursement Request : "+request.getType()+" "+" & Amount is "+request.getAmount());
					}
			         break;
			         
			case 3 :System.out.println("Your Details are : ");
			        Integer isManager = 0;
			        ArrayList<Employee> details= empcall.getDetails(id,isManager);  //storing employee details
			        for (Iterator iterator = details.iterator(); iterator.hasNext();) { //using iteration print emp data
						Employee employee = (Employee) iterator.next();
						System.out.println("Your Name : "+employee.getEmpname());
						System.out.println("Your Email : "+employee.getEmail());
						System.out.println("Your Password : "+employee.getPassword());
					}
					break;
					
			case 4 : System.out.println("Update Details");
			         //Implementation Remaining
			         break;
			         
			case 5:  
				     System.out.println("Logout");
			         loop=false;
			         logger.info("Logout");
			         break;
			default : System.out.println("Invalid Options");
			}
		}while(loop);
	}
}

