package com.gl.service;

import com.gl.test.Course;
import com.gl.test.Review;
import com.gl.test.Teacher;
import com.gl.test.TeacherDetails;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Read {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = null;
		Transaction tx = null;
		
//		Teacher t1 = new Teacher();
		TeacherDetails td1 = new TeacherDetails();
		
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			Course c1= session.get(Course.class, 1);
			
			System.out.println("course: "+c1);
			System.out.println("reviews: "+c1.getReview());
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		finally {
			factory.close();
		}
	}

}
