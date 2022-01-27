package com.ers.dao;

import java.util.ArrayList;

import com.ers.model.Employee;
import com.ers.model.Request;

public interface IManagerDao {
	public ArrayList<Request> getRequest(Integer statusCode);
	public ArrayList<Request> getEmpRequest(Integer empId);
	public ArrayList<Employee> getAllEmployee();
}
