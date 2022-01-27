package com.ers.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import com.ers.dbcon.DbConnection;
import com.ers.model.Employee;
import com.ers.model.Request;

public class EmployeeDaoImpl implements IEmployeDao {
	Employee emp = new Employee();
	Logger logger = Logger.getLogger(Logger.class.toString());
	@Override
	public HashMap<Integer, Employee> getEmployee(String email,String password,Integer isManager) {
		try {
			
			Statement st = DbConnection.dbConnection().createStatement();
			PreparedStatement pst =DbConnection.dbConnection().prepareStatement("SELECT * FROM EMPLOYEE WHERE email = ? AND password = ? AND isWorking = ? AND isManager = ? ");
			Integer isWorking = 1;
			pst.setString(1,email);
			pst.setString(2, password);
			pst.setInt(3, isWorking);
			pst.setInt(4, isManager);
			HashMap<Integer,Employee> data = new HashMap<Integer,Employee>();
			ResultSet rs = pst.executeQuery();
			while (rs.next()) { 
				Integer tempid = rs.getInt("empid");
			    String tempname = rs.getString("empname");
			    String tempemail = rs.getString("email");
			    String temppassword = rs.getString("password");
			    emp.setEid(tempid);
			    emp.setEmpname(tempname);
			    emp.setEmail(tempemail);
			    emp.setPassword(temppassword); 
			    data.put(tempid,emp);
			}
			logger.info("YES Final steap");
		    return data;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Integer submitRequest(String type, Integer amount,Integer id) {
	    try{
	    	
	    	Statement st = DbConnection.dbConnection().createStatement();
	    	String query = "insert into request (remtype,amount,empid) values (?,?,?)";
	    	PreparedStatement pst = DbConnection.dbConnection().prepareStatement(query);
	    	pst.setString(1,type);
			pst.setInt(2,amount);
			logger.info("Cmoing for getid");
			pst.setInt(3,id);
			Integer count = pst.executeUpdate();
			return count;
			
	    }catch(Exception e) {
	    	System.out.println(e.getMessage());
	    }
		return null;
	}

	@Override
	public ArrayList<Request> getPendingRequest(Integer id) {
		try {
			Statement st = DbConnection.dbConnection().createStatement();
			PreparedStatement pst =DbConnection.dbConnection().prepareStatement("SELECT * FROM Request WHERE empid = ? AND reqStatus = ?");
			Integer pending = 0; 
			pst.setInt(1, id);
			pst.setInt(2,pending);
			ResultSet rs = pst.executeQuery();
			ArrayList<Request> empList = new ArrayList<Request>();
			while(rs.next()) {
				Request request = new Request();
				request.setReqid(rs.getInt("reqid"));
				request.setType(rs.getString("remtype"));
				request.setAmount(rs.getInt("amount"));
				empList.add(request);
			}
			return empList;
		}catch(Exception e ) {
		 
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public ArrayList<Employee> getDetails(Integer id, Integer isManager) {
		
		try {
		Statement st = DbConnection.dbConnection().createStatement();
		PreparedStatement pst =DbConnection.dbConnection().prepareStatement("SELECT * FROM Employee WHERE empid = ? AND isManager = ?");
		Integer pending = 0; 
		pst.setInt(1, id);
		pst.setInt(2,pending);
		ResultSet rs = pst.executeQuery();
		ArrayList<Employee> details = new ArrayList<Employee>();
		while(rs.next()) {
			Employee request = new Employee();
			request.setEid(rs.getInt("empid"));
			request.setEmpname(rs.getString("empname"));
			request.setEmail(rs.getString("email"));
			request.setPassword(rs.getString("password"));
			details.add(request);
		}
		return details;
			
		}catch(Exception e ) {
			System.out.println(e.getMessage());
		}
		return null;
	}
		
}
