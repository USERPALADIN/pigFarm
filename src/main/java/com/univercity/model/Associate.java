package com.univercity.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;

@Entity
@Table(name = "associate")
public class Associate {

	@Id
	@Column(name = "associate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "date_birth")
	private String date;

	@Column(name = "address")
	private String address;

	@Column (name = "phone_number")
	private String phone;


	public Associate() {
	}

	public Associate(String name, String  date, String address, String phone) {
		this.name = name;
		this.date = date;
		this.address = address;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String  getDate() {
		return date;
	}

	public void setDate(String  date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}

