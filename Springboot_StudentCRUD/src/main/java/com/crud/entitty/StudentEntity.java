package com.crud.entitty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity {
	@Id
	private int stud_id;
	private String stud_name;
	private String city;
	private long mobile_no;

	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentEntity(int stud_id, String stud_name, String city, long mobile_no) {
		super();
		this.stud_id = stud_id;
		this.stud_name = stud_name;
		this.city = city;
		this.mobile_no = mobile_no;
	}

	public int getStud_id() {
		return stud_id;
	}

	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}

	public String getStud_name() {
		return stud_name;
	}

	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}

	@Override
	public String toString() {
		return "StudentEntity [stud_id=" + stud_id + ", stud_name=" + stud_name + ", city=" + city + ", mobile_no="
				+ mobile_no + "]";
	}

}
