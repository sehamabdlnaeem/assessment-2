package com.school.portal.pojo;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "Student_table")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sID")
	private int sID;
	
	@Column(name="sName")
	private String sName;
	
	@Column(name="sEmail")
	private String sEmail;
	
	@Override
	public String toString() {
		return "Student [sID=" + sID + ", sName=" + sName + ", sEmail=" + sEmail + ", course=" + course + "]";
	}


	@ManyToMany()
	@JoinTable(
			name="STUDENT_COURSE",
			joinColumns = @JoinColumn(name="sID", referencedColumnName = "sID"), 
			inverseJoinColumns =@JoinColumn(name="courseCode", referencedColumnName = "courseCode") )
	Set<Course> course;

	public Student(int sID, String sName, String sEmail, Set<Course> course) {
		super();
		this.sID = sID;
		this.sName = sName;
		this.sEmail = sEmail;
		this.course = course;
	} 
	
	public Student() {
		super();
	}


	public int getsID() {
		return sID;
	}


	public void setsID(int sID) {
		this.sID = sID;
	}


	public String getsName() {
		return sName;
	}


	public void setsName(String sName) {
		this.sName = sName;
	}


	public String getsEmail() {
		return sEmail;
	}


	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}


	public Set<Course> getCourse() {
		return course;
	}


	public void setCourse(Set<Course> course) {
		this.course = course;
	}
	
}
