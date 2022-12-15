package com.gl.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "teacher")
public class Teacher {

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name="f_name")
	private String f_name;
	@Column(name="l_name")
	private String l_name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="teacher_details_id")
	private TeacherDetails TeacherDetails;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "teacher", cascade = {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.REFRESH,
			CascadeType.PERSIST
			})
	private List<Course> courses;
	

	public Teacher() {
		
	}

	public Teacher(String f_name, String l_name) {
		this.f_name = f_name;
		this.l_name = l_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public TeacherDetails getTeacherDetails() {
		return TeacherDetails;
	}

	public void setTeacherDetails(TeacherDetails teacherDetails) {
		TeacherDetails = teacherDetails;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", f_name=" + f_name + ", l_name=" + l_name + ", TeacherDetails=" + TeacherDetails
				+ "]";
	}
	
	
	// convenience for bi directional mapping
	
	public void add(Course tempcourse) {
		if(courses == null) {
			courses = new ArrayList<>();
		}
		
		courses.add(tempcourse);
		
		tempcourse.setTeacher(this);
	}
}
