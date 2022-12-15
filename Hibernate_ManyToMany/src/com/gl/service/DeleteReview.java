package com.gl.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gl.test.Course;
import com.gl.test.Review;
import com.gl.test.Teacher;
import com.gl.test.TeacherDetails;

public class DeleteReview {

	public static void main(String[] args) {

		System.out.println("Connecting to database");
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		System.out.println("connected to database...");
		
		Session session = null;
		
		Transaction tx = null;
		System.out.println("Connected to database successfully");
		
		try{
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			
			Course c1 = session.get(Course.class, 1);
			session.delete(c1);
			
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
