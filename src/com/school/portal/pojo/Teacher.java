package com.school.portal.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "TEACHER")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="teacher_ID")
	private int teacherID;
	
	@Column(name="tName")
	private String tName;
//	
	@OneToOne(mappedBy = "courseTeacher")
	Course tCourse;
	
	
//	@OneToOne(mappedBy = "student")
//	Address address; /

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public Course gettCourse() {
		return tCourse;
	}

	public void settCourse(Course tCourse) {
		this.tCourse = tCourse;
	}

	public Teacher(String tName) {
		super();
		
		this.tName = tName;
//		this.tCourse = tCourse;
	}

	public Teacher() {
		super();
	}

	@Override
	public String toString() {
		return "Teacher [teacherID=" + teacherID + ", tName=" + tName + ", tCourse=" + tCourse + "]";
	}
	
	
}
