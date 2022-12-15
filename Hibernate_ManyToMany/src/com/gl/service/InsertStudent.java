package com.gl.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gl.test.Course;
import com.gl.test.Review;
import com.gl.test.Student;
import com.gl.test.Teacher;
import com.gl.test.TeacherDetails;

public class InsertStudent {
	
	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
		Session session = factory.getCurrentSession();
		
		Student s1 = new Student("Antony");
		Student s2 = new Student("Puneet");
		Student s3 = new Student("Krishna");
		
		Course c1 = new Course("C#");
		Course c2 = new Course("Ruby");
		
		try {
			session.beginTransaction();
			
//			c1.addStudent(s1);
//			c1.addStudent(s3);
//			
			c2.addStudent(s1);
			c2.addStudent(s2);
			c2.addStudent(s3);
			
//			session.save(c1);
			session.save(c2);
			
			session.save(s1);
			session.save(s2);
			session.save(s3);
			
			System.out.println("saved students "+c1.getStudents());
			System.out.println("Get course for one student "+s1.getCourses());
			
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
