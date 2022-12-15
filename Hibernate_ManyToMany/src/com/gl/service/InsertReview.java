package com.gl.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gl.test.Course;
import com.gl.test.Review;
import com.gl.test.Teacher;
import com.gl.test.TeacherDetails;

public class InsertReview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
		Course c1 = new Course("FSD");
		
		try{
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			c1.addReview(new Review("Best ever!!!"));
			c1.addReview(new Review("Mind blowing!!!"));
			c1.addReview(new Review("moderate course!!!"));
			
			session.save(c1);
			System.out.println("saved");
			System.out.println(c1);
			System.out.println(c1.getReview());
			
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
