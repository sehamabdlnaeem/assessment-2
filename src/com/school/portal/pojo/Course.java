package com.school.portal.pojo;

import java.util.List;
//import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course {

	@Id
	@Column(name = "courseCode")
	private String courseCode;

	@Column(name = "courseName")
	private String courseName;

	@ManyToMany(mappedBy = "course")
	Set<Student> student;

	@OneToMany(mappedBy = "course")
	Set<Batch> courseBatch; /* One course has many batches */

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="teacher_ID")
	Teacher courseTeacher;
	
	public Course() {
		super();
	}

	public Course(String courseCode, String courseName, Set<Student> student, Set<Batch> courseBatch,
			Teacher courseTeacher) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.student = student;
		this.courseBatch = courseBatch;
		this.courseTeacher = courseTeacher;
	}
	
	
	public Course(String courseCode, String courseName, Set<Batch> courseBatch,
			Teacher courseTeacher) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseBatch = courseBatch;
		this.courseTeacher = courseTeacher;
	}
	
	public Course(String courseCode, String courseName, Set<Batch> courseBatch
			) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseBatch = courseBatch;
//		this.courseTeacher = courseTeacher;
	}
	
	public Course(String courseCode, String courseName
			) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;

	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	public Teacher getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(Teacher courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	public Set<Batch> getCourseBatch() {
		return courseBatch;
	}

	public void setCourseBatch(Set<Batch> courseBatch) {
		this.courseBatch = courseBatch;
	}

	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", courseName=" + courseName + ", student=" + student
				+ ", courseBatch=" + courseBatch + ", courseTeacher=" + courseTeacher + "]";
	}

}
