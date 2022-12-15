package com.gl.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gl.test.Course;
import com.gl.test.Teacher;
import com.gl.test.TeacherDetails;

public class InsertCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Connecting to database");
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		System.out.println("connected to database...");
		
		Session session = null;
		
		Transaction tx = null;
		System.out.println("Connected to database successfully");
		
		Course c1 = new Course("FSD");
		Course c2 = new Course("DSE");
		try{
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			
			Teacher t1 = session.get(Teacher.class, 1);
			
			t1.add(c1);
			t1.add(c2);
				
			session.save(c1);
			session.save(c2);
			
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			factory.close();
		}
		System.out.println("Session completed successfully");
	}

}
