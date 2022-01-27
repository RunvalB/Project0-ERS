package com.ers.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.ers.model.Employee;
import com.ers.model.Request;

public interface IEmployeDao  {
		
		public HashMap<Integer,Employee> getEmployee(String email,String password,Integer isManager);
		public Integer submitRequest(String type, Integer amount,Integer id);
		public ArrayList<Request> getPendingRequest(Integer id);
		public ArrayList<Employee> getDetails(Integer id, Integer isManager);
		
}
