package com.school.portal.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BATCH")
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "batchID")
	private int batchID;

	@Column(name = "batchNumber")
	private String batchNumber;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "courseCode", referencedColumnName = "courseCode")
	Course course;
	
	public Batch(int batchID, String batchNumber, Course course) {
		super();
		this.batchID = batchID;
		this.batchNumber = batchNumber;
		this.course = course;
	}
	
	public Batch( String batchNumber) {
		super();
		this.batchNumber = batchNumber;
	}
	
	public Batch() {
		super();
	}

	public int getBatchID() {
		return batchID;
	}

	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Batch [batchID=" + batchID + ", batchNumber=" + batchNumber + "]";
	}

}
