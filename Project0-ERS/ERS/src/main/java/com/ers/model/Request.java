package com.ers.model;

public class Request {
	private Integer reqid;
	private String type;
	private Integer amount;
	private Boolean isWorking;
	private Boolean isManager;
	
	public Integer getReqid() {
		return reqid;
	}
	public void setReqid(Integer reqid) {
		this.reqid = reqid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Boolean getIsWorking() {
		return isWorking;
	}
	public void setIsWorking(Boolean isWorking) {
		this.isWorking = isWorking;
	}
	public Boolean getIsManager() {
		return isManager;
	}
	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}
	public Request(Integer reqid, String type, Integer amount, Boolean isWorking, Boolean isManager) {
		super();
		this.reqid = reqid;
		this.type = type;
		this.amount = amount;
		this.isWorking = isWorking;
		this.isManager = isManager;
	}
	public Request() {
		
	}
	
	
	
}
