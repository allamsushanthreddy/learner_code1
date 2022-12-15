package com.gl.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gl.test.Teacher;
import com.gl.test.TeacherDetails;


public class Delete {

	public static void main(String[] args) {
		
		System.out.println("Connecting to database");
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			TeacherDetails td1 = session.get(TeacherDetails.class, 1);
			
			if(td1!=null) {
				System.out.println("TeacherDetails: "+td1);
			}
			
			session.delete(td1);
			
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error" + e);
		}
		finally {
			factory.close();
		}
		System.out.println("Session completed successfully");
	}
}
