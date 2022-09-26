package com.advance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Student {
	@Id
	@GeneratedValue
	private int id;

	//@Pattern(regexp = "^[a-zA-Z]{2,}$", message = "will except a name with at least two characters")
	private String name;

	//@Pattern(regexp = "^\\d{10}$", message = "invalid phone number entered")
	private String phone;

	private String address;

	//@Pattern(regexp = " ^[A-Za-z0-9]$", message = "The password has at least one special character  ")
	private String password;

	public Student() {

	}

	
	public Student(int id, String name, String phone, String address, String password) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.password = password;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", password="
				+ password + "]";
	}

}
