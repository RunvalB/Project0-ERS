package com.ers.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.ers.exceptions.BusinessException;
import com.ers.model.Employee;
import com.ers.model.Request;

public interface IEmployeeService {
	    //It helps to achieve Abstraction and hiding our internal mechanism
		public HashMap<Integer,Employee> getEmployee(String email,String password,Integer isManager) throws BusinessException ;
		public Integer submitRequest(String type,Integer amount,Integer id) ;
		public ArrayList<Request> getPendingRequest(Integer id);
		public ArrayList<Employee> getDetails(Integer id,Integer isManager);
}
