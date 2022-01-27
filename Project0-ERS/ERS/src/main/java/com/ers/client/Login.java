package com.ers.client;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;
import com.ers.model.Employee;
import com.ers.service.EmployeeServiceImpl;
import com.ers.service.IEmployeeService;

public class Login {
	public static void main(String[] args) throws Exception {
		 
		Logger logger = Logger.getLogger(Logger.class.toString());
		logger.info("Application Started");
		
		//creating instance of Service
		IEmployeeService employee = new EmployeeServiceImpl();
		
		
		System.out.println("\t !! Welcome to Employee Reimbursement System !!");
		
		//Taking users from input for Their Role
		System.out.println("\n\t\t Employee or Manager \n\n 1.Press E for Employee \t 2.Press M for Manager");
		Scanner sc = new Scanner(System.in);
		Character empRole = sc.next().charAt(0); 
		empRole=Character.toUpperCase(empRole); //if user enters input in uppercase 
		switch(empRole) {
		
		//For Employee Role
		
		case 'E' :  logger.info("Entering to Employee Portal");
			        System.out.println("\t\tWelcome to Employee Portal\n");
					System.out.print("Enter Email : ");  
					String email = sc.next();                 //storing email from user
					System.out.print("Enter Password : ");  
					String password = sc.next();			//storing password from user
					
					HashMap<Integer,Employee> data = new HashMap<Integer,Employee>();
					Integer isManager = 0;
					//Calling Service for checking Login details
					data = employee.getEmployee(email, password,isManager); 
					if(data.size()==1) {  // if data found 
						System.out.println("You Are Login Successfully !");
						logger.info("Please Display Option for Employee");
						DisplayEmployeeOptions d = new DisplayEmployeeOptions();
						d.EmpOptions(data.keySet().iterator().next());
						logger.info("Move to options");
					}
					else {  // if users data not found
						logger.info("email or password incorrect");
						System.out.println("Email or password incorrect ! Please try Again");
					}
					break; 
					
		//For Manager Role
		case 'M' :  System.out.println("\t\tWelcome to Manager Portal");
					System.out.print("Enter Email : ");
					String manageremail = sc.next();
					System.out.print("Enter Password : ");
					String managerpassword = sc.next();
					HashMap<Integer,Employee> manager1 = new HashMap<Integer,Employee>();
					Integer Manager = 1;
					manager1 = employee.getEmployee(manageremail, managerpassword,Manager);
					if(manager1.size()==1) {
						logger.info("Call available options");
						DisplayManagerOptions d = new DisplayManagerOptions();
						d.managerOptions(manager1.keySet().iterator().next());
					}
					else {
						logger.info("email or password incorrect");
						System.out.println("Email or password incorrect ! Please try Again");
					}	
					break;
		default :   System.out.println("Wrong Input :( Please Login Again....");
	}
	sc.close();
	}
}
