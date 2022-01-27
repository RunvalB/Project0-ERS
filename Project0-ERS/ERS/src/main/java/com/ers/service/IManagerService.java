package com.ers.service;

import java.util.ArrayList;

import com.ers.model.Employee;
import com.ers.model.Request;

public interface IManagerService {
	//It helps to achieve Abstraction and hiding our internal mechanism
	public ArrayList<Request> getRequest(Integer statusCode);
	public ArrayList<Request> getEmpRequest(Integer empId);
	public ArrayList<Employee> getAllEmployee();

}
