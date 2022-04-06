package com.ers.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ers.dbhelper.DbConnection;
import com.ers.model.Employee;
import com.ers.model.Request;

public class EmployeeDaoImpl implements IEmployeeDao {
	
	private static final Logger LOGGER = Logger.getLogger(EmployeeDaoImpl.class);
	Session session = null;
	Transaction t = null;
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeUser(Employee emp) {
		try {
			session=DbConnection.getConnection().openSession();
			LOGGER.info("Inside method @getEmployeeUser()");
			String getLoginUser = "From Employee as e where e.email like :email and e.password like :password and e.isManager = :isManager and e.isWorking=:isWorking";
			Query<Employee> q = session.createQuery(getLoginUser);
			q.setParameter("email", emp.getEmail());
			q.setParameter("password",emp.getPassword());
			q.setParameter("isManager",emp.isManager());
			q.setParameter("isWorking",emp.isWorking());
			LOGGER.info("Inside method @getEmployeeUser() call for DAO Getting user for login");
			return q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}
	
	public boolean employeeRequest(Request emprequest) {
		LOGGER.info("Inside method @employeeRequest()");
		try {
			session=DbConnection.getConnection().openSession();
			session.beginTransaction();
			LOGGER.info("saving employee request call");
			session.save(emprequest);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}

}
