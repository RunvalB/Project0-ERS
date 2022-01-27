package com.ers.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Logger;
import com.ers.model.Employee;
import com.ers.model.Request;
import com.ers.service.IManagerService;
import com.ers.service.ManagerServiceImpl;

public class DisplayManagerOptions {
	Logger logger = Logger.getLogger(Logger.class.toString());
	
	public static  void managerDisplay() {
		System.out.println("\n1.Approve/Deny Request\t2.See Pending Request\t3.See Resolved Request\t4.View Reimbursement Request(Specific Employee)\t5.View All Employees\t6.Logout");
	}
	
	public void managerOptions(Integer id) {
		IManagerService manager= new ManagerServiceImpl(); //creating an instance of service
		boolean loop = true;
		Integer status = 0;
		do {
			managerDisplay();
			System.out.println("Enter Your Choice : ");
			Scanner sc = new Scanner(System.in);
			Integer choice = sc.nextInt();
			switch(choice) {
			case 1 : System.out.println("Approved/Deny Request");
				     //Implementation Remaining
				    break;
			
			case 2 :System.out.println("See Pending Request");
			       // pending Request
			         status = 0;
 			 		ArrayList<Request> pendingRequest= manager.getRequest(status);  //storing pending request
			 		System.out.println("Total Pending Employee ReImbursement Requests are: "+pendingRequest.size());
			 		if(pendingRequest.size() == 0) {
			 			System.out.println("No Pending Requests");
			 		}else {
			 			for (Iterator iterator = pendingRequest.iterator(); iterator.hasNext();) {
				 			Request request = (Request) iterator.next();
				 			System.out.println("Reimbursement Request : "+request.getType()+" "+" & Amount is "+request.getAmount());
				 		}	
			 		}
				    break;
				    
			case 3 :System.out.println("See Resolved Request");
			        status = 1; //Resolved Request
			 		ArrayList<Request> resolveRequest= manager.getRequest(status); //storing resolved request
			 		System.out.println("Total Resolved Employee ReImbursement Requests are: "+resolveRequest.size());
			 		for (Iterator iterator = resolveRequest.iterator(); iterator.hasNext();) {
			 			Request request = (Request) iterator.next();
			 			System.out.println("Reimbursement Request : "+request.getType()+" "+" & Amount is "+request.getAmount());
			 		}
		    break; 
			case 4 : logger.info("see specific employee details");
				    System.out.println("View Specific Employee Reimbursement Request : ");  
			        System.out.println("Please Enter Employee Id : "); 
			        Integer empId = sc.nextInt();
			        sc.nextLine();
			        ArrayList<Request> specificEmployeeRequest= manager.getEmpRequest(empId);
			 		System.out.println("Total Resolved Employee ReImbursement Requests are: "+specificEmployeeRequest.size());
			 		if(specificEmployeeRequest.size()==0) {
			 			System.out.println("No request found for Employee id "+empId);
			 		}else {
			 			for (Iterator iterator = specificEmployeeRequest.iterator(); iterator.hasNext();) {
				 			Request request = (Request) iterator.next();
				 			System.out.println("Reimbursement Request : "+request.getType()+" "+" & Amount is "+request.getAmount());
				 		}
			 		}
				    break;
			case 5 : System.out.println("All Employees");
					 ArrayList<Employee> empDetails= manager.getAllEmployee(); //storing employee details
				 	 System.out.println("Total Employees are : "+empDetails.size()); //count total employee currently working
				 	 for (Iterator iterator = empDetails.iterator(); iterator.hasNext();) {
				 		 Employee employee = (Employee) iterator.next();
				 		 System.out.println("Name : "+employee.getEmpname()+"\t Email : "+employee.getEmail());
				 	}
				    break;
			case 6: System.out.println("Logout");
	         		loop=false;
				    break;
			default : System.out.println("Invalid Options");
			}	
		
		}while(loop);
	}
}
