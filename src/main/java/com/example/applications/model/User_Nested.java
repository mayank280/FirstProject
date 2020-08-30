package com.example.applications.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class User_Nested {
	@Id
	private String id;
	private String username;
	private String password;
	private String email;
	private String[] phonenum;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String[] phonenum) {
		this.phonenum = phonenum;
	}
	@Override
	public String toString() {
		return "User_Nested [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phonenum=" + Arrays.toString(phonenum) + "]";
	}
	
	

}
