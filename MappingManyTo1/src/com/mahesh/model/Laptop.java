package com.mahesh.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lid")
	private int lid;

	@Column(name = "lapname")
	private String lapname;

	@Column(name = "price")
	private float lapprice;

	@ManyToMany
	private List<Student> student;

	public Laptop(int lid, String lapname, float lapprice, List<Student> student) {
		super();
		this.lid = lid;
		this.lapname = lapname;
		this.lapprice = lapprice;
		this.student = student;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public Laptop() {
		// TODO Auto-generated constructor stub
	}

	public Laptop(String lapname, float lapprice) {
		super();
		this.lapname = lapname;
		this.lapprice = lapprice;
	}

	public String getLapname() {
		return lapname;
	}

	public void setLapname(String lapname) {
		this.lapname = lapname;
	}

	public float getLapprice() {
		return lapprice;
	}

	public void setLapprice(float lapprice) {
		this.lapprice = lapprice;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lapname=" + lapname + ", lapprice=" + lapprice + ", student=" + student + "]";
	}

}
