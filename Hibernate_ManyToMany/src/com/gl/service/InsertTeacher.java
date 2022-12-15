package com.gl.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gl.test.Course;
import com.gl.test.Teacher;
import com.gl.test.TeacherDetails;

public class InsertTeacher {

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
		
		Teacher t1 = new Teacher("Sushanth", "Reddy");
		Teacher t2 = new Teacher("Jayakanthan", "Sinha");
		
		TeacherDetails td1 = new TeacherDetails("Hyderabad", "Cricket");
		TeacherDetails td2 = new TeacherDetails("Chennai", "Movies");
		
		t1.setTeacherDetails(td1);
		t2.setTeacherDetails(td2);
		
		Transaction tx = null;
		System.out.println("Connected to database successfully");
		
		try{
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			session.save(t1);
			session.save(t2);
			
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
