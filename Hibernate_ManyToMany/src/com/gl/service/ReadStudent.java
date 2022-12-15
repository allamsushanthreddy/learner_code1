package com.gl.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gl.test.Course;
import com.gl.test.Review;
import com.gl.test.Student;
import com.gl.test.Teacher;
import com.gl.test.TeacherDetails;

public class ReadStudent {
	
	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
		Session session = factory.getCurrentSession();
		
		Student s1 = new Student("Juli");
		Student s2 = new Student("Amar");
		Student s3 = new Student("Tej");
		
		Course c1 = new Course("Java");
		Course c2 = new Course("Python");
		
		try {
			session.beginTransaction();
			
			s1 = session.get(Student.class, 2);
//			c1 = session.get(Course.class, 1);
//			session.delete(s1);
//			c1.addStudent(s1);
			
			System.out.println("saved students "+c1.getStudents());
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}
}
