package com.ers.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name="Request")
public class Request implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RequestId")
	private Integer reqid;
	
	@Column(nullable=false,name="Reimbursement_type")
	private String type;//Reimbursement type
	
	@Column(nullable=false,name="Reimbursement_amount")
	private Integer amount;//amount of reimbursement
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name="SubmitDate")
	private Date submitdate;//submission date
	
	@Column(nullable=false)
	private boolean isApproved; // true=>Approved , false=>reject
	
	@Column(nullable=false)
	private boolean reqStatus; // ture=>Resolved , false=>Pending
	
	@ManyToOne()
	private Employee employee;  // Many Request comes from one or many employee 

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

	public Date getSubmitdate() {
		return submitdate;
	}

	public void setSubmitdate(Date submitdate) {
		this.submitdate = submitdate;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public boolean isReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(boolean reqStatus) {
		this.reqStatus = reqStatus;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Request() {
		super();
	}

	public Request(Integer reqid, String type, Integer amount, Date submitdate, boolean isApproved, boolean reqStatus,
			Employee employee) {
		super();
		this.reqid = reqid;
		this.type = type;
		this.amount = amount;
		this.submitdate = submitdate;
		this.isApproved = isApproved;
		this.reqStatus = reqStatus;
		this.employee = employee;
	}	
}
