package com.paytm.learnwebapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	private int id;
	private String name;
	private String jobrole;
	private String email;
	private String phone;
	
	public User(int id, String name, String jobrole, String email, String phone)
	{
		this.id = id;
		this.name = name;
		this.jobrole = jobrole;
		this.email = email;
		this.phone = phone;
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
	public String getJobrole() {
		return jobrole;
	}
	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", jobrole=" + jobrole + ", email=" + email + ", phone="
				+ phone + "]";
	}
	
}
