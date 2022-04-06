package com.ers.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@SuppressWarnings("serial")
@Entity
@Table(name="Employee",uniqueConstraints=@UniqueConstraint(columnNames = {"Email","mobileNumber"}))
//@NamedQueries({
//	@NamedQuery(name="GetLoginUser",query="From Employee e Where e.Email like :email AND e.password like :password AND e.isManager=:isManager")
//	
//})
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EmployeeId")
	private Integer empid;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable = false,name="Email")
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String gender;
	
	@Column(nullable=false,length=10)
	private String mobileNumber;
	
	@Column(nullable=false)
	private Integer salary;
	
	@Column(nullable=false)
	private String department;
	
	@Column(nullable=false,name="Manager")
	private boolean isManager;
	
	@Column(nullable=false,name="WorkingStatus")
	private boolean isWorking;
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "employee")
	private List<Request> request;

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	public boolean isWorking() {
		return isWorking;
	}

	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}

	public List<Request> getRequest() {
		return request;
	}

	public void setRequest(List<Request> request) {
		this.request = request;
	}

	public Employee() {
		super();
	}

	public Employee(Integer empid, String name, String email, String password, String gender, String mobileNumber,
			Integer salary, String department, boolean isManager, boolean isWorking, List<Request> request) {
		super();
		this.empid = empid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.salary = salary;
		this.department = department;
		this.isManager = isManager;
		this.isWorking = isWorking;
		this.request = request;
	}
}
