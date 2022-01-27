package com.ers.model;

public class Employee {
	
	private Integer eid;
	private String empname;
	private String email;
	private String password;
	private Boolean isManager;
	private Boolean isWorking;
	
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsManager() {
		return isManager;
	}
	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}
	public Boolean getIsWorking() {
		return isWorking;
	}
	public void setIsWorking(Boolean isWorking) {
		this.isWorking = isWorking;
	}
	public Employee(Integer eid, String empname, String email, String password) {
		super();
		this.eid = eid;
		this.empname = empname;
		this.email = email;
		this.password = password;
	}
	public Employee() {
		super();
		
	}
		
}
