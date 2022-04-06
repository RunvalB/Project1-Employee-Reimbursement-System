package com.ers.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.*;

import com.ers.dbhelper.DbConnection;
import com.ers.exception.NoEmployeeResultFound;
import com.ers.model.Employee;
import com.ers.model.Request;


public class ManagerDaoImpl implements IManagerDao {
	private static final Logger LOGGER = Logger.getLogger(ManagerDaoImpl.class);
	Session session = null;
	Transaction t = null;
	
	@SuppressWarnings("unchecked")
	public List<Employee> getManagerUser(Employee emp) {
		try {
			LOGGER.info("class @ManagerDaoImpl inside method @getManangerUser");
			session=DbConnection.getConnection().openSession();
			String getLoginUser = "From Employee as e where e.email like :email and e.password like :password and isManager = :isManager and isWorking =:isWorking";
			Query<Employee> q = session.createQuery(getLoginUser);
			q.setParameter("email", emp.getEmail());
			q.setParameter("password",emp.getPassword());
			q.setParameter("isManager",emp.isManager());
			q.setParameter("isWorking",emp.isWorking());
			LOGGER.info("getting manager used detail for login");
			return q.list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee(Employee employee) {
		try {
			LOGGER.info("class @ManagerDaoImpl inside method @getAllEmployee");
			session=DbConnection.getConnection().openSession();
			String getLoginUser = "From Employee as e where isManager = :isManager ";
			Query<Employee> q = session.createQuery(getLoginUser);
			q.setParameter("isManager",employee.isManager());
			List<Employee> empResult = q.list();
			return empResult;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Request> getAllRequest(Request requestObj) {
		try {
			LOGGER.info("class @ManagerDaoImpl inside method @getAllRequest");
			session=DbConnection.getConnection().openSession();
			String getLoginUser = "From Request";
			Query<Request> q = session.createQuery(getLoginUser);
			return q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public int approvedRequest(Request req) {
		try{
		LOGGER.info("class @ManagerDaoImpl inside method @approvedRequest");	
		session=DbConnection.getConnection().openSession();
		session.getTransaction().begin();
		Query q = session.createQuery("Update Request set isApproved =:approved where reqid=:req");
		q.setParameter("approved", true);
		q.setParameter("req", req.getReqid());
		Integer count = q.executeUpdate();
		session.getTransaction().commit();
		return count;
		}
		catch (HibernateException e) {
//			if(t.isActive()) {
//				t.rollback();	
//			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return 0;
	}

	@SuppressWarnings("rawtypes")
	public int resolvedRequest(Request req) {
		try{
			LOGGER.info("class @ManagerDaoImpl inside method @ResolvedRequest");
			session=DbConnection.getConnection().openSession();
			session.getTransaction().begin();
			Query q = session.createQuery("Update Request set reqStatus =:resolved where reqid=:req");
			q.setParameter("resolved", true);
			q.setParameter("req", req.getReqid());
			Integer count = q.executeUpdate();
			session.getTransaction().commit();
			return count;
			}
			catch (HibernateException e) {
				if(t.isActive()) {
					t.rollback();	
				}
			}finally {
				
				session.close();
			}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public Employee getSpecificEmployeeDetail(Employee emp) throws NoEmployeeResultFound {
		try {
			LOGGER.info("class @ManagerDaoImpl inside method @getSpecificEmployeeDetail");
			session=DbConnection.getConnection().openSession();
			LOGGER.info("Inside @getSpecificEmployeeDetail method");
			String getEmployeeDetail = "From Employee as e where e.email like :email";
			Query<Employee> q = session.createQuery(getEmployeeDetail);
			q.setParameter("email", emp.getEmail());
			LOGGER.info("Call for Getting Employee ");
		    return  q.getSingleResult();
		}
		catch (HibernateException e) {
			e.getMessage();
		}finally {
			session.close();
		}
		return null;
	}
}
