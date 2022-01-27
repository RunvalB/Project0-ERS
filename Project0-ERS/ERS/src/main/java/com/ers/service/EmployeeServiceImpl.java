package com.ers.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import com.ers.dao.EmployeeDaoImpl;
import com.ers.dao.IEmployeDao;
import com.ers.model.Employee;
import com.ers.model.Request;

public class EmployeeServiceImpl implements IEmployeeService{
	
	IEmployeDao emp = new EmployeeDaoImpl();
	Logger logger = Logger.getLogger(Logger.class.toString());
	
	@Override
	public HashMap<Integer,Employee> getEmployee(String email,String password,Integer isManager){
		logger.info("Login Stage");
		try {
			logger.info("find record for employee");
			return emp.getEmployee(email, password,isManager);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;	
	}

	@Override
	public Integer submitRequest(String type,Integer amount,Integer id)  {
		logger.info("Submit State");
		try {
			return emp.submitRequest(type,amount,id);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		
	}

	@Override
	public ArrayList<Request> getPendingRequest(Integer id) {
		logger.info("Get PendingRequest State");
		try {
			return emp.getPendingRequest(id);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public ArrayList<Employee> getDetails(Integer id, Integer isManager) {
		logger.info("Get PendingRequest State");
		try {
			return emp.getDetails(id,isManager);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
