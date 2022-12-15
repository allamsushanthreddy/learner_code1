package com.gl.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gl.test.Course;
import com.gl.test.Teacher;
import com.gl.test.TeacherDetails;

public class GetCourse {

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
		
		
		try{
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			
			Teacher t1 = session.get(Teacher.class, 1);
			
			System.out.println("Teacher: "+t1);
			
			System.out.println("COurses: "+t1.getCourses());
			
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
