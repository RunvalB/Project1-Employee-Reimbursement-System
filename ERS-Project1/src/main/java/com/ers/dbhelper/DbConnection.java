package com.ers.dbhelper;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DbConnection {
	private DbConnection() {
		
	}
	private static final Logger LOGGER = Logger.getLogger(DbConnection.class);
	public static SessionFactory getConnection() {
		
		LOGGER.info("inside @method getConnection() ");
		
		try {
			LOGGER.info("Creating Connection with Database");
			//db Configuration using hibernate.cfg.xml
			SessionFactory sessionfactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			LOGGER.info(sessionfactory.toString());
			return sessionfactory;
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		return null;

	}
}
