package com.scp.java.app.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class HibernateUtil {
	
	static{
		System.out.println("hibernate util loaded....!");
	}
	
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void saveNFlush(Session session, Transaction tr) {
			if(session!=null){
				session.flush();
					if(tr!=null)
						tr.commit();
					session.close();
			}
			
			
			
			
		
	}

	
	
	
}
