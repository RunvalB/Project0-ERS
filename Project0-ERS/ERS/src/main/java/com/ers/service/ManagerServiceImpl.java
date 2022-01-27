package com.ers.service;

import java.util.ArrayList;
import com.ers.dao.IManagerDao;
import com.ers.dao.ManagerDaoImpl;
import com.ers.model.Employee;
import com.ers.model.Request;

public class ManagerServiceImpl implements IManagerService {
    IManagerDao manager = new ManagerDaoImpl();
	
    @Override  // Getting requests pending and resolved but with use of parameter statusCode ,it manipulates
	public ArrayList<Request> getRequest(Integer statusCode) {
		// TODO Auto-generated method stub
		try {
			return manager.getRequest(statusCode);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	
	}

	@Override   // getting employee reimbursement request
	public ArrayList<Request> getEmpRequest(Integer empId) {
		try {
			return manager.getEmpRequest(empId);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	
	@Override  //getting employee details
	public ArrayList<Employee> getAllEmployee() {
		try {
			return manager.getAllEmployee();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return null;
	}
}
