package com.ers.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.ers.dbcon.DbConnection;
import com.ers.model.Employee;
import com.ers.model.Request;

public class ManagerDaoImpl implements IManagerDao {

	@Override
	public ArrayList<Request> getRequest(Integer statusCode) {
		try {
			Statement st = DbConnection.dbConnection().createStatement();
			PreparedStatement pst =DbConnection.dbConnection().prepareStatement("SELECT * FROM Request WHERE reqStatus = ?");
			pst.setInt(1,statusCode);
			ResultSet rs = pst.executeQuery();
			ArrayList<Request> reqList = new ArrayList<Request>();
			while(rs.next()) {
				Request request = new Request();
				request.setReqid(rs.getInt("reqid"));
				request.setType(rs.getString("remtype"));
				request.setAmount(rs.getInt("amount"));
				reqList.add(request);
			}
		  return reqList;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public ArrayList<Request> getEmpRequest(Integer empId) {
		try {
		Statement st = DbConnection.dbConnection().createStatement();
		PreparedStatement pst =DbConnection.dbConnection().prepareStatement("SELECT * FROM Request WHERE empId = ?");
		pst.setInt(1,empId);
		ResultSet rs = pst.executeQuery();
		ArrayList<Request> reqList = new ArrayList<Request>();
		while(rs.next()) {
			Request request = new Request();
			request.setReqid(rs.getInt("reqid"));
			request.setType(rs.getString("remtype"));
			request.setAmount(rs.getInt("amount"));
			reqList.add(request);
		}
	  return reqList;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		try {
			Statement st = DbConnection.dbConnection().createStatement();
			PreparedStatement pst =DbConnection.dbConnection().prepareStatement("SELECT * FROM Employee WHERE isManager = ?");
			Integer isManager = 0;
			pst.setInt(1, isManager);
			ResultSet rs = pst.executeQuery();
			ArrayList<Employee> details = new ArrayList<Employee>();
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEid(rs.getInt("empid"));
				employee.setEmpname(rs.getString("empname"));
				employee.setEmail(rs.getString("email"));
				details.add(employee);
			}
			return details;
		}catch(Exception e ) {
		 
			System.out.println(e.getMessage());
		}
		return null;
	}


}
