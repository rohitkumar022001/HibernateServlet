package com.digit.servletHibernate.model;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.digit.servletHibernate.bean.AadharDetails;


public class HibernateManager {
	 private Session session;

	 

	    public HibernateManager() {

	        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

	        ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());

	        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());

	        session = sessionFactory.openSession();

	        System.out.println("Connected to Pf...");

	    }
	    public boolean saveObject(AadharDetails a) {

	        Transaction trn = session.beginTransaction();

	        session.save(a);

	        trn.commit();

	        System.out.println("Object Saved!");
	        return true;

	    }
	    public boolean update(String s) {
			Transaction trn = session.beginTransaction();
			AadharDetails a=(AadharDetails)session.get(AadharDetails.class,s);
			a.setName(a.getName());
			session.update(a);
			System.out.println("update success");
	    	trn.commit();
	    	return true;
		}
	    public boolean delete(String s) {
			Transaction trn = session.beginTransaction();
			AadharDetails a = (AadharDetails)session.get(AadharDetails.class, s);
	          session.delete(a);
			System.out.println("delete success");
	    	trn.commit();
	    	return true;
		}
	    public boolean read(String s) {
			//Transaction trn = session.beginTransaction();
			session.beginTransaction();
			AadharDetails c=(AadharDetails) session.get(AadharDetails.class, s);
	    	System.out.println(c.getId()+"   "+c.getName()+"   "+c.getAddress()+"  "+c.getDob());
	    	return true;
		}

	    
		

}
